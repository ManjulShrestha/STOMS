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
@Table(name = "am_sales_return")
public class SalesReturn extends BaseEntity implements Serializable, ReferenceableByChild {

    private static final long serialVersionUID = 2016101711050L;
    
    @Column(name = "TOTAL_AMOUNT")
    private Float totalAmount;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="SALES_ID")
    private Sales sales;

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }  
    
    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub
    }
}
