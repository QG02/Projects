package LibraryProj;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

	private Scanner sc = new Scanner(System.in);
    private List<Book> bookInventory;

    public Library() {
        this.bookInventory = new ArrayList<>();
        initializeBooks();
    }

    public void initializeBooks() {
		
    	Book book1 = new Book("isbn-library-0001", "Physics", "Muhammad Shakir", "Advance Physics");
		Book book2 = new Book("isbn-library-0002", "Computer", "Muhammad Shakir", "Java Programming");		
		Book book3 = new Book("isbn-library-0003", "Math", "Sari Ghazal", "Calculas One");
		Book book4 = new Book("isbn-library-0004", "API", "Qayz Ghazal", "Application Program Interface");
		Book book5 = new Book("isbn-library-0005", "Computer", "Sumair Munawar", "Web Development");
		Book book6 = new Book("isbn-library-0006", "Art", "Muhammad Shakir", "Art 101");
		Book book7 = new Book("isbn-library-0007", "Chemistry", "Muhammad Shakir", "Chemistry 101");		
		Book book8 = new Book("isbn-library-0008", "Arabic", "Sari Ghazal", "Everything About Arabic Language");
		Book book9 = new Book("isbn-library-0009", "Urdu", "Qayz Ghazal", "General Knowledge of Urdu");
		Book book10 = new Book("isbn-library-0010", "English", "Sumair Munawar", "Cambridge Dictionary");

		addBookToInventory(book1);
		addBookToInventory(book2);
		addBookToInventory(book3);
		addBookToInventory(book4);
		addBookToInventory(book5);
		addBookToInventory(book6);
		addBookToInventory(book7);
		addBookToInventory(book8);
		addBookToInventory(book9);
		addBookToInventory(book10);
	}

    // Search Book by ISBN Number
    public Book searchBookByISBNNumber(String isbnNumber) {
        Book bookFound = null;
    	for (Book book : bookInventory) {
    		if (!isEmptyString(isbnNumber) && isbnNumber.equals(book.getIsbnNumber())) {
				bookFound = book;
    		}
        }
        return bookFound;
    }
    
    public void addBookToInventory(Book book) {
    	if (book != null) {
    		bookInventory.add(book);    		
    	}
    }
    
    public void removeBookFromInventory(String isbnNumber) {
        Book bookToRemove = searchBookByISBNNumber(isbnNumber);
        if (bookToRemove != null) {
            bookInventory.remove(bookToRemove);
            System.out.println("The book has been removed from the inventory.");
        } else {
            System.out.println("Book not found in the inventory.");
        }
    }
    
    public List<String> listOfGenres() {
        List<String> listOfGenres = new ArrayList<>();
        for (Book genre : bookInventory) {
            if (!listOfGenres.contains(genre.getGenre())) {
            	listOfGenres.add(genre.getGenre());
            }
        }
        return listOfGenres;
    }
    
    public void printListOfGenres() {
    	int index = 1;
    	System.out.println("****** Print List of Genre(s) ******");
    	int size = listOfGenres().size();
    	System.out.println("Genre List Size: " + size);
    	for (String genre : listOfGenres()) {
			System.out.println(index + " ===> " + genre);
			index++;
    	}
    }
    
    public void displayBooksInGenre(String genre) {
        System.out.println("Books in " + genre + " Genre\n");
        int index = 1;
        for (Book book : bookInventory) {
            if (book.getGenre().equals(genre)) {
                System.out.println(index + " ===> " + book.getTitle() + " by " + book.getAuthor() + ".");
                index++;
            }
        }
    }
    
    public void displayPublicLibraryBooks() {
    	int index = 1;
    	for (Book book : bookInventory) {
    		System.out.println(index + " ==> " + book.getTitle() + " by " + book.getAuthor() + ".");
            index++;
    	}
    }
    
	public static boolean isEmptyString(String input) {
		return (input == null) || (input.length() == 0) || (input.trim().length() == 0);
	}
	
	public void runLibrary() {
        int choice;
		
        boolean userAuthorize = authenticateUserFirst();
		
		
		while(userAuthorize) {
            System.out.println("\nPlease enter number to perform action:");
            System.out.println("--------------------------------");
            System.out.println("1. View available genres");
            System.out.println("2. Search for a book");
            System.out.println("3. Add book to inventory");
            System.out.println("4. Remove book from inventory");
            System.out.println("5. Display book inventory");
            System.out.println("6. Exit program");
            System.out.println("--------------------------------");
            System.out.print("User Selection: ");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                	printListOfGenres();
                    break;
                case 2:
            		System.out.print("Search Book by ISBN Number: ");
            		String isbnNumber = sc.next();
            		Book book = searchBookByISBNNumber(isbnNumber);
            		if (book != null) {
            			System.out.println();
            			System.out.println("ISBN Number: " + isbnNumber);
            			System.out.println("Book Title: "+ book.getTitle());
            			System.out.println("Book Author: "+ book.getAuthor());
            			System.out.println("Book Genre: "+ book.getGenre());
            			System.out.println();
            		}
            		break;
                case 3:
                	  System.out.println("To add a book to inventory, you must provide the book ID, author's full name, book title, and genre.");
                	  Book newBook = addNewBookToLibraryInventory();
                      addBookToInventory(newBook);
                      break;
                case 4:
            		System.out.print("Remove Book from Inventory: ");
            		String isbn = sc.next();
            		Book bookFound = searchBookByISBNNumber(isbn);
            		if (bookFound != null) {
            			removeBookFromInventory(isbn);
            		}
            		break;                      
                case 5:
                	displayPublicLibraryBooks();   
                	break;
                case 6:
                	System.out.println("Exiting program...");
                	userAuthorize = false;
                    sc.close();
                    System.exit(0);
                default:
                	System.out.println("Please enter a valid option.");
                    break;
            }
		}
	}

	private boolean authenticateUserFirst() {
		boolean userAuthorize = false;
		System.out.println("Welcome to your local library!");
        System.out.println("--------------------------------");
        System.out.println("Sign IN");
        System.out.println("--------------------------------");
        System.out.print("Username: ");
        String username = sc.next();
        System.out.print("Password: ");
		String password = sc.next();
		if (username.equals("qaysGhazal") && password.equals("libraryProject123")) {
			System.out.println("User [" + username+"] is authorize to access the application.");
			userAuthorize = true;
		} else {
			System.out.println("User [" + username+"] is NOT authorize to access the application.");
		}
		return userAuthorize;
	}

	private Book addNewBookToLibraryInventory() {
		System.out.print("Please enter the book ISBN Number: ");
		String isbnNumber = sc.next();
		System.out.print("Please enter the GENRE of the book: ");
		String newGenre = sc.next();
		System.out.print("Please enter Author Name: ");
		String newAuthor = sc.next();
		System.out.print("Please enter the Author's full name: ");
		String newTitle = sc.next();
		Book newBook = new Book(isbnNumber, newGenre, newAuthor, newTitle);
		return newBook;
	}
    
}