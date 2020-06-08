package models;

public class Song {
    private String title;
    private String author;
    private String lyrics;
    private String thumbnail;
    private String links;
    private String error;

    public Song(String title, String author, String lyrics, String thumbnail, String links, String error) {
        this.title = title;
        this.author = author;
        this.lyrics = lyrics;
        this.thumbnail = thumbnail;
        this.links = links;
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

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", links='" + links + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

    public void setError(String error) {
        this.error = error;
    }

}
