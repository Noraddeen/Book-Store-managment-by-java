package com.model.data.managment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.data.Book;

public class BookList {
	
	 List<Book> books;
     ListFile file;
     
     BookList(List<Book> books){
    	 this.books = books;
     }
      
     BookList(){                // by default is getting listFile of Book
    	  file = new ListFile<Book>("BookList.txt");
    	  books = (LinkedList)file.open();
    	  
     }
     
     void add(Book book) {
    	 books.add(book);
    	 file.add(book);
     }
     
     
     
     void close() {
    	 file.close();
     }

}
