import com.wixpress.ci.rest.client.RestClientException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yael_Zaritsky on 03/11/2016.
 */
public class MovieDataTest {
    MovieData movieData = new MovieData();

    @Test
    public void testHowLongIsIt() throws RestClientException, IOException {
        assertEquals(movieData.howLongIsIt("men+in+black"), "98 min");
    }

    @Test
    public void testPlot() throws RestClientException, IOException {
        assertEquals(movieData.plot("men+in+black"), "A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth.");
    }

    @Test
    public void testRating() throws RestClientException, IOException {
        assertEquals(movieData.rating("men+in+black"), "7.3");
    }

    @Test
    public void testPosterUrl() throws RestClientException, IOException {
        assertEquals(movieData.posterUrl("men+in+black"), "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_SX300.jpg");
    }

}