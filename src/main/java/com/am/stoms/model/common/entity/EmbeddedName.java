/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.am.stoms.model.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author manjul
 */
@Embeddable
public class EmbeddedName {

    // NOTE: @Column is not needed as it gets override but incase having the not
    // to override this is helpful
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    public String getConcatenatedName() {
        // Assumes, firstname and lastname to be mandatory
        String result = firstName;
        if (middleName != null) {
            result += " " + middleName;
        }
        result += " " + lastName;
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
