/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.repository.impl;

import com.dht.pojo.Tour;
import com.dht.repository.TourRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class TourRepositoryImpl implements TourRepository {

    @Autowired
    private LocalSessionFactoryBean localSessionFactoryBean;

    @Override
    public List<Tour> getTour(String kw) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Tour> q = b.createQuery(Tour.class);
        Root root = q.from(Tour.class);
        q.select(root);

        if (kw != null && !kw.isEmpty()) {
            Predicate p = b.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            q.where(p);
        }

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Tour getTourById(Integer id) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        Query q = session.createQuery("select t from Tour t where id = "+id);
        return (Tour) q.getSingleResult();
    }

    @Override
    public void editTour(Tour tour) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        session.update(tour);
    }

    @Override
    public void deleteTour(Tour tour) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        session.delete(tour);
    }

    @Override
    public void addTour(Tour tour) {
        Session session = this.localSessionFactoryBean.getObject().getCurrentSession();
        session.save(tour);
    }
}
