/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.service.impl;

import com.dht.pojo.Tourinformation;
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
    public List<Tourinformation> getTour(String kw) {
        return this.tourRepository.getTour(kw);
    }
    
}
        
//@Autowired
//    private TourRepository tourRepository;
//    @Override
//    public List<Tourinformation> getTour() {
//        return this.tourRepository.getTour();
//    }