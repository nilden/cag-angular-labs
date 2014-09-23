package com.caglabs.bookregister.domain;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Artist extends AbstractEntity {

    public String forename;
    public String surname;
    @Temporal(TemporalType.DATE)
    public Date birthDate;

    protected Artist(){}


    public Artist(String forename, String surname, Date birthDate) {
        this.forename = forename;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artist{");
        sb.append("forename='").append(forename).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
