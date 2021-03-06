/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dht.service;

import com.dht.pojo.Tour;
import java.util.List;

/**
 *
 * @author huynh
 */
public interface TourService {
    List<Tour> getTour(String kw);
    void addTour(Tour tour);
    Tour getTourById(Integer id);
    void editTour(Tour tour);
    void deleteTour(Tour tour);
}
