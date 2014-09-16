package com.caglabs.bookregister.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class Book extends AbstractEntity {
    public String title;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "publications")
    public List<Author> authors;
    public String isbn;
    @Temporal(TemporalType.DATE)
    public Date publicationDate;

    protected Book() {
    }

    public Book(String title, List<Author> authors, String isbn, Date publicationDate) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", authors=").append(authors);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", publicationDate=").append(publicationDate);
        sb.append('}');
        return sb.toString();
    }
}
