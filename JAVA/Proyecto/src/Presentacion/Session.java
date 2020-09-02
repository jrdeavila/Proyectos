package Presentacion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Session extends JDialog implements ActionListener, KeyListener, MouseListener{

    private Button bCancelar, bIniciar;
    private TextField tDNI, tPass;
    private Label lTitulo;
    private Container cont;

    public Session(JFrame frame){
        super(frame, "Iniciar Session");
        this.pack();
        this.setBounds(0,0, 450,250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        init();
    }

    public void init(){
        cont = this.getContentPane();
        cont.setLayout(new BorderLayout());
        cont.add(panelTitulo(), BorderLayout.NORTH);
        cont.add(panelTexto(), BorderLayout.CENTER);
        cont.add(panelButton(), BorderLayout.SOUTH);

    }

    public JPanel panelTitulo(){
        JPanel panel1, panel2, panel3, panel4, panel5;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();


        lTitulo = new Label("Iniciar Session");
        lTitulo.setHorizontalAlignment(Label.CENTER);
        lTitulo.setFont(new font2());
        panel1.setLayout(new BorderLayout());
        panel1.add(panel2, BorderLayout.WEST);
        panel1.add(panel3, BorderLayout.EAST);
        panel1.add(panel4, BorderLayout.NORTH);
        panel1.add(panel5, BorderLayout.SOUTH);
        panel1.add(lTitulo, BorderLayout.CENTER);



        return panel1;
    }

    public JPanel panelTexto(){
        JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10, panel11;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        panel10 = new JPanel();
        panel11 = new JPanel();

        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());

        tDNI = new TextField("Documento");
        tPass = new TextField("Contraseña");

        panel5.setLayout(new GridLayout(2,0, 0,10));
        panel5.add(tDNI);
        panel5.add(tPass);

        panel6.setLayout(new BorderLayout());
        panel6.add(panel1, BorderLayout.NORTH);
        panel6.add(panel2, BorderLayout.SOUTH);
        panel6.add(panel3, BorderLayout.WEST);
        panel6.add(panel4, BorderLayout.EAST);
        panel6.add(panel5, BorderLayout.CENTER);

        panel7.setLayout(new BorderLayout());

        panel8.setLayout(new FlowLayout());
        panel9.setLayout(new FlowLayout());
        panel10.setLayout(new FlowLayout());
        panel11.setLayout(new FlowLayout());


        panel7.add(panel6, BorderLayout.CENTER);
        panel7.add(panel8, BorderLayout.NORTH);
        panel7.add(panel9, BorderLayout.SOUTH);
        panel7.add(panel10, BorderLayout.EAST);
        panel7.add(panel11, BorderLayout.WEST);


        return panel7;
    }

    public JPanel panelButton(){
        JPanel panel1, panel2, panel3, panel4, panel5, panel6;
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        panel6 = new JPanel();

        panel1.setLayout(new BorderLayout());
        bCancelar = new Button("Cancelar");
        bCancelar.addActionListener(this);
        bIniciar = new Button("Iniciar");
        bIniciar.addActionListener(this);
        panel2.setLayout(new FlowLayout());
        panel2.add(bCancelar);
        panel2.add(bIniciar);

        panel1.add(panel5, BorderLayout.EAST);
        panel1.add(panel4, BorderLayout.WEST);
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(panel5, BorderLayout.NORTH);
        panel1.add(panel6, BorderLayout.SOUTH);

        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.bCancelar){
            this.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
