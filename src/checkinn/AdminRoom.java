/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinn;
//import java.util.*;

/**
 *
 * @author rafa5
 */
public class AdminRoom {

    String roomNo, type, roomDetails, price, status;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(String roomDetails) {
        this.roomDetails = roomDetails;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AdminRoom(String roomNo, String type, String roomDetails, String price, String status) {
        this.roomNo = roomNo;
        this.type = type;
        this.roomDetails = roomDetails;
        this.price = price;
        this.status = status;
    }

}
