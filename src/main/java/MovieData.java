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
    private MovieInfo info;

    public MovieData(MovieDataFetcher movieDataFetcher, String movieTitle) throws RestClientException, IOException {
        info = movieDataFetcher.getMovieDataFromIMDB(movieTitle);
    }

    public String howLongIsIt() throws RestClientException, IOException {
        return info.getRuntime();
    }

    public String plot() throws RestClientException, IOException {
        return info.getPlot();
    }

    public String rating() throws RestClientException, IOException {
        return info.getImdbRating();
    }

    public String posterUrl() throws RestClientException, IOException {
        return info.getPosterUrl();
    }
}
