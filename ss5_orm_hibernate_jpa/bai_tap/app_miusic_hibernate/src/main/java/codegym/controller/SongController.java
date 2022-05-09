package codegym.controller;


import codegym.model.Song;
import codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String getList(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("songList", iSongService.finAll());
        redirectAttributes.addFlashAttribute("message", "");
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String saveSong(Song song, RedirectAttributes redirectAttributes) {
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("message", "Save song successfully");
        return "redirect:/";
    }

    @GetMapping("/view")
    public String viewSong(Model model, int id) {
        model.addAttribute("song", iSongService.findById(id));
        return "view";
    }

    @GetMapping("/edit")
    public String editForm(Model model, int id) {
        model.addAttribute("song", iSongService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(Song song, RedirectAttributes redirectAttributes) {
        iSongService.update(song);
        redirectAttributes.addFlashAttribute("message", "update successfully");
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteSong (@RequestParam Integer id,RedirectAttributes redirectAttributes){
        iSongService.delete(iSongService.findById(id));
        redirectAttributes.addFlashAttribute("message","delete song successfully");
        return "redirect:/";
    }

}
