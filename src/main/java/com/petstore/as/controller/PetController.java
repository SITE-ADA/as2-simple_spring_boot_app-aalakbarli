package com.petstore.as.controller;

import com.petstore.as.model.Owner;
import com.petstore.as.model.Pet;
import com.petstore.as.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService service;

    @RequestMapping(value = {"/", "/all"}, method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("pets", service.getAll());
        return "all_pets";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getPetById(Model model, @PathVariable Integer id) {
        model.addAttribute("pet", service.getPetById(id));
        return "id_pet";
    }

    @RequestMapping(value = {"/create", "/new"}, method = RequestMethod.GET)
    public String createPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "create_pet";
    }

    @RequestMapping(value = {"/{id}/update", "/{id}/edit", "/{id}/modify"}, method = RequestMethod.GET)
    public String updatePetById(Model model, @PathVariable Integer id) {
        model.addAttribute("pet", service.getPetById(id));
        return "update_pet";
    }

    @RequestMapping(value = {"save_new"}, method = RequestMethod.POST)
    public String saveNew(Model model, Pet pet) {
        service.createPet(pet);
        model.addAttribute("pets", service.getAll());
        return "all_pets";
    }

    @RequestMapping(value = {"save_update"}, method = RequestMethod.POST)
    public String saveUpdate(Model model, Pet pet) {
        service.updatePet(pet);
        model.addAttribute("pets", service.getAll());
        return "all_pets";
    }

    @RequestMapping(value = {"/{id}/delete"}, method = RequestMethod.GET)
    public String deletePetById(Model model, @PathVariable Integer id) {
        service.deletePetById(id);
        model.addAttribute("pets", service.getAll());
        return "all_pets";
    }

    @RequestMapping(value = {"/{id}/remove_from_owner"}, method = RequestMethod.GET)
    public String removeFromOwner(Model model, @PathVariable Integer id) {
        service.removeFromOwner(id);
        model.addAttribute("pets", service.getAll());
        return "all_pets";
    }
}
