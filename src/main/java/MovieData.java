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
    final String RETURN_ON_ERROR = "OOPSI!";

    public String howLongIsIt(String movieTitle) {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unmarhsal(jsonResponse);

        if (info != null)
            return info.getRuntime();
        else
            return RETURN_ON_ERROR;
    }

    public String plot(String movieTitle) {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unmarhsal(jsonResponse);

        if (info != null)
            return info.getPlot();
        else
            return RETURN_ON_ERROR;
    }

    public String rating(String movieTitle) {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unmarhsal(jsonResponse);

        if (info != null) {
            return info.getImdbRating();
        }
        else {
            return RETURN_ON_ERROR;
        }
    }

    public String posterUrl(String movieTitle) {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unmarhsal(jsonResponse);

        if (info != null)
            return info.getPosterUrl();
        else
            return RETURN_ON_ERROR;
    }

    private MovieInfo unmarhsal(String jsonResponse) {
        MovieInfo info;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            info = mapper.readValue(jsonResponse, MovieInfo.class);
            return info;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getMovieDataFromIMDB(String movieTitle) {
        String baseUrl = "http://www.omdbapi.com/";

        String jsonResponse;
        try {
            HttpClient httpClient = HttpClients.custom().build();
            RestClient restClient  = new RestClient(baseUrl, httpClient);
            jsonResponse = restClient.executeGet("?t=" + movieTitle);
            return jsonResponse;
        } catch (RestClientException e) {
            e.printStackTrace();
            return "OOPSI!";
        }
    }
}
