package User;

import java.util.ArrayList;

public class manager extends employee{
    private static ArrayList<users> customers = new ArrayList<>();
    private static ArrayList<employee> receptionists = new ArrayList<>();

    //for customers
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

    //for receptionists
    public static ArrayList<employee> getReceptionists() {
        return receptionists;
    }

    public void addReceptionist(employee r){
        if(receptionists.contains(r)){
            System.out.println("Receptionist already exists");
        }else{
            customers.add(r);
        }

    }
    public void deleteReceptionist(employee r){
        receptionists.remove(r);
    }

   //own function for manager
    public void print()
    {
        System.out.println("Manager: "+this.fname);
    }
    
    /// for flyweight design pattern
    public static void assignDetails(String fname,String lname,String g,String phone,String city,String uname,String pass,String  age,String workhrs,String hid,String bday){
        manager m =new manager();
        m.setRoleid("1");
        m.setFname(fname);
        m.setLname(lname);
        m.setPhone(phone);
        m.setCity(city);
        m.setUsername(uname);
        m.setPassword(pass);
        m.setAge(age);
        m.setWorkhours(workhrs);
        m.setHotelid(hid);
        m.setBday(bday);
    }
    public manager(){
        roleid="1";
    }

}