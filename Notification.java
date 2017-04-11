
import java.util.Date;

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
    private Date timeCreated;
    
    public Notification(String description, Date timeCreated, String from) {
        this.description = description;
        this.timeCreated = timeCreated;
        this.from = from;
    }
    
    public String getDescription() {
        return description;
    }
    
    public Date getTimeCreated() {
        return timeCreated;
    }
    
    public String getFrom() {
        return from;
    }
    
    public void setDescription(String d) {
        this.description = d;
    }
            
}
