package com.company;

/**
 * class representing DVD object
 *
 * @author paulina
 */
public class DVD {
    private int id;
    private String title;
    private String realiseDate;
    private String mppaRating;
    private String director;
    private String studio;
    private String userRating;

    public DVD(int id, String title, String realiseDate, String mppaRating, String director,
               String studio, String userRating) {
        this.id = id;
        this.title = title;
        this.realiseDate = realiseDate;
        this.mppaRating = mppaRating;
        this.director = director;
        this.studio = studio;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRealiseDate() {
        return realiseDate;
    }

    public void setRealiseDate(String realiseDate) {
        this.realiseDate = realiseDate;
    }

    public String getMppaRating() {
        return mppaRating;
    }

    public void setMppaRating(String mppaRating) {
        this.mppaRating = mppaRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
