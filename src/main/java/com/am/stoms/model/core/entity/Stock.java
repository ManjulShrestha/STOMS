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
import com.am.stoms.model.metadata.entity.Unit;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "am_stock")
public class Stock extends BaseEntity implements Serializable, ReferenceableByChild {

    private static final long serialVersionUID = 2016101711050L;

    @Column(name = "RATE")
    private Float rate;
    
    @Column(name = "QUANTITY")
    private Float quantity;
    
    @Column(name = "IN_QUANTITY")
    private Float inQuantity;
    
    @Column(name = "OUT_QUANTITY")
    private Float outQuantity;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PRODUCT_ID")
    private Product product;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="UNIT_ID")
    private Unit unit; 

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getInQuantity() {
        return inQuantity;
    }

    public void setInQuantity(Float inQuantity) {
        this.inQuantity = inQuantity;
    }

    public Float getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(Float outQuantity) {
        this.outQuantity = outQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub
    }
}
