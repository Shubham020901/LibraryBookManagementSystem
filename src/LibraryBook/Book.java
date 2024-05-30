package LibraryBook;

import java.util.Objects;

public class Book {

	private String title;
    private String author;
    private String ISBN;
    private String genre;
    private boolean available;
    
    public Book() {	
    }

    public Book(String title, String author, String ISBN, String genre) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
		this.title = title;
	}

    public String getAuthor() {
        return author;
    }
    
	public void setAuthor(String author) {
		this.author = author;
	}

	 public String getISBN() {
	        return ISBN;
	    }
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getGenre() {
        return genre;
    }
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", genre=" + genre + ", available="
				+ available + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, author, available, genre, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(author, other.author) && available == other.available
				&& Objects.equals(genre, other.genre) && Objects.equals(title, other.title);
	}

/*	public Book[] getBorrowingHistory() {
		// TODO Auto-generated method stub
		return getBorrowingHistory();
	}

/*	public void returnBook(Book bookToReturn) {
		// TODO Auto-generated method stub
		
	}
*/
	
    
}

    
    
