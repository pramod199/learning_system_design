package lld_algomaster.bookmyshow.entities;


import java.util.List;

public class Movie {
    private String id;
    private String title;
    private int durationInMinutes;
    private String language;
    private String genre;
    private List<Show> shows;

    public Movie(String id, String title, int durationInMinutes) {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getDurationInMinutes() { return durationInMinutes; }
    public String getLanguage() { return language; }
    public String getGenre() { return genre; }
}
