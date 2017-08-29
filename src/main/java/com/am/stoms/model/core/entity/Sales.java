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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "am_sales")
public class Sales extends BaseEntity implements Serializable, ReferenceableByChild {

    private static final long serialVersionUID = 2016101711050L;

    @Column(name = "AMOUNT")
    private Float amount;
    
    @Column(name = "DISCOUNT_AMOUNT")
    private Float disocuntAmount;
    
    @Column(name = "DISCOUNT_PERCENTAGE")
    private Float discountPercentage;
    
    @Column(name = "TOTAL_AMOUNT")
    private Float totalAmount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="BUYER_ID")
    private Buyer buyer;

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

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
    
    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub
    }
}
