/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;

/**
 *
 * @author HP
 */
public class modeltable3 {

    String Foodname, FoodPrice, Qty;

    public String getFoodname() {
        return Foodname;
    }

    public void setFoodname(String Foodname) {
        this.Foodname = Foodname;
    }

    public String getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(String FoodPrice) {
        this.FoodPrice = FoodPrice;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String Qty) {
        this.Qty = Qty;
    }

    public modeltable3(String Foodname, String FoodPrice, String Qty) {
        this.Foodname = Foodname;
        this.FoodPrice = FoodPrice;
        this.Qty = Qty;

    }

}
