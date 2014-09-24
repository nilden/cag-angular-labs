/*
 * NYPS 2020
 * 
 * User: joel
 * Date: 2014-09-10
 * Time: 20:10
 */
package com.caglabs.bookregister.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Author extends AbstractEntity {
    public String forename;
    public String surname;
    @Temporal(TemporalType.DATE)
    public Date birthDate;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public List<Book> publications;

    protected Author() {
    }

    public Author(String forename, String surname, Date birthDate, List<Book> publications) {
        this.forename = forename;
        this.surname = surname;
        this.birthDate = birthDate;
        this.publications = publications;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("forename='").append(forename).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", publications=").append(publications);
        sb.append('}');
        return sb.toString();
    }
}
