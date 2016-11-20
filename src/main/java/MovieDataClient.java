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
public class MovieDataClient {
    RestClient restClient;
    HttpClient httpClient = HttpClients.custom().build();
    MovieInfoMarshaller marshaller = new MovieInfoMarshaller();

    public MovieDataClient(String baseUrl) {
        restClient  = new RestClient(baseUrl, httpClient);
    }

    public MovieInfo getMovieDataFromIMDB(String movieTitle) throws RestClientException, IOException {
        String jsonResponse;
        jsonResponse = restClient.executeGet("?t=" + movieTitle);
        return marshaller.unMarhsall(jsonResponse);
    }
}
