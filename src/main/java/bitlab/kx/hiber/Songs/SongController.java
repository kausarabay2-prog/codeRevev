package bitlab.kx.hiber.Songs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SongController {

    private final SongRepository songRepository;

    // ALL + SEARCH
    @GetMapping("/")
    public String songsPage(
            Model model,

            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxDuration,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String genre
    ) {

        List<Song> songs =
                songRepository.findAllByCriteria(
                        minYear,
                        maxDuration,
                        title,
                        artist,
                        genre
                );

        model.addAttribute("songs", songs);

        return "songs";
    }

    // ADD PAGE
    @GetMapping("/add")
    public String addPage(Model model) {

        model.addAttribute("song", new Song());

        return "add-song";
    }

    // ADD
    @PostMapping("/add")
    public String addSong(@ModelAttribute Song song) {

        songRepository.save(song);

        return "redirect:/";
    }

    // DETAILS
    @GetMapping("/details/{id}")
    public String details(
            @PathVariable Long id,
            Model model
    ) {

        Song song = songRepository.findById(id)
                .orElse(null);

        model.addAttribute("song", song);

        return "details";
    }

    // UPDATE PAGE
    @GetMapping("/update/{id}")
    public String updatePage(
            @PathVariable Long id,
            Model model
    ) {

        Song song = songRepository.findById(id)
                .orElse(null);

        model.addAttribute("song", song);

        return "update-song";
    }

    // UPDATE
    @PostMapping("/update")
    public String updateSong(
            @ModelAttribute Song song
    ) {

        songRepository.save(song);

        return "redirect:/";
    }

    // DELETE
    @PostMapping("/delete/{id}")
    public String deleteSong(
            @PathVariable Long id
    ) {

        songRepository.deleteById(id);

        return "redirect:/";
    }
}