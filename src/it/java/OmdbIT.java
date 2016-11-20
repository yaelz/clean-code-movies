import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Created by Yael_Zaritsky on 05/11/2016.
 */
public class OmdbIT {
    int PORT = 8080;
    MovieDataClient movieDataClient = new MovieDataClient("http://localhost:" + PORT);
    EmbeddedOMDB embeddedOMDB = new EmbeddedOMDB();

    @Test
    public void test() throws Exception {
        MovieInfo expected = new MovieInfo("98 min",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA2MzI5Nzc0N15BMl5BanBnXkFtZTcwODE2NDU2MQ@@._V1_SX300.jpg",
                "A police officer joins a secret organization that polices and monitors extraterrestrial interactions on Earth.",
                "7.3");
        embeddedOMDB.start(PORT);
        embeddedOMDB.setApiResponse("men in black", expected);
        assertEquals(expected, movieDataClient.getMovieDataFromIMDB("men+in+black"));
        embeddedOMDB.shutDown();
    }
}
