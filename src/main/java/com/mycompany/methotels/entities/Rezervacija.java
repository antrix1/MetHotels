/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.methotels.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Andrej
 */
@Entity
@Table(name = "rezervacija")
@NamedQueries({
    @NamedQuery(name = "Rezervacija.findAll", query = "SELECT r FROM Rezervacija r")})
public class Rezervacija implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REZERVACIJAID")
    private Integer rezervacijaid;
    @Lob
    @Column(name = "IME")
    @Validate("required, minLength=2")
    private String ime;
    @Lob
    @Column(name = "PREZIME")
    @Validate("required, minLength=2")
    private String prezime;
    @Column(name = "DATUM")
    @Temporal(TemporalType.DATE)
    @Validate("required")
    private Date datum;
    @Column(name = "BROJDANA")
    @Validate("required")
    private Integer brojdana;
    @Validate("required")
    @JoinColumn(name = "SOBAID", referencedColumnName = "SOBAID")
    @ManyToOne
    private Soba sobaid;

    @Inject
    public Rezervacija() {
    }

    public Rezervacija(Integer rezervacijaid) {
        this.rezervacijaid = rezervacijaid;
    }

    public Integer getRezervacijaid() {
        return rezervacijaid;
    }

    public void setRezervacijaid(Integer rezervacijaid) {
        this.rezervacijaid = rezervacijaid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getBrojdana() {
        return brojdana;
    }

    public void setBrojdana(Integer brojdana) {
        this.brojdana = brojdana;
    }

    public Soba getSobaid() {
        return sobaid;
    }

    public void setSobaid(Soba sobaid) {
        this.sobaid = sobaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rezervacijaid != null ? rezervacijaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rezervacija)) {
            return false;
        }
        Rezervacija other = (Rezervacija) object;
        if ((this.rezervacijaid == null && other.rezervacijaid != null) || (this.rezervacijaid != null && !this.rezervacijaid.equals(other.rezervacijaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.methotels.entities.Rezervacija[ rezervacijaid=" + rezervacijaid + " ]";
    }
    
}
