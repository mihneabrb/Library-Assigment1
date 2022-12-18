package firstassignment.inheritance;

import java.util.*;

public class Novel extends Book {
    private String genre;

    Novel(int bookNo, String title, String author, int pagesNo, String genre) {
        super(bookNo, title, author, pagesNo);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Novel = { genre=" + genre + " , " + super.toString() + "}";
    }

    public static void main(String[] args) {

        List<Novel> c = new ArrayList<Novel>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Welcome to the Library for novels!");
            System.out.println("1. Add novel/s");
            System.out.println("2. List novel/s");
            System.out.println("3. Search novel/s");
            System.out.println("4. Delete novel/s");
            System.out.println("5. Update novel/s");
            System.out.println("Please, select your option: ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter novel number: ");
                    int bookNo = s.nextInt();
                    System.out.println("Enter novel title: ");
                    String title = s1.nextLine();
                    System.out.println("Enter novel author: ");
                    String author = s1.nextLine();
                    System.out.println("Enter number of pages: ");
                    int pagesNo = s.nextInt();
                    System.out.println("Enter novel genre: ");
                    String genre = s1.nextLine();

                    c.add(new Novel(bookNo, title, author, pagesNo, genre));
                    break;

                case 2:
                    System.out.println("--------------------------------");
                    Iterator<Novel> i = c.iterator();
                    while(i.hasNext()) {
                        Novel n = i.next();
                        System.out.println(n);
                    }
                    System.out.println("--------------------------------");
                    break;

                case 3:
                    boolean found = false;
                    System.out.println("Please, enter the novel id number: ");
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
                        System.out.println("The novel was not found! :(");
                    }
                    System.out.println("--------------------------------");
                    break;

                case 4:
                    found = false;
                    System.out.println("Please, enter the novel id in order to delete it: ");
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
                        System.out.println("The novel was not found! :(");
                    } else {
                        System.out.println("The novel as deleted from library! :)");
                    }
                    System.out.println("--------------------------------");
                    break;

                case 5:
                    found = false;
                    System.out.println("Please, enter the novel id in order to edit it: ");
                    bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    ListIterator<Novel> li = c.listIterator();
                    while(li.hasNext()) {
                        Book b = li.next();
                        if (b.getBookNo() == bookNo1) {
                            System.out.println("Enter new title: ");
                            title = s1.nextLine();
                            System.out.println("Enter new author: ");
                            author = s1.nextLine();
                            System.out.println("Edit current number of pages: ");
                            pagesNo = s.nextInt();
                            System.out.println("Enter new genre: ");
                            genre = s1.nextLine();
                            li.set(new Novel(bookNo1, title, author, pagesNo, genre));
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The novel was not found! :(");
                    } else {
                        System.out.println("The novel was updated in the library! :)");
                    }
                    System.out.println("--------------------------------");
                    break;
            }
        } while (ch != 0);
    }
}
