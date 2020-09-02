
package PRESENTACION;

import DATOS.Docente;
import DATOS.IntegranteComite;
import DATOS.Usuario;
import LOGICA.CentroOperaciones;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;
import java.util.List;


public class principalGUI extends JFrame implements ActionListener, MouseListener, KeyListener{
    private JTextField tUsuario, tPassword, tRadicado;
    private JPanel lienzo, lienzoBG;
    private JButton bIniciar, bRegistrarP;
    private JLabel lLogin, lTitulo, lConP, lRad;
    private Container contenedor, contenedor2;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    
    private int nUsu=0, nPass=0, nRad=0;
    
    private Image bg;
    private URL fondo;
    public principalGUI(){
        super("SISTEMA DE GESTION DE PROTECTOS");
        this.setBounds(0,0,800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_HORIZ);
        inicializarComponenetes();
    }
    
    public void inicializarComponenetes(){
        contenedor = this.getContentPane();
       crearFondo();
   }
    
    public void crearFondo(){
        lienzoBG = new PanelFondo();
         
         crearPanelPrincipal();
         lienzoBG.add(lienzo, BorderLayout.CENTER);
        contenedor.add(lienzoBG, BorderLayout.CENTER);
        contenedor.revalidate();
        
    }
    
   public void crearPanelPrincipal(){
       lienzo= new JPanel();
       lienzo.setLayout(new BorderLayout());
       lienzo.setOpaque(false);
       PanelLeft panel2 = new PanelLeft();
       bIniciar = panel2.getbIngresar();
       bRegistrarP  =panel2.getbRegistrarPropuesta();
       tPassword = panel2.gettContraseña();
       tUsuario = panel2.gettUsuario();
       tUsuario.addKeyListener(this);
       tPassword.addKeyListener(this);
       tUsuario.addMouseListener(this);
       tPassword.addMouseListener(this);
       lienzo.add(panel2, BorderLayout.CENTER);
       lienzo.add(panel_2(), BorderLayout.SOUTH);
       
       bIniciar.addActionListener(this);
       bRegistrarP.addActionListener(this);
   }
   
   public void setContenedor(Container cont){
       contenedor.removeAll();
       contenedor = cont;
       revalidate();
   }
   
    public void setPanel(JPanel panel){
        contenedor.removeAll();
        lienzo = panel;
        contenedor.add(lienzo, BorderLayout.CENTER);
        revalidate();
    }
    
    public JPanel panel_2(){
        JPanel lienzoP = new JPanel();
        lienzoP.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lMessage = new JLabel("SI YA REISTRO SU SOLICITUD, CONSULTE SU ESTADO AQUI:", JLabel.CENTER);
        lMessage.setFont(font3);
        lienzoP.add(lMessage);
        
         ImageIcon lupa = new ImageIcon("         ");
         
         JLabel lLupa = new JLabel(lupa);
        lienzoP.add(lLupa);
        
        tRadicado = new JTextField("RADICADO", 20);
        tRadicado.setFont(font3);
        tRadicado.setForeground(Color.LIGHT_GRAY);
        tRadicado.addMouseListener(this);
        lienzoP.add(tRadicado);
        
        return lienzoP;
    }
    
    public String usuario(){
        return this.tUsuario.getText();
    }
    
    public String contraseña(){
        return this.tUsuario.getText();
    }
    
    public boolean acceso(){
        if("DEFAULT".equals(usuario())){
            if("DEFAULT".equals(contraseña())){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
        
    }
    
  
 public List<Usuario> listaUsuario(){
     return CentroOperaciones.allUsuarios;
 }
    
public Usuario encontrarUsuario(){
    Usuario p = null;
    if(!tUsuario.getText().isEmpty() && !tPassword.getText().isEmpty()){
        String usu = tUsuario.getText(), password = tPassword.getText();
        for(Usuario i : listaUsuario()){
            if(usu.equals(i.getUsuario()) && password.equals(i.getPassword())){
                p = i;
                break;
            }
            
        }
        
    }
    
    if(p == null){
        JOptionPane.showMessageDialog(this, "NO EXISTE EL USUARIO");
    }
    return p;
}    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bIniciar){
            if(acceso()){
                setPanel(new AdministradorGUI(this));
            }
            else{
                if(encontrarUsuario() instanceof Docente){
                    setPanel(new DocenteGUI(this,(Docente)encontrarUsuario()));
                }
                if(encontrarUsuario() instanceof IntegranteComite){
                    setPanel(new integranteComiteGUI(this, (IntegranteComite)encontrarUsuario()));
                }
            }
        }
        else{
            
        }
        if(e.getSource() == this.bRegistrarP){
            setPanel(new RegistrarPropuestaGUI(this));
        }
        
    }

   

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.tPassword && this.nPass == 0){
            tPassword.setText("");
            tPassword.setForeground(Color.BLACK);
            revalidate();
            nPass++;
        }
        if(e.getSource() == tUsuario && this.nUsu == 0){
            tUsuario.setText("");
            tUsuario.setForeground(Color.BLACK);
            revalidate();
            nUsu++;
        }
        if(e.getSource() == tRadicado && nRad == 0){
            tRadicado.setText("");
            tRadicado.setForeground(Color.BLACK);
            revalidate();
            nRad++;
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == this.tPassword && this.nPass == 0){
            tPassword.setText("");
            tPassword.setForeground(Color.BLACK);
            revalidate();
            nPass++;
        }
        if(e.getSource() == tUsuario && this.nUsu == 0){
            tUsuario.setText("");
            tUsuario.setForeground(Color.BLACK);
            revalidate();
            nUsu++;
        }
        if(e.getSource() == tRadicado && nRad == 0){
            tRadicado.setText("");
            tRadicado.setForeground(Color.BLACK);
            revalidate();
            nRad++;
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource() == this.tPassword && this.nPass == 0){
            tPassword.setText("");
            tPassword.setForeground(Color.BLACK);
            revalidate();
            nPass++;
        }
        if(e.getSource() == tUsuario && this.nUsu == 0){
            tUsuario.setText("");
            tUsuario.setForeground(Color.BLACK);
            revalidate();
            nUsu++;
        }
        if(e.getSource() == tRadicado && nRad == 0){
            tRadicado.setText("");
            tRadicado.setForeground(Color.BLACK);
            revalidate();
            nRad++;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == this.tPassword && this.nPass == 0){
            tPassword.setText("");
            tPassword.setForeground(Color.BLACK);
            revalidate();
            nPass++;
        }
        if(e.getSource() == tUsuario && this.nUsu == 0){
            tUsuario.setText("");
            tUsuario.setForeground(Color.BLACK);
            revalidate();
            nUsu++;
        }
        if(e.getSource() == tRadicado && nRad == 0){
            tRadicado.setText("");
            tRadicado.setForeground(Color.BLACK);
            revalidate();
            nRad++;
            
        }
    }

    
    
}

class PanelFondo extends JPanel {
    private URL fondo;
    private Image bg;
    private JLabel lTitulo;
    
    
    public PanelFondo(){
        fondo = this.getClass().getResource("bg.jpg");
        bg = new ImageIcon(fondo).getImage();
        this.setLayout(new BorderLayout());
        this.add(crearPanel_1(), BorderLayout.NORTH);
    }
    //donde descargaste 
    
    //el titulo hay que cambiarlo de color  madamelo para ir tomado las capturas de l docu
    @Override
    public void paintComponent(Graphics g){
          
        g.drawImage(bg,0,0, getWidth(), getHeight(), this);
    }
    
    public JPanel crearPanel_1(){
        JPanel lienzoP = new JPanel();
        lienzoP.setLayout(new BorderLayout());
        
         this.lTitulo = new JLabel("SISTEMA DE GESTION DE PROYECTOS", JLabel.CENTER);
         lTitulo.setForeground(Color.BLACK);
         lTitulo.setFont(new Font("Cambria Math", 1, 24));
         lienzoP.add(lTitulo, BorderLayout.CENTER);
         lienzoP.add(new JLabel("    "), BorderLayout.EAST);
         lienzoP.add(new JLabel("    "), BorderLayout.WEST);
         lienzoP.add(new JLabel("    "), BorderLayout.NORTH);
         lienzoP.add(new JLabel("    "), BorderLayout.SOUTH);
         
        lienzoP.setOpaque(false);
        return lienzoP;
    }
    
}

class PanelLeft extends JPanel{
    private  Color p = new Color(240,128,128);
    private Font fuente = new Font("Cambria Math", 1, 12);
    private Font fuenteTitulo = new Font("Cambria Math", 1, 13);
    private JButton bIngresar;
    private JTextField tUsuario, tContraseña;
    private JButton bRegistrarPropuesta;
    
      public PanelLeft(){
        inicializarComponentes();
    }
    
    public JButton getbIngresar() {
        return bIngresar;
    }

    public JTextField gettUsuario() {
        return tUsuario;
    }

    public JTextField gettContraseña() {
        return tContraseña;
    }

    public JButton getbRegistrarPropuesta() {
        return bRegistrarPropuesta;
    }
    
  
    
    public void inicializarComponentes(){
        this.setLayout(new GridLayout(0,3));
            this.add(panel_2());
            this.add(new JLabel("     "));
            this.add(panel_1());
            this.setOpaque(false);
    }
    
    public JPanel panel_1(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);
        JPanel g = new JPanel();
        g.setOpaque(false);
        
        JPanel cont = new JPanel();
        cont.setLayout(new BorderLayout());
        cont.setOpaque(false);
        cont.add(panel_prop(), BorderLayout.NORTH);
        cont.add(new JLabel("   "), BorderLayout.CENTER);
        cont.add(panelLogin(), BorderLayout.SOUTH);
        //cont.add(new JLabel("  "));

        panel1.add(new JLabel("        "), BorderLayout.EAST);     
        panel1.add(new JLabel("    "), BorderLayout.SOUTH);
        panel1.add(new JLabel("        "), BorderLayout.WEST);
        panel1.add(new JLabel("    "), BorderLayout.NORTH);

        panel1.add(cont, BorderLayout.CENTER);

        
        return panel1;
    }
    
    public JPanel panel_prop(){
        JPanel panelPrp = new JPanel();
        panelPrp.setLayout(new BorderLayout());
        panelPrp.setOpaque(true);
        
         JLabel lMensaje = new JLabel("<html>SI ERES ESTUDIANTE PUEDES REGISTRAR TU PROPUESTA, <P> SIN NECESIDAD DE INICIAR SESIÓN<html>");
        lMensaje.setFont(fuente);
        lMensaje.setOpaque(false);
        
          bRegistrarPropuesta = new JButton("REGISTRAR PROPUESTA");
        bRegistrarPropuesta.setFont(fuente);
       
        bRegistrarPropuesta.setBackground(p);
        bRegistrarPropuesta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelPrp.add(lMensaje, BorderLayout.NORTH);
        panelPrp.add(new JLabel("   "), BorderLayout.CENTER);
        
        panelPrp.add(bRegistrarPropuesta, BorderLayout.SOUTH);
        
        panelPrp.setBackground(Color.WHITE);
        
        JPanel panelPrp2 = new JPanel();
        panelPrp2.setLayout(new BorderLayout());
        panelPrp2.add(panelPrp, BorderLayout.CENTER);
        
        
        panelPrp2.add(new JLabel("     "), BorderLayout.NORTH);
        panelPrp2.add(new JLabel("     "), BorderLayout.SOUTH);
        panelPrp2.add(new JLabel("     "), BorderLayout.EAST);
        panelPrp2.add(new JLabel("     "), BorderLayout.WEST);
        
        
        panelPrp2.setBackground(Color.WHITE);
        panelPrp2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        return panelPrp2;
        
    }
    
    public JPanel  panelLogin(){
         JPanel panelPrp = new JPanel();
        panelPrp.setLayout(new BorderLayout());
        panelPrp.setOpaque(true);
        
        JLabel lLogin = new JLabel("LOGIN", JLabel.CENTER);
        lLogin.setFont(fuenteTitulo);
        JPanel titulo = new JPanel();
        titulo.setLayout(new BorderLayout());
        titulo.add(lLogin, BorderLayout.CENTER);
        titulo.add(new JLabel("    "), BorderLayout.WEST);
        titulo.add(new JLabel("    "), BorderLayout.EAST);
        //titulo.add(new JLabel("    "), BorderLayout.NORTH);
        titulo.add(new JLabel("    "), BorderLayout.SOUTH);
        panelPrp.add(titulo, BorderLayout.NORTH);
        titulo.setOpaque(false);
        tUsuario = new JTextField("USUARIO", JLabel.CENTER);
        tUsuario.setForeground(Color.LIGHT_GRAY);
        tContraseña = new JTextField("CONSTRASEÑA", JLabel.CENTER);
        tContraseña.setForeground(Color.LIGHT_GRAY);
        tUsuario.setFont(fuente);
        tContraseña.setFont(fuente);
        
        JPanel lienzoInt = new JPanel();
        lienzoInt.setLayout(new GridLayout(2,0,10,5));
        lienzoInt.add(tUsuario);
        lienzoInt.add(tContraseña);
        lienzoInt.setOpaque(false);
        panelPrp.add(lienzoInt);
        
        
        bIngresar = new JButton("INGRESAR");
        bIngresar.setFont(fuente);
        bIngresar.setBackground(p);
        bIngresar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel panelButtom = new JPanel();
        panelButtom.setLayout(new BorderLayout());
        panelButtom.add(bIngresar, BorderLayout.CENTER);
        panelButtom.add(new JLabel("    "), BorderLayout.EAST);
        panelButtom.add(new JLabel("    "), BorderLayout.WEST);
        panelButtom.add(new JLabel("    "), BorderLayout.NORTH);
        panelButtom.add(new JLabel("    "), BorderLayout.SOUTH);
        panelButtom.setOpaque(false);
        panelPrp.add(panelButtom, BorderLayout.SOUTH);
        panelPrp.setBackground(Color.WHITE);

      
        
        JPanel panelPrp2 = new JPanel();
        panelPrp2.setLayout(new BorderLayout());
        panelPrp2.add(panelPrp, BorderLayout.CENTER);
        
        panelPrp2.add(new JLabel("     "), BorderLayout.NORTH);
        panelPrp2.add(new JLabel("     "), BorderLayout.SOUTH);
        panelPrp2.add(new JLabel("     "), BorderLayout.EAST);
        panelPrp2.add(new JLabel("     "), BorderLayout.WEST);
        
       
        
        panelPrp2.setBackground(Color.WHITE);
        panelPrp2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        return panelPrp2;
        
    }
    
    
    public JPanel panel_2(){
        JPanel panelPrp = new JPanel();
        panelPrp.setOpaque(false);
        return panelPrp;
    }
    
}