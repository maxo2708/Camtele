
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirstyn
 */
public class Notifications implements Listing<Notification> {
    ArrayList<Notification> notifs;
    
    public Notifications() {
        this.notifs = new ArrayList<Notification>();
    }
    
    public boolean add(Notification n) {
        return this.notifs.add(n);
    }
    
    public Notification remove(int index) {
        return this.notifs.remove(index);
    }
    
    public Notification get(int index) {
        return this.notifs.get(index);
    }
}
