package codegym.service;

import codegym.model.Song;
import codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    @Override
    public List<Song> getSongList() {
        return iSongRepository.getSongList();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }
}
