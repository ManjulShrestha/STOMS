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
import com.am.stoms.model.metadata.entity.Country;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "am_supplier")
public class Supplier extends BaseEntity implements Serializable, ReferenceableByChild {

    private static final long serialVersionUID = 2016101711050L;

    @Column(name="NAME_ENGLISH")
    private String nameEnglish;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
    
    @Column(name="BANK_NAME")
    private String bankName;
    
    @Column(name="ACCOUNT_NUMBER")
    private String accountNumber;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COUNTRY_ID")
    private Country country;

    public String getNameEnglish() {
        return nameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    @Override
    public void setReferenceInChildren() {
        // TODO Auto-generated method stub
    }
}
