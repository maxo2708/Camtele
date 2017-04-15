
import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Comment implements Serializable {
    
    private String from;
    private String messageBody;
    private LocalDateTime timeCreated;
    private List likedBy;
    
    public Comment(String from, String messageBody) {
        this.from = from;
        this.messageBody = messageBody;
        this.timeCreated = LocalDateTime.now();
    }
    
    public String getFrom() {
        return from;
    }
    
    public String getMessageBody() {
        return messageBody;
    }
    
    public LocalDateTime getTimeCreated() {
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

    public String toString() {
        return "Date Created: " + this.getTimeCreated().toString() + "\n" +
                "From: " + this.getFrom() + "\n" +
                "Message: " + this.getMessageBody();
    }
}
