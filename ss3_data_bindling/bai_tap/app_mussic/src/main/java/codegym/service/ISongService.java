package codegym.service;

import codegym.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> getSongList();
    void save (Song song);
}
