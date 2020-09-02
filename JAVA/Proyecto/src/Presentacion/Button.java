package Presentacion;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String name){
        super(name);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setFont(new font());
    }
}
