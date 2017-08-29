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
@Table(name = "am_sales_detail")
public class SalesDetail extends BaseEntity implements Serializable, ReferenceableByChild {

    private static final long serialVersionUID = 2016101711050L;
 
    @Column(name = "AMOUNT")
    private Float amount;
    
    @Column(name = "RATE")
    private Float rate;
    
    @Column(name = "QUANTITY")
    private Float quantity;
    
    @Column(name = "DISCOUNT_AMOUNT")
    private Float disocuntAmount;
    
    @Column(name = "DISCOUNT_PERCENTAGE")
    private Float discountPercentage;  
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SALES_ID")
    private Sales sales;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="UNIT_ID")
    private Unit unit;
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getDisocuntAmount() {
        return disocuntAmount;
    }

    public void setDisocuntAmount(Float disocuntAmount) {
        this.disocuntAmount = disocuntAmount;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

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

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }  
    
    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub
    }
}
