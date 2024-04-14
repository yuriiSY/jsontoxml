package com.yuriisykal.modal;


public abstract class Book {

    private String title;
    private String author;
    private int year_published;
    private String genre;


    public Book() {
    }

    public Book(String title, String author, int year_published, String genres) {
        this.title = title;
        this.author = author;
        this.year_published = year_published;
        this.genre = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year_published=" + year_published +
                ", genres='" + genre + '\'' +
                '}';
    }
}
