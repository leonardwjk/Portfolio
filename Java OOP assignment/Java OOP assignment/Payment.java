/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import java.time.format.DateTimeFormatter;

public class Payment implements Transaction{
    private User user;
    private FoodOrderItem foodOrderItem;
    private Table table;
    private double price;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final String FORMATTED_DATE = CURRENT_DATE.format(formatter);
    private String chosenPayment;
    private static int paymentNo = 1000;
    
    public Payment() {
        
    }
       

    public Payment(String chosenPayment, Table p1){
        this.chosenPayment = chosenPayment;
        this.table = p1;
        paymentNo++;
        
    }
    
    public double getPrice(){
        return price;
    }
    
    
    public void setPaymentNo(int paymentNo){
        Payment.paymentNo = paymentNo;
    }
    
    public int getPaymentNo(){
        return paymentNo;
    }
    
    public String getFormattedDateTime(){
        return FORMATTED_DATE;
    }
    
    
    public String getChosenPayment(){
        return chosenPayment;
    }
    
    public double getRoomCharge(){
        return table.getPrice();
    }

    @Override
    public double getGrandTotal() {
        return FoodOrderItem.getTotalPrice() + getGSTCharge() + getServiceCharge() + getRoomCharge();
    }
    
    @Override
    public double getGSTCharge(){
       return FoodOrderItem.getTotalPrice() * GST;
    }
    
    @Override
    public double getServiceCharge(){
       return FoodOrderItem.getTotalPrice() * SERVICE_TAX;
    }

    
    
    
    

    
    
    
    
    }

    
    

