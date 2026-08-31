package bitlab.kx.hiber.GameHybernate;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable Long id) {
        return gameService.getById(id);
    }

    @PostMapping
    public Game add(@RequestBody Game game) {
        return gameService.add(game);
    }

    @PutMapping
    public Game update(@RequestBody Game game) {
        return gameService.update(game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gameService.delete(id);
    }
}