package com.model.managment;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.model.data.Book;
import com.model.data.BookType;
import com.model.data.Customer;

public class BookList {

	 List<Book> books;
    ListFile<Book> file;

//     public BookList(String str){
//         books = new ArrayList<>();
//         books.add(new Book("Success",              "Hoaon Haji",   "dar alktb",  "3", "3.5", BookType.SELF_DEVELOPMENT));
//         books.add(new Book("Politic Action", "Haron Omer", "dar alktb", "12", "6.8", BookType.POLITIC));
//         books.add(new Book("Middle East History", "Roman Karim", "dar alktb", "24", "3", BookType.HISTORIC));
//         books.add(new Book("principle of economy", "Ali Kamel", "dar alktb", "12", "8", BookType.ECONIMIC));
//         books.add(new Book("Story before bed", "Joan Kamel", "dar alktb", "6", "9", BookType.CHILDREN));
//         books.add(new Book("Success for you",      "Naz Alti", "dar alktb", "7", "9", BookType.SELF_DEVELOPMENT));
//         books.add(new Book("External Politic", "Delshad Omer", "dar alktb", "8", "11", BookType.POLITIC));
//         books.add(new Book("Power for entire year",              "Hoaon Haji",   "dar alktb",  "3", "3.5", BookType.SELF_DEVELOPMENT));
//         books.add(new Book("Leaders Of Countries", "Haron Omer", "dar alktb", "12", "6.8", BookType.POLITIC));
//         books.add(new Book("Middle East History", "Roman Karim", "dar alktb", "24", "3", BookType.HISTORIC));
//         books.add(new Book("Increace Economy", "Ali Kamel", "dar alktb", "12", "8", BookType.ECONIMIC));
//         books.add(new Book("How To", "Joan Kamel", "dar alktb", "6", "9", BookType.CHILDREN));
//         books.add(new Book("Self improvment",      "Naz Alti", "dar alktb", "7", "9", BookType.SELF_DEVELOPMENT));
//         books.add(new Book("1984", " george orwell", "dar alktb", "8", "11", BookType.NOVEL));
//         books.add(new Book("Animal Farm", " george orwell", "dar alktb", "8", "11", BookType.NOVEL));
//         books.add(new Book("Aldous Huxley", "Joan Kamel", "dar alktb", "8", "11", BookType.NOVEL));
//         books.add(new Book("Coraline", "Delshad Omer", "dar alktb", "8", "11", BookType.NOVEL));
//         file = new ListFile<Book>("books");
//         file.saveAndClose(books);
//     }
    public BookList(){
         try {
             file = new ListFile<Book>("books");
             books = file.openAndFitch();
         }catch (Exception e) {
             System.out.println(e.getMessage());
         }
    }

    public List<Book> getBooks(){
         return books;
    }

    public Book getById(long id){
         Book book;
         book = (Book) books.stream()
                 .filter(t -> t.getId() == id)
                 .findAny()
                 .orElse(null);
         return Optional.ofNullable(book)
                 .orElseThrow(()->new IllegalStateException("in field price be aware of not input except numbers"));
    }


    public List<Book> getByTitle(String title) throws Exception {
         List<Book> bookList =  books.stream()
                 .filter((t)->t.getTitle().toLowerCase().equals(title.toLowerCase()))
                 .collect(Collectors.toList());
         if(bookList.size() == 0){
             throw new Exception(" | book with the title"+title +" not found");
         }
         return bookList ;
    }
    public List<Book> getByAthor(String auhtor) throws Exception {
        List<Book> bookList =  books.stream()
                .filter((t)->t.getAuther().equals(auhtor))
                .collect(Collectors.toList());
        if(bookList.size() == 0){
            throw new Exception(" | the ather "+auhtor +" not found");
        }
        return bookList ;
    }
     public void removeById(Book book){
         books.remove(book);
     }
     public void removeByTitle(List<Book> bookList) {
         books.removeAll(bookList);
     }
    public void removeByAuthor(List<Book> bookList) {
        books.removeAll(bookList);
    }
    public void removeByType(List<Book> bookList){
         books.removeAll(bookList);
    }
    public List<Book> getByType(BookType type) throws Exception {
         List<Book> bookList ;
         bookList = books.stream().filter((t)->t.getBooktype().equals(type)).collect(Collectors.toList());
        if(bookList.size() == 0){
            throw new Exception(" | the type "+ type.toString() +" not found");
        }
        return bookList ;
    }

    public void add(Book book) {
         books.add(book);
    }
    public void saveUpdate(){
        file.saveAndClose(books);
    }
}