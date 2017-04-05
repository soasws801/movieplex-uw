/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author umairwarsi
 */
@Entity
@Table(name = "THEATERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t")
    ,
 @NamedQuery(name = "Theater.findById",
            query = "SELECT t FROM Theater t WHERE t.id = :id")
    ,
 @NamedQuery(name = "Theater.findByCapacity",
            query = "SELECT t FROM Theater t WHERE t.capacity = :capacity")})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private Integer id;
    @NotNull
    private int capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private Collection<ShowTiming> showTimings;

    public Theater() {
    }

    public Theater(Integer id) {
        this.id = id;
    }

    public Theater(Integer id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public Collection<ShowTiming> getShowTimings() {
        return showTimings;
    }

    public void setShowTimings(Collection<ShowTiming> showTimings) {
        this.showTimings = showTimings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Theater[id=" + id + "]";
    }
}
