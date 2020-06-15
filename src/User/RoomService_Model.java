package User;

public class RoomService_Model {
    int Room_id;
    int service_id;
    int service_cost;

    public RoomService_Model(int room_id, int service_id, int service_cost) {
        Room_id = room_id;
        this.service_id = service_id;
        this.service_cost = service_cost;
    }

    public RoomService_Model() {

    }

    public int getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(int room_id) {
        Room_id = room_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getService_cost() {
        return service_cost;
    }

    public void setService_cost(int service_cost) {
        this.service_cost = service_cost;
    }
}