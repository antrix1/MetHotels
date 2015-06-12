/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Andrej
 */
@Entity
@Table(name = "soba")
@NamedQueries({
    @NamedQuery(name = "Soba.findAll", query = "SELECT s FROM Soba s")})
public class Soba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SOBAID")
    private Integer sobaid;
    @Lob
    @Column(name = "IMESOBE")
    private String imesobe;
    @Column(name = "SPRAT")
    private Integer sprat;
    @Column(name = "TV")
    private Boolean tv;
    @Column(name = "DJAKUZI")
    private Boolean djakuzi;
    @Column(name = "INTERNET")
    private Boolean internet;
    @OneToMany(mappedBy = "sobaid")
    private List<Rezervacija> rezervacijaList;

    @Inject
    public Soba() {
    }

    public Soba(Integer sobaid) {
        this.sobaid = sobaid;
    }

    public Integer getSobaid() {
        return sobaid;
    }

    public void setSobaid(Integer sobaid) {
        this.sobaid = sobaid;
    }

    public String getImesobe() {
        return imesobe;
    }

    public void setImesobe(String imesobe) {
        this.imesobe = imesobe;
    }

    public Integer getSprat() {
        return sprat;
    }

    public void setSprat(Integer sprat) {
        this.sprat = sprat;
    }

    public Boolean getTv() {
        return tv;
    }

    public void setTv(Boolean tv) {
        this.tv = tv;
    }

    public Boolean getDjakuzi() {
        return djakuzi;
    }

    public void setDjakuzi(Boolean djakuzi) {
        this.djakuzi = djakuzi;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public List<Rezervacija> getRezervacijaList() {
        return rezervacijaList;
    }

    public void setRezervacijaList(List<Rezervacija> rezervacijaList) {
        this.rezervacijaList = rezervacijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sobaid != null ? sobaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soba)) {
            return false;
        }
        Soba other = (Soba) object;
        if ((this.sobaid == null && other.sobaid != null) || (this.sobaid != null && !this.sobaid.equals(other.sobaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imesobe;
    }
    
}
