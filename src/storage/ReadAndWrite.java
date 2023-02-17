package storage;

import model.Staff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static void writeToFile(List<Staff> students) {
        try {
            FileOutputStream fos = new FileOutputStream("demoCase2.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Staff> readDataFromFile(){
        List<Staff> Staff = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("demoCase2.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Staff = (List<Staff>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Staff;
    }
}