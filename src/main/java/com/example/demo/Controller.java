package com.example.demo;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    ArrayList<String> opgaver = new ArrayList<>();


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("opgaver", opgaver);

        return "index";
    }

    @GetMapping("/add")
    public String add(WebRequest data) {
        int counter = Integer.parseInt(data.getParameter("counterID"));

        for (int i = 1; i < counter + 1; i++) {
            opgaver.add(data.getParameter("opgaver" + i));
        }

        return "redirect:/";
    }

}
