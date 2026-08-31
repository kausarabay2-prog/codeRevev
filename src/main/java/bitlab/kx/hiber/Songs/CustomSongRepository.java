package bitlab.kx.hiber.Songs;

import java.util.List;

public interface CustomSongRepository {

    List<Song> findAllByCriteria(
            Integer minYear,
            Integer maxDuration,
            String name,
            String artist,
            String genre
    );
}