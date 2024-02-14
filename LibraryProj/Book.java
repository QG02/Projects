package LibraryProj;
public class Book {

	private String isbnNumber;
	private String genre;
	private String author;
	private String title;
	
	public Book(String isbnNumber, String genre, String author, String title) {
		this.isbnNumber = isbnNumber;
		this.genre = genre;
		this.author = author;
		this.title = title;
	}
	
	public String getIsbnNumber() {
		return isbnNumber;
	}
	
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [isbnNumber=" + isbnNumber + ", genre=" + genre + ", author=" + author + ", title=" + title + "]";
	}
	
}
