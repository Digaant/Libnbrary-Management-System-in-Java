import Entities.Book;
import Entities.Issue;
import Entities.User;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LMS_Implementation {
    static List<Book> books = new ArrayList<Book>();
    static List<User> users = new ArrayList<User>();
    static List<Issue> issues = new ArrayList<Issue>();

    public static void main(String[] args) {
        boolean quit = false;
        while(!quit){
            int choice = getChoice();
            switch(choice){
                case 1 : addBook();
                        break;
                case 2 : addUser();
                        break;
                case 3 : issueBook();
                        break;
                case 4 : returnBook();
                        break;
                case 5 : searchBook();
                        break;
                case 6 : searchUser();
                        break;
                case 7 : viewAllBooks();
                        break;
                case 8 : viewAllUsers();
                        break;
                case 9 : quit = true;
                        break;
                default : System.out.println("Enter valid number please");
            }
        }

    }
    public static void printMenu(){
        System.out.println("Choose what you would like to do according to the options given below :(1-9)");
        System.out.println("1. Add book to the library." +
                "\n2. Add User." +
                "\n3. Issue Book." +
                "\n4. Return Book." +
                "\n5. Search Book." +
                "\n6. Search User." +
                "\n7. View All Books." +
                "\n8. View All Users." +
                "\n9. Exit");
    }
    public static int getChoice(){
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int choice = scanner.nextInt();
        return choice;
    }
    public static void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book Details : ");
        System.out.println("Book ID : ");
        Long id = scanner.nextLong();
        System.out.println("Book Name : ");
        scanner.nextLine();
        String bookName = scanner.nextLine();
        System.out.println("Price : ");
        int price = scanner.nextInt();
        System.out.println("Genre : ");
        scanner.nextLine();
        String genre = scanner.nextLine();
        AtomicInteger flag = new AtomicInteger();
        flag.set(0);
        if (books.isEmpty()) {
            Book book = new Book(id, bookName, price, genre);
            books.add(book);
            System.out.println("Book with following details has been added" + book.toString());
        } else {
            books.forEach(book -> {
                if (book.getBID().equals(id)) {
                    flag.set(1);
                    System.out.println("Book with same Book ID already exists.");
                }
            });
            if (flag.get() == 0) {
                Book book = new Book(id, bookName, price, genre);
                books.add(book);
                System.out.println("Book with following details has been added" + book.toString());
            }
        }
    }
    public static void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter User Details : ");
        System.out.println("User ID : ");
        Long id = scanner.nextLong();
        System.out.println("User Name : ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        System.out.println("Password : ");
        String password = scanner.nextLine();
        System.out.println("Admin : ('true/false')");
        Boolean admin = scanner.nextBoolean();
        AtomicInteger flag = new AtomicInteger();
        flag.set(0);
        if (users.isEmpty()) {
            User user = new User(id, userName, password, admin);
            users.add(user);
            System.out.println("User with following details has been added" + user.toString());
        } else {
            users.forEach(user -> {
                if (user.getUID().equals(id)) {
                    flag.set(1);
                    System.out.println("User with same User ID already exists");
                }
            });
            if (flag.get() == 0) {
                User user = new User(id, userName, password, admin);
                users.add(user);
                System.out.println("User with following details has been added" + user.toString());
            }
        }
    }
    public static void searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Book Name to be searched for : ");
        scanner.nextLine();
        String bookName = scanner.nextLine();
        AtomicInteger flag = new AtomicInteger();
        flag.set(0);
        books.forEach(book -> {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                flag.set(1);
                System.out.println(book.toString());
            }
        });
        if (flag.get() == 0) {
            System.out.println("Book with name " + bookName + " not found.");
        }
    }
    public static void searchUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name of User to be searched for : ");
        scanner.nextLine();
        String userName = scanner.nextLine();
        AtomicInteger flag = new AtomicInteger();
        flag.set(0);
        users.forEach(user -> {
            if (user.getUserName().equalsIgnoreCase(userName)) {
                flag.set(1);
                System.out.println(user.toString());
            }
        });
        if (flag.get() == 0) {
            System.out.println("User with name " + userName + " not found.");
        }
    }
    public static void issueBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter issuing details : ");
        System.out.println("Enter Issue ID : ");
        Long IID = scanner.nextLong();
        System.out.println("Enter User ID : ");
        Long UID = scanner.nextLong();
        System.out.println("Enter Book ID : ");
        Long BID = scanner.nextLong();
        AtomicInteger flag = new AtomicInteger();
        issues.forEach(issue -> {
            if (issue.getBID().equals(BID)) {
                flag.set(1);
                System.out.println("Sorry the book has already been issued by someone else on "
                        + issue.getIssueDate().toString());
            }
        });
        if (flag.get() == 0) {
            LocalDateTime issueDate = LocalDateTime.now();
            Issue issue = Issue.builder().IID(IID).UID(UID).BID(BID).issueDate(issueDate).build();
            issues.add(issue);
            System.out.println("Your issue details : " + issue.toString());
        }
    }
    public static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter BID to return : ");
        Long BID = scanner.nextLong();
        AtomicInteger flag = new AtomicInteger();
        flag.set(0);
        AtomicLong id = new AtomicLong();
        issues.forEach(issue -> {
            if (issue.getBID().equals(BID)) {
                flag.set(1);
                LocalDateTime returnTime = LocalDateTime.now();
                LocalDateTime issueTime = issue.getIssueDate();
                Duration period = Duration.between(issueTime,returnTime);
                issue.setReturnDate(returnTime);
                issue.setPeriod((int) period.toDays());
                issue.setFine(0);
                System.out.println("The following issue has been returned : " + issue.toString());
                id.set(issue.getIID());
            }
        });
        if(flag.get()==1){
            long remId = id.get();
            int remID = (int)remId;
            issues.remove(remID-1);
        }
        if (flag.get() == 0) {
            System.out.println("Book was never issued");
        }
    }
    public static void viewAllBooks() {
        books.forEach(book -> {
            System.out.println(book.toString());
        });
    }
    public static void viewAllUsers(){
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }
}
