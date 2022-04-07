/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Tour;
import com.dht.repository.TourRepository;
import com.dht.service.TourService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author huynh
 */

@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;
    
    @Override
    public List<Tour> getTour(String kw) {
        return this.tourRepository.getTour(kw);
    }

    @Override
    public Tour getTourById(Integer id) {
        return this.tourRepository.getTourById(id);
    }

    @Override
    public void editTour(Tour tour) {
        this.tourRepository.editTour(tour);
    }

    @Override
    public void deleteTour(Tour tour) {
        this.tourRepository.deleteTour(tour);
    }

    @Override
    public void addTour(Tour tour) {
        this.tourRepository.addTour(tour);
    }
    
}