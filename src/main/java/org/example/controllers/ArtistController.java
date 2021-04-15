package org.example.controllers;


import org.example.dao.ArtistDAO;
import org.example.dao.ArtistRestDAO;
import org.example.model.Artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtistController {
    private final ArtistDAO artistDAO = new ArtistRestDAO();

    public Artist createAlbum(String name) {
        var artist = new Artist(name);
        artistDAO.save(artist);
        return artist;
    }

    public List<Artist> getAll() {
        return artistDAO.getAll();
    }

    public Optional<Artist> get(UUID id) {
        return artistDAO.get(id);
    }
}
