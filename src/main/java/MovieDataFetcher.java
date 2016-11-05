import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wixpress.ci.rest.client.RestClient;
import com.wixpress.ci.rest.client.RestClientException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Created by Yael_Zaritsky on 05/11/2016.
 */
public class MovieDataFetcher {
    RestClient restClient;

    public MovieDataFetcher() {
        HttpClient httpClient = HttpClients.custom().build();
        restClient  = new RestClient("http://www.omdbapi.com/", httpClient);
    }
    public MovieDataFetcher(String baseUrl) {
        HttpClient httpClient = HttpClients.custom().build();
        restClient  = new RestClient(baseUrl, httpClient);
    }

    public MovieInfo getMovieDataFromIMDB(String movieTitle) throws RestClientException, IOException {
        String jsonResponse;
        jsonResponse = restClient.executeGet("?t=" + movieTitle);
        return unMarhsall(jsonResponse);
    }

    private MovieInfo unMarhsall(String jsonResponse) throws IOException {
        MovieInfo info;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        info = mapper.readValue(jsonResponse, MovieInfo.class);
        return info;
    }
}
