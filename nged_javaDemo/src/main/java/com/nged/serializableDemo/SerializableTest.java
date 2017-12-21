package com.nged.serializableDemo;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args){
        User user = new User();
        user.setUserName("tom");
        user.setAge(22);
        user.setPwd("jfljadkfjkdasl");
        user.setSex('1');

        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("serializableTxt"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=oos){
                    oos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File file = new File("serializableTxt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User user1 = (User)ois.readObject();
            System.out.println(user1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(null!=ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
