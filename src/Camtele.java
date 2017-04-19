/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;

/**
 *
 * @author kirstyn
 */
public class Camtele {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Post p = new Post(new Account("testuser", "testpassword",""), "ImageURI", "Description");
        
        System.out.println("ImageURI: " + p.getImageURI());
        System.out.println("Description: " + p.getDescription());
        System.out.println("Time Created: " + p.getTimeCreated());
        
        p.setImageURI("new picture");
        System.out.println("New ImageURI: " + p.getImageURI());
        
        p.setDescription("pretty picture");
        System.out.println("New description: " + p.getDescription());
        
        Notification n = new Notification("User liked your picture", "User");
        System.out.println("Notification: " + n.getDescription() + " From: " + n.getFrom());

        Accounts accs = new Accounts();
        Account a = new Account("name", "password", "");
        Account a2 = new Account("name2", "password2", "");
        accs.add(a); accs.add(a2);
        a.getPosts().add(p);
        System.out.println("Posts made: " + a.getPosts()); //have to do toString() method so this prints the post normally

        // Try serializing Accounts
        try {
            FileOutputStream fileOut = new FileOutputStream("accounts.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(accs);
            out.close(); fileOut.close();
            System.out.println("Serialized data is saved in accounts.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Try deserializing Accounts
        Accounts accs2 = null;
        try {
            FileInputStream fileIn = new FileInputStream("accounts.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            accs2 = (Accounts) in.readObject();
            in.close(); fileIn.close();
            System.out.println("Serialized data is read.");
        }
        catch(FileNotFoundException e) { e.printStackTrace(); return; }
        catch (IOException e2) { e2.printStackTrace(); return; }
        catch (ClassNotFoundException e3) { e3.printStackTrace(); return; }

        System.out.println(accs2);

        if (accs.equals(accs2)) {
            System.out.println("Serializing Successful");
        } else {
            System.out.println("Error: Serialized accounts does not equal accounts");
        }
    }




    
}
