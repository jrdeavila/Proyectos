package Presentacion;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String name){
        super(name);
        this.setOpaque(true);
        this.setFont(new font());
    }
}
