package com.petstore.as.controller;

import com.petstore.as.model.Owner;
import com.petstore.as.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping(value = {"/", "/all", "/owners"})
    public String getAll(Model model) {
        model.addAttribute("owners", service.getAll());
        return "all_owners";
    }

    @GetMapping("/{id}")
    public String getOwnerById(@PathVariable("id") Integer ownerId, Model model) {
        model.addAttribute("owner", service.getOwnerById(ownerId));
        return "id_owner";
    }

    @GetMapping(value = {"/create", "/new"})
    public String createOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "create_owner";
    }

    @GetMapping(value = {"/{id}/update", "/{id}/modify", "/{id}/edit"})
    public String updateOwnerById(Model model, @PathVariable Integer id) {
        model.addAttribute("owner", service.getOwnerById(id));
        return "update_owner";
    }

    @PostMapping(value = "/save_new")
    public String saveOwnerNew(Model model, Owner owner) {
        service.create(owner);
        model.addAttribute("owners", service.getAll());
        return "all_owners";
    }
    @PostMapping(value = "/save_update")
    public String saveOwnerUpdate(Model model, Owner owner) {
        service.create(owner);
        model.addAttribute("owners", service.getAll());
        return "all_owners";
    }

    @GetMapping("/{id}/delete")
    public String deleteOwnerById(Model model, @PathVariable Integer id) {
        service.deleteOwnerById(id);
        model.addAttribute("owners", service.getAll());
        return "all_owners";
    }

    @GetMapping("/{oid}/{pid}/deleteOwnerPet")
    public String deleteOwnerPetById(Model model, @PathVariable("oid") Integer ownerId, @PathVariable("pid") Integer petId) {
        service.deleteOwnerPet(ownerId, petId);
        model.addAttribute("owners", service.getAll());
        return "all_owners";
    }
}
