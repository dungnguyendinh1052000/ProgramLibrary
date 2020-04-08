package Program;
import java.util.Random; 
import java.util.Scanner;
public class Library {
	private String libraryName;
	private static int numberOfBooks = 0;
	private Book bookList[] = new Book[100];
	public static final int MAX_NUMBER_OF_BOOK = 100;
	public Library(String libraryName) {
		this.libraryName = libraryName;
	}
	public void addNewBook() {
		if (numberOfBooks < MAX_NUMBER_OF_BOOK) {
			System.out.println("Enter book's information:");
			if (numberOfBooks == 0) {
				Scanner scan = new Scanner(System.in);
				System.out.println("(1)Book Title: ");
				System.out.println("(2)Book ID: ");
				System.out.println("(3)Amount: ");
				String title = scan.nextLine();
				int id = scan.nextInt();
				int amount = scan.nextInt();
				bookList[0] = new Book(id,title,amount);	
				numberOfBooks = numberOfBooks + 1;
			}
			else {
				Scanner scan = new Scanner(System.in);
				System.out.println("(1)Book Title: ");
				System.out.println("(2)Book ID: ");
				System.out.println("(3)Amount: ");
				String title = scan.nextLine();
				int id = scan.nextInt();
				int amount = scan.nextInt();
				int bol = 1;
				for (int index = 0; index<numberOfBooks; index++) {
					if (id == bookList[index].getBookID()) {
						bol = 0;
						break;
					}
				}
				if (bol == 1) {
					bookList[numberOfBooks] = new Book(id,title,amount);	
					numberOfBooks = numberOfBooks + 1;
				}
				else {
					System.out.println("ID = "+id+" already exist");
				}
			}
			
		}
	}
	public boolean findBook(int bookID) {
		for (int index = 0; index<numberOfBooks; index++) {
			if (bookID == bookList[index].getBookID()) {
				bookList[index].showBookInfo();
				return true;
			}
		}
		return false;
	}
	public boolean findBook(String key) {
		int count = 0;
		for (int index = 0; index<numberOfBooks; index++) {
			String[] result = key.split(" ");
			boolean check;
			for (int index_ = 0;index_ < result.length;index_++) {
				check = bookList[index].getBookTitle().contains(result[index_]);
				if (check == true) {
					count += 1;
					System.out.println(bookList[index].getBookTitle());
					break;
				}
				
			}
		}
		if (count == 0) {
			return false;
		}
		
		else {
			System.out.println(count);
			return true;
		}
		
	}
	public Book getALuckyBook() {
		Random rand = new Random();
		int index = rand.nextInt(numberOfBooks);
		bookList[index].setAvailable(bookList[index].getAvailable()-1);
		return bookList[index];
	}
	public void borrowBook(int bookID) {
		for (int index = 0; index<numberOfBooks; index++) {
			if (bookID == bookList[index].getBookID()) {
				bookList[index].showBookInfo();
				if(bookList[index].getAvailable() > 0) {
					System.out.println("successfully");
					bookList[index].setAvailable(bookList[index].getAvailable()-1);
					bookList[index].showBookInfo();
					break;
				}
				else {
					System.out.println("Available = 0");
				}
			}
		}
	}
	public void returnBook(int bookID) {
		for (int index = 0; index<numberOfBooks; index++) {
			if (bookID == bookList[index].getBookID()) {
				bookList[index].showBookInfo();
				System.out.println("successfully");
				bookList[index].setAvailable(bookList[index].getAvailable()+1);
				bookList[index].showBookInfo();
				break;
				}
				
			}
	}
	public void showLibraryInfo() {
		System.out.println("Library name: "+libraryName);
		System.out.println("Number of books: "+numberOfBooks);
		for (int index = 0; index<numberOfBooks; index++) {
			System.out.println("-----");
			bookList[index].showBookInfo();
		}
	}
}
