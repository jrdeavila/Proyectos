/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import DATOS.Docente;
import DATOS.LineaInvestigacion;
import DATOS.PropuestaGrado;
import java.awt.*;
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
public class DocenteGUI extends PanelFondo implements ActionListener{
    private JLabel lNombreDoc, lDNI, lLineaInv;
    private JPanel lienzo, panel2;
    private JButton bHistorial, bCerrarSesion, bRevisarPropuestas;
    private JTable tablaProp, TablaHist, TablaRevisar;
    
    private String nombre;
    private List<LineaInvestigacion> linea;
    private long DNI;
     private List<PropuestaGrado> lista;
    
    private Docente docente;
    private Font font = new Font("Cambria Math", 1, 18);
    private Font font2 = new Font("Cambria Math", 1, 13);
    private Font font3 = new Font("Cambria Math", 1, 12);
    private  Color p = new Color(240,128,128);
    private DefaultTableModel modelo;
    private JScrollPane scroll;
    private principalGUI frame;
    
    public DocenteGUI(principalGUI frame, Docente docente){
        this.docente  = docente;
        this.DNI = this.docente.getCedula();
        this.nombre = "<html>" + this.docente.getApellido() + "<P>" + this.docente.getNombre() + "<html>";
        this.linea = this.docente.getLineaTrabajo();
        this.lista = this.docente.getProyectosAsignados();
        this.frame = frame;
        inicializarComponentes();
    }

    public void inicializarComponentes() {
        lienzo = new JPanel();
        panel2 = new JPanel();
        panel2.setOpaque(false);
        lienzo.setOpaque(false);
        lienzo.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        lienzo.add(new JLabel("    "), BorderLayout.NORTH);
        lienzo.add(new JLabel("    "), BorderLayout.SOUTH);
        lienzo.add(new JLabel("    "), BorderLayout.EAST);
        lienzo.add(new JLabel("    "), BorderLayout.WEST);
        crearPanelOpc();
        crearPanel2(); 
        JPanel contenedor = new JPanel();
        contenedor.setLayout(new GridLayout(0,3));
        contenedor.add(panel2);
        contenedor.add(new JLabel());
        contenedor.add(lienzo);
        contenedor.setOpaque(false);
        this.add(contenedor, BorderLayout.CENTER);
        actualizarDatos();
    }
    
    public void actualizarDatos(){
        
        modelo.setNumRows(0);
       int p=0;
        for(PropuestaGrado i : lista){
           Object[] info = {i.getCodigo(),i.getTitulo(), i.getIntegrantes()};
           modelo.addRow(info);
           p++;
       }
        modelo.setNumRows(13 - p);
        
    }
    
    
    
    public void crearPanel2(){
        
        String[] items = {"CODIGO", "TITULO", "# DE INTEGRANTES"};
        String data[][] = {};
         this.modelo = new DefaultTableModel(data, items);
         tablaProp = new JTable(modelo);
         tablaProp.setFont(new Font("Cambria Math", 0, 11));
         tablaProp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         scroll = new JScrollPane(tablaProp);
         //scroll.setViewportView(tablaProp);
         scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         JPanel panel22 = new JPanel();
         panel22.setLayout(new BorderLayout());
         
         panel22.add(scroll, BorderLayout.CENTER);
         panel22.add(new JLabel("    "), BorderLayout.NORTH);
        panel22.add(new JLabel("    "), BorderLayout.SOUTH);
        panel22.add(new JLabel("    "), BorderLayout.EAST);
        panel22.add(new JLabel("    "), BorderLayout.WEST);
         panel22.setOpaque(false);

         JPanel infoDoc = new JPanel();
         infoDoc.setLayout(new GridLayout(3,0));
         infoDoc.setOpaque(false);
         lNombreDoc = new JLabel(nombre);
         lNombreDoc.setFont(font2);
         lNombreDoc.setForeground(Color.BLACK);
         lLineaInv = new JLabel();
         lLineaInv.setFont(font2);
         lLineaInv.setForeground(Color.BLACK);
         lDNI = new JLabel(Long.toString(DNI));
         lDNI.setFont(font2);
         lDNI.setForeground(Color.BLACK);
         
         infoDoc.add(lNombreDoc);
         infoDoc.add(lDNI);
         infoDoc.add(lLineaInv);
         
         
         
         
         JPanel lienzo3 = new JPanel();
         lienzo3.setLayout(new BorderLayout());
         lienzo3.setOpaque(false);
         
        lienzo3.add(new JLabel("    "), BorderLayout.NORTH);
        lienzo3.add(new JLabel("    "), BorderLayout.SOUTH);
        lienzo3.add(new JLabel("    "), BorderLayout.EAST);
        lienzo3.add(new JLabel("    "), BorderLayout.WEST); 
        lienzo3.add(infoDoc, BorderLayout.CENTER);
         
         
         
        JPanel lienzo2 = new JPanel();
        lienzo2.setLayout(new GridLayout(2,0));
        lienzo2.add(lienzo3);
        lienzo2.add(panel22);
        lienzo2.setOpaque(false);
        
         panel2.add(new JLabel());
         panel2.add(lienzo2);
    }
    
    public void crearPanelOpc(){
        JPanel lienzoP = new JPanel();
        lienzoP.setLayout(new BorderLayout());
        bCerrarSesion = new JButton("CERRAR SESIÓN");
        bCerrarSesion.setFont(font3);
        bCerrarSesion.setBackground(p);
        bCerrarSesion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bHistorial = new JButton("HISTORIAL");
        bHistorial.setFont(font3);
        bHistorial.setBackground(p);
        bHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bRevisarPropuestas = new JButton("REVISAR PROPUESTAS");
        bRevisarPropuestas.setFont(font3);
        bRevisarPropuestas.setBackground(p);
        bRevisarPropuestas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bCerrarSesion.addActionListener(this);
        bRevisarPropuestas.addActionListener(this);
        bHistorial.addActionListener(this);
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setOpaque(false);
        contenedorBotones.setLayout(new GridLayout(4,0,0,5));
        contenedorBotones.add(new JLabel());
        contenedorBotones.add(bRevisarPropuestas);
        contenedorBotones.add(bHistorial);
        contenedorBotones.add(bCerrarSesion);
        
        JLabel funcDoc = new JLabel("FUNCIONES DEL DOCENTE", JLabel.CENTER);
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

        
        lienzo.add(lienzoP2, BorderLayout.CENTER);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bCerrarSesion){
            frame.dispose();
            frame = new principalGUI();
        }
    }


}
