package User;

import java.sql.Date;
import java.util.ArrayList;

public class employee extends users {

    String age;
    String workhours;
    String  roleid;
    String hotelid;
    String bday;

    public employee(){}

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWorkhours() {
        return workhours;
    }

    public void setWorkhours(String workhours) {
        this.workhours = workhours;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }


    public void setBday(Date valueOf) {
        this.bday= String.valueOf(valueOf);

    }




}

