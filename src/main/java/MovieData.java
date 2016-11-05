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

    public String howLongIsIt(String movieTitle) throws RestClientException, IOException {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unMarhsall(jsonResponse);

        return info.getRuntime();
    }

    public String plot(String movieTitle) throws RestClientException, IOException {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unMarhsall(jsonResponse);

        return info.getPlot();
    }

    public String rating(String movieTitle) throws RestClientException, IOException {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unMarhsall(jsonResponse);

        return info.getImdbRating();
    }

    public String posterUrl(String movieTitle) throws RestClientException, IOException {
        String jsonResponse = getMovieDataFromIMDB(movieTitle);
        MovieInfo info = unMarhsall(jsonResponse);

        return info.getPosterUrl();
    }

    private MovieInfo unMarhsall(String jsonResponse) throws IOException {
        MovieInfo info;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        info = mapper.readValue(jsonResponse, MovieInfo.class);
        return info;
    }

    private String getMovieDataFromIMDB(String movieTitle) throws RestClientException {
        String baseUrl = "http://www.omdbapi.com/";

        String jsonResponse;
        HttpClient httpClient = HttpClients.custom().build();
        RestClient restClient  = new RestClient(baseUrl, httpClient);
        jsonResponse = restClient.executeGet("?t=" + movieTitle);
        return jsonResponse;
    }
}
