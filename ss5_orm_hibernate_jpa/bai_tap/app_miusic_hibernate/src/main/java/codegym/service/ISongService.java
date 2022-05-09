package codegym.service;

import codegym.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> finAll();

    void save(Song song);

    void delete(Song song);

    void update (Song song);

    Song findById (int id);
}
