package id.sjp.movie.api.staticvalues;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PathConstant {

    public static final String CREATE = "/create";
    public static final String REGISTER = "/register";
    public static final String UPDATE = "/update/{id}";
    public static final String DELETE = "/delete/{id}";
    public static final String SEARCH_MOVIE = "/search-movie";
    public static final String SEARCH_ACTOR = "/search-actor/{keyword}";
    public static final String SEARCH_DIRECTOR = "/search-director";
    public static final String SEARCH_GENRES = "/search-genres";
    public static final String SEARCH_REVIEWER = "/search-reviewer";
    public static final String SEARCH_MOVIE_CAST = "/search-movie-cast";
    public static final String SEARCH_MOVIE_DIRECTION = "/search-movie-direction";
    public static final String SEARCH_MOVIE_GENRES = "/search-movie-genres";
    public static final String SEARCH_MOVIE_RATING = "/search-movie-rating";
    public static final String ACTOR_LIST = "/find-all-actor/{page}/{size}";
    public static final String DIRECTOR_LIST = "/find-all-director/{page}/{size}";
    public static final String GENRES_LIST = "/find-all-genres/{page}/{size}";
    public static final String MOVIE_LIST = "/find-all-movie/{page}/{size}";
    public static final String MOVIE_LIST_DETAIL = "/find-detail-movie/{id}";
    public static final String MOVIE_CAST_LIST = "/find-all-movie-cast/{page}/{size}";
    public static final String MOVIE_DIRECTION_LIST = "/find-all-movie-direction/{page}/{size}";
    public static final String MOVIE_GENRES_LIST = "/find-all-movie-genres/{page}/{size}";
    public static final String MOVIE_RATING_LIST = "/find-all-movie-rating/{page}/{size}";
    public static final String REVIEWER_LIST = "/find-all-reviewer/{page}/{size}";


}
