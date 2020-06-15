package User;

public class customer extends users {
    public void print()
    {
        System.out.println("Customer "+this.fname);
    }
    public void assignData (String fname,String lname, String city, String gender,String phone){
        customer current_customer = new customer();
        current_customer.setFname(fname);
        current_customer.setLname(lname);
        current_customer.setPhone(phone);
        current_customer.setCity(city);
        current_customer.setGender(gender);
    }

}
