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
@Table(name = "commentinformation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commentinformation.findAll", query = "SELECT c FROM Commentinformation c"),
    @NamedQuery(name = "Commentinformation.findByCommentId", query = "SELECT c FROM Commentinformation c WHERE c.commentId = :commentId"),
    @NamedQuery(name = "Commentinformation.findByCommentTour", query = "SELECT c FROM Commentinformation c WHERE c.commentTour = :commentTour")})
public class Commentinformation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id")
    private Integer commentId;
    @Size(max = 100)
    @Column(name = "comment_Tour")
    private String commentTour;
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id")
    @ManyToOne
    private Tourinformation tourId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public Commentinformation() {
    }

    public Commentinformation(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentTour() {
        return commentTour;
    }

    public void setCommentTour(String commentTour) {
        this.commentTour = commentTour;
    }

    public Tourinformation getTourId() {
        return tourId;
    }

    public void setTourId(Tourinformation tourId) {
        this.tourId = tourId;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commentinformation)) {
            return false;
        }
        Commentinformation other = (Commentinformation) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.Commentinformation[ commentId=" + commentId + " ]";
    }
    
}
