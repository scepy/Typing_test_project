package typingtestproject;

import java.time.LocalDateTime;

public class TypingTestResult {
    private String userId;
    private double typingSpeed;
    private LocalDateTime timestamp;
    // ... other fields and methods
    
    // Constructor
    public TypingTestResult(String userId2, double typingSpeed) {
        this.userId = userId2;
        this.typingSpeed = typingSpeed;
        this.timestamp = LocalDateTime.now();
    }
    
    // Getters and setters
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public double getTypingSpeed() {
        return typingSpeed;
    }
    
    public void setTypingSpeed(double typingSpeed) {
        this.typingSpeed = typingSpeed;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;;
    }
}

