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
                new GregorianCalendar(1942, 1, 8).getTime(),
                Lists.<Book>newArrayList());
        Book book1 = new Book(
                "The Grand Design",
                newArrayList(author1),
                "0-553-80537-1",
                new GregorianCalendar(2010, 9, 7).getTime());
        book1.authors.add(author1);
        entityManager.persist(author1);
        entityManager.persist(book1);
        entityManager.flush();
        System.out.printf("Initialization complete!!!!\n");
    }
}
