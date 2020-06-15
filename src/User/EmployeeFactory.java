package User;

import java.util.HashMap;
// key  is int  (role id)  if 1 then it is manager ,elseif 2 it is receptionist


public class EmployeeFactory {
    public   HashMap<Integer, employee> hashMap=new HashMap<Integer, employee>();
     public  employee getEmployee(int key){
         employee n = null;
         employee e= new manager();
        employee r = new receptionist();

         if(hashMap.containsKey(key))
         {
             System.out.println("Already created. It will be returned in a minute  :)");
             return n=hashMap.get(key);
         }else{
             switch (key)
             {
                 case 1:
                     System.out.println("Manager is created");
                     return e;
                 case 2:
                     System.out.println("Receptionist is created");
                     return r;
                 default:
                     System.out.println("Invalid key");
             }
         }
        System.out.println("error ! ");
         return  null;
     }

}
