
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class MessageInfo {
    private String message;
    private Color backgroundColor;

    public MessageInfo(String message, Color backgroundColor) {
        this.message = message;
        this.backgroundColor = backgroundColor;
    }

    public String getMessage() {
        return message;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
}
