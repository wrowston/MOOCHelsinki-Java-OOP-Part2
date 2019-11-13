package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        double o1Ratings = 0;
        double o2Ratings = 0;

        for (Rating rating : ratings.get(o1)) {
            o1Ratings += rating.getValue();
        }

        o1Ratings /= ratings.size();
        o1Ratings = (int) o1Ratings;

        for (Rating rating : ratings.get(o2)) {
            o2Ratings += rating.getValue();
        }

        o2Ratings /= ratings.size();
        o2Ratings = (int) o2Ratings;

        if (o1Ratings == o2Ratings) {
            return 0;
        } else if (o1Ratings > o2Ratings) {
            return -1;
        } else {
            return 1;
        }
    }
}