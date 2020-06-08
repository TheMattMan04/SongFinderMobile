package models;

import com.google.gson.annotations.SerializedName;

public class SongResponse {
    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private String author;
    @SerializedName("lyrics")
    private String lyrics;
    @SerializedName("thumbnail")
    private Genius thumbnail;
    @SerializedName("links")
    private Genius links;
    @SerializedName("error")
    private String error;

    public SongResponse() { }

    public SongResponse(String title, String author, String lyrics, Genius thumbnail, Genius links, String error) {
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

    public Genius getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Genius thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Genius getLinks() {
        return links;
    }

    public void setLinks(Genius links) {
        this.links = links;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "SongResponse{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", lyrics='" + lyrics + '\'' +
                ", thumbnail=" + thumbnail +
                ", links=" + links +
                ", error='" + error + '\'' +
                '}';
    }
}
