package Program;

import java.util.Scanner;

public class ProgramLibrary {
	private static int option;
	public static void showMenu() {
		System.out.println("------------Menu------------");
		System.out.println("1. Show library infomation");
		System.out.println("2. Add new book");
		System.out.println("3. Find Book");
		System.out.println("4. Borrow a book");
		System.out.println("5. Return a book");
		System.out.println("6. Exit");
		System.out.println("----------------------------");
		System.out.println("Enter menu ID (1-6): ");
		
	}
	public static void askOption() {
		Scanner scan = new Scanner(System.in);
		int op = scan.nextInt();
		option = op;
	}
	public static void main(String[] args) {
		Library library = new Library("Nguyen Dinh Dung");
		int exit = 0;
		while(exit == 0) {
			showMenu();
			askOption();
			switch (option) {
			case 1:
				library.showLibraryInfo();
				break;
			case 2:
				library.addNewBook();
				break;
			case 3:
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter Book ID: ");
				int id = scan.nextInt();
				library.findBook(id);
				break;
			case 4:
				Scanner scan1 = new Scanner(System.in);
				System.out.println("Enter Book ID: ");
				int id1 = scan1.nextInt();
				library.borrowBook(id1);
				break;
			case 5:
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Enter Book ID: ");
				int id2 = scan2.nextInt();
				library.returnBook(id2);
				break;
			case 6:
				exit = 1;
				break;
			}
		}	
	}	
}
