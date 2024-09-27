/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;

public class FoodOrderItem {
    private Food food;
    private int quantity;
    private static double totalPrice;

    public FoodOrderItem() {
    }

    public FoodOrderItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;

    }

    public void setFood(Food food) {
        this.food = food;
    }
    

    public Food getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;

    }

    public double getSubPrice() {
        return food.getFoodPrice() * quantity;
    }

    public static double getTotalPrice(){
        return totalPrice;
    }

    public static double getTotalPrice(ArrayList<FoodOrderItem> sameItems) {
    totalPrice = 0.0;
    for (int i = 0; i < sameItems.size(); i++) {
        FoodOrderItem item = sameItems.get(i);
        totalPrice += item.getSubPrice();
    }
    return totalPrice;
    }
    

    @Override
    public String toString() {
        return String.format("%-45s %-4s RM %6.2f %-2s RM %6.2f", food.getFoodName(), quantity, food.getFoodPrice(),"", getSubPrice());
    }
    
    
}