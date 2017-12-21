package com.nged.hashcodeandequals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HashTest {

    public static void main(String[] args){

       /* String a = new String("112a");
        String b = a;
        System.out.println("a.equals(b):");
        System.out.println(a.equals(b));
        System.out.println(a.hashCode()==b.hashCode());*/

        Users user = new Users(1,"lilei");
        Users user1 = new Users(1,"lilei");
        System.out.println("user.equals(user1)");
        System.out.println(user.equals(user1));
        System.out.println(user.hashCode()==user1.hashCode());

        Users user2 = user;
        System.out.println("user2.equals(user)");
        System.out.println(user2.equals(user));
        System.out.println(user2.hashCode()==user.hashCode());

        HashMap<String,Users> hashMap = new HashMap<>();
        hashMap.put("1",user);
        hashMap.put("2",user1);
        hashMap.put("3",user2);
        System.out.println("===hashMap");
        for(String key:hashMap.keySet()){
            System.out.println(key+":"+hashMap.get(key));
        }

        System.out.println("===hashSet");
        HashSet<Users> hashSet = new HashSet<>();
        hashSet.add(user);
        hashSet.add(user1);
        hashSet.add(user2);
      /*  for(Users u:hashSet){
            System.out.println(u);
        }
*/
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Users u = (Users)iterator.next();
            System.out.println(u.hashCode());
        }
    }
}
