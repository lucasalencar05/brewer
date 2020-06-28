package com.brewer.controller;

import com.brewer.model.Cerveja;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CervejasController {


    @RequestMapping("/cervejas/novo")
    public String create(Cerveja cerveja) {
        return "cerveja/create";
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String store(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {

        if(result.hasErrors()) {
            return create(cerveja);
        }
        attributes.addFlashAttribute("message", "Sucesso, cadastro realizado");
        return "redirect:/cervejas/novo";
    }


}
