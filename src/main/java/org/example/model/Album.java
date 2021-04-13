package org.example.model;

import java.util.UUID;

public class Album {
    private final UUID id;
    private String artist;
    private String title;
    private Integer year;

    public Album(String artist, String title, Integer year) {
        this.id = UUID.randomUUID();
        this.artist = artist;
        this.title = title;
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public UUID getId() {
        return id;
    }
}
