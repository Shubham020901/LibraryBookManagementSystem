package LibraryBook;

import java.util.Scanner;

public class LibraryManagementSystem {

    private static final Book title = null;
	private BookManagement bookManagement;
    private User currentUser = null;
   

    public LibraryManagementSystem() {
        this.bookManagement = new BookManagement();
        this.currentUser =null;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Welcome to  Library Management System");
            System.out.println("1. User Management");
            System.out.println("2. Book Management");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choice:");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    userManagementMenu();
                    break;
                case 2:
                    if (currentUser != null) {
                        bookManagementMenu();
                    } else {
                        System.out.println("Please login first to access book management features.");
                    }
                    break;
                case 3:
                    System.out.println("Exit from Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    public void userManagementMenu() {
        System.out.println("\n Welcome to User Management Menu");
        System.out.println("1. Register User");
        System.out.println("2. Login User");
        System.out.println("3. View Borrowing History (if logged in)");
        System.out.println("4. Exit");

        int choice = Integer.parseInt(getInput("Enter your choice: "));

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                if (currentUser == null) {
                    System.out.println("Please login first.");
                } else {
                    viewBorrowingHistory();
                }
                break;
            case 4:
                System.out.println("Exit from User Management Menu.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

	public void bookManagementMenu() {
        System.out.println("\n Welcome to Book Management Menu");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Update Book");
        System.out.println("4. Get Available Books");
        System.out.println("5. Borrow Books");
        System.out.println("6. Return Books");
        System.out.println("7. Search Books");
        System.out.println("8. Exit");

        int choice = Integer.parseInt(getInput("Enter your choice: "));

        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                removeBook();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                getAvailableBooks();
                break;
                
            case 5:
            	borrowBook(currentUser);
            	break;
            	
            case 6:
            	returnBook(currentUser);
            	break;
                
            case 7:
                searchBooks();
                break;
            case 8:
                System.out.println("Exit from Book Management Menu.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
		
	private String getInput(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message);
		return sc.nextLine();
	}

	public void registerUser() {
		// TODO Auto-generated catch block
		String name = getInput("Enter name: ");
		String ID = getInput("Enter ID: ");
		String membershipStatus = getInput("Enter membership status: ");
		try {
				bookManagement.addUser(new User(name, ID, membershipStatus));
			} catch (DuplicateUserException e) {
					e.printStackTrace();
			} 
		System.out.println("User registered successfully.");
	}

	private boolean isUserLoggedIn() {
		return currentUser !=null; 
	}
	
	private void loginUser() {
		String ID = getInput("Enter ID: ");
		User user = bookManagement.findUserByID(ID); 
		if (user != null) {
			currentUser = user;
			System.out.println("Login successful.");
		} else {
			System.out.println("User not found.");
		}
	}
	
		public void viewBorrowingHistory() {
			if (currentUser != null) {
				Book[] borrowingHistory = currentUser.getBorrowingHistory(currentUser);// .getBorrowingHistory();
				if (borrowingHistory.length == 0) {
					System.out.println("No borrowing history found for " + currentUser.getName());
        	} else {
            	System.out.println("\nBorrowing History for User " + currentUser.getName() + ":");
            	for (Book borrowedBook : borrowingHistory) {
                	System.out.println(borrowedBook); // Assuming BorrowedBook has a meaningful toString method
            	}
        	}
    	} else {
        	System.out.println("Please login first.");
    	}
	}
    
    	private void addBook() {
    		String title = getInput("Enter book title: ");
    		String author = getInput("Enter book author: ");
    		String ISBN = getInput("Enter book ISBN: ");
    		String genre = getInput("Enter book genre: ");

    		try {
    			bookManagement.addBook(new Book(title, author, ISBN, genre));
    			System.out.println("Book added successfully.");
    		} catch (IllegalArgumentException e) {
    			System.out.println("Invalid book details. Please try again.");
    		}
    	}

    	private void removeBook() {
    		String ISBN = getInput("Enter ISBN of the book to remove: ");
    		try {
    			bookManagement.removeBook(ISBN);
    			System.out.println("Book removed successfully.");
    		} catch (BookNotFoundException e) {
    			System.out.println(e.getMessage());
    		}
    	}

    	private void updateBook() {
        	String ISBN = getInput("Enter ISBN of the book to update: ");
        	String newTitle = getInput("Enter new title (or leave blank to keep existing title): ");
        	String newAuthor = getInput("Enter new author (or leave blank to keep existing author): ");
        	try {
            	bookManagement.updateBook(ISBN, newTitle.isEmpty() ? null : newTitle, newAuthor.isEmpty() ? null : newAuthor);
            	System.out.println("Book updated successfully.");
        	} catch (BookNotFoundException e) {
            	System.out.println(e.getMessage());
        	} catch (IllegalArgumentException e) {
            	System.out.println("Invalid book details. Please try again.");
        	}
    	}

    	private Book[] getAvailableBooks() {
        	Book[] availableBooks = bookManagement.getAvailableBooks();
        	if (availableBooks.length == 0) {
            	System.out.println("There are no available books at the moment.");
        	} else {
            	System.out.println("\nAvailable Books:");
            	for (Book book : availableBooks) {
                	System.out.println(book);
            	}
        	}
			return availableBooks;
    	}

/*    private void borrowBook(User user) {
		// TODO Auto-generated method stub
		user.borrowBook(title);	
		}
*/
		public void borrowBook(User user) {
    		if (isUserLoggedIn()) {
    				Book selectedBook = chooseBook();
    		if (selectedBook != null) {
    				user.borrowBook(selectedBook); 
    			} else {
    					System.out.println("No book selected.");
    					}
    			} else {
    					System.out.println("Please login to borrow books.");
    					}
				}
/*//step 1 right code
		private Book chooseBook() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Available Books:");
    	System.out.print("Enter book title (or 'q' to quit): ");
    	String title = sc.nextLine();

    	if (title.equalsIgnoreCase("q")) {
        	return null; 
    	}

    	Book selectedBook = findBookByTitle(title);
    	if (selectedBook == null) {
        	System.out.println("Book not found.");
    	}
    	return selectedBook;
	}
*/
		private Book chooseBook() {
    		Scanner sc = new Scanner(System.in);
    			Book[] availableBooks = getAvailableBooks();

    			if (availableBooks.length == 0) {
        		System.out.println("No books available.");
        		return null;
    		}
    			System.out.println("Available Books:");
    			for (int i = 0; i < availableBooks.length; i++) {
        		System.out.println((i + 1) + ". " + availableBooks[i].getTitle());
    		}
    			System.out.print("Enter book number (or 'q' to quit): ");
    			String choice = sc.nextLine();

    			if (choice.equalsIgnoreCase("q")) {
    				return null; 
    		}

    			try {
    					int selectedIndex = Integer.parseInt(choice) - 1; // Convert to index
    						if (selectedIndex >= 0 && selectedIndex < availableBooks.length) {
    							return availableBooks[selectedIndex]; // Return selected book
    						} else {
    							System.out.println("Invalid selection.");
    							return null;
    						}
    				} catch (NumberFormatException e) {
    					System.out.println("Invalid input. Please enter a number or 'q'.");
    						return null;
    				}
			}

    	
    	private void searchBooks() {
        	String searchTerm = getInput("Enter search term (title or author): ");
        	Book[] searchResults = bookManagement.searchBooks(searchTerm);
        	if (searchResults.length == 0) {
            	System.out.println("No books found matching your search term.");
        	} else {
            	System.out.println("\nSearch Results:");
            	for (Book book : searchResults) {
                	System.out.println(book);
            	}
        	}
    	}
    	
    	/*
    	private void returnBook(User user) {
    		// TODO Auto-generated method stub
    		user.returnBook(title);
    	}
    */	
    	private void returnBook(User user) {
    		if (isUserLoggedIn()) {
    			Scanner sc = new Scanner(System.in);
    			System.out.print("Enter book title to return: ");
    			String title = sc.nextLine();

    			Book bookToReturn = findBorrowedBookByTitle(user, title);
    				if (bookToReturn != null) {
    					user.returnBook(bookToReturn); 
    				} else {
    					System.out.println("Book not found in borrowed list.");
    				}
    		} else {
    			System.out.println("Please login to return books.");
    		}
    	}

/*  	private Book findBookByTitle(String title) {
		return null; 
	}
*/ 
    	private Book findBorrowedBookByTitle(User user, String title) {
    		if (user.borrowedBooks == null || user.borrowedCount == 0) {
    			return null; 
    		}

    		for (int i = 0; i < user.borrowedCount; i++) {
    			if (user.borrowedBooks[i] != null && user.borrowedBooks[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
    				return user.borrowedBooks[i]; 
    			}
    		}
    		return null; 
    	}
 
 public static void main(String[] args) {
    	LibraryManagementSystem LMS =new LibraryManagementSystem();
    	LMS.run();
   }
}





