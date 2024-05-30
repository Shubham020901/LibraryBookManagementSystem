package LibraryBook;

import java.util.Scanner;

public class UserManagement {	
	private User[] users;
    private int userCount;

    public UserManagement() {
        this.users = new User[100]; 
        this.userCount = 0;
    }

    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter ID: ");
        String ID = sc.nextLine();
        System.out.print("Enter membership status: ");
        String membershipStatus = sc.nextLine();

        if (userCount == users.length) {
            User[] newUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            users = newUsers;
        }

        users[userCount++] = new User(name, ID, membershipStatus);
        System.out.println("User registered successfully!");
    }

    public User loginUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String ID = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getID().equals(ID) && password.equals("password")) { // Replace "password" with your desired password validation mechanism
                return users[i];
            }
        }
        System.out.println("Invalid login credentials.");
        return null;
    }

    public void viewBorrowingHistory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String ID = sc.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getID().equals(ID)) {
                if (users[i].borrowedCount == 0) {
                    System.out.println("User has no borrowed books.");
                } else {
                    System.out.println("Borrowing History for User " + users[i].getName() + ":");
                    for (int j = 0; j < users[i].borrowedCount; j++) {
                        System.out.println(users[i].borrowedBooks[j]);
                    }
                }
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void viewUserBorrowingHistory(User user) {
        if (user.borrowedCount == 0) {
            System.out.println("User has no borrowed books.");
        } else {
            System.out.println("Borrowing History for User " + user.getName() + ":");
            for (int j = 0; j < user.borrowedCount; j++) {
                System.out.println(user.borrowedBooks[j]);
            }
        }
    }
/*
    public void registerUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        System.out.print("Enter membership status: ");
        String membershipStatus = scanner.nextLine();

        if (userCount == users.length) {
            User[] newUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            users = newUsers;
        }

        users[userCount++] = new User(name, ID, membershipStatus);
        System.out.println("User registered successfully!");
    }
*/
/*    public User loginUser(Scanner scanner) {
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getID().equals(ID) && password.equals("password")) { // Replace "password" with your desired password validation mechanism
                return users[i];
            }
        }
        System.out.println("Invalid login credentials.");
        return null;
    }
*/
/*    public void viewBorrowingHistory(Scanner scanner) {
        System.out.print("Enter ID: ");
        String ID = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getID().equals(ID)) {
                if (users[i].borrowedCount == 0) {
                    System.out.println("User has no borrowed books.");
                } else {
                    System.out.println("Borrowing History for User " + users[i].getName() + ":");
                    for (int j = 0; j < users[i].borrowedCount; j++) {
                        System.out.println(users[i].borrowedBooks[j]);
                    }
                }
                return;
            }
        }
        System.out.println("User not found.");
    }
    */
}



