package User;

public class RoomType_Model {
    int id;
    String category;


    String description;

    public RoomType_Model() {

    }

    public void RoomType_Model(){};
    public RoomType_Model(String category, String id) {
        this.setCategory(category);
        this.setId(Integer.parseInt(id));
    }


    public String getId(){
    return String.valueOf(id);
}
    public int getId(String string) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
