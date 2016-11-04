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
    public void testWhatIsThePlot() {
        assertEquals(movieData.plot("men+in+black"), "A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth.");
    }

}