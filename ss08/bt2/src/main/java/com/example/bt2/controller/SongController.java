package com.example.bt2.controller;

import com.example.bt2.dto.SongDto;
import com.example.bt2.model.Song;
import com.example.bt2.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("song")
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songList",songService.showList());
        return "list";
    }
    @GetMapping("create")
    public String create(Model model){
        SongDto songDto = new SongDto();
        model.addAttribute("songDto",songDto);
        return "create";
    }
    @PostMapping("create")
    public String create(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
       if (bindingResult.hasErrors()){
            return "create";
       }
       Song song= new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.add(song);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công!");
        return "redirect:/song";
    }
    @GetMapping("update/{id}")
    public String update(@PathVariable int id, Model model){
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "update";
    }
    @PostMapping("update")
    public String update(@Valid @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "update";
        }
        Song song= new Song();
        BeanUtils.copyProperties(songDto,song);
        songService.update(song);
        redirectAttributes.addFlashAttribute("mess","Chỉnh sửa thành công!");
        return "redirect:/song";
    }
}
