package com.model.managment;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.model.data.Book;
import com.model.data.BookType;

import static java.util.stream.Collectors.toList;

public class BookListQueries {
	
	List<Book> books;

    BookListQueries(List<Book> list){
   	 books = list;
    }
     
    public List<Book> searchByType(BookType type){
            List<Book> bookList ;
            bookList = books.stream().
                    filter((t)->t.getBooktype().equals(type)).
                    collect(Collectors.toList());
            return bookList;
    }
    public List<Book> searchByTitle(String text){
            List<Book> bookList ;
            bookList = books.stream().
                    filter((t)->t.getTitle().contains(text)).
                    collect(Collectors.toList());
            return bookList;
    }

    public List<Book> searchByAuthor(String text){
        List<Book> bookList ;
        bookList = books.stream().
                filter((t)->t.getAuther().contains(text)).
                collect(Collectors.toList());
        return bookList;
    }

    public void displayResualt(List<Book> list){
        list.stream().
                sorted((o1,o2)->o2.getTitle().compareTo(o1.getTitle())).
                forEach((t)-> {
                   // String str = String.format("|%-40d||%-40d||%-40d|",t.getTitle(),t.getAuther(),t.getPrice());
                    System.out.printf("|title: %-30s |author: %-30s |price: %-20s \n",t.getTitle(),t.getAuther(),t.getPrice());
                });
    }

    public void displayAll(){
        books.stream().forEach(t->
                System.out.printf("|id: %-20d|title: %-30s |author: %-30s |price: %-20s \n",(t.getId()+1), t.getTitle(), t.getAuther(), t.getPrice()));
    }

    private String strFormat(String str){
        return  String.format("|%-20d|",str);
    }



}
