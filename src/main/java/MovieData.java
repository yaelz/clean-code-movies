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
    private MovieDataFetcher movieDataFetcher;

    public MovieData(MovieDataFetcher movieDataFetcher) {
        this.movieDataFetcher = movieDataFetcher;
    }

    public String howLongIsIt(String movieTitle) throws RestClientException, IOException {
        MovieInfo info = movieDataFetcher.getMovieDataFromIMDB(movieTitle);
        return info.getRuntime();
    }

    public String plot(String movieTitle) throws RestClientException, IOException {
        MovieInfo info = movieDataFetcher.getMovieDataFromIMDB(movieTitle);
        return info.getPlot();
    }

    public String rating(String movieTitle) throws RestClientException, IOException {
        MovieInfo info = movieDataFetcher.getMovieDataFromIMDB(movieTitle);
        return info.getImdbRating();
    }

    public String posterUrl(String movieTitle) throws RestClientException, IOException {
        MovieInfo info = movieDataFetcher.getMovieDataFromIMDB(movieTitle);
        return info.getPosterUrl();
    }
}
