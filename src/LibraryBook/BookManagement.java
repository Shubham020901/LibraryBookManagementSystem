package LibraryBook;

public class BookManagement {
private static final Object ID = null;
/*	private Book[] books;
    private int count;

    public BookManagement(int capacity) {
        books = new Book[capacity];
        count = 0;
    }
*/	
	    private Book[] books;
	    private User[] users;
	    public BookManagement() {
	        this.books = new Book[0];
	    }

	    public void addBook(Book book) {
	        if (books.length == 0) {
	            books = new Book[1]; 
	        	} else if (books.length == books.length) { 
	        		Book[] tempArray = new Book[books.length * 2]; 
	        		System.arraycopy(books, 0, tempArray, 0, books.length);
	        		books = tempArray;
	        	}
	        	books[books.length - 1] = book; 
	    	}

	    public void removeBook(String ISBN) throws BookNotFoundException {
	        int bookIndex = -1;
	        for (int i = 0; i < books.length; i++) {
	            if (books[i].getISBN().equals(ISBN)) {
	                bookIndex = i;
	                break;
	            }
	        }

	        if (bookIndex == -1) {
	            throw new BookNotFoundException("Book with ISBN " + ISBN + " not found.");
	        }

	        for (int i = bookIndex; i < books.length - 1; i++) {
	            books[i] = books[i + 1];
	        }
	        books[books.length - 1] = null; 
	    }

	    public void updateBook(String ISBN, String newTitle, String newAuthor) throws BookNotFoundException {
	        for (int i = 0; i < books.length; i++) {
	            if (books[i].getISBN().equals(ISBN)) {
	                books[i].setTitle(newTitle);
	                books[i].setAuthor(newAuthor);
	                return;
	            }
	        }
	        throw new BookNotFoundException("Book with ISBN " + ISBN + " not found.");
	    }

	    public Book[] getAvailableBooks() {
	        int availableCount = 0;
	        for (Book book : books) {
	            if (book.isAvailable()) {
	                availableCount++;
	            }
	        }

	        Book[] availableBooks = new Book[availableCount];
	        int j = 0;
	        for (Book book : books) {
	            if (book.isAvailable()) {
	                availableBooks[j++] = book;
	            }
	        }
	        return availableBooks;
	    }

	    public Book[] searchBooks(String searchTerm) {
	        Book[] searchResults = new Book[0]; 
	        for (Book book : books) {
	            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
	                    book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
	                if (searchResults.length == 0) {
	                    searchResults = new Book[1]; 
	                } else if (searchResults.length == searchResults.length) { 
	                    Book[] tempArray = new Book[searchResults.length * 2]; 
	                    System.arraycopy(searchResults, 0, tempArray, 0, searchResults.length);
	                    searchResults = tempArray;
	                }
	                searchResults[searchResults.length - 1] = book; 
	            }
	        }
	        return searchResults;
	    }

	    public void addUser(User user) throws DuplicateUserException {
	    	// TODO Auto-generated method stub
	        if (users == null) {
	            users = new User[1]; 
	            users[0] = user;
	            return;
	        }

	        for (User existingUser : users) {
	            if (existingUser != null && existingUser.getID().equals(user.getID())) {
	                throw new DuplicateUserException("User with ID " + user.getID() + " already exists.");
	            }
	        }

	        if (isFull(users)) {
	            User[] tempUsers = new User[users.length * 2];
	            System.arraycopy(users, 0, tempUsers, 0, users.length);
	            users = tempUsers;
	        }
	        
	        int i = 0;
	        while (users[i] != null) {
	            i++;
	        }
	        users[i] = user;
	    }

	    /*		public User findUserByID(String iD) {
		//	User[] users = null;
			// TODO Auto-generated method stub
			if (users == null) {
	            return null; 
	        }

	        for (User user : users) {
	            if (user != null && user.getID().equals(ID)) {
	                return user;
	            }
	        }
	        return null; 
	    }
*/	    
	    public User findUserByID(String ID) {
	        if (users == null) {
	            return null; 
	        }

	        for (User user : users) {
	            if (user != null && user.getID().equals(ID)) {
	                return user;
	            }
	        }
	        return null; 
	    }

	    private boolean isFull(Object[] arr) {
	        return arr[arr.length - 1] != null;
	    }
	}




