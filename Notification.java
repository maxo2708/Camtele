
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirstyn
 */
public class Notification {
    
    private String from;
    private String description;
    private LocalDateTime timeCreated;
    
    public Notification(String description, String from) {
        this.description = description;
        this.timeCreated = LocalDateTime.now();
        this.from = from;
    }
    
    public String getDescription() {
        return description;
    }
    
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setDescription(String d) {
        this.description = d;
    }
            
}
