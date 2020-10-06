package com.bingyublog.demo.controller;

import com.southwind.springboottest.entity.Book;
import com.southwind.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll")
    public List<Book> list() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest request = PageRequest.of(page, size);
        return bookRepository.findAll(request);
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }


    @PutMapping("/update")
    public String update(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
    }

}
