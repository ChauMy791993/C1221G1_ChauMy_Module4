package codegym.service.impl;


import codegym.model.Song;
import codegym.repository.ISongRepository;
import codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> finAll() {
        return iSongRepository.finAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void delete(Song song) {
        iSongRepository.delete(song);
    }

    @Override
    public void update( Song song) {
        iSongRepository.update(song);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id);
    }
}
