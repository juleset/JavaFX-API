package org.example.controllers;

import org.example.dao.AlbumDAO;
import org.example.dao.AlbumInMemoryDAO;
import org.example.dao.AlbumRestDAO;
import org.example.model.Album;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AlbumController {
    private final AlbumDAO albumDAO = new AlbumRestDAO();

    public Album createAlbum(String artist, String title, Integer year) {
         var album = new Album(artist, title, year);
         albumDAO.save(album);
         return album;
    }

    public List<Album> getAll() {
        return albumDAO.getAll();
    }

    public Optional<Album> get(UUID id) {
        return albumDAO.get(id);
    }
}
