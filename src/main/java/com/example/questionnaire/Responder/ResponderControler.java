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

    @GetMapping("/form")
    public String showForm(Model model){
        Responder responder = new Responder();
        model.addAttribute("responder",responder);
        return "index";
    }


    @PostMapping("/add")
    public String registerNewResponder(@ModelAttribute Responder responder){
        responderService.addNewResponder(responder);
        return "index";
    }

}
