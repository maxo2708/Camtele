/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirstyn
 */
public class Camtele {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Post p = new Post("ImageURI", "Description");
        
        System.out.println("ImageURI: " + p.getImageURI());
        System.out.println("Description: " + p.getDescription());
        System.out.println("Time Created: " + p.getTimeCreated());
        
        p.setImageURI("new picture");
        System.out.println("New ImageURI: " + p.getImageURI());
        
        p.setDescription("pretty picture");
        System.out.println("New description: " + p.getDescription());
    }
    
}