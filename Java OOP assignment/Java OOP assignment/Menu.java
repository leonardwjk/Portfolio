/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User
 */
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Menu {

    private ArrayList<Food> Appetizer;
    private ArrayList<Food> MainCourse;
    private ArrayList<Food> Drinks;
    private ArrayList<Food> Dessert;

    public Menu() {
        //Appetizer Items
        Appetizer = new ArrayList<>();
        Appetizer.add(new Appetizer("Avocado Toast", 35.00));
        Appetizer.add(new Appetizer("Garlic Bread with Mushroom Soup", 55.00));
        Appetizer.add(new Appetizer("Ranch Chicken Cheese Dips", 55.00));
        Appetizer.add(new Appetizer("Prawn and Ginger Dumplings", 75.00));
        Appetizer.add(new Appetizer("Scallop Broth", 105.00));

        //MainCourse Items
        MainCourse = new ArrayList<>();
        MainCourse.add(new MainCourse("Spaghetti Carbonara", 18.00));
        MainCourse.add(new MainCourse("Grilled salmon with roasted vegetables", 80.00));
        MainCourse.add(new MainCourse("Chicken Chop", 45.00));
        MainCourse.add(new MainCourse("Fish and Chips", 50.00));
        MainCourse.add(new MainCourse("Spaghetti Bolognese", 50.00));
        MainCourse.add(new MainCourse("Lobster Thermidor", 130.00));
        MainCourse.add(new MainCourse("Beef Wellington with Red Wine Sauce", 300.00));
        MainCourse.add(new MainCourse("Chicken Parmesan", 89.00));
        MainCourse.add(new MainCourse("Spicy shrimp tacos with avocado and lime", 150.00));
        MainCourse.add(new MainCourse("Pan-seared steak with mashed potatoes", 200.00));
        
        //Drink Items
        Drinks = new ArrayList<>();
        Drinks.add(new Drinks("Coke", 12.00));
        Drinks.add(new Drinks("Iced Tea", 12.50));
        Drinks.add(new Drinks("Champagne", 120.50));
        Drinks.add(new Drinks("Sky Juice", 130.50));
        Drinks.add(new Drinks("Red Wine", 140.50));
        Drinks.add(new Drinks("White Wine", 140.50));
        Drinks.add(new Drinks("Whiskey", 140.50));
        Drinks.add(new Drinks("Martini", 150.50));
        Drinks.add(new Drinks("Gin and Tonic", 100.50));
        Drinks.add(new Drinks("Rose Wine", 150.50));

       
        //Dessert Items
        Dessert = new ArrayList<>();
        Dessert.add(new Dessert("Cheesecake", 60.00));
        Dessert.add(new Dessert("Tiramisu", 60.00));
        Dessert.add(new Dessert("Chocolate Souffle", 79.99));
        Dessert.add(new Dessert("Creme Brulee", 88.00));
        Dessert.add(new Dessert("Fruit Tart", 78.00));
        

    }
    
    public ArrayList<Food> getAppetizer() {
        return Appetizer;
    }

    public ArrayList<Food> getMainCourse() {
        return MainCourse;
    }

    public ArrayList<Food> getDrinks() {
        return Drinks;
    }

    public ArrayList<Food> getDessert() {
        return Dessert;
    }


}
