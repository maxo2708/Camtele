
import java.io.Serializable;
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
public class Notification implements Serializable {
    
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

    public String toString() {
        return "Date Created: " + this.getTimeCreated().toString() + "\n" +
                "From: " + this.getFrom() + "\n" +
                "Body: " + this.getDescription();
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Notification n2 = (Notification) obj;
        return this.getFrom().equals(n2.getFrom()) && this.getDescription().equals(n2.getDescription());
    }
            
}
