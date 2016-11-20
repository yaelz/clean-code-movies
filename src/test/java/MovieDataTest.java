import com.wixpress.ci.rest.client.RestClientException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yael_Zaritsky on 03/11/2016.
 */
public class MovieDataTest extends Mockito {
    MovieDataFetcher fetcher = mock(MovieDataFetcher.class);
    MovieData movieDataForMIB;

    @Before
    public void executedBeforeEach() throws RestClientException, IOException {
        when(fetcher.getMovieDataFromIMDB("men+in+black")).thenReturn(
                new MovieInfo(
                        "98 min",
                        "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_SX300.jpg",
                        "A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth.",
                        "7.3"
                )
        );
        movieDataForMIB = new MovieData(fetcher, "men+in+black");
    }


    @Test
    public void testHowLongIsIt() throws RestClientException, IOException {
        assertEquals(movieDataForMIB.howLongIsIt(), "98 min");
    }

    @Test
    public void testPlot() throws RestClientException, IOException {
        assertEquals(movieDataForMIB.plot(), "A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth.");
    }

    @Test
    public void testRating() throws RestClientException, IOException {
        assertEquals(movieDataForMIB.rating(), "7.3");
    }

    @Test
    public void testPosterUrl() throws RestClientException, IOException {
        assertEquals(movieDataForMIB.posterUrl(), "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_SX300.jpg");
    }

}