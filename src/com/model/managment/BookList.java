package com.model.managment;

import java.util.*;

import com.model.data.Book;
import com.model.data.BookType;

public class BookList {

	 List<Book> books;

     BookList(){
         books = new ArrayList<>();
         books.add(new Book("Success",              "Hoaon Haji",   "dar alktb",  "3", "3.5", BookType.SELF_DEVELOPMENT));
         books.add(new Book("Politic Action", "Haron Omer", "dar alktb", "12", "6.8", BookType.POLITIC));
         books.add(new Book("Middle East History", "Roman Karim", "dar alktb", "24", "3", BookType.HISTORIC));
         books.add(new Book("principle of economy", "Ali Kamel", "dar alktb", "12", "8", BookType.ECONIMIC));
         books.add(new Book("Story before bed", "Joan Kamel", "dar alktb", "6", "9", BookType.CHILDREN));
         books.add(new Book("Success for you",      "Naz Alti", "dar alktb", "7", "9", BookType.SELF_DEVELOPMENT));
         books.add(new Book("External Politic", "Delshad Omer", "dar alktb", "8", "11", BookType.POLITIC));
         books.add(new Book("Power for entire year",              "Hoaon Haji",   "dar alktb",  "3", "3.5", BookType.SELF_DEVELOPMENT));
         books.add(new Book("Leaders Of Countries", "Haron Omer", "dar alktb", "12", "6.8", BookType.POLITIC));
         books.add(new Book("Middle East History", "Roman Karim", "dar alktb", "24", "3", BookType.HISTORIC));
         books.add(new Book("Increace Economy", "Ali Kamel", "dar alktb", "12", "8", BookType.ECONIMIC));
         books.add(new Book("How To", "Joan Kamel", "dar alktb", "6", "9", BookType.CHILDREN));
         books.add(new Book("Self improvment",      "Naz Alti", "dar alktb", "7", "9", BookType.SELF_DEVELOPMENT));
         books.add(new Book("1984", " george orwell", "dar alktb", "8", "11", BookType.NOVEL));
         books.add(new Book("Animal Farm", " george orwell", "dar alktb", "8", "11", BookType.NOVEL));
         books.add(new Book("Aldous Huxley", "", "dar alktb", "8", "11", BookType.NOVEL));
         books.add(new Book("Coraline", "Delshad Omer", "dar alktb", "8", "11", BookType.NOVEL));
     }

    public List<Book> getBooks(){
         return books;
    }

    public void add(){
         Scanner input = new Scanner(System.in);
         System.out.println("--------enter book information: ---------");
         String title, author, puplisher, number, price, typeStr;
         BookType type ;
         boolean inputAgain = false;
         do{

             try{
                 System.out.print("| book title: ");
                 title = input.nextLine();
                 System.out.print("| book auther: ");
                 author = input.nextLine();
                 System.out.print("| puplisher of book: ");
                 puplisher = input.nextLine();
                 System.out.print("| prise of book: ");
                 price = input.nextLine();
                 System.out.print("| number of books: ");
                 number = input.nextLine();
                 System.out.println("| select Type of books: ");
                 System.out.println("   | hi:  HISTORIC,       no: NOVEL,      sc: SCIENTIC,  ac: ACADEMIC,   ri: RILAGIN\n" +
                                    "   | sy:  PSYCHOLOJIST,   ch: CHILDREN,   po: POLITIC,   ec: ECONIMIC,   se: SELF_DEVELOPMENT ");
                 typeStr = input.nextLine();
                 type = getType(typeStr.toLowerCase());
                 System.out.println("                                                                                   @ Press inter key to submet ");
                 input.nextLine();
                 books.add(new Book(title, author, puplisher, number, price, type));
             }catch (Exception e){
                 System.out.println(e.getMessage());
                 inputAgain = true;
             }
         }while(inputAgain);
     }

     void remove(){
         Scanner input = new Scanner(System.in);
         System.out.print("Id of the book: ");
         int Id = input.nextInt();
         books.remove(Id);
     }

    void removeByType(List<Book> list){
         Optional<List<Book>> lists = Optional.ofNullable(list);
         if(lists.isPresent()) {
             for (Book book : list) {
                 books.remove(book);
             }
         }
    }


    void apdute(){
        Scanner input = new Scanner(System.in);
        System.out.print("Id of the book: ");
        int Id = input.nextInt();
        String title, author, puplisher, number, price, typeStr;
        BookType type ;
        if (Id < books.size()) {
            boolean inputAgain = false;
            Book book = books.get(Id);
            System.out.printf("|id: %-20d|title: %-30s |author: %-30s |price: %-20s \n",(book.getId()+1), book.getTitle(), book.getAuther(), book.getPrice());
            System.out.println();
            do {

                try {
                    System.out.print("| book title: ");
                    title = input.nextLine();
                    System.out.print("| book auther: ");
                    author = input.nextLine();
                    System.out.print("| puplisher of book: ");
                    puplisher = input.nextLine();
                    System.out.print("| prise of book: ");
                    price = input.nextLine();
                    System.out.print("| number of books: ");
                    number = input.nextLine();
                    System.out.println("| select Type of books: ");
                    System.out.println("   | hi:  HISTORIC,       no: NOVEL,      sc: SCIENTIC,  ac: ACADEMIC,   ri: RILAGIN\n" +
                            "   | sy:  PSYCHOLOJIST,   ch: CHILDREN,   po: POLITIC,   ec: ECONIMIC,   se: SELF_DEVELOPMENT ");
                    typeStr = input.nextLine();
                    type = getType(typeStr.toLowerCase());
                    System.out.println("                                                                                   @ Press inter key to submet ");
                    input.nextLine();
                    books.add(new Book(title, author, puplisher, number, price, type));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    inputAgain = true;
                }
            } while (inputAgain);
        }
    }



    private BookType getType(String str) throws Exception {
         switch (str.substring(0,2)){
             case "hi" :
                 return BookType.HISTORIC;
             case "no" :
                 return BookType.NOVEL;
             case "ac" :
                 return BookType.SCIENTIC;
             case "ri" :
                 return BookType.RILAGIN;
             case "sy" :
                 return BookType.PSYCHOLOJIST;
             case "ch" :
                 return BookType.CHILDREN;
             case "po" :
                 return BookType.POLITIC;
             case "ec" :
                 return BookType.ECONIMIC;
             case "se" :
                 return BookType.SELF_DEVELOPMENT;
             default:
                 throw new Exception("please select the type correctely : ");
         }

    }


}
//
//    ListFile file;
//    BookList(List<Book> books){
//        this.books = books;
//    }
//
//    BookList(String path) throws IOException{
//        // by default is getting listFile of Book
//        file = new ListFile<Book>(path);
//        books = (LinkedList)file.open();
//    }
//    void add(Book book) {
//        books.add(book);
//        file.add(book);
//
//    }
//    void close() throws IOException {
//        file.close();
//    }