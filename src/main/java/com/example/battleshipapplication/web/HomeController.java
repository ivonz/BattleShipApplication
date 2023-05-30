package com.example.battleshipapplication.web;

import com.example.battleshipapplication.Domain.entities.Ship;
import com.example.battleshipapplication.Domain.helpers.LoggedUser;
import com.example.battleshipapplication.Domain.model.binding.BattleShipsModel;
import com.example.battleshipapplication.Domain.model.binding.UserWithShipsModel;
import com.example.battleshipapplication.repositories.ShipRepository;
import com.example.battleshipapplication.services.BattleService;
import com.example.battleshipapplication.services.ShipService;
import com.example.battleshipapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final LoggedUser loggedUser;
    private final BattleService battleService;
    private final UserService userService;
    private final ShipRepository shipRepository;
    private final ShipService shipService;

    @Autowired
    public HomeController(LoggedUser loggedUser, BattleService battleService, UserService userService, ShipRepository shipRepository, ShipService shipService) {
        this.loggedUser = loggedUser;
        this.battleService = battleService;
        this.userService = userService;
        this.shipRepository = shipRepository;
        this.shipService = shipService;
    }

    @GetMapping("home")
    public ModelAndView getHome(ModelAndView modelAndView) {

        UserWithShipsModel loggedUserWithShips = this.battleService.getUserWithShips(this.loggedUser.getId());
        UserWithShipsModel notLoggedUserWithShips = this.battleService.getUserWithShips(this.userService.findByIdNot(this.loggedUser.getId()).getId());

        modelAndView.setViewName("home");
        modelAndView.addObject("loggedUserWithShips", loggedUserWithShips);
        modelAndView.addObject("notLoggedUserWithShips", notLoggedUserWithShips);

        return modelAndView;
    }

    @PostMapping("battle")
    public String getHome(@ModelAttribute(name = "battleShipsModel") BattleShipsModel battleShipsModel) {

        this.shipService.fight(battleShipsModel);

        return "redirect:home";
    }

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @ModelAttribute(name = "battleShipsModel")
    public BattleShipsModel battleShipsModel() {
        return new BattleShipsModel();
    }

    @ModelAttribute(name = "allShips")
    public List<Ship> ships() {
        return this.shipRepository.findAll();
    }
}
