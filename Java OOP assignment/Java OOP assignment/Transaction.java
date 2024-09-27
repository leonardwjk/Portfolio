


import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author User
 */
public interface Transaction {
    static final LocalDateTime CURRENT_DATE = LocalDateTime.now();
    static final String[] PAYMENT_METHOD = {"Maybank", "City Bank", "Public Bank", "Ambank", "Hong Leong Bank", "Touch'N Go"};
    static final double GST = 0.06;
    static final double SERVICE_TAX = 0.1;
    
    
    public abstract double getGSTCharge();
    public abstract double getServiceCharge();
    public abstract double getGrandTotal();
    
}
