import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yael_Zaritsky on 05/11/2016.
 */
public class EmbeddedOMDB {
    private Server jettyServer = null;
    private Map<String, MovieInfo> apisResultsMap = new HashMap<String, MovieInfo>();

    public void setApiResponse(String name, MovieInfo info){
        apisResultsMap.put(name, info);
    }

    public void start(int port)throws Exception{
        jettyServer = new Server(port);
        jettyServer.setHandler(new RequestHandler()) ;
        jettyServer.start();
        int tries = 0 ;
        HttpClient httpClient = HttpClients.createDefault();
        while(tries < 3)  {
            try {
                HttpHost host = new HttpHost("localhost", 8080);
                HttpGet httpGet = new HttpGet("");
                HttpResponse resp = httpClient.execute(host, httpGet);
                if (resp.getStatusLine().getStatusCode() == 404) {
                    Thread.sleep(1000);
                    tries++;
                } else {
                    break;
                }
            }catch(Exception e){
                Thread.sleep(1000);
                tries++;
            }
        }
    }

    public void shutDown()throws Exception{
        if(jettyServer != null){
            jettyServer.stop();
        }
    }

    public class RequestHandler extends AbstractHandler {

        public void handle(String path, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
            System.out.println("Handling request: " + request);
            if (requestIsByTitle(httpServletRequest)) {
                String movieTitle = getTitleFromRequest(httpServletRequest);
                httpServletResponse.setContentType("application/json;charset=utf-8");
                request.setHandled(true);
                sendResponse(httpServletResponse, apisResultsMap.get(movieTitle));
            } else {
                sendResponse(httpServletResponse, null);
            }
        }

        private boolean requestIsByTitle(HttpServletRequest httpServletRequest) {
            return httpServletRequest.getParameter("t") != null;
        }

        private String getTitleFromRequest(HttpServletRequest httpServletRequest) {
            return httpServletRequest.getParameter("t");
        }

        private void sendResponse(HttpServletResponse httpServletResponse, MovieInfo responseObject) throws IOException {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            ObjectMapper objectMapper = new ObjectMapper();

            if (responseObject != null) httpServletResponse.getWriter().write(objectMapper.writeValueAsString(responseObject));
            else httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server not configured for this request");
        }
    }
}