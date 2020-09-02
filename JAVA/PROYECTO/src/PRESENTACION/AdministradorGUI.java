/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import DATOS.Docente;
import DATOS.IntegranteComite;
import DATOS.LineaInvestigacion;
import DATOS.Usuario;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import LOGICA.*;
import static LOGICA.CentroOperaciones.allLineas;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author moren
 */

public class AdministradorGUI extends PanelFondo implements ActionListener{
    private JLabel lAdmin;
    private JButton bRegistrar, bLineas,  bCerrarSesion;
    private JPanel lienzo;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128);
    private principalGUI frame;
    public AdministradorGUI(principalGUI frame){
        this.frame = frame;
        inicializarComponentes();
    }
    
    public void inicializarComponentes() {
        lienzo = new JPanel();
        lienzo.setLayout(new GridLayout(0,3));
        lienzo.setOpaque(false);
        lienzo.add(crearPanel1());
        lienzo.add(new JLabel());
        lienzo.add(crearPanel_2());
        
        this.add(lienzo, BorderLayout.CENTER);
    }
    
    
    
    public JPanel crearPanel_2() {
       JPanel lienzoP = new JPanel();
        lienzoP.setLayout(new BorderLayout());
        bCerrarSesion = new JButton("CERRAR SESIÓN");
        bCerrarSesion.setFont(font3);
        bCerrarSesion.setBackground(p);
        bCerrarSesion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bLineas = new JButton("LINEAS DE INVESTIGACION");
        bLineas.setFont(font3);
        bLineas.setBackground(p);
        bLineas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRegistrar = new JButton("USUARIOS");
        bRegistrar.setFont(font3);
        bRegistrar.setBackground(p);
        bRegistrar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        bCerrarSesion.addActionListener(this);
        bLineas.addActionListener(this);
        bRegistrar.addActionListener(this);
        
        
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setOpaque(false);
        contenedorBotones.setLayout(new GridLayout(4,0,0,5));
        contenedorBotones.add(new JLabel());
        contenedorBotones.add(bRegistrar);
        contenedorBotones.add(bLineas);
        contenedorBotones.add(bCerrarSesion);
        
        JLabel funcDoc = new JLabel("FUNCIONES", JLabel.CENTER);
        funcDoc.setFont(font2);
        
        JPanel titulo = new JPanel();
        titulo.setLayout(new BorderLayout());
        titulo.setOpaque(false);
         titulo.add(new JLabel("    "), BorderLayout.NORTH);
        titulo.add(new JLabel("    "), BorderLayout.SOUTH);
        titulo.add(new JLabel("    "), BorderLayout.EAST);
        titulo.add(new JLabel("    "), BorderLayout.WEST);
        titulo.add(funcDoc, BorderLayout.CENTER);
        
        lienzoP.add(new JLabel("    "), BorderLayout.EAST);
        lienzoP.add(new JLabel("    "), BorderLayout.WEST);
        lienzoP.add(contenedorBotones, BorderLayout.CENTER);
        lienzoP.add(titulo, BorderLayout.NORTH);
        lienzoP.add(new JLabel("    "), BorderLayout.SOUTH);
        
        lienzoP.setBackground(Color.WHITE);
        lienzoP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //lienzoP.setOpaque(false);
        
        
        JPanel lienzoP2 = new JPanel();
        lienzoP2.setLayout(new GridLayout(3,0));
        lienzoP2.setOpaque(false);
        lienzoP2.add(new JLabel("  "));
        lienzoP2.add(lienzoP);
        lienzoP2.add(new JLabel("  "));
        
        
        JPanel lienzoP3 = new JPanel();
        lienzoP3.setLayout(new BorderLayout());
        lienzoP3.setOpaque(false);
        lienzoP3.add(lienzoP2, BorderLayout.CENTER);
       lienzoP3.add(new JLabel("   "), BorderLayout.NORTH);
       lienzoP3.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzoP3.add(new JLabel("   "), BorderLayout.EAST);
       lienzoP3.add(new JLabel("   "), BorderLayout.WEST);
        
        
        return lienzoP3;
    }
    
    
    public JPanel crearPanel1() {
       JPanel lienzo2 = new JPanel();
       lienzo2.setLayout(new BorderLayout());
       lienzo2.setOpaque(false);
       JPanel lienzo3 = new JPanel();
       lienzo3.setLayout(new BorderLayout());
       lienzo3.setOpaque(false);
       lAdmin = new JLabel("ADMINISTRADOR", JLabel.CENTER);
       lAdmin.setFont(font);
       lAdmin.setForeground(Color.WHITE);
       lienzo3.add(lAdmin, BorderLayout.NORTH);
       lienzo3.add(new JLabel("   "), BorderLayout.CENTER);
       lienzo3.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzo3.add(new JLabel("   "), BorderLayout.EAST);
       lienzo3.add(new JLabel("   "), BorderLayout.WEST);
       
       
        lienzo2.add(lienzo3, BorderLayout.CENTER);
       lienzo2.add(new JLabel("   "), BorderLayout.NORTH);
       lienzo2.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzo2.add(new JLabel("   "), BorderLayout.EAST);
       lienzo2.add(new JLabel("   "), BorderLayout.WEST);
       
       return lienzo2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bCerrarSesion){
            frame.dispose();
            frame = new principalGUI();
        }
        if(e.getSource() == this.bRegistrar){
            frame.setPanel(new AdUsuario(frame));
        }
        if(e.getSource() == this.bLineas){
            frame.setPanel(new AdLineas(frame));
        }
    }

    

    
    
}


class AdUsuario extends PanelFondo implements ActionListener{

    JButton bRDoc;
    JButton bRIn;
    JButton bCancelar;
    JLabel lSub;
    private JPanel lienzo;
    Font font = new Font("Cambria Math", 1, 18);
    Font font2 = new Font("Cambria Math", 1, 15);
    Font font3 = new Font("Cambria Math", 1, 12);
    Color p = new Color(240,128,128);
    principalGUI frame;
    
    public AdUsuario(principalGUI frame){
        this.frame = frame;
        lienzo = inicializarComponentes();
        this.add(lienzo, BorderLayout.CENTER);
        frame.setPanel(this);
    }
    
    
    public JPanel inicializarComponentes(){
        
        JPanel lienzo2 = new JPanel();
        lienzo2.setLayout(new GridLayout(0,3));
        lienzo2.setOpaque(false);
        lienzo2.add(panel1());
        lienzo2.add(new JLabel());
        lienzo2.add(panel2());
        
       return lienzo2; 
    }
    
    
    public JPanel panel1(){
        JPanel lienzo2 = new JPanel();
       lienzo2.setLayout(new BorderLayout());
       lienzo2.setOpaque(false);
       JPanel lienzo3 = new JPanel();
       lienzo3.setLayout(new BorderLayout());
       lienzo3.setOpaque(false);
       lSub = new JLabel("ADMINISTRADOR", JLabel.CENTER);
       lSub.setFont(font);
       lSub.setForeground(Color.WHITE);
       lienzo3.add(lSub, BorderLayout.NORTH);
       lienzo3.add(new JLabel("   "), BorderLayout.CENTER);
       lienzo3.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzo3.add(new JLabel("   "), BorderLayout.EAST);
       lienzo3.add(new JLabel("   "), BorderLayout.WEST);
       
       
        lienzo2.add(lienzo3, BorderLayout.CENTER);
       lienzo2.add(new JLabel("   "), BorderLayout.NORTH);
       lienzo2.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzo2.add(new JLabel("   "), BorderLayout.EAST);
       lienzo2.add(new JLabel("   "), BorderLayout.WEST);
       
       return lienzo2;
    }
    
    public JPanel panel2(){
        JPanel lienzoP = new JPanel();
        lienzoP.setLayout(new BorderLayout());
        bCancelar = new JButton("ATRAS");
        bCancelar.setFont(font3);
        bCancelar.setBackground(p);
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRIn = new JButton("HISTORIAL DE USUARIOS");
        bRIn.setFont(font3);
        bRIn.setBackground(p);
        bRIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRDoc = new JButton("REGISTRO DE USUARIOS");
        bRDoc.setFont(font3);
        bRDoc.setBackground(p);
        bRDoc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        bCancelar.addActionListener(this);
        bRIn.addActionListener(this);
        bRDoc.addActionListener(this);
        
        
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setOpaque(false);
        contenedorBotones.setLayout(new GridLayout(4,0,0,5));
        contenedorBotones.add(new JLabel());
        contenedorBotones.add(bRDoc);
        contenedorBotones.add(bRIn);
        contenedorBotones.add(bCancelar);
        
        JLabel funcDoc = new JLabel("FUNCIONES", JLabel.CENTER);
        funcDoc.setFont(font2);
        
        JPanel titulo = new JPanel();
        titulo.setLayout(new BorderLayout());
        titulo.setOpaque(false);
         titulo.add(new JLabel("    "), BorderLayout.NORTH);
        titulo.add(new JLabel("    "), BorderLayout.SOUTH);
        titulo.add(new JLabel("    "), BorderLayout.EAST);
        titulo.add(new JLabel("    "), BorderLayout.WEST);
        titulo.add(funcDoc, BorderLayout.CENTER);
        
        lienzoP.add(new JLabel("    "), BorderLayout.EAST);
        lienzoP.add(new JLabel("    "), BorderLayout.WEST);
        lienzoP.add(contenedorBotones, BorderLayout.CENTER);
        lienzoP.add(titulo, BorderLayout.NORTH);
        lienzoP.add(new JLabel("    "), BorderLayout.SOUTH);
        
        lienzoP.setBackground(Color.WHITE);
        lienzoP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //lienzoP.setOpaque(false);
        
        
        JPanel lienzoP2 = new JPanel();
        lienzoP2.setLayout(new GridLayout(3,0));
        lienzoP2.setOpaque(false);
        lienzoP2.add(new JLabel("  "));
        lienzoP2.add(lienzoP);
        lienzoP2.add(new JLabel("  "));
        
        
        JPanel lienzoP3 = new JPanel();
        lienzoP3.setLayout(new BorderLayout());
        lienzoP3.setOpaque(false);
        lienzoP3.add(lienzoP2, BorderLayout.CENTER);
       lienzoP3.add(new JLabel("   "), BorderLayout.NORTH);
       lienzoP3.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzoP3.add(new JLabel("   "), BorderLayout.EAST);
       lienzoP3.add(new JLabel("   "), BorderLayout.WEST);
        
        
        return lienzoP3;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bCancelar){
            frame.setPanel(new AdministradorGUI(frame));
        }
        if(e.getSource() == this.bRDoc){
            new RegistrarUsuario(frame, "REGISTRO DE USUARIOS");
        }
        if(e.getSource() == this.bRIn){
            
        }
    }
    
    
}

class RegistrarUsuario extends JDialog implements ActionListener, KeyListener, MouseListener{
    
    private JButton bAgregar, bCancelar;
    private JTextField tNombre, tUsuario, tContraseña, tComp, tTelefono, tDNI, tApellido;
    private JComboBox cLinea, tipo;
    private Container contenedor;
    private JPanel lienzo;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
    private int nNom=0, nUsu=0, nCon=0, nCom=0, nPro=0, nDNI=0;
    
    private  List<LineaInvestigacion> lista;
    private String usuario, contraseña, nombre, apellido;
    private long codigo, telefono;
    
    
    public RegistrarUsuario(JFrame frame, String titulo){
        super(frame, titulo);
        this.inicializarComponentes();
        this.pack();
        this.setBounds(0,0, 450,250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void inicializarComponentes(){
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(crearPanelCombo(), BorderLayout.NORTH);
        contenedor.add(crearPanelBotones(), BorderLayout.SOUTH);
        contenedor.add(new JLabel("    "), BorderLayout.EAST);
        contenedor.add(new JLabel("    "), BorderLayout.WEST);
        lienzo = crearPanel1();
        contenedor.add(lienzo, BorderLayout.CENTER);
        contenedor.setBackground(Color.WHITE);
    }
    
    public JPanel crearPanel1(){
        nNom=0; nUsu=0; nCon=0; nCom=0; nPro=0; nDNI=0;
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4,4,5,5));
        
        tNombre = new JTextField();
        tNombre.setFont(font3);
        tNombre.setForeground(Color.LIGHT_GRAY);
        tNombre.setText("NOMBRE");
        tNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.addKeyListener(this);
        tNombre.addMouseListener(this);
        tApellido = new JTextField();
        tApellido.setFont(font3);
        tApellido.setForeground(Color.LIGHT_GRAY);
        tApellido.setText("APELLIDO");
        tApellido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tApellido.addKeyListener(this);
        tApellido.addMouseListener(this);
        tComp = new JTextField();
        tComp.setFont(font3);
        tComp.setForeground(Color.LIGHT_GRAY);
        tComp.setText("COMPROBAR CONTRASEÑA");
        tComp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tContraseña = new JTextField();
        tContraseña.setFont(font3);
        tContraseña.setForeground(Color.LIGHT_GRAY);
        tContraseña.setText("CONTRASEÑA");
        tContraseña.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tContraseña.addKeyListener(this);
        tContraseña.addMouseListener(this);
         tComp.addKeyListener(this);
        tComp.addMouseListener(this);
        tUsuario = new JTextField();
        tUsuario.setFont(font3);
        tUsuario.setForeground(Color.LIGHT_GRAY);
        tUsuario.setText("USUARIO");
        tUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tUsuario.addKeyListener(this);
        tUsuario.addMouseListener(this);
        tTelefono = new JTextField();
        tTelefono.setFont(font3);
        tTelefono.setForeground(Color.LIGHT_GRAY);
        tTelefono.setText("TELEFONO");
        tTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tTelefono.addKeyListener(this);
        tTelefono.addMouseListener(this);
        tDNI = new JTextField();
        tDNI.setFont(font3);
        tDNI.setForeground(Color.LIGHT_GRAY);
        tDNI.setText("DOCUMENTO");
        tDNI.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDNI.addMouseListener(this);
        tDNI.addKeyListener(this);
       
        List<String> nombreLineas = nombreLineas(listaLineas());
        String[] items = new String[nombreLineas.size()];
        items = nombreLineas.toArray(items);
        cLinea= new JComboBox(items);
        cLinea.setFont(font3);
        cLinea.setBackground(t);
        cLinea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        panel4.add(cLinea);
        panel4.add(tNombre);
        panel4.add(tUsuario);
        panel4.add(tApellido);
         panel4.add(tContraseña);
        panel4.add(tDNI);
        panel4.add(tComp);
        panel4.add(tTelefono);
        
        
        panel4.setOpaque(false);
        
        return panel4;
    }
    
    
        public List<LineaInvestigacion> listaLineas(){
            return CentroOperaciones.allLineas;
        }
    
       
    
   public List<String> nombreLineas(List<LineaInvestigacion> lineas){
        List<String> nombreLineas = new ArrayList();
        for(LineaInvestigacion i : lineas){
            nombreLineas.add(i.getNombreLinea());
        }
        return nombreLineas;
    }
   
    
    public JPanel crearPanel2(){
        nNom=0; nUsu=0; nCon=0; nCom=0; nPro=0; nDNI=0;
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4,2,5,5));
        
        tNombre = new JTextField();
        tNombre.setFont(font3);
        tNombre.setForeground(Color.LIGHT_GRAY);
        tNombre.setText("NOMBRE");
        tNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.addKeyListener(this);
        tNombre.addMouseListener(this);
        tApellido = new JTextField();
        tApellido.setFont(font3);
        tApellido.setForeground(Color.LIGHT_GRAY);
        tApellido.setText("APELLIDO");
        tApellido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tApellido.addKeyListener(this);
        tApellido.addMouseListener(this);
        tComp = new JTextField();
        tComp.setFont(font3);
        tComp.setForeground(Color.LIGHT_GRAY);
        tComp.setText("COMPROBAR CONTRASEÑA");
        tComp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tComp.addKeyListener(this);
        tComp.addMouseListener(this);
        tContraseña = new JTextField();
        tContraseña.setFont(font3);
        tContraseña.setForeground(Color.LIGHT_GRAY);
        tContraseña.setText("CONTRASEÑA");
        tContraseña.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tContraseña.addKeyListener(this);
        tContraseña.addMouseListener(this);
        tUsuario = new JTextField();
        tUsuario.setFont(font3);
        tUsuario.setForeground(Color.LIGHT_GRAY);
        tUsuario.setText("USUARIO");
        tUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tUsuario.addKeyListener(this);
        tUsuario.addMouseListener(this);
        tDNI = new JTextField();
        tDNI.setFont(font3);
        tDNI.setForeground(Color.LIGHT_GRAY);
        tDNI.setText("DOCUMENTO");
        tDNI.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDNI.addMouseListener(this);
        tDNI.addKeyListener(this);
         tTelefono = new JTextField();
        tTelefono.setFont(font3);
        tTelefono.setForeground(Color.LIGHT_GRAY);
        tTelefono.setText("TELEFONO");
        tTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tTelefono.addKeyListener(this);
        tTelefono.addMouseListener(this);
        
        panel4.add(tUsuario);
        panel4.add(tNombre);        
        panel4.add(tContraseña);
        panel4.add(tApellido);
        panel4.add(tComp);
        panel4.add(tDNI);
        panel4.add(new JLabel());
        panel4.add(tTelefono);
        

        
        panel4.setOpaque(false);
        
        return panel4;
    }
    
    public JPanel crearPanelCombo(){
        String[] items = {"DOCENTE", "<html>INTEGRANTE<P>DEL COMITE<html>"};
        tipo = new JComboBox(items);
        tipo.setFont(font3);
        tipo.setBackground(t);
        tipo.addActionListener((ActionEvent e)->{
            String select = (String)tipo.getSelectedItem();
            if(select.equals("DOCENTE")){
                this.setBounds(0,0, 450,250);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                this.setVisible(true);
                contenedor.remove(lienzo);
                lienzo = crearPanel1();
                contenedor.add(lienzo, BorderLayout.CENTER);
                revalidate();
            }
            else{
                this.setBounds(0,0, 450,250);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                this.setVisible(true);
                contenedor.remove(lienzo);
                lienzo = crearPanel2();
                contenedor.add(lienzo, BorderLayout.CENTER);
                revalidate();
            }
        });
        tipo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(new JLabel("   "), BorderLayout.NORTH);
        panel2.add(new JLabel("   "), BorderLayout.SOUTH);
        panel2.add(new JLabel("   "), BorderLayout.EAST);
        panel2.add(new JLabel("   "), BorderLayout.WEST);
        panel2.add(tipo, BorderLayout.CENTER);
        panel2.setOpaque(false);

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(0,3));
        panel3.add(new JLabel());
        panel3.add(panel2);
        panel3.add(new JLabel());
        
        
        panel3.setOpaque(false);
        return panel3;
    }
    
    public JPanel crearPanelBotones(){
         bAgregar = new JButton("AGREGAR");
        bCancelar = new JButton("CANCELAR");
        bCancelar.setBackground(p);
        bCancelar.setFont(font3);
        bAgregar.setFont(font3);
        bAgregar.setBackground(q);
        bAgregar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.addActionListener(this);
        bAgregar.addActionListener(this);
        JPanel panel2, panel3, panel4;
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(0,2,5,0));
        panel4.add(bCancelar);
        panel4.add(bAgregar);
        panel4.setOpaque(false);
        
        panel2.setLayout(new BorderLayout());
        panel2.add(new JLabel("   "), BorderLayout.NORTH);
        panel2.add(new JLabel("   "), BorderLayout.SOUTH);
        panel2.add(new JLabel("   "), BorderLayout.EAST);
        panel2.add(new JLabel("   "), BorderLayout.WEST);
        panel2.add(panel4, BorderLayout.CENTER);
        panel2.setOpaque(false);
        
        panel3.add(new JLabel("        "), BorderLayout.EAST);
        panel3.add(panel2, BorderLayout.CENTER);
        panel3.add(new JLabel("        "), BorderLayout.WEST);
        
        panel3.setOpaque(false);
        
        return panel3;
    }
    
   
    public Docente extraerDocente(){
        Docente p = null;
        if(!tUsuario.getText().isEmpty() && !tContraseña.getText().isEmpty() && !tComp.getText().isEmpty()
                && !tDNI.getText().isEmpty() && !tNombre.getText().isEmpty() && !tTelefono.getText().isEmpty()
                && !tApellido.getText().isEmpty()){
            LineaInvestigacion q = CentroOperaciones.buscarLinea((String)cLinea.getSelectedItem(), listaLineas());
            usuario = tUsuario.getText();
            contraseña = tContraseña.getText();
            nombre = tNombre.getText();
            apellido = tApellido.getText();
            codigo = Long.parseLong(tDNI.getText());
            telefono = Long.parseLong(tTelefono.getText());
            
            if(q != null){
               lista = new ArrayList();
                lista.add(q);
                p = new Docente(lista, usuario, contraseña, nombre, apellido, codigo, telefono);
            }
        }
        
        return p;
    }
    
     public IntegranteComite extraerIntegrante(){
         IntegranteComite p = null;
         
        if(!tUsuario.getText().isEmpty() && !tContraseña.getText().isEmpty() && !tComp.getText().isEmpty()
                && !tDNI.getText().isEmpty() && !tNombre.getText().isEmpty() && !tTelefono.getText().isEmpty()
                && !tApellido.getText().isEmpty()){
           
            usuario = tUsuario.getText();
            contraseña = tContraseña.getText();
            nombre = tNombre.getText();
            apellido = tApellido.getText();
            codigo = Long.parseLong(tDNI.getText());
            telefono = Long.parseLong(tTelefono.getText());
                
           p = new IntegranteComite( usuario, contraseña, nombre, apellido, codigo, telefono);
      
        }
        
        return p;
    }
    
    public boolean verficarTipo(){
        return "DOCENTE".equals(tipo.getSelectedItem());      
    }
  
    public void cleanText(){
        if(nNom <1){
            tNombre.setText("");
            nNom++;
        }
        if(nCon < 1){
            tContraseña.setText("");
            nCon++;
        }    
        if(nCom < 1){
            tComp.setText("");
           nCom++; 
        }
        if(nDNI < 1){
            tDNI.setText("");
            nDNI++;
        }
        if(nUsu < 1){
            tUsuario.setText("");
            nUsu++;
        }
        if(nPro < 1){
            tTelefono.setText("");
            nPro++;
        }
        
        tNombre.setForeground(Color.BLACK);
        tApellido.setForeground(Color.BLACK);
        tUsuario.setForeground(Color.BLACK);
        tContraseña.setForeground(Color.BLACK);
        tTelefono.setForeground(Color.BLACK);
        tComp.setForeground(Color.BLACK);
        tDNI.setForeground(Color.BLACK);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == this.bCancelar){
           this.dispose();
       }
       if(e.getSource() == this.bAgregar){
           if(verficarTipo()){
               CentroOperaciones.agregarUsuarios(extraerDocente());
               JOptionPane.showMessageDialog(this, "DOCENTE AGREGADO");
               this.dispose();
           }
           else{
               CentroOperaciones.agregarUsuarios(extraerIntegrante());
               JOptionPane.showMessageDialog(this, "INTEGRANTE DE COMITE AGREGADO");
               this.dispose();
           }
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        cleanText();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        cleanText();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        cleanText();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       cleanText();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //cleanText();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //cleanText();
    }
    
}




class AdLineas extends PanelFondo implements ActionListener{

    private JButton bRHistorial, bCancelar, bRDoc, bRIn;
    private principalGUI frame;
    private JLabel lSub;
    
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
     private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
    private JPanel lienzo;
    
     public AdLineas(principalGUI frame) {
         this.frame = frame;
        lienzo = inicializarComponentes();
        this.add(lienzo, BorderLayout.CENTER);
        frame.setPanel(this);
    }
    
    
    public JPanel inicializarComponentes(){
        
        JPanel lienzo2 = new JPanel();
        lienzo2.setLayout(new GridLayout(0,3));
        lienzo2.setOpaque(false);
        lienzo2.add(panel1());
        lienzo2.add(new JLabel());
        lienzo2.add(panel2());
        
       return lienzo2; 
    }
    
    
    public JPanel panel1(){
        JPanel lienzo2 = new JPanel();
       lienzo2.setLayout(new BorderLayout());
       lienzo2.setOpaque(false);
       JPanel lienzo3 = new JPanel();
       lienzo3.setLayout(new BorderLayout());
       lienzo3.setOpaque(false);
       lSub = new JLabel("ADMINISTRADOR", JLabel.CENTER);
       lSub.setFont(font);
       lSub.setForeground(Color.WHITE);
       lienzo3.add(lSub, BorderLayout.NORTH);
       lienzo3.add(new JLabel("   "), BorderLayout.CENTER);
       lienzo3.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzo3.add(new JLabel("   "), BorderLayout.EAST);
       lienzo3.add(new JLabel("   "), BorderLayout.WEST);
       
       
        lienzo2.add(lienzo3, BorderLayout.CENTER);
       lienzo2.add(new JLabel("   "), BorderLayout.NORTH);
       lienzo2.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzo2.add(new JLabel("   "), BorderLayout.EAST);
       lienzo2.add(new JLabel("   "), BorderLayout.WEST);
       
       return lienzo2;
    }
    
    public JPanel panel2(){
        JPanel lienzoP = new JPanel();
        lienzoP.setLayout(new BorderLayout());
        bCancelar = new JButton("ATRAS");
        bCancelar.setFont(font3);
        bCancelar.setBackground(p);
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRIn = new JButton("SUBLINEAS");
        bRIn.setFont(font3);
        bRIn.setBackground(p);
        bRIn.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRDoc = new JButton("LINEAS");
        bRHistorial = new JButton("HISTORIAL");
        bRHistorial.setBackground(p);
        bRHistorial.setFont(font3);
        bRHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRDoc.setFont(font3);
        bRDoc.setBackground(p);
        bRDoc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        bCancelar.addActionListener(this);
        bRIn.addActionListener(this);
        bRDoc.addActionListener(this);
        bRHistorial.addActionListener(this);
        
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setOpaque(false);
        contenedorBotones.setLayout(new GridLayout(4,0,0,5));
        //contenedorBotones.add(new JLabel());
        contenedorBotones.add(bRDoc);
        contenedorBotones.add(bRIn);
        contenedorBotones.add(bRHistorial);
        contenedorBotones.add(bCancelar);
        
        JLabel funcDoc = new JLabel("FUNCIONES", JLabel.CENTER);
        funcDoc.setFont(font2);
        
        JPanel titulo = new JPanel();
        titulo.setLayout(new BorderLayout());
        titulo.setOpaque(false);
         titulo.add(new JLabel("    "), BorderLayout.NORTH);
        titulo.add(new JLabel("    "), BorderLayout.SOUTH);
        titulo.add(new JLabel("    "), BorderLayout.EAST);
        titulo.add(new JLabel("    "), BorderLayout.WEST);
        titulo.add(funcDoc, BorderLayout.CENTER);
        
        lienzoP.add(new JLabel("    "), BorderLayout.EAST);
        lienzoP.add(new JLabel("    "), BorderLayout.WEST);
        lienzoP.add(contenedorBotones, BorderLayout.CENTER);
        lienzoP.add(titulo, BorderLayout.NORTH);
        lienzoP.add(new JLabel("    "), BorderLayout.SOUTH);
        
        lienzoP.setBackground(Color.WHITE);
        lienzoP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //lienzoP.setOpaque(false);
        
        
        JPanel lienzoP2 = new JPanel();
        lienzoP2.setLayout(new GridLayout(3,0));
        lienzoP2.setOpaque(false);
        lienzoP2.add(new JLabel("  "));
        lienzoP2.add(lienzoP);
        lienzoP2.add(new JLabel("  "));
        
        
        JPanel lienzoP3 = new JPanel();
        lienzoP3.setLayout(new BorderLayout());
        lienzoP3.setOpaque(false);
        lienzoP3.add(lienzoP2, BorderLayout.CENTER);
       lienzoP3.add(new JLabel("   "), BorderLayout.NORTH);
       lienzoP3.add(new JLabel("   "), BorderLayout.SOUTH);
       lienzoP3.add(new JLabel("   "), BorderLayout.EAST);
       lienzoP3.add(new JLabel("   "), BorderLayout.WEST);
        
        
        return lienzoP3;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bCancelar){
            frame.setPanel(new AdministradorGUI(frame));
            System.out.println("true");
        }
        if(e.getSource() == this.bRDoc){
            RegistrarLineas registrarLineas = new RegistrarLineas(frame, "REGISTRAR LINEAS");
        }
        if(e.getSource() == this.bRIn){
            RegistrarSublineas registrarSublineas = new RegistrarSublineas( frame, "REGISTRAR SUBLINEAS");
        }
        if(e.getSource() == this.bRHistorial){
            Historial historial = new Historial(frame,"HISTORIAL");
        }

    }
    
    
    
    
}

class RegistrarLineas extends JDialog implements ActionListener, MouseListener, KeyListener{
    private JTextField tCodigo, tNombre;
    private JButton bAgregar, bCancelar;
    private Container contenedor;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
    private int nCod=0, nNom=0;
    
    public RegistrarLineas(JFrame frame, String titulo){
        super(frame, titulo); 
         this.inicializarComponentes();
        this.pack();
        this.setBounds(0,0,250,170);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void inicializarComponentes(){
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        contenedor.add(panel_1(), BorderLayout.CENTER);
        contenedor.add(new JLabel("    "), BorderLayout.NORTH);
        contenedor.add(new JLabel("    "), BorderLayout.SOUTH);
        contenedor.add(new JLabel("    "), BorderLayout.WEST);
        contenedor.add(new JLabel("    "), BorderLayout.EAST);

    }
    
    public JPanel panel_1(){
        JPanel panel = new JPanel();
         panel.setLayout(new BorderLayout());
        tCodigo = new JTextField("CODIGO");
        tNombre = new JTextField("NOMBRE DE LINEA");
        tCodigo.setFont(font3);
        tCodigo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.setFont(font3);
        tNombre.addKeyListener(this);
        tCodigo.addMouseListener(this);
        tNombre.addMouseListener(this);
        tCodigo.addKeyListener(this);
        tCodigo.setForeground(Color.LIGHT_GRAY);
        tNombre.setForeground(Color.LIGHT_GRAY);
        bAgregar = new JButton("AGREGAR");
        bAgregar.setFont(font3);
        bAgregar.setBackground(p);
        bAgregar.addActionListener(this);
        bAgregar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        bCancelar = new JButton("CANCELAR");
        bCancelar.setFont(font3);
        bCancelar.setBackground(q);
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.addActionListener(this);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.add(bCancelar);
        panel2.add(bAgregar);
        panel2.setOpaque(false);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,0,0,5));
        panel3.add(tCodigo);
        panel3.add(tNombre);
        panel3.setOpaque(false);
        JLabel t = new JLabel("DATOS", JLabel.CENTER);
        t.setFont(font);
        panel.add(t, BorderLayout.NORTH);
        panel.add(panel3, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        panel.setOpaque(false);
        
        return panel;
    }
    
  public void agregarLinea(){
      if(!tNombre.getText().isEmpty() && !tCodigo.getText().isEmpty()){
          allLineas.add(new LineaInvestigacion(tNombre.getText(), Long.parseLong(tCodigo.getText())));
          CentroOperaciones.guardarLineas();
          System.out.println("LINEA AGREGADA");
          cleanText();
      }
  }
    
    public void cleanText(){
        tNombre.setForeground(Color.BLACK);
        tCodigo.setForeground(Color.BLACK);
        
        if(nNom < 1){
            tNombre.setText("");
            nNom++;
        }
        if(nCod < 1){
            tCodigo.setText("");
            nCod++;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bAgregar){
             agregarLinea();
        }
        if(e.getSource() == this.bCancelar){
            dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        cleanText();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        cleanText();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        cleanText();
    }
    
}

class RegistrarSublineas extends JDialog implements ActionListener, KeyListener, MouseListener{
    private JTextField tCodigo, tNombre;
    private JButton bAgregar, bCancelar;
    private Container contenedor;
    private JComboBox cLinea;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
    private int nCod=0, nNom=0;
    
    public RegistrarSublineas(JFrame frame, String titulo){
        super(frame, titulo); 
         this.inicializarComponentes();
        this.pack();
        this.setBounds(0,0,250,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void inicializarComponentes(){
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        contenedor.add(panel_1(), BorderLayout.CENTER);
        contenedor.add(new JLabel("    "), BorderLayout.NORTH);
        contenedor.add(new JLabel("    "), BorderLayout.SOUTH);
        contenedor.add(new JLabel("    "), BorderLayout.WEST);
        contenedor.add(new JLabel("    "), BorderLayout.EAST);

    }
    
    public JPanel panel_1(){
        JPanel panel = new JPanel();
         panel.setLayout(new BorderLayout());
        tCodigo = new JTextField("CODIGO");
        tNombre = new JTextField("NOMBRE DE LINEA");
        tCodigo.setFont(font3);
        tCodigo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.setFont(font3);
        tNombre.addKeyListener(this);
        tCodigo.addMouseListener(this);
        tCodigo.setForeground(Color.LIGHT_GRAY);
        tNombre.setForeground(Color.LIGHT_GRAY);
        bAgregar = new JButton("AGREGAR");
        bAgregar.setFont(font3);
        bAgregar.setBackground(p);
        bAgregar.addActionListener(this);
        bAgregar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        bCancelar = new JButton("CANCELAR");
        bCancelar.setFont(font3);
        bCancelar.setBackground(q);
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.addActionListener(this);
        List<String> lista = nombreLineas(listaLineas());
        String[] items = new String[lista.size()];
        items = lista.toArray(items);
        cLinea = new JComboBox(items);
        cLinea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cLinea.setFont(font3);
        cLinea.setBackground(t);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.add(bCancelar);
        panel2.add(bAgregar);
        panel2.setOpaque(false);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3,0,0,5));
        panel3.add(cLinea);
        panel3.add(tCodigo);
        panel3.add(tNombre);
        
        panel3.setOpaque(false);
        JLabel t = new JLabel("DATOS", JLabel.CENTER);
        t.setFont(font);
        panel.add(t, BorderLayout.NORTH);
        panel.add(panel3, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
        panel.setOpaque(false);
        
        return panel;
    }
    
   public List<LineaInvestigacion> listaLineas(){
       return CentroOperaciones.allLineas;
   }
    
    
   public List<String> nombreLineas(List<LineaInvestigacion> lineas){
        List<String> nombreLineas = new ArrayList();
        for(LineaInvestigacion i : lineas){
            nombreLineas.add(i.getNombreLinea());
        }
        return nombreLineas;
    }
   
   public void agregarSublinea(String nombreLinea){
       LineaInvestigacion p = null;
       for(LineaInvestigacion i : listaLineas()){
           if(nombreLinea.equals(i.getNombreLinea())){
               p = i;
               break;
           }
       }
       
       String nombre, codigo;
       nombre = tNombre.getText();
       codigo = tCodigo.getText();
       
       if(!nombre.isEmpty() && !codigo.isEmpty()){
           LineaInvestigacion sublinea = new LineaInvestigacion(nombre, Long.parseLong(codigo));
           if(p != null){
               System.out.println(p.getNombreLinea());
               List<LineaInvestigacion> lista = p.getSublineas();
               lista.add(sublinea);
               p.setSublineas(lista);
               CentroOperaciones.guardarLineas();
               System.out.println("SUBLINEA AGREGADA");
          }
       }
       
       
   }
    
    public void cleanText(){
        tNombre.setForeground(Color.BLACK);
        tCodigo.setForeground(Color.BLACK);
        if(nNom < 1){
            tNombre.setText("");
            nNom++;
        }
        if(nCod < 1){
            tCodigo.setText("");
            nCod++;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bAgregar){
             agregarSublinea((String)cLinea.getSelectedItem());
             tNombre.setText("");
             tCodigo.setText("");
             revalidate();
        }
        if(e.getSource() == this.bCancelar){
            dispose();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        cleanText();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        cleanText();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        cleanText();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        cleanText();
    }
}


class Historial extends JDialog{
    
    private JTable tabla, tabla2;
    private  JTextField panelBusqueda;
    private DefaultTableModel modelo, modelo2;
    private Container contenedor;
    private int nPanel=0;
    
     private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
   
    Historial(JFrame frame, String titulo){
        super(frame, titulo);
        inicializarComponentes();
        this.setBounds(0,0,400,400);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void inicializarComponentes(){
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        contenedor.add(new JLabel("    "), BorderLayout.NORTH);
        contenedor.add(new JLabel("    "), BorderLayout.SOUTH);
        contenedor.add(new JLabel("    "), BorderLayout.EAST);
        contenedor.add(new JLabel("    "), BorderLayout.WEST);
        contenedor.add(crearPanel(), BorderLayout.CENTER);
        contenedor.setBackground(Color.WHITE);
        actualizarDatos();
    }
    
    public JPanel crearPanel(){
        panelBusqueda = new JTextField("NOMBRE O CODIGO DE LINEA");
        panelBusqueda.setFont(font3);
        panelBusqueda.setForeground(Color.LIGHT_GRAY);
        
        panelBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                
                if(nPanel < 1){
                     panelBusqueda.setText("");
                     nPanel++;
                }
                panelBusqueda.setForeground(Color.BLACK);
               actualizarDatos();
             }
            
        });
        panelBusqueda.addMouseListener(new MouseAdapter(){
                @Override
                  public void mousePressed(MouseEvent e) {
                        if(nPanel < 1){
                            panelBusqueda.setText("");
                            nPanel++;
                        }
                        panelBusqueda.setForeground(Color.BLACK);
                        actualizarDatos();
                    }

                  @Override
                     public void mouseReleased(MouseEvent e) {
                         if(nPanel < 1){
                             panelBusqueda.setText("");
                            nPanel++;
                        }
                         actualizarDatos();
                    }
                     
        });
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.add(panelBusqueda);
        panel2.setOpaque(false);
        panel.add(panel2, BorderLayout.CENTER);
        panel.add(crearTabla(), BorderLayout.SOUTH);
        panel.setOpaque(false);
        return panel;
    }
    
    class boton extends JButton{
            private LineaInvestigacion linea;
            public boton(LineaInvestigacion linea){
                this.linea = linea;
                this.setText("CLICK PARA VER");
                this.setBackground(t);
                this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                this.setForeground(Color.WHITE);
                this.setFont(font3);
            }
            
            public LineaInvestigacion getLinea(){
                return linea;
            }
        };
    
    public JScrollPane crearTabla(){
        
        final Class[] tipoColum = new Class[]{
            java.lang.String.class,
            java.lang.String.class,
            boton.class
        };
        
        Object[] items = {"CODIGO", "NOMBRE", "SUBLINEAS"};
        modelo = new DefaultTableModel(null, items){
            Class[] colum = tipoColum;
            @Override
            public Class getColumnClass(int columIndex){
                return colum[columIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column){
                return !(getColumnClass(column).equals(boton.class));
            }
        };
        tabla = new JTable(modelo);
        tabla.setOpaque(false);
        tabla.setFont(font3);
        tabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        tabla.setDefaultRenderer(JButton.class, new TableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
              return (Component) value;
            }
        
        });
        
        tabla.addMouseListener(new MouseAdapter(){
            @Override
                  public void mouseClicked(MouseEvent e) {
                        int fila = tabla.rowAtPoint(e.getPoint());
                        int columna = tabla.columnAtPoint(e.getPoint());
                        if(tabla.getModel().getColumnClass(columna).equals(boton.class)){
                            if(tabla.getModel().getValueAt(fila, columna) instanceof boton){
                                boton q = (boton)tabla.getModel().getValueAt(fila, columna);
                                new HistorialSublinea(null, "SUBLINEAS DE INVESTIGACION", q.getLinea());
                            }
                            else{
                               Object q = tabla.getComponentAt(fila, columna);
                                System.out.println(q.getClass());
                            }
                        }
                    }

                  
        });
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setOpaque(false);
        return scroll;
    }
    
    
   
    
    public void actualizarDatos(){    
        String text = panelBusqueda.getText();
        List<LineaInvestigacion> lista = CentroOperaciones.filtrarLineas(text);
        modelo.setNumRows(0);
        int p =0;
        for(LineaInvestigacion i : lista){
            Object[] inf = {i.getCodigo(), i.getNombreLinea(), new boton(i)};
            modelo.addRow(inf);
            p++;
            
        }
        modelo.setNumRows(28-p);
    }
  
}




class HistorialSublinea extends JDialog{
    private JTable tabla;
    private Container contenedor;
    private LineaInvestigacion linea;
    private DefaultTableModel modelo;
    private Font font3 = new Font("Cambria Math", 1, 12);
     
    public HistorialSublinea(JFrame frame, String titulo, LineaInvestigacion linea){
        super(frame, titulo);
        this.linea = linea;
        this.inicializarComponentes();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    public void inicializarComponentes(){
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(new JLabel("    "), BorderLayout.NORTH);
        contenedor.add(new JLabel("    "), BorderLayout.SOUTH);
        contenedor.add(new JLabel("    "), BorderLayout.WEST);
        contenedor.add(new JLabel("    "), BorderLayout.EAST);
        contenedor.add(crearTabla(), BorderLayout.CENTER);
        contenedor.setBackground(Color.WHITE);
        actualizarDatos();
        
    }
    
    public JScrollPane crearTabla(){
        String[] items ={"CODIGO", "NOMBRE"};
        this.modelo = new DefaultTableModel(null, items);
        tabla = new JTable(modelo);
        tabla.setOpaque(false);
        tabla.setFont(font3);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setOpaque(false);
        return scroll;
    }
    
    public void actualizarDatos(){
        List<LineaInvestigacion> lista = linea.getSublineas();
        modelo.setNumRows(0);
        int p=0;
        for(LineaInvestigacion i : lista){
            Object[] info = {i.getCodigo(), i.getNombreLinea()};
            modelo.addRow(info);
            p++;
        }
        modelo.setNumRows(25-p);
        
    }
    
}