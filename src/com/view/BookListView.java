package com.view;

import com.model.data.Book;
import com.model.data.BookType;
import com.model.managment.BookList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookListView implements ListViewInterface{
    BookList books;
    Scanner input;

    public BookListView() {
        books = new BookList();
        input = new Scanner(System.in);
    }

    public void showSteps() throws Exception {
           boolean close = false;
           displayList(books.getBooks());
        do {
            System.out.println("\n |  options to managment Book datas : ");
            System.out.println(" |  1 : insert Book");
            System.out.println(" |  2 : remove Book");
            System.out.println(" |  3 : update Book");
            System.out.println(" |  4 : display Books");
            System.out.println(" |  5 : search Books");
            System.out.println(" |  0 : exit books list");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 :
                    add();
                    break;
                case 2 :
                    remove();
                    break;
                case 3 :
                    update();
                    break;
                case 4:
                    displayList(books.getBooks());
                    break;
                case 5 :
                    search();
                    break;
                case 0 :
                    close = true;
                    break;
                default:
                    System.out.println("  |  please input valid option number");
            }
        }while(!close);
    }

    public void add(){
        System.out.println("\n-------- enter book information: ---------\n");
        String title, author, puplisher, number, price, typeStr;
        BookType type;
        boolean inputAgain = false;
        do {

            try {
                title = input("title");
                author = input("author");
                puplisher = input("puplisher");
                number = input("number");
                price = input("price");
                displayType();
                typeStr = input("type");
                type = getType(typeStr);

                books.add(new Book(title, author, puplisher, number, price, type));

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("want to continue for adding");
                inputAgain = confirming("add");

            }
        } while (inputAgain);
    }

    public void update() {
        System.out.println("  |  to update, select book title : ");
        List<Book> bookList =  new ArrayList<>();
        try {
            bookList = searchByTitle();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        Book book ;
        if(bookList.size() > 1) {
             System.out.println("have more than one book with the same title, input Id");
             book = searchById();
        }else {
            book = bookList.get(0);
        }
        String title, author, puplisher, number, price, typeStr;
        BookType type ;
            boolean inputAgain ;
            do {
                    inputAgain = false;
                try {

                    title = input("title");
                    book.setTitle(title.equals("-") ? book.getTitle() : title);

                    author = input("author");
                    book.setAuthor(author.equals("-")? book.getAuther() : author);

                    puplisher = input("puplisher");
                    book.setPuplisher(puplisher.equals("-")? book.getPuplisher() : puplisher);

                    number = input("number");
                    book.setnumber(number.equals("-")? ""+book.getnumber() : number);

                    price = input("price");
                    book.setprice(price.equals("-")? ""+book.getprice() : price);

                    displayType();
                    typeStr = input("type");
                    book.setBookType(typeStr.equals("-")? book.getBooktype() : getType(typeStr));

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("want to continue for updating");
                    if(confirming("update"))
                    inputAgain = true;
                }
            } while (inputAgain);
        }

       public void remove() {
        System.out.println("\n---remove books---");
        System.out.println("  |  1 remove book by id");
        System.out.println("  |  2 remove book by title");
        System.out.println("  |  3 remove book by author");
        System.out.println("  |  4 remove book by Type");
        System.out.println("  |  0 close removing section");
        int choice ;
        try {
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    removeById();
                    break;
                case 2:
                    removeByTitle();
                    break;
                case 3:
                    removeByAuther();
                    break;
                case 4:
                    removeBytype();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("added wrong choice option number for delete");
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }catch (Exception e2){
            System.out.println(e2.getMessage());
        }
    }

    private void removeById() {
        Book book = searchById();
        if(confirming("remove"))
        books.removeById(book);
    }
    private void removeByTitle() throws Exception {
        List<Book> bookList = searchByTitle();
        if(confirming("remove"))
        books.removeByTitle(bookList);
    }
    private void removeByAuther() throws Exception {
        List<Book> bookList = searchByAuther();
        if(confirming("remove"))
        books.removeByAuthor(bookList);
    }
    private void removeBytype() throws Exception {
        List<Book> bookList = searchByType();
        if(confirming("remove"))
        books.removeByType(bookList);
    }
    private boolean confirming(String str){
        boolean validInput ;
        do {
            validInput = !true;
            System.out.print("  |  Confirm to "+str+" [ y:yes | n:no ] : ");
            String YorN = input.nextLine();
            if (YorN.substring(0,1).contains("y")) {
                return true;
            } else if(YorN.substring(0,1).contains("n")){
                return false;
            }else{
                validInput = !false;
                System.out.println("please inter yes or no or just character y or n");
            }
        }while(validInput);
        return false;
    }


    public void search() throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("   | 1 : search by title");
        System.out.println("   | 2 : search by author");
        System.out.println("   | 3 : search by Id");
        System.out.println("   | 4 : search by type");
        System.out.println("   | 0 : close searching section");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice){
            case 3 :
                searchById();
                break;
            case 1 :
                searchByTitle();
                break;
            case 2 :
                searchByAuther();
                break;
            case 4 :
                searchByType();
                break;
            case 0 :
                return;
            default :
                System.out.println("input wrong option");
        }
    }

    public List<Book> searchByAuther() throws Exception {
        String author = input("author");
        List<Book> bookList = books.getByAthor(author);
        System.out.println("  |  list of book with you search \n");
        displayList(bookList);
        return bookList;
    }

    public List<Book> searchByType() throws Exception {
        displayType();
        String type = input("type");
        List<Book> bookList = books.getByType(getType(type));
        System.out.println("  |  list of book you search \n");
        displayList(bookList);
        return bookList;
    }

    public Book searchById() {
        long id = Long.parseLong(input("Id"));
        Book book = books.getById(id);
        System.out.println("  |  list of book you search \n");
        displayList(new ArrayList<>(){{add(book);}});
        return book;
    }

    public List<Book> searchByTitle() throws Exception {
        String title = input("title");
        List<Book> bookList = books.getByTitle(title);
        System.out.println("\n  |  list of book you search \n");
        displayList(bookList);
        return bookList;
    }

     private void displayList(List<Book> bookList){
        for(Book t : bookList){
            System.out.printf("|id: %-20d|title: %-30s |author: %-25s |number: %-10s |type: %-25s |price: %-20s \n",
                    t.getId(),
                    t.getTitle(),
                    t.getAuther(),
                    t.getnumber(),
                    t.getBooktype(),
                    t.getprice());
        }
    }

    private void displayType(){
        System.out.println("  |  those are types enter one with just first two characters ");
        System.out.println("   | hi:  HISTORIC,       no: NOVEL,      sc: SCIENTIC,  ac: ACADEMIC,   ri: RILAGIN\n" +
                "   | sy:  PSYCHOLOJIST,   ch: CHILDREN,   po: POLITIC,   ec: ECONIMIC,   se: SELF_DEVELOPMENT ");
    }

    private String input(String inputKind) {
        System.out.print("  |  book "+inputKind+": ");
        return input.nextLine();
    }

    private BookType getType(String str) throws Exception {
        switch (str.substring(0, 2)) {
            case "hi":
                return BookType.HISTORIC;
            case "no":
                return BookType.NOVEL;
            case "ac":
                return BookType.SCIENTIC;
            case "ri":
                return BookType.RILAGIN;
            case "sy":
                return BookType.PSYCHOLOJIST;
            case "ch":
                return BookType.CHILDREN;
            case "po":
                return BookType.POLITIC;
            case "ec":
                return BookType.ECONIMIC;
            case "se":
                return BookType.SELF_DEVELOPMENT;
            default:
                throw new Exception("please select the type correctely : ");
        }

    }
}
