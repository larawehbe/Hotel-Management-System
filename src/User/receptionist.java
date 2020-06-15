package User;

import java.util.ArrayList;

public class receptionist extends employee {
    private static ArrayList<users> customers = new ArrayList<>();


    public static ArrayList<users> getCustomers() {
        return customers;
    }

    public void addCustomer(users c){
        if(customers.contains(c)){
            System.out.println("Customer already exists");
        }else{
            customers.add(c);
        }

    }
    public void deleteCustomer(users c){
        customers.remove(c);
    }

    public void print(employee e){
        if(this.roleid=="2")
        {
            System.out.println("Receptionist: "+this.fname);
        }


    }

    //for flyweight pattern
    public  void assignDetails(String fname,String lname,String phone,String city,String uname,String pass,String  age,String workhrs,String hid,String bday){
        receptionist rec =new receptionist();
        rec.setRoleid("2");
        rec.setFname(fname);
        rec.setLname(lname);
        rec.setPhone(phone);
        rec.setCity(city);
        rec.setUsername(uname);
        rec.setPassword(pass);
        rec.setAge(age);
        rec.setWorkhours(workhrs);
        rec.setHotelid(hid);
        rec.setBday(bday);
    }
    public receptionist()
    {
        roleid="2";
    }


}
