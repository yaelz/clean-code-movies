import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wixpress.ci.rest.client.RestClient;
import com.wixpress.ci.rest.client.RestClientException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;


/**
 * Created by Yael_Zaritsky on 03/11/2016.
 */
public class MovieData {
    private String baseUrl = "http://www.omdbapi.com/";

    public String howLongIsIt(String movieTitle) {
        HttpClient httpClient = HttpClients.custom().build();
        RestClient restClient  = new RestClient(baseUrl, httpClient);
        String jsonResponse = null;
        try {
            jsonResponse = restClient.executeGet("?t=" + movieTitle);
        } catch (RestClientException e) {
            e.printStackTrace();
            return "OOPSI!";
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            MovieInfo info = mapper.readValue(jsonResponse, MovieInfo.class);
            return info.getRuntime();
        } catch (IOException e) {
            e.printStackTrace();
            return "OOPSI!";
        }
    }

    public String plot(String movieTitle) {
        HttpClient httpClient = HttpClients.custom().build();
        RestClient restClient  = new RestClient(baseUrl, httpClient);
        String jsonResponse = null;
        try {
            jsonResponse = restClient.executeGet("?t=" + movieTitle);
        } catch (RestClientException e) {
            e.printStackTrace();
            return "OOPSI!";
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            MovieInfo info = mapper.readValue(jsonResponse, MovieInfo.class);
            return info.getPlot();
        } catch (IOException e) {
            e.printStackTrace();
            return "OOPSI!";
        }
    }
}
