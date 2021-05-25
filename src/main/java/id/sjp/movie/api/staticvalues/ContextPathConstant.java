package id.sjp.movie.api.staticvalues;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContextPathConstant {
    public static final String VERSION_V1 = "/v1";
    public static final String ACTOR = "/actor";
    public static final String DIRECTOR = "/director";
    public static final String GENRES = "/genres";
    public static final String MOVIE = "/movie";
    public static final String MOVIE_CAST = "/movie-cast";
    public static final String MOVIE_DIRECTION = "/movie-direction";
    public static final String MOVIE_GENRES = "/movie-genres";
    public static final String MOVIE_RATING = "/movie-rating";
    public static final String REVIEWER = "/reviewer";

    public static final String USERS = "/users";
}
