/*
 * NYPS 2020
 * 
 * User: joel
 * Date: 2014-09-04
 * Time: 23:37
 */
package com.caglabs.bookregister.service;

import com.caglabs.bookregister.domain.Author;
import com.caglabs.bookregister.domain.Book;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import java.util.GregorianCalendar;

import static com.google.common.collect.Lists.newArrayList;

@Controller
@Transactional
public class Initializer {
    @Autowired
    private EntityManager entityManager;

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "/init")
    @ResponseBody
    @Transactional
    public void initialize() {
        System.out.printf("Initializing!!!!\n");
        Author author1 = new Author(
                "Stephen",
                "Hawking",
                new GregorianCalendar(1942, 0, 8).getTime(),
                Lists.<Book>newArrayList());
        Author author2 = new Author(
                "Isaac",
                "Newton",
                new GregorianCalendar(1642, 11, 25).getTime(),
                Lists.<Book>newArrayList());
        Author author3 = new Author(
                "Douglas",
                "Adams",
                new GregorianCalendar(1952, 3, 11).getTime(),
                Lists.<Book>newArrayList());
        Book book1 = new Book(
                "The Grand Design",
                newArrayList(author1),
                "0-553-80537-1",
                new GregorianCalendar(2010, 7, 7).getTime());
        book1.authors.add(author1);
        author1.publications.add(book1);
        Book book2 = new Book(
                "Black Holes and Baby Universes and Other Essays",
                newArrayList(author1),
                "0307790452",
                new GregorianCalendar(2011, 0, 1).getTime());
        book2.authors.add(author1);
        author1.publications.add(book2);
        Book book3 = new Book(
                "Philosophiae Naturalis Principia Mathematica",
                newArrayList(author2),
                "9780762420223",
                new GregorianCalendar(1687, 0, 1).getTime());
        author2.publications.add(book3);
        Book book4 = new Book(
                "The Hitchiker's Guide to the Galaxy",
                newArrayList(author3),
                "0-330-25864-8",
                new GregorianCalendar(1979, 10, 12).getTime());
        author3.publications.add(book4);
        Book book5 = new Book(
                "Fictive",
                newArrayList(author1,author2,author3),
                "42",
                new GregorianCalendar(2145, 10, 12).getTime());
        author1.publications.add(book5);
        author2.publications.add(book5);
        author3.publications.add(book5);
        entityManager.persist(author1);
        entityManager.persist(author2);
        entityManager.persist(author3);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);
        entityManager.persist(book4);
        entityManager.persist(book5);
        entityManager.flush();
        System.out.printf("Initialization complete!!!!\n");
    }
}
