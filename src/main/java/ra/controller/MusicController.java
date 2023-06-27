package ra.controller;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.model.Music;
import ra.service.IMusicService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")

public class MusicController {
    @Autowired
    IMusicService musicService;
    @GetMapping
    public String findAll(){
        List<Music> musicList = musicService.findAll();
        return "/listMusic";
    }

    @PostMapping("/createMusic")
    public String createMusic(@RequestParam("file")MultipartFile files, @ModelAttribute Music music, Model model) throws IOException {
        String uploadPath = "D:\\New folder (3)\\src\\main\\resources\\assets\\files\\";
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        String fileName = files.getOriginalFilename();
        FileCopyUtils.copy(files.getBytes(), new File(uploadPath + File.separator + fileName));
        model.addAttribute("fileName", fileName);
        Music songC = new Music(music.getName(),music.getSinger(),fileName);

        musicService.save(songC);
        return "redirect:/";
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
