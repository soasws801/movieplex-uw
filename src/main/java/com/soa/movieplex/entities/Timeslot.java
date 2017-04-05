/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soa.movieplex.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author umairwarsi
 */
@Entity
@Table(name = "TIMESLOTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timeslot.findAll", query = "SELECT t FROM Timeslot t")
    ,
 @NamedQuery(name = "Timeslot.findById",
            query = "SELECT t FROM Timeslot t WHERE t.id = :id")
    ,
 @NamedQuery(name = "Timeslot.findByStartTime",
            query = "SELECT t FROM Timeslot t WHERE t.startTime = :startTime")
    ,
 @NamedQuery(name = "Timeslot.findByEndTime", query = "SELECT t FROM Timeslot t WHERE t.endTime = :endTime")})
public class Timeslot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 1, max = 5)

    @Column(name = "START_TIME")
    private String startTime;
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "END_TIME")
    private String endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timeslot")
    private Collection<ShowTiming> showTimings;

    public Timeslot() {

    }

    public Timeslot(Integer id) {
        this.id = id;
    }

    public Timeslot(Integer id, String startTime, String endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        if (!(object instanceof Timeslot)) {
            return false;
        }
        Timeslot other = (Timeslot) object;
        if ((this.id == null && other.id != null) || (this.id != null
                && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return startTime;
    }
}
