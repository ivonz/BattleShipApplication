package com.example.battleshipapplication.web;

import com.example.battleshipapplication.Domain.model.binding.ShipAddModel;
import com.example.battleshipapplication.services.ShipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;

    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/add")
    public String getAddShip() {
        return "ship-add";
    }

    @PostMapping("/add")
    public String postAddShip(@Valid @ModelAttribute(name = "shipAddModel")ShipAddModel shipAddModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("shipAddModel", shipAddModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipAddModel",
                            bindingResult);

            return "redirect:add";
        }

        this.shipService.addShip(shipAddModel);

        return "redirect:/home";
    }

    //model attributes
    @ModelAttribute(name = "shipAddModel")
    public ShipAddModel shipAddModel() {
        return new ShipAddModel();
    }
}
