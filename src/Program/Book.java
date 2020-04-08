package Program;
public class Book {
	private int bookID;
	private String bookTitle;
	private int amount;
	private int available;
	public Book() {
		bookID = 0;
		bookTitle = new String("book");
		amount = 1;
		available = 1;
	}
	public Book(int bookID,String bookTitle,int amount) {
		this.bookID = bookID;
		this.bookTitle = bookTitle;
		this.amount = amount;
		this.available = amount;
		
	}
	public void showBookInfo() {
		System.out.println("Book ID: "+bookID);
		System.out.println("Book Title: "+bookTitle);
		System.out.println("Total Amount: "+amount);
		System.out.println("Availabel: "+available);
		
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getBookID() {
		return bookID;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public int getAmount() {
		return amount;
	}
	public int getAvailable() {
		return available;
	}
	
}
