/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class User {
    private static String username;
    private String password;

    public User(String username, String password) {
        User.username = username;
        this.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }
    
    public static void signup(List<User> users, Map<String, User> userMap, Scanner scanner) {
        System.out.println("\n=== Sign Up ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (userMap.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        String password = getPassword(scanner);
        User user = new User(username, password);
        users.add(user);
        userMap.put(username, user);
        System.out.println("Sign up successful.\n");
    }

    public static void login(Map<String, User> userMap, Scanner scanner) {
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!userMap.containsKey(username)) {
            System.out.println("Invalid username. Please try again.\n");
            return;
        }

        String password = getPassword(scanner);
        User user = userMap.get(username);

        if (!user.authenticate(password)) {
            System.out.println("Incorrect password. Please try again.\n");
            return;
        }

        System.out.println("Login successful. Welcome, " + user.getUsername() + "!\n");
        FoodOrder.action+=1;
        
    }

    public static String getPassword(Scanner scanner) {
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        while (password.length() < 8 || !password.matches(".*\\d.*")) {
            System.out.println("Password must be at least 8 characters long and contain at least one digit.");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        return password;
    }
}