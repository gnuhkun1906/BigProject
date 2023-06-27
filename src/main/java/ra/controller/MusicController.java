package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.model.Music;
import ra.service.IMusicService;

@Controller
@RequestMapping("/")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @PostMapping("/update")
    public String upDate( @ModelAttribute("music")Music music){
        musicService.save(music);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id,Model model){
        Music music=musicService.findById(id);
        model.addAttribute("music",music);
        return "updateMusic";
    }
}
