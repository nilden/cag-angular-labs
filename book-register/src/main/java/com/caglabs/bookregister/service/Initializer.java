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

    @RequestMapping(method = RequestMethod.POST, value = "/init")
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
        Book book1 = new Book(
                "The Grand Design",
                newArrayList(author1),
                "0-553-80537-1",
                new GregorianCalendar(2010, 7, 7).getTime());
        book1.authors.add(author1);
        Book book2 = new Book(
                "Black Holes and Baby Universes and Other Essays",
                newArrayList(author1),
                "0307790452",
                new GregorianCalendar(2011, 0, 1).getTime());
        book2.authors.add(author1);
        Book book3 = new Book(
                "Philosophiae Naturalis Principia Mathematica",
                newArrayList(author2),
                "9780762420223",
                new GregorianCalendar(1687, 0, 1).getTime());

        entityManager.persist(author1);
        entityManager.persist(author2);
        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);
        entityManager.flush();
        System.out.printf("Initialization complete!!!!\n");
    }
}
