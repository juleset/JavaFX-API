package org.example.dao;

import org.example.model.Album;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlbumDAO {
    List<Album> getAll();
    Optional<Album> get(UUID id);
    void save(Album album);
}
