package com.acorn.day01Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StartController {

    @Autowired
    PracTaskService service;

    @GetMapping("/showallplayer")
    public String showAll(Model model){

        List<Player> list = service.showAll();
        model.addAttribute("list",list);

        return "showall";
    }

    @GetMapping("/showoneplayer")
    public String showOne(
            @RequestParam(name="name", required = false, defaultValue = "") String name,
            Model model){

        Player p = service.showOne(name);
        model.addAttribute("player",p);

        return "showone";
    }

    @GetMapping("/insertPlayer")
    public String insert(){
        return "insertPlayer";
    }

    @PostMapping("/inserting")
    public String insertPlayer(@ModelAttribute Player p){

        service.insert(p);

        return "redirect:/showallplayer";
    }

    @GetMapping("/deleteplayer")
    public String deletepPlayer(){
        return "deletePlayer";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam(name="name", required = false, defaultValue = "") String name
            ){
        service.delete(name);
        return "redirect:/showallplayer";
    }
}
