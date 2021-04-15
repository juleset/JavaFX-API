package org.example.dao;


import com.google.gson.Gson;
import okhttp3.*;
import org.example.model.Album;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AlbumRestDAO implements AlbumDAO{

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    @Override
    public List<Album> getAll() {
        try {
            var request = new Request.Builder()
                    .url("http://localhost:3000/albums")
                    .build();

            var response = client.newCall(request).execute();
            var data = response.body().string();

            //Récupérer un album[]
            Album[] albums = gson.fromJson(data, Album[].class);

            //le transformer en List<Album>
            List<Album> albumList = Arrays.asList(albums);

            //on retourne en List<Album>
            return albumList;
        } catch (Exception e){
            return null;
        }

    }

    @Override
    public Optional<Album> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public void save(Album album) {
        try {
            var data = gson.toJson(album);

            MediaType mediaType = MediaType.parse("application/json");
            var body = RequestBody.create(mediaType, data);

            var request = new Request.Builder()
                    .url("http://localhost:3000/albums")
                    .post(body)
                    .addHeader("Content-Type", "Application/json")
                    .build();

            client.newCall(request).execute();
        }catch (IOException e){
            System.out.println("erreur");
        }

    }
}
