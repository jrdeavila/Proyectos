/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import DATOS.Docente;
import DATOS.Estudiante;
import DATOS.LineaInvestigacion;
import DATOS.PracticasEmpresariales;
import DATOS.PropuestaGrado;
import DATOS.ProyectoAplicado;
import LOGICA.CentroOperaciones;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moren
 */
public class RegistrarPropuestaGUI  extends PanelFondo implements ActionListener, MouseListener, KeyListener{
    private JButton bAgregar, bCancelar, bAgregarEstudiante, bSiguiente;
    private JTextField tNombre, tNombreDocente, tDNI, tTelefono, tApellido;
    private JTextField tNombrePropuesta, tPrograma,tApellidoDocente, tTelefonoDocente;
    private JTextField tDNIDocente, tTiempo;
    private JComboBox cLinea, cSublinea;
    private JTable tabla;
    private DefaultTableModel modelo;
    
    private List<Estudiante> integrantes;
    private Docente docente;
    private String titulo;
    private int tiempo;
    private LineaInvestigacion linea;
    private LineaInvestigacion sublinea;
    private principalGUI frame;
    
    
    private int nNomEst=0, nNomDoc=0, nDNI=0, nApeEst=0, nNomPro=0, nPro=0;
    private int nApeDoc=0, nTelDoc=0, nDNIDoc=0, nTiempo=0, nTelEst=0;
    
    
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
     private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
     
    public RegistrarPropuestaGUI(principalGUI frame){
        this.frame = frame;
        inicializarComponentes();
    }
    
    public void inicializarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2,200,0));
        panel.add(panel3());
        panel.add(panel1());
        panel.setOpaque(false);
        
        JPanel panel3 =  new JPanel(), panel4 = new JPanel(), panel5 = new JPanel();
        
         panel3.setLayout(new BorderLayout());
        panel3.add(panel, BorderLayout.CENTER);
        panel3.add(new JLabel("    "), BorderLayout.EAST);
        panel3.add(new JLabel("    "), BorderLayout.WEST);
        panel3.setOpaque(false);
        
        panel4.setLayout(new GridLayout(0,2,100,0));
        panel4.add(panel4());
        panel4.add(panel2());
        panel4.setOpaque(false);
        
        panel5.setLayout(new BorderLayout());
        panel5.add(panel4, BorderLayout.CENTER);
        panel5.add(new JLabel("    "), BorderLayout.EAST);
        panel5.add(new JLabel("    "), BorderLayout.WEST);
        panel5.setOpaque(false);
        
        JPanel panel6 = new JPanel();
        panel6.setOpaque(false);
        panel6.setLayout(new BorderLayout());
        panel6.add(new JLabel("    "), BorderLayout.NORTH);

        panel6.add(panel3, BorderLayout.CENTER);
        panel6.add(new JLabel("    "), BorderLayout.SOUTH);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2,0,0,40));
        panel2.add(panel6);
        panel2.add(panel5);
        panel2.setOpaque(false);
        this.add(panel2, BorderLayout.CENTER);
        this.add(new JLabel("    "), BorderLayout.SOUTH);
    }
    
    
    public JPanel panel1(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setBackground(Color.WHITE);
        
        //inicializar componentes
        tDNIDocente = new JTextField("DOCUMENTO");
        tNombreDocente = new JTextField("NOMBRE");
        tApellidoDocente = new JTextField("APELLIDO");
        tTelefonoDocente = new JTextField("TELEFONO");
       
        tDNIDocente.setFont(font3);
        tDNIDocente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDNIDocente.setForeground(Color.LIGHT_GRAY);
        tDNIDocente.addKeyListener(this);
        tDNIDocente.addMouseListener(this);
        
        tNombreDocente.setFont(font3);
        tNombreDocente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombreDocente.setForeground(Color.LIGHT_GRAY);
        tNombreDocente.addKeyListener(this);
        tNombreDocente.addMouseListener(this);
        
        tApellidoDocente.setFont(font3);
        tApellidoDocente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tApellidoDocente.setForeground(Color.LIGHT_GRAY);
        tApellidoDocente.addKeyListener(this);
        tApellidoDocente.addMouseListener(this);
        
        tTelefonoDocente.setFont(font3);
        tTelefonoDocente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tTelefonoDocente.setForeground(Color.LIGHT_GRAY);
        tTelefonoDocente.addKeyListener(this);
        tTelefonoDocente.addMouseListener(this);
        
     
        
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4,0,0,5));
        panel2.add(tNombreDocente);
        panel2.add(tApellidoDocente);
        panel2.add(tDNIDocente);
        panel2.add(tTelefonoDocente);
        panel2.setOpaque(false);
        
        JLabel titulo  =new JLabel("DATOS DEL DOCENTE", JLabel.CENTER);
        titulo.setFont(font2);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(new JLabel("    "), BorderLayout.NORTH);
        panel3.add(new JLabel("    "), BorderLayout.SOUTH);
        panel3.add(titulo, BorderLayout.CENTER);
        panel3.add(new JLabel("    "), BorderLayout.EAST);
        panel3.add(new JLabel("    "), BorderLayout.WEST);
        panel3.setOpaque(false);
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel4.setOpaque(false);
        
        bAgregar = new JButton("AGREGAR");
        bAgregar.setFont(font3);
        bAgregar.setBackground(q);
        bAgregar.addActionListener(this);
        
        panel4.add(bAgregar);
        panel1.add(panel3, BorderLayout.NORTH);
        panel1.add(panel4, BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.WEST);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        panel1.add(panel2, BorderLayout.CENTER);
        
        return panel1;
    }
    
    public JPanel panel2(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setBackground(Color.WHITE);
        
        //inicializar componentes
        tDNI = new JTextField("DOCUMENTO");
        tNombre = new JTextField("NOMBRE");
        tApellido = new JTextField("APELLIDO");
        tTelefono = new JTextField("TELEFONO");
        tPrograma = new JTextField("PROGRAMA");
       
        tDNI.setFont(font3);
        tDNI.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDNI.setForeground(Color.LIGHT_GRAY);
        tDNI.addKeyListener(this);
        tDNI.addMouseListener(this);
        
        tNombre.setFont(font3);
        tNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNombre.setForeground(Color.LIGHT_GRAY);
        tNombre.addKeyListener(this);
        tNombre.addMouseListener(this);
        
        tApellido.setFont(font3);
        tApellido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tApellido.setForeground(Color.LIGHT_GRAY);
        tApellido.addKeyListener(this);
        tApellido.addMouseListener(this);
        
        tTelefono.setFont(font3);
        tTelefono.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tTelefono.setForeground(Color.LIGHT_GRAY);
        tTelefono.addKeyListener(this);
        tTelefono.addMouseListener(this);
        
        tPrograma.setFont(font3);
        tPrograma.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tPrograma.setForeground(Color.LIGHT_GRAY);
        tPrograma.addKeyListener(this);
        tPrograma.addMouseListener(this);
        
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5,0,0,5));
        panel2.add(tNombre);
        panel2.add(tApellido);
        panel2.add(tDNI);
        panel2.add(tTelefono);
        panel2.add(tPrograma);
        panel2.setOpaque(false);
        JLabel titulo  =new JLabel("DATOS DEL ESTUDIANTE", JLabel.CENTER);
        titulo.setFont(font2);
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        panel3.add(new JLabel("    "), BorderLayout.NORTH);
        panel3.add(new JLabel("    "), BorderLayout.SOUTH);
        panel3.add(titulo, BorderLayout.CENTER);
        panel3.add(new JLabel("    "), BorderLayout.EAST);
        panel3.add(new JLabel("    "), BorderLayout.WEST);
        panel3.setOpaque(false);
        
        bAgregarEstudiante = new JButton("AGREGAR");
        bAgregarEstudiante.setFont(font3);
        bAgregarEstudiante.setBackground(q);
        bAgregarEstudiante.addActionListener(this);
        
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel4.add(bAgregarEstudiante);
        panel4.setOpaque(false);
        
        panel1.add(panel3, BorderLayout.NORTH);
        panel1.add(panel4, BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.WEST);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        panel1.add(panel2, BorderLayout.CENTER);
        
        return panel1;
    }
    
    public JPanel panel3(){
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel1.setLayout(new BorderLayout());
        
        bCancelar = new JButton("CANCELAR");
        bSiguiente = new JButton("SIGUIENTE");
        bCancelar.setBackground(p);
        bSiguiente.setBackground(q);
        bCancelar.setFont(font3);
        bSiguiente.setFont(font3);
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bSiguiente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.addActionListener(this);
        bSiguiente.addActionListener(this);
        tNombrePropuesta = new JTextField("TITULO");
        tTiempo = new JTextField("TIEMPO DE EJECUCION (DIAS)");
        tNombrePropuesta.setFont(font3);
        tNombrePropuesta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tTiempo.setFont(font3);
        tTiempo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tTiempo.setForeground(Color.LIGHT_GRAY);
        tNombrePropuesta.setForeground(Color.LIGHT_GRAY);
        tNombrePropuesta.addKeyListener(this);
        tTiempo.addKeyListener(this);
        tTiempo.addMouseListener(this);
        tNombrePropuesta.addMouseListener(this);
        List<String> lista = nombreLineas(listaLineas());
        String[] items = new String[lista.size()];
        items = lista.toArray(items);
        cLinea = new JComboBox(items);
        cLinea.setFont(font3);
        cLinea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        List<String> listaSub = nombreLineas(listaSublineas((String)cLinea.getSelectedItem()));
        String[] items2 = new String[listaSub.size()];
        items = listaSub.toArray(items2);
        cSublinea = new JComboBox(items2);
        cSublinea.setFont(font3);
        cSublinea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cLinea.setBackground(t);
        cSublinea.setBackground(t);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(0,2,10,0));
        panel2.setOpaque(false);
        panel2.add(cLinea);
        panel2.add(cSublinea);
        
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3,0,0,5));
        panel3.setOpaque(false);
        panel3.add(panel2);
        panel3.add(tNombrePropuesta);
        panel3.add(tTiempo);
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel4.setOpaque(false);
        panel4.add(bCancelar);
        panel4.add(bSiguiente);
        
        JPanel panel5 = new JPanel();
        panel5.setLayout(new BorderLayout());
        panel5.setOpaque(false);
        panel5.add(new JLabel("    "), BorderLayout.NORTH);
        panel5.add(new JLabel("    "), BorderLayout.SOUTH);
        JLabel titulo = new JLabel("DATOS DE LA PROPUESTA", JLabel.CENTER);
        titulo.setFont(font3);
        panel5.add(titulo, BorderLayout.CENTER);
        
        panel1.add(panel5, BorderLayout.NORTH);
        panel1.add(panel3, BorderLayout.CENTER);
        panel1.add(panel4, BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        panel1.add(new JLabel("    "), BorderLayout.WEST);

        
        return panel1;
    }
    
    public JPanel panel4(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setOpaque(false);
        JLabel titulo = new JLabel("INTEGRANTES", JLabel.CENTER);
        titulo.setFont(font);
        //titulo.setForeground(Color.WHITE);
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(crearTabla(), BorderLayout.CENTER);
        
        return panel;
    }
    
    public void actualizarDatos(){
        modelo.setNumRows(0);
        int p = 0;
        for(Estudiante i : integrantes){
            Object[] info = {i.getCedula(), i.getApellido() + " " + i.getNombre(), i.getCarrera()};
            p++;
            modelo.addRow(info);
        }
        //modelo.setNumRows(11-p);
    }
    
    public JScrollPane crearTabla(){
        Object[] items = {"DOCUMENTO","NOMBRE", "PROGRAMA" };
        modelo = new DefaultTableModel(null, items);
        tabla = new JTable(modelo);
        tabla.setBackground(Color.WHITE);
        tabla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tabla.setFont(font3);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return scroll;
    }
    
    public Estudiante extraerDatosEst(){
        Estudiante p = null;
        if(!tNombre.getText().isEmpty() && !tApellido.getText().isEmpty() && !tPrograma.getText().isEmpty()
                && !tTelefono.getText().isEmpty() && !tDNI.getText().isEmpty()){
            p = new Estudiante(tNombre.getText(), tApellido.getText(), Long.parseLong(tDNI.getText()), 
                    Long.parseLong(tTelefono.getText()), tPrograma.getText());
        }
        
        return p;
    }
    
    public Docente extraerDatosDoc(){
        Docente p = null;
        if(!tNombreDocente.getText().isEmpty() && !tApellidoDocente.getText().isEmpty()
                && !tDNIDocente.getText().isEmpty() && !tTelefonoDocente.getText().isEmpty()){
            p = new Docente(tNombreDocente.getText(), tApellidoDocente.getText(),
            Long.parseLong(tDNIDocente.getText()), Long.parseLong(tTelefonoDocente.getText()));
        }
        
        return p;
    }
    
    public void cleanTextPro(){
        if(nNomPro < 1){
            tNombrePropuesta.setText("");
            nNomPro++;
        }
        if(nTiempo < 1){
            tTiempo.setText("");
            nTiempo++;
        }
        tTiempo.setForeground(Color.BLACK);
        tNombrePropuesta.setForeground(Color.BLACK);
    }
    
    public void cleanTextEst(){
        if(nNomEst<1){
            tNombre.setText(" ");
            nNomEst++;
        }
        if(nApeEst<1){
            tApellido.setText("");
            nApeEst++;
        }
        if(nDNI<1){
            tDNI.setText("");
            nDNI++;
        }
        if(nPro<1){
            tPrograma.setText("");
            nPro++;
        }
        if(nTelEst < 1){
            tTelefono.setText("");
            nTelEst++;
        }
        tTelefono.setForeground(Color.BLACK);
        tNombre.setForeground(Color.BLACK);
        tApellido.setForeground(Color.BLACK);
        tDNI.setForeground(Color.BLACK);
        tPrograma.setForeground(Color.BLACK);
    }
    
    public void cleanTextDoc(){
         if(nNomDoc<1){
            tNombreDocente.setText(" ");
            nNomDoc++;
        }
        if(nApeDoc<1){
            tApellidoDocente.setText("");
            nApeDoc++;
        }
        if(nDNIDoc<1){
            tDNIDocente.setText("");
            nDNIDoc++;
        }
        
        if(nTelDoc < 1){
            tTelefonoDocente.setText("");
            nTelDoc++;
        }
        tTelefonoDocente.setForeground(Color.BLACK);
        tNombreDocente.setForeground(Color.BLACK);
        tApellidoDocente.setForeground(Color.BLACK);
        tDNIDocente.setForeground(Color.BLACK);
    }
    
    public void agregarEst(Estudiante p){
        if(integrantes == null){
            integrantes = new ArrayList();
        }
        integrantes.add(p);
    }
    
       public List<LineaInvestigacion> listaLineas(){
       return CentroOperaciones.allLineas;
   }
    
       public List<LineaInvestigacion> listaSublineas(String nombre){
           LineaInvestigacion p = null;
            for(LineaInvestigacion i : listaLineas()){
                if(nombre.equals(i.getNombreLinea())){
                    p = i;
                }
            }
            if(p!= null){
                return p.getSublineas();
            }
            else{
                return new ArrayList();
            }
       }
    
   public List<String> nombreLineas(List<LineaInvestigacion> lineas){
        List<String> nombreLineas = new ArrayList();
        for(LineaInvestigacion i : lineas){
            nombreLineas.add(i.getNombreLinea());
        }
        return nombreLineas;
    }
   
   public void extraerInformacion(){
       String nombreLinea = (String) cLinea.getSelectedItem();
       for(LineaInvestigacion i : listaLineas()){
           if(nombreLinea.equals(i.getNombreLinea())){
               linea = i;
               break;
           }
       }
       
       String nombreSublinea = (String) cSublinea.getSelectedItem();
       for(LineaInvestigacion i : listaLineas()){
           for(LineaInvestigacion j : i.getSublineas()){
               if(nombreSublinea.equals(j.getNombreLinea())){
                   sublinea = j;
                   break;
               }
           }
       }
       
       if(!tNombrePropuesta.getText().isEmpty()){
           titulo = tNombrePropuesta.getText();
       }
       if(!tTiempo.getText().isEmpty()){
           tiempo = Integer.parseInt(tTiempo.getText());
   }
       
   }
   
   public boolean  verificarInformacion(){
       extraerInformacion();
       if(integrantes != null && tiempo != 0 && docente != null && titulo != null  && linea != null && sublinea != null){
           return true;
       }
       else{
           return false;
       }
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.bAgregarEstudiante){
            agregarEst(extraerDatosEst());
            actualizarDatos();
            tNombre.setText("");
            tApellido.setText("");
            tDNI.setText("");
            tPrograma.setText("");
            tTelefono.setText("");
        }
        if(e.getSource() == this.bAgregar){
            docente = extraerDatosDoc();
            tNombreDocente.setEnabled(false);
            tApellidoDocente.setEnabled(false);
            tDNIDocente.setEnabled(false);
            tTelefonoDocente.setEnabled(false);
            tNombreDocente.setDisabledTextColor(Color.LIGHT_GRAY);
            tApellidoDocente.setDisabledTextColor(Color.LIGHT_GRAY);
            tDNIDocente.setDisabledTextColor(Color.LIGHT_GRAY);
            tTelefonoDocente.setDisabledTextColor(Color.LIGHT_GRAY);
            tNombreDocente.setBackground(Color.GRAY);
            tApellidoDocente.setBackground(Color.GRAY);
            tDNIDocente.setBackground(Color.GRAY);
            tTelefonoDocente.setBackground(Color.GRAY);
            tNombreDocente.setText("NOMBRE");
            tApellidoDocente.setText("APELLIDO");
            tDNIDocente.setText("DOCUMENTO");
            tTelefonoDocente.setText("TELEFONO");
           bAgregar.setEnabled(false);
        }
        if(e.getSource() == this.bCancelar){
            frame.dispose();
            frame = new principalGUI();
        }
        if(e.getSource() == this.bSiguiente && verificarInformacion()){
            List<LineaInvestigacion> sublineas = new ArrayList();
            sublineas.add(sublinea);
             new TipoPropuesta(frame, this.integrantes, this.titulo, this.tiempo,
                    this.docente, this.linea, sublineas);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.tNombre){
            cleanTextEst();
        }
         if(e.getSource() == this.tApellido){
            cleanTextEst();
        }
          if(e.getSource() == this.tDNI){
            cleanTextEst();
        }
           if(e.getSource() == this.tPrograma){
            cleanTextEst();
        }
            if(e.getSource() == this.tTelefono){
            cleanTextEst();
        }
             if(e.getSource() == this.tNombreDocente){
            cleanTextDoc();
        }
         if(e.getSource() == this.tApellidoDocente){
            cleanTextDoc();
        }
          if(e.getSource() == this.tDNIDocente){
            cleanTextDoc();
          }
            if(e.getSource() == this.tTelefonoDocente){
            cleanTextDoc();
        }
        if(e.getSource() == this.tNombrePropuesta){
            cleanTextPro();
          }
            if(e.getSource() == this.tTiempo){
            cleanTextPro();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
         if(e.getSource() == this.tNombre){
            cleanTextEst();
        }
         if(e.getSource() == this.tApellido){
            cleanTextEst();
        }
          if(e.getSource() == this.tDNI){
            cleanTextEst();
        }
           if(e.getSource() == this.tPrograma){
            cleanTextEst();
        }
            if(e.getSource() == this.tTelefono){
            cleanTextEst();
        }
             if(e.getSource() == this.tNombreDocente){
            cleanTextDoc();
        }
         if(e.getSource() == this.tApellidoDocente){
            cleanTextDoc();
        }
          if(e.getSource() == this.tDNIDocente){
            cleanTextDoc();
          }
            if(e.getSource() == this.tTelefonoDocente){
            cleanTextDoc();
        }
        if(e.getSource() == this.tNombrePropuesta){
            cleanTextPro();
          }
            if(e.getSource() == this.tTiempo){
            cleanTextPro();
        }
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
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == this.tNombre){
            cleanTextEst();
        }
         if(e.getSource() == this.tApellido){
            cleanTextEst();
        }
          if(e.getSource() == this.tDNI){
            cleanTextEst();
        }
           if(e.getSource() == this.tPrograma){
            cleanTextEst();
        }
            if(e.getSource() == this.tTelefono){
            cleanTextEst();
        }
             if(e.getSource() == this.tNombreDocente){
            cleanTextDoc();
        }
         if(e.getSource() == this.tApellidoDocente){
            cleanTextDoc();
        }
          if(e.getSource() == this.tDNIDocente){
            cleanTextDoc();
          }
            if(e.getSource() == this.tTelefonoDocente){
            cleanTextDoc();
        }
        if(e.getSource() == this.tNombrePropuesta){
            cleanTextPro();
          }
            if(e.getSource() == this.tTiempo){
            cleanTextPro();
        }
    }
    
}


class TipoPropuesta extends JDialog implements ActionListener, KeyListener, MouseListener{
    private JComboBox cTipo;
    private Container contenedor;
    private JTextField tObjetivo, tEspecifico, tFunciones, tDepTrabajo, tAreaTrabajo, tNIT;
    private JTextArea tAreaJus, tAreaRe, tDatosEmpresa;
    private JTable tablaObj, tablaEsp, tablaFunc;
    private DefaultTableModel modelo1, modelo2, modelo3;
    private JButton bAgregarGen, bAgregarEs, bSiguiente, bCancelar;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 15);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128), q = new Color(144, 235, 109), t = new Color(109,184,235);
     private List<String> objGenerales, objEspecificos, objFunciones;
    private JButton bFuncion;
    private JPanel lienzo;
    private JButton bSubir;
    
    private List<String> listaGen, listaEsp, listaFun;
    private String justificacion, resumen, datosEmpresa, deptrabajo, areatrabajo;
    private List<Estudiante> integrantes;
    private String titulo;
    private int tiempo;
    private Docente docente;
    private LineaInvestigacion linea;
    private List<LineaInvestigacion> sublineas;
    private long nitEmpresa;
    private principalGUI frame;
    private int nObj=0, nEsp=0, nFun=0, nDep=0, nJust=0, nRe=0, nDat=0, nTra=0, nNit=0;
    
    public TipoPropuesta(principalGUI frame, List<Estudiante> integrantes, String titulo, int tiempo, 
            Docente docente, LineaInvestigacion linea, List<LineaInvestigacion> sublineas){
        super(frame, "PROPUESTA");    
        this.inicializarComponentes();
        this.pack();
        this.setVisible(true);
         this.setBounds(0,0,400,485);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        this.integrantes = integrantes;
        this.tiempo = tiempo;
        this.docente = docente;
        this.titulo = titulo;
        this.linea = linea;
        this.sublineas = sublineas;
        
        
    }
    
     public TipoPropuesta(principalGUI frame){
        super(frame, "PROPUESTA");        
        this.inicializarComponentes();
        this.pack();
        this.setVisible(true);
         this.setBounds(0,0,400,485);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.frame = frame;
    }
    
    public void inicializarComponentes(){
        contenedor = this.getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.setBackground(Color.WHITE);
        lienzo = panelCentral();
        contenedor.add(lienzo, BorderLayout.CENTER);
        contenedor.add(panelSuperior(), BorderLayout.NORTH);
        contenedor.add(panelInferior(), BorderLayout.SOUTH);
    } 
    
    
    
    public JPanel panelSuperior(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setOpaque(false);
        String[] items = {"PROYECTO APLICADO", "PRACTICAS EMPRESARIALES"};
        
        cTipo = new JComboBox(items);
        cTipo.setBackground(t);
        cTipo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cTipo.setFont(font3);
        cTipo.addActionListener(this);
        panel2.add(cTipo);
        
        
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(new JLabel("    "), BorderLayout.NORTH);
        panel1.add(new JLabel("    "), BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.WEST);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        
        return panel1;
    }
    
    public JPanel panelCentral(){
            JPanel panel1 = new JPanel();
            panel1.setLayout(new BorderLayout());
            //panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel1.setOpaque(false);

        tObjetivo = new JTextField("OBJETIVOS GENERALES");
        tEspecifico = new JTextField("OBJETIVOS ESPECIFICOS");
        tAreaJus = new JTextArea("JUSTIFICACION");
        tAreaRe = new JTextArea("RESUMEN");
        
        tObjetivo.setFont(font3);
        tObjetivo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tObjetivo.setForeground(Color.LIGHT_GRAY);
        tEspecifico.setFont(font3);
        tEspecifico.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tEspecifico.setForeground(Color.LIGHT_GRAY);
        tAreaJus.setFont(font3);
        tAreaJus.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tAreaJus.setForeground(Color.LIGHT_GRAY);
        tAreaRe.setFont(font3);
        tAreaRe.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tAreaRe.setForeground(Color.LIGHT_GRAY);
        
        tAreaRe.addKeyListener(this);
        tAreaJus.addMouseListener(this);
        tEspecifico.addKeyListener(this);
        tObjetivo.addKeyListener(this);
        tAreaRe.addMouseListener(this);
        tEspecifico.addMouseListener(this);
        tObjetivo.addMouseListener(this);
        
        bAgregarEs = new JButton("AGREGAR");
        bAgregarGen = new JButton("AGREGAR");
        bAgregarEs.setFont(font3);
        bAgregarEs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bAgregarGen.setFont(font3);
        bAgregarGen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bAgregarEs.setBackground(q);
        bAgregarGen.setBackground(q);
        
        bAgregarGen.addActionListener(this);
        bAgregarEs.addActionListener(this);
        
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel4.setOpaque(false);
        panel4.add(bAgregarGen);
        
        JPanel panel5  = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel5.setOpaque(false);
        panel5.add(bAgregarEs);
        
        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setLayout(new GridLayout(4,0,0,5));
        panel3.add(tObjetivo);
        panel3.add(panel4);
        panel3.add(tEspecifico);
        panel3.add(panel5);
        
        
        JPanel panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        panel6.setOpaque(false);
        panel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel6.add(new JLabel("    "), BorderLayout.NORTH);
        panel6.add(new JLabel("    "), BorderLayout.SOUTH);
        panel6.add(new JLabel("    "), BorderLayout.EAST);
        panel6.add(new JLabel("    "), BorderLayout.WEST);
        panel6.add(panel3, BorderLayout.CENTER);
        
        
        JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayout(2,0,0,10));
        panel7.setOpaque(false);
        panel7.add(tAreaRe);
        panel7.add(tAreaJus);
        
        JPanel panel8 = new JPanel();
        panel8.setLayout(new BorderLayout());
        panel8.setOpaque(false);
        panel8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel8.add(panel7, BorderLayout.CENTER);
        panel8.add(new JLabel("    "), BorderLayout.NORTH);
        panel8.add(new JLabel("    "), BorderLayout.SOUTH);
        panel8.add(new JLabel("    "), BorderLayout.EAST);
        panel8.add(new JLabel("    "), BorderLayout.WEST);
        
        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setLayout(new GridLayout(2,2,20,20));
        panel2.add(crearTabla1());
        panel2.add(panel6);
        panel2.add(crearTabla2());
        panel2.add(panel8);
        
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(new JLabel("    "), BorderLayout.NORTH);
        panel1.add(new JLabel("    "), BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        panel1.add(new JLabel("    "), BorderLayout.WEST);
        
        return panel1;
    }
    
    public JPanel panelCentral2(){
        JPanel panel1 = new JPanel();
            panel1.setLayout(new BorderLayout());
            //panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel1.setOpaque(false);

        tDatosEmpresa = new JTextArea("DATOS DE LA EMPRESA");
        tDepTrabajo = new JTextField("DEPARTAMENTO DE TRABAJO");
        tFunciones = new JTextField("FUNCIONES A DESARROLLAR");
        tAreaTrabajo = new JTextField("AREA DE TRABAJO");
        tNIT = new JTextField("NIT DE LA EMPRESA");
        
        
        
        tNIT.setFont(font3);
        tNIT.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tNIT.setForeground(Color.LIGHT_GRAY);
        tDatosEmpresa.setFont(font3);
        tDatosEmpresa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDatosEmpresa.setForeground(Color.LIGHT_GRAY);
        tDepTrabajo.setFont(font3);
        tDepTrabajo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tDepTrabajo.setForeground(Color.LIGHT_GRAY);
        tFunciones.setFont(font3);
        tFunciones.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tFunciones.setForeground(Color.LIGHT_GRAY);
        tAreaTrabajo.setFont(font3);
        tAreaTrabajo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tAreaTrabajo.setForeground(Color.LIGHT_GRAY);
        tAreaTrabajo.addKeyListener(this);
        tAreaTrabajo.addMouseListener(this);
        tFunciones.addKeyListener(this);
        tFunciones.addMouseListener(this);
        tDepTrabajo.addKeyListener(this);
        tDepTrabajo.addMouseListener(this);
        tDatosEmpresa.addKeyListener(this);
        tDatosEmpresa.addMouseListener(this);
        tNIT.addMouseListener(this);
        tNIT.addKeyListener(this);
        bFuncion = new JButton("AGREGAR");
        bFuncion.setFont(font3);
        bFuncion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bFuncion.setBackground(q);
        bFuncion.addActionListener(this);
        
        
        JPanel panel5  = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel5.setOpaque(false);
        panel5.add(bFuncion);
        
        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setLayout(new GridLayout(5,0,0,5));
        panel3.add(tFunciones);
        panel3.add(panel5);
        panel3.add(tDepTrabajo);
        panel3.add(tAreaTrabajo);
        
        
        JPanel panel6 = new JPanel();
        panel6.setLayout(new BorderLayout());
        panel6.setOpaque(false);
        panel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel6.add(new JLabel("    "), BorderLayout.NORTH);
        panel6.add(new JLabel("    "), BorderLayout.SOUTH);
        panel6.add(new JLabel("    "), BorderLayout.EAST);
        panel6.add(new JLabel("    "), BorderLayout.WEST);
        panel6.add(panel3, BorderLayout.CENTER);
        
        JPanel panel9 =  new JPanel();
        panel9.setLayout(new BorderLayout());
        panel9.setOpaque(false);
        panel9.add(tNIT);
        panel9.add(new JLabel("    "), BorderLayout.NORTH);
        JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayout());
        panel7.setOpaque(false);
        panel7.add(tDatosEmpresa);
        
        JPanel panel10 = new JPanel();
        panel10.setLayout(new BorderLayout());
        panel10.setOpaque(false);
        panel10.add(panel7);
        panel10.add(panel9, BorderLayout.SOUTH);
        JPanel panel8 = new JPanel();
        panel8.setLayout(new BorderLayout());
        panel8.setOpaque(false);
        panel8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel8.add(panel10, BorderLayout.CENTER);
        panel8.add(new JLabel("    "), BorderLayout.NORTH);
        panel8.add(new JLabel("    "), BorderLayout.SOUTH);
        panel8.add(new JLabel("    "), BorderLayout.EAST);
        panel8.add(new JLabel("    "), BorderLayout.WEST);
        
        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setLayout(new GridLayout(0,2, 10,0));
        
        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2,0,0,10));
        panel4.setOpaque(false);
        panel4.add(panel6);
        panel4.add(panel8);
        
        panel2.add(crearTabla3());
        panel2.add(panel4);
        
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(new JLabel("    "), BorderLayout.NORTH);
        panel1.add(new JLabel("    "), BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        panel1.add(new JLabel("    "), BorderLayout.WEST);
        
        return panel1;
    }
    
    public JPanel panelInferior(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel2.setOpaque(false);
        
        bSiguiente = new JButton("ENVIAR");
        bCancelar = new JButton("CANCELAR");
        bSiguiente.setFont(font3);
        bCancelar.setFont(font3);
        bSiguiente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bSiguiente.setBackground(q);
        bCancelar.setBackground(p);
        bSubir = new JButton("SUBIR DOCUMENTO");
        bSubir.setFont(font3);
        bSubir.setBackground(Color.CYAN);
        bSubir.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCancelar.addActionListener(this);
        bSubir.addActionListener(this);
        bSiguiente.addActionListener(this);
        
        panel2.add(bCancelar);
        panel2.add(bSiguiente);
        panel2.add(bSubir);
        
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(new JLabel("    "), BorderLayout.NORTH);
        panel1.add(new JLabel("    "), BorderLayout.SOUTH);
        panel1.add(new JLabel("    "), BorderLayout.WEST);
        panel1.add(new JLabel("    "), BorderLayout.EAST);
        
        
        return panel1;
    }
    
    public JScrollPane crearTabla1(){
        String item[] = {"OBJETIVOS GENERALES"};
        modelo1 = new DefaultTableModel(null, item);
        tablaObj =  new JTable(modelo1);
        tablaObj.setOpaque(false);
        tablaObj.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tablaObj.setFont(font3);
        
        JScrollPane scroll = new JScrollPane(tablaObj);
        scroll.setOpaque(false);
        
        return scroll;
    }
    
    
    public JScrollPane crearTabla2(){
        String item[] = {"OBJETIVOS ESPECIFICOS"};
        modelo2 = new DefaultTableModel(null, item);
        tablaEsp =  new JTable(modelo2);
        tablaEsp.setOpaque(false);
        tablaEsp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tablaEsp.setFont(font3);
        JScrollPane scroll = new JScrollPane(tablaEsp);
        scroll.setOpaque(false);
        
        return scroll;
    }
    
    public JScrollPane crearTabla3(){
        String item[] = {"FUNCIONES A DESARROLLAR"};
        modelo3 = new DefaultTableModel(null, item);
        tablaFunc =  new JTable(modelo3);
        tablaFunc.setOpaque(false);
        tablaFunc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tablaFunc.setFont(font3);
        JScrollPane scroll = new JScrollPane(tablaFunc);
        scroll.setOpaque(false);
        
        return scroll;
    }
    
    public void actualizarTabla1(){
        modelo1.setNumRows(0);
        int p=0;
        for(String i : listaGen){
            Object[] info = {i};
            modelo1.addRow(info);
            p++;
        }
        modelo1.setNumRows(8-p);
    }
    public void actualizarTabla2(){
        modelo2.setNumRows(0);
        int p=0;
        for(String i : listaEsp){
            Object[] info = {i};
            modelo2.addRow(info);
            p++;
        }
        modelo2.setNumRows(8-p);
    }
    
    public void actualizarTabla3(){
        modelo3.setNumRows(0);
        int p=0;
        for(String i : listaFun){
            Object[] info = {i};
            modelo3.addRow(info);
            p++;
        }
        modelo3.setNumRows(17-p);
    }
    
    public void guardarGen(){
        if(listaGen == null){
            listaGen = new ArrayList();
        }
        
        if(!tObjetivo.getText().isEmpty() ){
            listaGen.add(tObjetivo.getText());
        }
        actualizarTabla1();
    }
    public void guardarEsp(){
        if(listaEsp == null){
            listaEsp = new ArrayList();
        }
        
        if(!tEspecifico.getText().isEmpty() ){
            listaEsp.add(tEspecifico.getText());
        }
        actualizarTabla2();
    }
    public void guardarFun(){
        if(listaFun == null){
            listaFun = new ArrayList();
        }
        
        if(!tFunciones.getText().isEmpty() ){
            listaFun.add(tFunciones.getText());
        }
        actualizarTabla3();
    }
    
    public void cleanTextPrac(){
        
        if(nDep < 1){
            tDepTrabajo.setText("");
            nDep++;
        }
        
        if(nFun < 1){
            tFunciones.setText("");
            nFun++;
        }
       
       
       if(nDat < 1){
           tDatosEmpresa.setText("");
           nDat++;
       }
        
       if(nTra < 1){
           tAreaTrabajo.setText("");
           nTra++;
       }
       if(nNit < 1){
           tNIT.setText("");
           nNit++;
       }
       tNIT.setForeground(Color.BLACK);
       tAreaTrabajo.setForeground(Color.BLACK);
       tDatosEmpresa.setForeground(Color.BLACK);
       tDepTrabajo.setForeground(Color.BLACK);
       tFunciones.setForeground(Color.BLACK);
       
    }
    
    public void cleanTextPro(){
        if(nObj < 1){
            tObjetivo.setText("");
            nObj++;
        }

        if(nEsp < 1){
            tEspecifico.setText("");
            nEsp++;
        }
  
        if(nRe < 1){
            tAreaRe.setText("");
            nRe++;
        }
        if(nJust < 1){
            tAreaJus.setText("");
            nJust++;
        }
      tAreaJus.setForeground(Color.BLACK);
      tAreaRe.setForeground(Color.BLACK);
      tEspecifico.setForeground(Color.BLACK);
      tObjetivo.setForeground(Color.BLACK);
    }
    
    
    public boolean validarInfoPro(){
        if(!tAreaJus.getText().isEmpty() && !tAreaRe.getText().isEmpty() && 
                listaEsp != null && listaGen != null){
            justificacion = tAreaJus.getText();
            resumen = tAreaRe.getText();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean validarInfoPrac(){
        if(!tAreaTrabajo.getText().isEmpty() && !tDatosEmpresa.getText().isEmpty() &&
                !tDepTrabajo.getText().isEmpty() && listaFun != null && !tNIT.getText().isEmpty()){
            nitEmpresa = Long.parseLong(tNIT.getText());
            areatrabajo = tAreaTrabajo.getText();
            deptrabajo = tDepTrabajo.getText();
            datosEmpresa = tDatosEmpresa.getText();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean tipoPropuesta(){
        return cTipo.getSelectedItem().equals("PROYECTO APLICADO");
    }
    
    
    public ProyectoAplicado crearProtecto(){
        return new ProyectoAplicado(titulo, resumen, listaGen, listaEsp, justificacion, integrantes
                                                        , docente, tiempo, linea, sublineas, null);
    }
    
    public PracticasEmpresariales crearPracticas(){
        return new PracticasEmpresariales(titulo,datosEmpresa, deptrabajo, areatrabajo, listaFun,
        nitEmpresa, integrantes, docente, tiempo, linea, sublineas, null);
    }    

    
    public void guardarPropuesta(PropuestaGrado p){
        CentroOperaciones.agregarPropuesta(p);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.cTipo){
            nObj=0;nEsp=0; nFun=0; nDep=0; nJust=0; nRe=0; nDat=0;
            String select = (String)cTipo.getSelectedItem();
            if("PROYECTO APLICADO".equals(select)){
                this.setBounds(0,0,450,485);
                this.setLocationRelativeTo(null);
                contenedor.remove(lienzo);
                lienzo = panelCentral();
                contenedor.add(lienzo, BorderLayout.CENTER);
                contenedor.revalidate();
            }
            else{
                 nObj=0;nEsp=0; nFun=0; nDep=0; nJust=0; nRe=0; nDat=0;
                this.setBounds(0,0,450,500);
                this.setLocationRelativeTo(null);
                contenedor.remove(lienzo);
                lienzo = panelCentral2();
                contenedor.add(lienzo, BorderLayout.CENTER);
                contenedor.revalidate();
            }
            
        }
        if(e.getSource() == bAgregarGen){
            guardarGen();
            tObjetivo.setText("");
        }
        if(e.getSource() == bAgregarEs){
            guardarEsp();
            tEspecifico.setText("");
        }
        if(e.getSource() == bFuncion){
            guardarFun();
            tFunciones.setText("");
        }
        if(e.getSource() == bSiguiente){
            if(tipoPropuesta()){
                if(validarInfoPro()){
                    PropuestaGrado p = crearProtecto();
                    guardarPropuesta(p);
                    JOptionPane.showMessageDialog(this, "RADICADO: " + p.getCodigo());
                    this.dispose();
                    
                    
                    
                }
                else{
                    JOptionPane.showMessageDialog(this, "LLENAR CAMPOS");
                }
            }
            else{
                if(validarInfoPrac()){
                    PropuestaGrado p = crearPracticas();
                     guardarPropuesta(p);
                    JOptionPane.showMessageDialog(this, "RADICADO: " + p.getCodigo());
                    this.dispose();
                   
                    
                   
                }
                else{
                    JOptionPane.showMessageDialog(this, "LLENAR CAMPOS");
                }
            }
        }
        if(e.getSource() == bCancelar){
            dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == tAreaJus){
            cleanTextPro();
        }
        if(e.getSource() == tAreaRe){
            cleanTextPro();
        }
        if(e.getSource() == tEspecifico){
            cleanTextPro();
        }
        if(e.getSource() == tObjetivo){
            cleanTextPro();
        }
        if(e.getSource() == tFunciones){
            cleanTextPrac();
        }
        if(e.getSource() == tDatosEmpresa){
            cleanTextPrac();
        }
        if(e.getSource() == tDepTrabajo){
            cleanTextPrac();
        }
        if(e.getSource() == tNIT){
            cleanTextPrac();
        }
        if(e.getSource() == tAreaTrabajo){
            cleanTextPrac();
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getSource() == tAreaJus){
            cleanTextPro();
        }
        if(e.getSource() == tAreaRe){
            cleanTextPro();
        }
        if(e.getSource() == tEspecifico){
            cleanTextPro();
        }
        if(e.getSource() == tObjetivo){
            cleanTextPro();
        }
        if(e.getSource() == tFunciones){
            cleanTextPrac();
        }
        if(e.getSource() == tDatosEmpresa){
            cleanTextPrac();
        }
        if(e.getSource() == tDepTrabajo){
            cleanTextPrac();
        }
        if(e.getSource() == tNIT){
            cleanTextPrac();
        }
        if(e.getSource() == tAreaTrabajo){
            cleanTextPrac();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
         if(e.getSource() == tAreaJus){
            cleanTextPro();
        }
        if(e.getSource() == tAreaRe){
            cleanTextPro();
        }
        if(e.getSource() == tEspecifico){
            cleanTextPro();
        }
        if(e.getSource() == tObjetivo){
            cleanTextPro();
        }
        if(e.getSource() == tFunciones){
            cleanTextPrac();
        }
        if(e.getSource() == tDatosEmpresa){
            cleanTextPrac();
        }
        if(e.getSource() == tDepTrabajo){
            cleanTextPrac();
        }
        if(e.getSource() == tNIT){
            cleanTextPrac();
        }
        if(e.getSource() == tAreaTrabajo){
            cleanTextPrac();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if(e.getSource() == tAreaJus){
            cleanTextPro();
        }
        if(e.getSource() == tAreaRe){
            cleanTextPro();
        }
        if(e.getSource() == tEspecifico){
            cleanTextPro();
        }
        if(e.getSource() == tObjetivo){
            cleanTextPro();
        }
        if(e.getSource() == tFunciones){
            cleanTextPrac();
        }
        if(e.getSource() == tDatosEmpresa){
            cleanTextPrac();
        }
        if(e.getSource() == tDepTrabajo){
            cleanTextPrac();
        }
        if(e.getSource() == tNIT){
            cleanTextPrac();
        }
        if(e.getSource() == tAreaTrabajo){
            cleanTextPrac();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() == tAreaJus){
            cleanTextPro();
        }
        if(e.getSource() == tAreaRe){
            cleanTextPro();
        }
        if(e.getSource() == tEspecifico){
            cleanTextPro();
        }
        if(e.getSource() == tObjetivo){
            cleanTextPro();
        }
        if(e.getSource() == tFunciones){
            cleanTextPrac();
        }
        if(e.getSource() == tDatosEmpresa){
            cleanTextPrac();
        }
        if(e.getSource() == tDepTrabajo){
            cleanTextPrac();
        }
        if(e.getSource() == tNIT){
            cleanTextPrac();
        }
        if(e.getSource() == tAreaTrabajo){
            cleanTextPrac();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         if(e.getSource() == tAreaJus){
            cleanTextPro();
        }
        if(e.getSource() == tAreaRe){
            cleanTextPro();
        }
        if(e.getSource() == tEspecifico){
            cleanTextPro();
        }
        if(e.getSource() == tObjetivo){
            cleanTextPro();
        }
        if(e.getSource() == tFunciones){
            cleanTextPrac();
        }
        if(e.getSource() == tDatosEmpresa){
            cleanTextPrac();
        }
        if(e.getSource() == tDepTrabajo){
            cleanTextPrac();
        }
        if(e.getSource() == tNIT){
            cleanTextPrac();
        }
        if(e.getSource() == tAreaTrabajo){
            cleanTextPrac();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

