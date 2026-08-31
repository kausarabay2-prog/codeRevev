package bitlab.kx.hiber.Songs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomSongRepositoryImpl implements CustomSongRepository {

    private final EntityManager entityManager;

    @Override
    public List<Song> findAllByCriteria(
            Integer minYear,
            Integer maxDuration,
            String name,
            String artist,
            String genre) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Song> query = cb.createQuery(Song.class);

        Root<Song> root = query.from(Song.class);

        List<Predicate> predicates = new ArrayList<>();

        if (minYear != null) {
            predicates.add(
                    cb.greaterThanOrEqualTo(
                            root.get("year"),
                            minYear
                    )
            );
        }

        if (maxDuration != null) {
            predicates.add(
                    cb.lessThanOrEqualTo(
                            root.get("duration"),
                            maxDuration
                    )
            );
        }

        if (name != null && !name.isEmpty()) {
            predicates.add(
                    cb.like(
                            cb.lower(root.get("name")),
                            "%" + name.toLowerCase() + "%"
                    )
            );
        }

        if (artist != null && !artist.isEmpty()) {
            predicates.add(
                    cb.like(
                            cb.lower(root.get("artist")),
                            "%" + artist.toLowerCase() + "%"
                    )
            );
        }

        if (genre != null && !genre.isEmpty()) {
            predicates.add(
                    cb.equal(
                            root.get("genre"),
                            genre
                    )
            );
        }

        if (!predicates.isEmpty()) {
            query.where(
                    predicates.toArray(new Predicate[0])
            );
        }

        TypedQuery<Song> typedQuery =
                entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}