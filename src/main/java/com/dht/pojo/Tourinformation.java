/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author huynh
 */
@Entity
@Table(name = "tourinformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tourinformation.findAll", query = "SELECT t FROM Tourinformation t"),
    @NamedQuery(name = "Tourinformation.findByTourId", query = "SELECT t FROM Tourinformation t WHERE t.tourId = :tourId"),
    @NamedQuery(name = "Tourinformation.findByNameTour", query = "SELECT t FROM Tourinformation t WHERE t.nameTour = :nameTour"),
    @NamedQuery(name = "Tourinformation.findByBookingDate", query = "SELECT t FROM Tourinformation t WHERE t.bookingDate = :bookingDate"),
    @NamedQuery(name = "Tourinformation.findByPrice", query = "SELECT t FROM Tourinformation t WHERE t.price = :price"),
    @NamedQuery(name = "Tourinformation.findByImage", query = "SELECT t FROM Tourinformation t WHERE t.image = :image")})
public class Tourinformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tour_id")
    private Integer tourId;
    @Size(max = 100)
    @Column(name = "name_tour")
    private String nameTour;
    @Size(max = 20)
    @Column(name = "booking_date")
    private String bookingDate;
    @Column(name = "price")
    private Long price;
    @Size(max = 100)
    @Column(name = "image")
    private String image;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public Tourinformation() {
    }

    public Tourinformation(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tourId != null ? tourId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tourinformation)) {
            return false;
        }
        Tourinformation other = (Tourinformation) object;
        if ((this.tourId == null && other.tourId != null) || (this.tourId != null && !this.tourId.equals(other.tourId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.Tourinformation[ tourId=" + tourId + " ]";
    }
    
}
