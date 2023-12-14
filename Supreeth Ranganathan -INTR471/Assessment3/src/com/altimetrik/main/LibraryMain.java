package com.altimetrik.main;

import com.altimetrik.exceptions.NoAvailableBooksException;
import com.altimetrik.model.Library;
import com.altimetrik.service.LibraryService;

import java.util.Scanner;
import java.util.function.Supplier;

public class LibraryMain {
    public static void main(String[] args) throws NoAvailableBooksException {
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Library Management System:");
        System.out.println("Enter the operation you want to perform:");
        System.out.println("1. Add New Book to Library Database");
        System.out.println("2. Update Existing Library Database");
        System.out.println("3. Display Available Books");
        System.out.println("4. Remove Book from Database");
        choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Adding New Book to the library:");
                addBooks();
                break;
            case 2:
                System.out.println("Updating Existing Book records:");
                update();
                break;
            case 3:
                System.out.println("Displaying available books:");
                showAvailable();
                break;
            case 4:
                System.out.println("Deleting a book from the database:");
                removeBook();
                break;
            default:
                System.out.println("Please select a valid Operation");
        }

    }

    private static void removeBook() {
        Scanner sc = new Scanner(System.in);
        int bookID;
        System.out.println("Enter the Book ID which you want to remove from the system:");
        bookID = sc.nextInt();
        LibraryService libraryService = new LibraryService();
        libraryService.removeBook(bookID);
    }

    public static void update(){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        System.out.println("Enter the ID of the Book:");
        library.setBookID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the Name of the Book:");
        library.setBookName(sc.nextLine());
        System.out.println("Enter the genre category of the Book:");
        library.setGenre(sc.nextLine());
        System.out.println("Enter the cost of the Book:");
        library.setBookCost(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the Availability of the Book:");
        library.setAvailable(sc.nextLine());
        LibraryService libraryService = new LibraryService();
        libraryService.update(library);
    }
    public static void showAvailable() throws NoAvailableBooksException {
        LibraryService libraryService = new LibraryService();
        libraryService.showAvailable().stream().forEach(System.out::println);
    }
    public static void addBooks(){
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        System.out.println("Enter the ID of the Book:");
        library.setBookID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the Name of the Book:");
        library.setBookName(sc.nextLine());
        System.out.println("Enter the genre category of the Book:");
        library.setGenre(sc.nextLine());
        System.out.println("Enter the cost of the Book:");
        library.setBookCost(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the Availability of the Book:");
        library.setAvailable(sc.nextLine());
        LibraryService libraryService = new LibraryService();
        libraryService.addBook(library);
    }
}
