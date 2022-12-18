package firstassignment.inheritance;

import java.util.*;

public class ArtAlbums extends Book {
    private String paperQuality;

    ArtAlbums(int bookNo, String title, String author, int pagesNo, String paperQuality) {
        super(bookNo, title, author, pagesNo);
        this.paperQuality = paperQuality;
    }

    public String getPaperQuality() {
        return paperQuality;
    }

    public void setPaperQuality() {
        this.paperQuality = paperQuality;
    }

    @Override
    public String toString() {
        return "ArtAlbums = { paper quality=" + paperQuality + " , " + super.toString() + "}";
    }

    public static void main(String[] args) {

        List<ArtAlbums> c = new ArrayList<ArtAlbums>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Welcome to the Library for Art Albums!");
            System.out.println("1. Add art album/s");
            System.out.println("2. List art album/s");
            System.out.println("3. Search art album/s");
            System.out.println("4. Delete art album/s");
            System.out.println("5. Update art album/s");
            System.out.println("Please, select your option: ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter art album number: ");
                    int bookNo = s.nextInt();
                    System.out.println("Enter art album title: ");
                    String title = s1.nextLine();
                    System.out.println("Enter art album author: ");
                    String author = s1.nextLine();
                    System.out.println("Enter number of pages: ");
                    int pagesNo = s.nextInt();
                    System.out.println("Enter paper quality: ");
                    String paperQuality = s1.nextLine();

                    c.add(new ArtAlbums(bookNo, title, author, pagesNo, paperQuality));
                    break;

                case 2:
                    System.out.println("--------------------------------");
                    Iterator<ArtAlbums> i = c.iterator();
                    while(i.hasNext()) {
                        ArtAlbums a = i.next();
                        System.out.println(a);
                    }
                    System.out.println("--------------------------------");
                    break;

                case 3:
                    boolean found = false;
                    System.out.println("Please, enter the art album id number: ");
                    int bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        ArtAlbums a = i.next();
                        if (a.getBookNo() == bookNo1) {
                            System.out.println(a);
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The art album was not found! :(");
                    }
                    System.out.println("--------------------------------");
                    break;

                case 4:
                    found = false;
                    System.out.println("Please, enter the art album id in order to delete it: ");
                    bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        ArtAlbums a = i.next();
                        if (a.getBookNo() == bookNo1) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The art album was not found! :(");
                    } else {
                        System.out.println("The art album as deleted from library! :)");
                    }
                    System.out.println("--------------------------------");
                    break;

                case 5:
                    found = false;
                    System.out.println("Please, enter the art album id in order to edit it: ");
                    bookNo1 = s.nextInt();
                    System.out.println("--------------------------------");
                    ListIterator<ArtAlbums> li = c.listIterator();
                    while(li.hasNext()) {
                        ArtAlbums a = li.next();
                        if (a.getBookNo() == bookNo1) {
                            System.out.println("Enter new title: ");
                            title = s1.nextLine();
                            System.out.println("Enter new author: ");
                            author = s1.nextLine();
                            System.out.println("Edit current number of pages: ");
                            pagesNo = s.nextInt();
                            System.out.println("Enter new paper quality: ");
                            paperQuality = s1.nextLine();
                            li.set(new ArtAlbums(bookNo1, title, author, pagesNo, paperQuality));
                            found = true;
                        }
                    }
                    if (found == false) {
                        System.out.println("The art album was not found! :(");
                    } else {
                        System.out.println("The art album was updated in the library! :)");
                    }
                    System.out.println("--------------------------------");
                    break;
            }
        } while (ch != 0);
    }
}
