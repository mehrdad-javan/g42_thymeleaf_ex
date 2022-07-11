package se.lexicon.thymeleafex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    List<String> contacts = new ArrayList<>();

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }


    @PostMapping("/contact")
    public String contact(@RequestParam("email") String email){
        System.out.println("Email:" + email);
        contacts.add(email);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts")
    public String contacts(Model model){
        model.addAttribute("contacts", contacts);
        return "contacts";
    }


}
