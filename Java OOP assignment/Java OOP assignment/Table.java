/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author user
 */
public class Table {
    private String tableType;
    private String tableNo;
    private String capacity;
    private double price;

    public Table(double price,String tableType, String tableNo, String capacity) {
        this.price = price;
        this.tableType = tableType;
        this.tableNo = tableNo;
        this.capacity = capacity;
    }

    public String getTableNo() {
        return tableNo;
    }

    public String getCapacity() {
        return capacity;
    }
    
    public double getPrice(){
        return price;
    }
   
    
    public String getTableType(){
        return tableType;
    }

    @Override
    public String toString() {
    return String.format("%-15s: %s\n%-15s: %s\n%-15s: %s\n",
        "Table type", getTableType(),
        "Number of pax", getCapacity(),
        "Table No.", getTableNo());
    }
}