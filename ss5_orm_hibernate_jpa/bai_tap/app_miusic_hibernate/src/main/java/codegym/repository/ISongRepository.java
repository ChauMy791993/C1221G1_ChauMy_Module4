package codegym.repository;

import codegym.model.Song;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ISongRepository {
    List<Song> finAll();

    void save(Song song);

    void delete(Song song);

    void update (Song song);

    Song findById (int id);

}
