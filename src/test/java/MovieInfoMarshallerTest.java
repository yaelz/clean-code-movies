import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Yael_Zaritsky on 06/11/2016.
 */
public class MovieInfoMarshallerTest {
    MovieInfoMarshaller marshaller = new MovieInfoMarshaller();

    @Test
    public void testUnMarshall() throws IOException {
        assertEquals(marshaller.unMarhsall(
                "{\"Runtime\": \"98\", \"Poster\": \"https://images.jpg\", \"Plot\": \"A police officer\", \"imdbRating\": \"10\"}"),
                new MovieInfo(
                        "98",
                        "https://images.jpg",
                        "A police officer",
                        "10"
                ));
    }
}