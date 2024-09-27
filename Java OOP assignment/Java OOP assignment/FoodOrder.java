/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FoodOrder {
    public static int action = 0;
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<FoodOrderItem> order = new ArrayList<>();
        ArrayList<FoodOrderItem> sameItems = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        
        login(scan);
        Table p1 = displayReservation();
        displayOrder(scan, order, sameItems,menu);
        modifyOrder(scan, order,sameItems, menu);
        displayPayment(sameItems,scan, p1);
        
        
    }
    
     public static void login(Scanner scanner){ 
        List<User> users = new ArrayList<>();
        Map<String, User> userMap = new HashMap<>();
        
        while (action == 0) {
            System.out.println("\n==========================");
            System.out.println("Welcome to Aloy Restaurant");
            System.out.println("==========================");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    User.signup(users, userMap, scanner);
                    break;
                case 2:
                    User.login(userMap, scanner);                  
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
        
    }
    
    
    public static Table displayReservation(){
        Scanner scan = new Scanner(System.in);
        int dateSelect;
        int timeSelect;
        int paxNum;
        String tableNum = "";
        int type;

        Table[] tables1 = new Table[2];
        for (int i = 0; i < 2; i++) {
            tables1[i] = new PrivateTable("P" + (i + 1), "1-2pax");
        }

        Table[] tables2 = new Table[4];
        for (int i = 0; i < 4; i++) {
            tables2[i] = new PrivateTable("P" + (i + 3), "3-6pax");
        }

        Table[] tables3 = new Table[4];
        for (int i = 0; i < 4; i++) {
            tables3[i] = new PrivateTable("P" + (i + 7), "7-10pax");
        }

        Table[] tables4 = new Table[2];
        for (int i = 0; i < 2; i++) {
            tables4[i] = new RegularTable("R" + (i + 1), "1-2pax");
        }

        Table[] tables5 = new Table[4];
        for (int i = 0; i < 4; i++) {
            tables5[i] = new RegularTable("R" + (i + 3), "3-6pax");
        }

        Table[] tables6 = new Table[4];
        for (int i = 0; i < 4; i++) {
            tables6[i] = new RegularTable("R" + (i + 7), "7-10pax");
        }

        while (true) {
            System.out.println("--------------------------");
            System.out.println("Date");
            System.out.println("--------------------------");
            System.out.println("1. 17/5/2023");
            System.out.println("2. 18/5/2023");
            System.out.println("3. 19/5/2023");
            System.out.println("5. 20/5/2023");
            System.out.println("6. 21/5/2023");
            System.out.println("7. 22/5/2023");
            System.out.println("");
            System.out.println("Please select the date for your reservation:");

            int selection = scan.nextInt();
            if (selection < 1 || selection > 7) {
                System.out.println("Invalid selection, please try again.");

            } else {
                dateSelect = selection;
                break;
            }
        }
        System.out.println("");

        while (true) {
            System.out.println("--------------------------");
            System.out.println("Time");
            System.out.println("--------------------------");
            System.out.println("1. 5pm");
            System.out.println("2. 6pm");
            System.out.println("3. 7pm");
            System.out.println("4. 8pm");
            System.out.println("");
            System.out.println("Please select the time for your reservation:");

            int selection = scan.nextInt();
            if (selection < 1 || selection > 4) {
                System.out.println("Invalid selection, please try again.");

            } else {
                timeSelect = selection;
                break;
            }
        }

        System.out.println("");
        System.out.println("--------------------------");
        System.out.println("Table Type Selection");
        System.out.println("--------------------------");
        System.out.println("1.  Private Room (RM50 additional charged will be added) ");
        System.out.println("2.  Regular Table (RM20 additional charged will be added)");
        System.out.println("");
        
        do {
            System.out.println("Please select the table type: ");
            type = scan.nextInt();
        } while (type != 1 && type != 2);

        while (true) {
            System.out.println("");
            System.out.println("--------------------------");
            System.out.println("Number of pax");
            System.out.println("--------------------------");
            System.out.println("1. 1-2pax");
            System.out.println("2. 3-6pax");
            System.out.println("3. 7-10pax");
            System.out.println("");
            System.out.println("Please select the number of pax for your reservation:");
            
            int selection = scan.nextInt();
            if (selection < 1 || selection > 3) {
                System.out.println("Invalid selection, please try again.");

            } else {
                paxNum = selection;
                break;
            }
        }
        
        Table[] availableTables = new Table[0];
        switch (type) {
            case 1:
                switch (paxNum){
                    case 1:
                        availableTables = tables1;
                        break;
                    case 2:
                        availableTables = tables2;
                        break;
                    case 3:
                        availableTables = tables3;
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                switch (paxNum){
                    case 1:
                        availableTables = tables4;
                        break;
                    case 2:
                        availableTables = tables5;
                        break;
                    case 3:
                        availableTables = tables6;
                        break;
                    default:
                        break;
                }
                break;
            default: 
                availableTables = new Table[0];
                break;
        }
        
        System.out.println("");
        System.out.println("--------------------------");
        System.out.println("Available tables");
        System.out.println("--------------------------");
        System.out.println("Table No. - Number of Pax");
        System.out.println("");    
        
        for (Table table : availableTables) {
            System.out.println(table.getTableNo() + " - " + table.getCapacity());
        }
        
        boolean validTableNum = false;
        
        while (!validTableNum) {
            System.out.println("");
            System.out.println("Enter the table number you wish to reserve: ");
            tableNum = scan.next().toUpperCase();
            for (Table table : availableTables) {
                if (tableNum.equals(table.getTableNo())) {
                    validTableNum = true;
                    break;
                }
            }
            if (!validTableNum) {
                System.out.println("Invalid table number, please try again.");
            }
        }
        
        String NumbeOfPax = null;
        
        switch (paxNum) {
            case 1:
                NumbeOfPax = "1-2pax";
                break;
            case 2:
                NumbeOfPax = "3-6pax";
                break;
            case 3:
                NumbeOfPax = "7-10pax";
                break;
            default:
                break;
        }

        System.out.println("");
        Table p1;     
        if (type == 1) {
            p1 = new PrivateTable(tableNum, NumbeOfPax) {
            };
                       
        } else {
            p1 = new RegularTable(tableNum, NumbeOfPax) {
            };
        }
        System.out.print(p1.toString());
        System.out.println("");
        return p1;
}
    
    public static void displayCategory(ArrayList<Food> category, String categoryName) {
        System.out.printf("%25s\n", categoryName);
        System.out.println("-------------------------------------------------");
        int i = 1;
        for (Food food : category) {
            System.out.printf("%2d) %s",i ,food.toString());
            i++;
        }
    }
       
    public static void displayOrder(Scanner scan, ArrayList<FoodOrderItem> order, ArrayList<FoodOrderItem> sameItems, Menu menu){
        int categoryNumber = -1;
        int inputProceed = -1;
        FoodOrderItem foodOrderItem;
        System.out.println("--------------------------");
        System.out.println("Menu");
        System.out.println("--------------------------");
        System.out.println("Here are the categories:");

        while (categoryNumber != 0 || inputProceed == 0) {
            System.out.println("1) Appetizer");
            System.out.println("2) Main Course");
            System.out.println("3) Drinks");
            System.out.println("4) Dessert");
            System.out.println("0) Finish and display order");
            System.out.print("Please enter the category number you would like to order from (0-4): ");
            System.out.println(" ");

            categoryNumber = scan.nextInt();
             while(categoryNumber ==0 && FoodOrderItem.getTotalPrice(order) == 0){
                 System.out.println("Please at least order one item before proceeding to display order (select any one of the category): ");
                 categoryNumber = scan.nextInt();
             }
             
            switch (categoryNumber) {
                case 1:
                    displayCategory(menu.getAppetizer(), "Appetizer");
                    getOrderItems(menu.getAppetizer(), order, scan);
                    break;
                case 2:
                    displayCategory(menu.getMainCourse(), "Main Course");
                    getOrderItems(menu.getMainCourse(), order, scan);
                    break;
                case 3:
                    displayCategory(menu.getDrinks(), "Drinks");
                    getOrderItems(menu.getDrinks(), order, scan);
                    break;
                case 4:
                    displayCategory(menu.getDessert(), "Dessert");
                    getOrderItems(menu.getDessert(), order, scan);
                    break;
                case 0:    
                    break;
                default:
                    System.out.println("Invalid category number, please try again.");
                    break;
            }
        }
        System.out.println("");
        System.out.printf("%-47s %-5s %-11s %-10s \n","Here's your order:", "Qty", "Price", "Subtotal");
        System.out.println("---------------------------------------------------------------------------------");
        
        for (int i = 0; i < order.size(); i++) {
            int found = 0;
            foodOrderItem = order.get(i);
            for (int j = 0; j < sameItems.size(); j++) {
                FoodOrderItem same = sameItems.get(j);
                if (same.getFood().getFoodName().equals(foodOrderItem.getFood().getFoodName())) {
                    same.setQuantity(same.getQuantity() + foodOrderItem.getQuantity());
                    found = 1;
                    break;
                }
            }
            if (found == 0) {
                sameItems.add(foodOrderItem);
            }
        }
        int counter = 1;
        for (FoodOrderItem orderItem : sameItems) {
            System.out.println(counter + ") " + orderItem.toString());
            counter++;
        }

        System.out.printf("\nTotal price: RM %.2f\n", FoodOrderItem.getTotalPrice(sameItems));}
    
    
       public static void getOrderItems(ArrayList<Food> category, ArrayList<FoodOrderItem> order, Scanner scan) {
        while (true) {
            System.out.println("");
            System.out.print("Enter the item number(e.g. 1) or 0 to go back to category selection: ");
            System.out.println("");
            int itemNumber = scan.nextInt();
            if (itemNumber == 0) {
                break;
            } else if (itemNumber < 1 || itemNumber > category.size()) {
                System.out.println("Invalid item number, please try again.");
                continue;
            }
            System.out.print("Enter the quantity for item number " + itemNumber + ": ");
            int quantity = scan.nextInt();
            while(quantity < 1){
                    System.out.print("Please reenter a valid quantity: ");
                    quantity = scan.nextInt();
                }
            
            System.out.println("Item added!");
            Food food = category.get(itemNumber - 1);
            FoodOrderItem orderItem = new FoodOrderItem(food, quantity);
            order.add(orderItem);
        }
    }
       
    public static void modifyOrder( Scanner scan, ArrayList<FoodOrderItem> order, ArrayList<FoodOrderItem> sameItems, Menu menu) {
    int action;
    FoodOrderItem foodOrderItem;
    do {
        System.out.println("Select which action to perform: ");
        System.out.println("0) Proceed to Payment");
        System.out.println("1) Add item");
        System.out.println("2) Remove item");
        System.out.println("3) Modify quantity");
        System.out.print("Action: ");
        action = scan.nextInt();
        
        switch (action) {
            case 0:
                break;
            case 1:
                System.out.println("\nPlease select a category:");
                System.out.println("1) Appetizer");
                System.out.println("2) Main Course");
                System.out.println("3) Drinks");
                System.out.println("4) Dessert");
                int category = 0;
                System.out.print("Enter the category number(e.g 1): ");
                category = scan.nextInt();
                    
                while(category < 0 || category > 4){
                    System.out.print("Invalid! Please enter a valid category number: ");
                    category = scan.nextInt();
                };
                
                ArrayList<Food> foodList = new ArrayList<>();
                String categoryName = " ";
                switch (category) {
                    case 1:
                        foodList = menu.getAppetizer();
                        categoryName = "Appetizer";
                        break;
                    case 2:
                        foodList = menu.getMainCourse();
                        categoryName = "Main Course";
                        break;
                    case 3:
                        foodList = menu.getDrinks();
                        categoryName = "Drinks";
                        break;
                    case 4:
                        foodList = menu.getDessert();
                        categoryName = "Dessert";
                        break;
                    default:
                        System.out.println("Invalid category number");
                        break;
                }
                FoodOrder.displayCategory(foodList, categoryName);
                System.out.print("Enter the item number to add: ");
                int itemNumber = scan.nextInt();
                while(itemNumber < 1 || itemNumber > foodList.size()) {
                    System.out.println("Invalid item number");
                    System.out.print("Enter the item number to add: ");
                    itemNumber = scan.nextInt();
                }
                Food food = foodList.get(itemNumber - 1);
                System.out.print("Enter the quantity: ");
                int quantity = scan.nextInt();
                while (quantity < 1) {
                    System.out.print("Please enter a valid quantity: ");
                    quantity = scan.nextInt();
                }
                int itemFound = 0;
                for (FoodOrderItem item : sameItems) {
                    if (item.getFood().equals(food)) {
                        item.setQuantity(item.getQuantity() + quantity);
                        itemFound = 1;
                        break;
                    }
                }
                if (itemFound == 0) {
                    foodOrderItem = new FoodOrderItem(food, quantity);
                    sameItems.add(foodOrderItem);
                }
                System.out.println("Item added");
                break;
            case 2:
                System.out.println("Current order:");
                int counter = 1;
                for (FoodOrderItem orderItem : sameItems) {
                    System.out.println(counter + ") " + orderItem.toString());
                    counter++;
                }
                System.out.print("Enter the item number to remove: ");
                int itemToRemove = scan.nextInt();
                while (itemToRemove < 1 || itemToRemove > sameItems.size()) {
                    System.out.println("Invalid item number");
                    System.out.print("Enter the item number to remove: ");
                    itemToRemove = scan.nextInt();
                }
                sameItems.remove(itemToRemove - 1);
                System.out.println("Item removed");
                break;
            case 3:
                System.out.println("Current order:");
                int encounter = 1;
                for (FoodOrderItem orderItem : sameItems) {
                    System.out.println(encounter + ") " + orderItem.toString());
                    encounter++;
                }
                System.out.print("Enter the item number to modify: ");
                int itemToModify = scan.nextInt();                
                while (itemToModify < 1 || itemToModify > sameItems.size()) {
                    System.out.println("Invalid item number");
                    System.out.print("Enter the item number to modify: ");
                    itemToModify = scan.nextInt();
                }
                foodOrderItem = sameItems.get(itemToModify - 1);
                System.out.print("Enter the new quantity: ");
                int newQuantity = scan.nextInt();
                while (newQuantity < 1) {
                    System.out.print("Please enter a valid quantity: ");
                    newQuantity = scan.nextInt();
                }
                foodOrderItem.setQuantity(newQuantity);
                System.out.println("Quantity updated");
                break;
            default:
                System.out.println("Invalid action!\n");
                continue;
        }        

        if(action == 0){
            break;
        }
        
        int foodNum = 1;
        System.out.println("");
        System.out.printf("%-47s %-5s %-11s %-10s \n","Here's your order:", "Qty", "Price", "Subtotal");
        System.out.println("---------------------------------------------------------------------------------");
         for (FoodOrderItem orderItem : sameItems) {
            System.out.println(foodNum + ") " + orderItem.toString());
            foodNum++;
        }

        System.out.printf("\nTotal price: RM %.2f\n", FoodOrderItem.getTotalPrice(sameItems));
        }while(action!=0);


    System.out.println("");
    System.out.printf("%-47s %-5s %-11s %-10s \n","Here's your updated order:", "Qty", "Price", "Subtotal");
        System.out.println("---------------------------------------------------------------------------------");

    for (int i = 0; i < sameItems.size(); i++) {
        foodOrderItem = sameItems.get(i);
        System.out.printf("%d) %s\n", i + 1, foodOrderItem.toString());
    }

    System.out.printf("\nTotal price: RM %.2f\n", FoodOrderItem.getTotalPrice(sameItems));
}
    
    public static void displayPayment(ArrayList<FoodOrderItem> sameItems,Scanner scan, Table p1){
        int action;
        System.out.println("\nPayment Method");
        System.out.println("--------------------------");
        for(int i = 0; i < Payment.PAYMENT_METHOD.length; i++){
            System.out.println(i+1 + ") " + Payment.PAYMENT_METHOD[i]);
        }
        do{
        System.out.println("Please select one of the payment method: ");
        action = scan.nextInt();
        }while (action <= 0 || action > Payment.PAYMENT_METHOD.length);
        Payment payment = new Payment(Payment.PAYMENT_METHOD[action - 1], p1);
        System.out.printf("\n%40s", "Invoice\n");
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-17s %s\n","Booking No     : ", payment.getPaymentNo());
        System.out.printf("%-17s %s\n","Payment Method : ", payment.getChosenPayment());
        System.out.printf("%-17s %s\n","Username       : ", User.getUsername());
        System.out.printf("%-17s %s\n","Table No       : ", p1.getTableNo());
        System.out.printf("%-17s %s\n","Table Type     : ", p1.getTableType());
        System.out.printf("%-17s %s\n\n","Date Of Issue  : ", payment.getFormattedDateTime());
        System.out.printf("%-10s %-36s %-5s %-12s %-15s\n","No","Order","Qty", "Price", "Subtotal");
        System.out.println("----------------------------------------------------------------------------");
        for (int i = 0; i < sameItems.size(); i++) {
        FoodOrderItem foodOrderItem = sameItems.get(i);
        System.out.printf("%d) %s\n", i + 1, foodOrderItem.toString());
        }
        System.out.printf("\n%66s RM%7.2f\n", "6% GST Charge " , payment.getGSTCharge());
        System.out.printf("%66s RM%7.2f\n", "10% Service Charge " , payment.getServiceCharge());
        System.out.printf("%66s RM%7.2f\n", "Room Charge " , payment.getRoomCharge());
        System.out.printf("%66s RM%7.2f\n", "Grand Total " , payment.getGrandTotal());
        System.out.println("\n----------------------------------------------------------------------------");
        System.out.printf("%40s", "The End\n");
        System.out.println("----------------------------------------------------------------------------");
    }
    
    
}

