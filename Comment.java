
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirstyn
 */
public class Comment {
    
    public String from;
    public String messageBody;
    public Date timeCreated;
    public List likedBy;
    
    public Comment(String from, String messageBody, Date timeCreated) {
        this.from = from;
        this.messageBody = messageBody;
        this.timeCreated = timeCreated;
    }
    
    public String getFrom() {
        return from;
    }
    
    public String getMessageBody() {
        return messageBody;
    }
    
    public Date getTimeCreated() {
        return timeCreated;
    }
    
    public List getLikes() {
        return likedBy;
    }
    
    public void likeComment() {
        
    }
    
    public void dislikeComment() {
        
    }
    
    public void setMessageBody(String newMessage) {
        this.messageBody = newMessage;
    }
}
