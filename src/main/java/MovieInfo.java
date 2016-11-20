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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieInfo info = (MovieInfo) o;

        if (runtime != null ? !runtime.equals(info.runtime) : info.runtime != null) return false;
        if (posterUrl != null ? !posterUrl.equals(info.posterUrl) : info.posterUrl != null) return false;
        if (plot != null ? !plot.equals(info.plot) : info.plot != null) return false;
        return imdbRating != null ? imdbRating.equals(info.imdbRating) : info.imdbRating == null;

    }

    @Override
    public int hashCode() {
        int result = runtime != null ? runtime.hashCode() : 0;
        result = 31 * result + (posterUrl != null ? posterUrl.hashCode() : 0);
        result = 31 * result + (plot != null ? plot.hashCode() : 0);
        result = 31 * result + (imdbRating != null ? imdbRating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieInfo{" +
                "runtime='" + runtime + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", plot='" + plot + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
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
