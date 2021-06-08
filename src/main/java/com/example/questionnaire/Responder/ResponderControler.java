package com.example.questionnaire.Responder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResponderControler {


    private ResponderService responderService;

    @Autowired
    public ResponderControler(ResponderService responderService){
        this.responderService = responderService;
    }

    @GetMapping("/")
    public String showForm(Model model){
        Responder responder = new Responder();
        Diseases diseases = new Diseases();
        model.addAttribute("responder",responder);
        model.addAttribute("diseases",diseases);
        return "index";
    }


    @PostMapping("/add")
    public String registerNewResponder(@ModelAttribute Responder responder,@ModelAttribute Diseases diseases){
        responderService.addNewResponder(responder,diseases);
        return "index";
    }

}

