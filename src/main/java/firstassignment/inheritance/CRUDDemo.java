package firstassignment.inheritance;

import java.util.*;

class Book {
    private int bookNo;
    private String title;
    private String author;
    private int pagesNo;

    Book(int bookNo, String title, String author, int pagesNo) {
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.pagesNo = pagesNo;
    }

    public int getBookNo() {
        return bookNo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesNo() {
        return pagesNo;
    }

    public String toString() {
        return  "Book = { genre=" + "ID: " + bookNo + " " + ", "+
                "title: " + title + " " + ", " +
                "author: " + author + " " + ", " +
                "number of pages: " + pagesNo + "}";
    }
}

class CRUDDemo {
    public static void main(String[] args) {

        List<Book> c = new ArrayList<Book>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Welcome to the Library!");
            System.out.println("1. Add book/s");
            System.out.println("2. List book/s");
            System.out.println("3. Search book/s");
            System.out.println("4. Delete book/s");
            System.out.println("5. Update book/s");
            System.out.println("Please, select your option: ");
            ch = s.nextInt();

            switch(ch) {
                case 1:
                    System.out.println("Enter book number: ");
                    int bookNo = s.nextInt();
                    System.out.println("Enter book title: ");
                    String title = s1.nextLine();
                    System.out.println("Enter book author: ");
                    String author = s1.nextLine();
                    System.out.println("Enter number of pages: ");
                    int pagesNo = s.nextInt();

                    c.add(new Book(bookNo, title, author, pagesNo));
                break;

                case 2:
                    System.out.println("--------------------------------");
                    Iterator<Book> i = c.iterator();
                    while(i.hasNext()) {
                        Book b = i.next();
                        System.out.println(b);
                    }
                    System.out.println("--------------------------------");
                break;

                case 3:
                    boolean found = false;
                    System.out.println("Please, enter the book id number: ");
                    int bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        Book b = i.next();
                        if (b.getBookNo() == bookNo1) {
                            System.out.println(b);
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The book was not found! :(");
                    }
                    System.out.println("--------------------------------");
                    break;

                case 4:
                    found = false;
                    System.out.println("Please, enter the book id in order to delete it: ");
                    bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        Book b = i.next();
                        if (b.getBookNo() == bookNo1) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The book was not found! :(");
                    } else {
                        System.out.println("The book as deleted from library! :)");
                    }
                    System.out.println("--------------------------------");
                    break;

                case 5:
                    found = false;
                    System.out.println("Please, enter the book id in order to edit it: ");
                    bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    ListIterator<Book> li = c.listIterator();
                    while(li.hasNext()) {
                        Book b = li.next();
                        if (b.getBookNo() == bookNo1) {
                            System.out.println("Enter new title: ");
                            title = s1.nextLine();
                            System.out.println("Enter new author: ");
                            author = s1.nextLine();
                            System.out.println("Edit current number of pages: ");
                            pagesNo = s.nextInt();
                            li.set(new Book(bookNo1, title, author, pagesNo));
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The book was not found! :(");
                    } else {
                        System.out.println("The book was updated in the library1! :)");
                    }
                    System.out.println("--------------------------------");
                    break;
            }
        } while(ch!=0);
    }
}
