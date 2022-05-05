package codegym.repository;

import codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> getSongList();
    void save (Song song);
}
