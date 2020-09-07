package Presentacion;

import javax.swing.*;
import java.awt.*;

public class TextField extends JTextField {
    public TextField(String name){
        super(name);
        this.setFont(new font());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
