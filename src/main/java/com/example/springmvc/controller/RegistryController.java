package com.example.springmvc.controller;

import com.example.springmvc.model.Registry;
import com.example.springmvc.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistryController {

    private RegistryRepository registryRepository;

    @Autowired
    public void setProductRepository(RegistryRepository registryRepository) {
        this.registryRepository = registryRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/registries/add", method = RequestMethod.GET)
    public String createRegistry(Model model) {
        model.addAttribute("registry", new Registry());
        return "edit";
    }

    @RequestMapping(path = "registries", method = RequestMethod.POST)
    public String saveRegistry(Registry registry) {
    	registryRepository.save(registry);
        return "redirect:/";
    }

    @RequestMapping(path = "/registries", method = RequestMethod.GET)
    public String getAllRegistries(Model model) {
        model.addAttribute("registries", registryRepository.findAll());
        return "registries";
    }

    @RequestMapping(path = "/registries/edit/{id}", method = RequestMethod.GET)
    public String editRegistry(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("registry", registryRepository.findById(id));
        return "edit";
    }

    @RequestMapping(path = "/registries/delete/{id}", method = RequestMethod.GET)
    public String deleteRegistry(@PathVariable(name = "id") String id) {
    	registryRepository.deleteById(id);;
        return "redirect:/registries";
    }
}
