/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class RegularTable extends Table {
    private static final double PRICE = 20.00;
    private static final String TABLE_TYPE = "Regular";
    
    public RegularTable(String tableNo,String capacity){
        super(PRICE,TABLE_TYPE,tableNo,capacity);
    }
    
    @Override
    public String getTableType(){
        return TABLE_TYPE;
    }
    
    public double getPRICE() {
        return PRICE;
    }
        
    @Override
    public String toString() {
        return String.format("%s%n%-20s: %s\n",
        super.toString(),
        "Additional charge",
        PRICE);
    }
}