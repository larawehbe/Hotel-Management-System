package User;

import javafx.collections.ObservableList;

import java.sql.Date;

public class invoice_model {
int resid;
int roomid;
int custid;
int roomcost;
int sid;
int period;
int totalRoomCost;
Date in;
Date out;
Date d;

    public int getTotalRoomCost() {
        return totalRoomCost;
    }

    public void setTotalRoomCost(int totalRoomCost) {
        this.totalRoomCost = totalRoomCost;
    }

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public int getTotalRoomCost(int p, int c){
        return p*c;
    }
    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    int scost;

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public int getCustid() {
        return custid;
    }

    public void setCustid(int custid) {
        this.custid = custid;
    }

    public int getRoomcost() {
        return roomcost;
    }

    public void setRoomcost(int roomcost) {
        this.roomcost = roomcost;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getScost() {
        return scost;
    }

    public void setScost(int scost) {
        this.scost = scost;
    }
}
