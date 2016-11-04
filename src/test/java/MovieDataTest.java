import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Yael_Zaritsky on 03/11/2016.
 */
public class MovieDataTest {
    MovieData movieData = new MovieData();

    @Test
    public void testHowLongIsIt() {
        assertEquals(movieData.howLongIsIt("men+in+black"), "98 min");
    }

    @Test
    public void testPlot() {
        assertEquals(movieData.plot("men+in+black"), "A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth.");
    }

    @Test
    public void testRating() {
        assertEquals(movieData.rating("men+in+black"), "7.3");
    }

    @Test
    public void testPosterUrl() {
        assertEquals(movieData.posterUrl("men+in+black"), "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_SX300.jpg");
    }

}