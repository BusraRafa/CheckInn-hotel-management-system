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
public class modeltable5 {

    String fdname, fdprice, fdqty;

    public modeltable5(String fdname, String fdprice, String fdqty) {
        this.fdname = fdname;
        this.fdprice = fdprice;
        this.fdqty = fdqty;

    }

    public String getFdname() {
        return fdname;
    }

    public void setFdname(String fdname) {
        this.fdname = fdname;
    }

    public String getFdprice() {
        return fdprice;
    }

    public void setFdprice(String fdprice) {
        this.fdprice = fdprice;
    }

    public String getFdqty() {
        return fdqty;
    }

    public void setFdqty(String fdqty) {
        this.fdqty = fdqty;
    }

}
