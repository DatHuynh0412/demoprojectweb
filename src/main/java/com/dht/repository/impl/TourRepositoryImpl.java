/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Tourinformation;
import com.dht.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author huynh
 */
@Repository
@Transactional
public class TourRepositoryImpl implements TourRepository{
    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;
    @Override
    public List<Tourinformation> getTour(String kw) {
         Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
         
         CriteriaBuilder b = session.getCriteriaBuilder();
         CriteriaQuery<Tourinformation> q = b.createQuery(Tourinformation.class);
         Root root = q.from(Tourinformation.class);
         q.select(root);
         
         if(kw != null && !kw.isEmpty()){
             Predicate p = b.like(root.get("name").as(String.class), 
                     String.format("%%%s%%", kw));
         }
         
         Query query = session.createQuery(q);
         return query.getResultList();
    }     
}
