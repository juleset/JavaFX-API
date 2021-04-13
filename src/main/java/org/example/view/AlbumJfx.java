package org.example.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.model.Album;

public class AlbumJfx {
    private final SimpleStringProperty artist;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty year;

    public AlbumJfx(Album album) {
        this(album.getArtist(), album.getTitle(), album.getYear());
    }

    public AlbumJfx(String artist, String name, int year) {
        this.artist = new SimpleStringProperty(artist);
        this.name = new SimpleStringProperty(name);
        this.year = new SimpleIntegerProperty(year);
    }

    public String getArtist() {
        return artist.get();
    }

    public SimpleStringProperty artistProperty() {
        return artist;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }
}
