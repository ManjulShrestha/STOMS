package com.am.stoms.model.core.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.am.stoms.model.common.entity.BaseEntity;
import com.am.stoms.model.common.entity.ReferenceableByChild;
import com.am.stoms.model.metadata.entity.Color;
import com.am.stoms.model.metadata.entity.Manufacturer;
import com.am.stoms.model.metadata.entity.Model;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "am_product")
public class Product extends BaseEntity implements Serializable, ReferenceableByChild {

    private static final long serialVersionUID = 2016101711050L;

    @Column(name = "NAME_ENGLISH")
    private String nameEnglish;
    
    @Column(name = "CODE")
    private String code;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MODEL_ID")
    private Model model;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COLOR_ID")
    private Color color;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="MANUFACTURER_ID")
    private Manufacturer manufacturer;
    
    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }  

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub
    }
}
