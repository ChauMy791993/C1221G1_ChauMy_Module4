package codegym.controller;

import codegym.model.Song;
import codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping(value = "/settings")
    public String goSettings(Model model) {
        model.addAttribute("song", new Song());
        return "settings";
    }

    @GetMapping(value = "/list")
    public String goList(Model model) {
        model.addAttribute("songList", iSongService.getSongList());
        return "list";
    }

    @PostMapping(value = "/save")
    public String saveList(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("message","successfully");
        return "redirect:/settings";
    }

}
