package org.example.dao;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.model.Album;

import java.io.IOException;
import java.util.*;

public class AlbumInMemoryDAO implements AlbumDAO {
    private final List<Album> data = new ArrayList<>();

    public AlbumInMemoryDAO() {
        this.data.add(new Album("Carpenter Brut", "Trilogy", 2015));
        this.data.add(new Album("Toxic Avenger", " Ξ", 2016));
    }


    @Override
    public List<Album> getAll() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public Optional<Album> get(UUID id) {
//        Album album = null;
//        for (var item : data) {
//            if (item.getId().equals(id)) {
//                album = item;
//                break;
//            }
//        }
//        return Optional.ofNullable(album);

       return data
            .stream()
            .filter(a -> a.getId().equals(id))
            .findAny();
    }

    @Override
    public void save(Album album) {
        data.add(album);
    }
}
