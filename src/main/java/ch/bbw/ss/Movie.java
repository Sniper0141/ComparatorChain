package ch.bbw.ss;

public class Movie implements Comparable<Movie> {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Movie o) {
        return title.compareTo(o.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
