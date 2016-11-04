import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Yael_Zaritsky on 03/11/2016.
 */

public class MovieInfo {
    private String runtime;
    private String posterUrl;
    private String plot;
    private String imdbRating;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public MovieInfo(@JsonProperty("Runtime")String Runtime,
                     @JsonProperty("Poster")String Poster,
                     @JsonProperty("Plot")String Plot,
                     @JsonProperty("imdbRating")String imdbRating) {
        this.runtime = Runtime;
        this.posterUrl = Poster;
        this.plot = Plot;
        this.imdbRating = imdbRating;
    }

    public String getPlot() {
        return plot;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
