/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author huynh
 */
@Entity
@Table(name = "tickettype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickettype.findAll", query = "SELECT t FROM Tickettype t"),
    @NamedQuery(name = "Tickettype.findByType", query = "SELECT t FROM Tickettype t WHERE t.type = :type"),
    @NamedQuery(name = "Tickettype.findByDiscount", query = "SELECT t FROM Tickettype t WHERE t.discount = :discount")})
public class Tickettype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private Boolean type;
    @Column(name = "discount")
    private Short discount;

    public Tickettype() {
    }

    public Tickettype(Boolean type) {
        this.type = type;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Short getDiscount() {
        return discount;
    }

    public void setDiscount(Short discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tickettype)) {
            return false;
        }
        Tickettype other = (Tickettype) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dht.pojo.Tickettype[ type=" + type + " ]";
    }
    
}
