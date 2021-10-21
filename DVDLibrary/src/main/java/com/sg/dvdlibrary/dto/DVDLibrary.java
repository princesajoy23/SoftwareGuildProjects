/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sg.dvdlibrary.dto;

/**
 *
 * @author Joy Gilbuena
 * @email princesajoy23@gmail.com
 * 
 * 
 */
public class DVDLibrary { //how it should be done, without implementation, DTO - data transfer object
                          //holds all the info

    private final String title; //we do it private so it can't be accidentally modified, limited accessibility ; local 
    private String genre;
    private String year;
    private String studio;
    private String directorsName;
    private String userRating; 
    private String mpaaRating;

    public DVDLibrary(String title) { // pass the title parameter
        this.title = title; // store it in title variable
    }

    public String getTitle() { //get title
        return title; //return the value that gets stored in the variable
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }
    
}
