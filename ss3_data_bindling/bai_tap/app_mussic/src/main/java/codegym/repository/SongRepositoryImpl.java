package codegym.repository;

import codegym.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {
    public static List<Song> songList = new ArrayList<>();

    static {
        songList.add(new Song("hello", "adele", "Pop", "mp3.zing"));
    }

    @Override
    public List<Song> getSongList() {
        return songList;
    }

    @Override
    public void save(Song song) {
        songList.add(song);
    }
}
