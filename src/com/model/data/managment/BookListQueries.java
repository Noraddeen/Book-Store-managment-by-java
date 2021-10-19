package com.model.data.managment;

import java.util.List;

import com.model.data.Book;

public class BookListQueries {
	
	List<Book> books;
    ListFile file;
    
    BookListQueries(List<Book> books){
   	 this.books = books;
    }
     
    BookListQueries(){                // by default is getting listFile of Book
   	  file = new ListFile<Book>("BookList.txt");
   	  books = file.open();
    }
    
    Book find(){
    	
    	
    	
    }

}
