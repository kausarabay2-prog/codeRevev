package bitlab.kx.hiber.GameHybernate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public Game getById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    public Game add(Game game) {
        return gameRepository.save(game);
    }

    public Game update(Game game) {
        return gameRepository.save(game);
    }

    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}