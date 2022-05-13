package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> finAll();

    void save(Song song);

}
