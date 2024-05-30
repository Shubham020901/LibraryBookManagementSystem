package LibraryBook;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class User {

	private String name;
    private String ID;
    private String membershipStatus;
    Book[] borrowedBooks;
    int borrowedCount;
    private int userCount;
	private Object[] users;
	private User[] users1;
	private User currentUser;
    
    public User() {	
    }
    
    public User(String name, String ID, String membershipStatus) {
        this.name = name;
        this.ID = ID;
        this.membershipStatus = membershipStatus;
        this.borrowedBooks = new Book[2]; 
        this.borrowedCount = 1;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getMembershipStatus() {
		return membershipStatus;
	}

	public void setMembershipStatus(String membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

	public Book[] getBorrowedBooks() {
		Book[] borrowedBooksCopy = new Book[borrowedCount];
        System.arraycopy(borrowedBooks, 0, borrowedBooksCopy, 0, borrowedCount);
        return borrowedBooksCopy;
	
	}

	public void setBorrowedBooks(Book[] borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	
   public int getBorrowedCount() {
		return borrowedCount;
	}
	public void setBorrowedCount(int borrowedCount) {
		this.borrowedCount = borrowedCount;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

//step 1 right but shows error :Exception in thread "main" java.lang.NullPointerException: Cannot invoke "LibraryBook.Book.isAvailable()" because "book" is null
//	at LibraryBookManagementSystem/LibraryBook.User.borrowBook(User.java:83)
/*	public void borrowBook(Book book) {
        if (book.isAvailable()) {
            // Resize the array if needed
            if (borrowedBooks.length == borrowedCount) {
                Book[] tempArray = new Book[borrowedBooks.length * 2]; 
                System.arraycopy(borrowedBooks, 0, tempArray, 0, borrowedBooks.length);
                borrowedBooks = tempArray;
            }
            borrowedBooks[borrowedCount++] = book; 
            book.setAvailable(false);
        } else {
            System.out.println("Book is not available.");
        }
    }
*/
//step 2 right but shows this Error: No book selected. Please choose a book to borrow.	
/*	public void borrowBook(Book book) {
	    if (book == null) {
	        System.out.println("Error: No book selected. Please choose a book to borrow.");
	        return; 
	    }

	    if (book.isAvailable()) {
	        // Resize the array if needed
	        if (borrowedBooks.length == borrowedCount) {
	            Book[] tempArray = new Book[borrowedBooks.length * 2]; 
	            System.arraycopy(borrowedBooks, 0, tempArray, 0, borrowedBooks.length);
	            borrowedBooks = tempArray;
	        }

	        borrowedBooks[borrowedCount++] = book;
	        book.setAvailable(false);
	        System.out.println("Book borrowed successfully.");
	    } else {
	        System.out.println("Book is not available.");
	    }
	}
*/
	public void returnBook(Book book) {
	    boolean found = false; 
	    for (int i = 0; i < borrowedCount; i++) {
	        if (borrowedBooks[i] != null && borrowedBooks[i].equals(book)) {
	            borrowedBooks[i] = borrowedBooks[borrowedCount - 1];
	            borrowedCount--;
	            book.setAvailable(true);
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("User has not borrowed this book.");
	    }
	}
/*
	 public void returnBook(Book book) {
	        if (borrowedBooks.contains(book)) {
	            for (int i = 0; i < borrowedCount; i++) {
	                if (borrowedBooks[i].equals(book)) {
	                    borrowedBooks[i] = borrowedBooks[borrowedCount - 1];
	                    borrowedCount--;
	                    book.setAvailable(true);
	                    break;
	                }
	            }
	        } else {
	            System.out.println("User has not borrowed this book.");
	        }
	    }
*/
  /*  
    public void viewBorrowingHistory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (((User) users[i]).getID().equals(ID)) {
                if (users[i].getBorrowedBooks().isEmpty()) {
                    System.out.println("User has no borrowed books.");
                } else {
                  //  System.out.println("Borrowing History:");
                	System.out.println("Borrowing History for User " + ((User) users[i]).getName() + ":"); 
                    for (Book book : users[i].getBorrowedBooks()) {
                        System.out.println(book);
                    }
                }
                return;
            }
        }
        System.out.println("User not found.");
    }
*/
/*	 public void viewBorrowingHistory() {
		  Scanner scanner = new Scanner(System.in);
		  System.out.print("Enter ID: ");
		  String ID = scanner.nextLine();

		  User user = findUserByID(ID); // Assuming a method to find user by ID exists

		  if (user == null) {
		      System.out.println("User not found.");
		      return;
		  }

		  if (user.getBorrowedBooks().isEmpty()) {
		      System.out.println("User has no borrowed books.");
		  } else {
		      System.out.println("Borrowing History for User " + user.getName() + ":");
		      for (Book book : user.getBorrowedBooks()) {
		          System.out.println(book);
		      }
		  }
		}

		private User findUserByID(String ID) {
		  return null;
		}
*/		
/*
    public void viewUserBorrowingHistory(User user) {
        if (user.getBorrowedBooks().isEmpty()) {
            System.out.println("User has no borrowed books.");
        } else {
            // System.out.println("Borrowing History:");
        	System.out.println("Borrowing History for User " + user.getName() + ":");
            for (Book book : user.getBorrowedBooks()) {
                System.out.println(book);
            }
        }
    }
*/
	 public Book[] getBorrowingHistory(User currentUser) {
		    if (currentUser != null) {
		       // if (currentUser.getBorrowedBooks().isEmpty()) {
		    	if (currentUser.getBorrowedBooks().length == 0) { 
		    	System.out.println("You don't have any borrowed books at the moment.");
		        } else {
		            // Display borrowed books (implementation not shown here)
		        }
		    } else {
		        System.out.println("Please login to view your borrowing history.");
		    }
			return borrowedBooks;
		}
	 
	 public void borrowBook(Book selectedBook) {
			// TODO Auto-generated method stub
			if (selectedBook == null) {
		        System.out.println("Error: No book selected. Please choose a book to borrow.");
		        return; 
		    }

		    if (selectedBook.isAvailable()) {
		        if (borrowedBooks.length == borrowedCount) {
		            Book[] tempArray = new Book[borrowedBooks.length * 2]; 
		            System.arraycopy(borrowedBooks, 0, tempArray, 0, borrowedBooks.length);
		            borrowedBooks = tempArray;
		        }

		        borrowedBooks[borrowedCount++] = selectedBook;

		        selectedBook.setAvailable(false);

		        System.out.println("Book borrowed successfully.");
		    } else {
		        System.out.println("Book is not available.");
		    }
		}
		
		public void loginUser(String ID, String password) {
		     if (isValidLogin(ID, password)) {
		         currentUser = findUserByID(ID); 
		         System.out.println("Login successful.");
		     } else {
		         System.out.println("Invalid login credentials.");
		     }
		 }
		 
		private User findUserByID(String iD) {
			// TODO Auto-generated method stub
				for (Object user : users) { 
			        if (user != null && ((User) user).getID().equals(ID)) {
			            return (User) user; 
			        }
			    }
			    return null;
		}
			private boolean isValidLogin(String iD, String password) {
			// TODO Auto-generated method stub
				User user = findUserByID(ID); 
			    if (user != null && user.getPassword().equals(password)) {
			        return true; 
			    } else {
			        return false; 
			    }
		}
			private Object getPassword() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException("Direct password retrieval not supported. "
						+ "Consider implementing secure password reset functionality.");
			}

	 
	@Override
	public String toString() {
		return "User [name=" + name + ", ID=" + ID + ", membershipStatus=" + membershipStatus + ", borrowedBooks="
				+ Arrays.toString(borrowedBooks) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(borrowedBooks);
		result = prime * result + Objects.hash(ID, membershipStatus, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(ID, other.ID) && Arrays.equals(borrowedBooks, other.borrowedBooks)
				&& Objects.equals(membershipStatus, other.membershipStatus) && Objects.equals(name, other.name);
	}

	
}

    