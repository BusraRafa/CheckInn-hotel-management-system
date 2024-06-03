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
public class modeltable4 {

    String bookingId, Checkin, CheckOut, roomtype, roomNo, roomprice, tnight;

    public modeltable4(String bookingId, String Checkin, String CheckOut, String roomtype, String roomNo, String roomprice, String tnight) {
        this.bookingId = bookingId;
        this.Checkin = Checkin;
        this.CheckOut = CheckOut;
        this.roomtype = roomtype;
        this.roomNo = roomNo;
        this.roomprice = roomprice;
        this.tnight = tnight;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCheckin() {
        return Checkin;
    }

    public void setCheckin(String Checkin) {
        this.Checkin = Checkin;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String CheckOut) {
        this.CheckOut = CheckOut;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomprice() {
        return roomprice;
    }

    public void setRoomprice(String roomprice) {
        this.roomprice = roomprice;
    }

    public String getTnight() {
        return tnight;
    }

    public void setTnight(String tnight) {
        this.tnight = tnight;
    }

}
