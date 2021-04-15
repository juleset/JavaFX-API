package org.example.dao;

import org.example.model.Artist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArtistDAO {
    List<Artist> getAll();
    Optional<Artist> get(UUID id);
    void save(Artist artist);
}
