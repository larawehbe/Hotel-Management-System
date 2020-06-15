package User;

public class room {
    int roomid;
    String rate;
    String place;
    String roomCost;
    String status;
    String features;

    int nbofbeds;
    int hotelid;
    String resid;

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String location) {
        this.place = location;
    }

    public String getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(String roomCost) {
        this.roomCost = roomCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public int getNbofbeds() {
        return nbofbeds;
    }

    public void setNbofbeds(int nbofbeds) {
        this.nbofbeds = nbofbeds;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public String getResid() {
        return resid;
    }

    public void setResid(String resid) {
        this.resid = resid;
    }
}
