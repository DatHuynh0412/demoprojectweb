/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.controllers;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dht.pojo.Tour;
import com.dht.pojo.User;
import com.dht.service.TourService;
//import com.dht.pojo.User;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author huynh
 */
@Controller
public class HomeController {
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private TourService tourService;
    
    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "search", required = false) String kw){
        model.addAttribute("Tour",tourService.getTour(kw));
        return "index";
    }
    
    @GetMapping("/login")
    public String loginView(Model model){
        model.addAttribute("User", new User());
        return "login";
    }
    
    @GetMapping("/add")
    public String addView(Model model){
        model.addAttribute("Tour", new Tour());
        return "add";
    }
    
    @PostMapping("/add")
    public String addHandler(Model model, @ModelAttribute("Tour") Tour tour){
        if (!tour.getMultipartFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(tour.getMultipartFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto"
                        ));
                tour.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        tourService.addTour(tour);
        return "redirect:/";
    }
    
    @GetMapping("/{id}/edit")
    public String editView(@PathVariable("id") Integer id, Model model){
        Tour tour = tourService.getTourById(id);
        model.addAttribute("Tour", tour);
        return "edit";
    }
    
    @PostMapping("/{id}/edit")
    public String editHandler(Model model, @ModelAttribute("Tour") Tour tour){
        if (!tour.getMultipartFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(tour.getMultipartFile().getBytes(),
                        ObjectUtils.asMap(
                                "resource_type", "auto"
                        ));
                tour.setImage((String) res.get("secure_url"));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        tourService.editTour(tour);
        return "redirect:/";
    }
    
    @RequestMapping("/{id}/delete")
    public String deleteTour(@PathVariable("id") Integer id){
        Tour tour = tourService.getTourById(id);
        tourService.deleteTour(tour);
        return "redirect:/";
    }
}
