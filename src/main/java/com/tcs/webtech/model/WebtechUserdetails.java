/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.webtech.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ignite177
 */
@Entity
@Table(name = "webtech_userdetails")
@NamedQueries({
    @NamedQuery(name = "WebtechUserdetails.findAll", query = "SELECT w FROM WebtechUserdetails w")})
public class WebtechUserdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_webtech_userdetails")
    private Integer idWebtechUserdetails;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 60)
    @Column(name = "pwd")
    private String pwd;
    @Size(max = 100)
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "isCreatedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date isCreatedOn;
    @Column(name = "isDeleted")
    private Boolean isDeleted;

    public WebtechUserdetails(String name, String email, String pwd, String imagePath, Date isCreatedOn, Boolean isDeleted) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.imagePath = imagePath;
        this.isCreatedOn = isCreatedOn;
        this.isDeleted = isDeleted;
    }

    
    
    
    public WebtechUserdetails() {
    }

    public WebtechUserdetails(Integer idWebtechUserdetails) {
        this.idWebtechUserdetails = idWebtechUserdetails;
    }

    public Integer getIdWebtechUserdetails() {
        return idWebtechUserdetails;
    }

    public void setIdWebtechUserdetails(Integer idWebtechUserdetails) {
        this.idWebtechUserdetails = idWebtechUserdetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getIsCreatedOn() {
        return isCreatedOn;
    }

    public void setIsCreatedOn(Date isCreatedOn) {
        this.isCreatedOn = isCreatedOn;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWebtechUserdetails != null ? idWebtechUserdetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WebtechUserdetails)) {
            return false;
        }
        WebtechUserdetails other = (WebtechUserdetails) object;
        if ((this.idWebtechUserdetails == null && other.idWebtechUserdetails != null) || (this.idWebtechUserdetails != null && !this.idWebtechUserdetails.equals(other.idWebtechUserdetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.webtech.model.WebtechUserdetails[ idWebtechUserdetails=" + idWebtechUserdetails + " ]";
    }
    
}
