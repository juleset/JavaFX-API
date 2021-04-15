package org.example.dao;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.example.model.Album;
import org.example.model.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ArtistRestDAO implements ArtistDAO{

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();


    @Override
    public List<Artist> getAll() {
        try {
            var request = new Request.Builder()
                    .url("http://localhost:3000/artists")
                    .build();

            var response = client.newCall(request).execute();
            var data = response.body().string();

            //Récupérer un album[]
            Artist[] artists = gson.fromJson(data, Artist[].class);

            //le transformer en List<Album>
            List<Artist> artistList = Arrays.asList(artists);

            //on retourne en List<Album>
            return artistList;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Optional<Artist> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(Artist artist) {

    }
}
