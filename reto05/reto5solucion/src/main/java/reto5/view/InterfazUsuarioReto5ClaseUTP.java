package reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import reto5.controller.InformesController;
import reto5.model.vo.ComprasProveedoresVo;
import reto5.model.vo.InformacionLiderVo;
import reto5.model.vo.ProyectosCasaCampestreVo;

public class InterfazUsuarioReto5ClaseUTP extends JFrame implements ActionListener{
    private InformesController controller;
    private JMenuBar mMenuBar;
    private JMenu menu;
    private JMenuItem i1,i2,i3;
    private JButton btnquery1,btnquery2,btnquery3;
    private JTable tabla;
    private DefaultTableModel modelo;
    // private JPanel panelRespuesta;
    // private JPanel panel1, panel2;
    

    public InterfazUsuarioReto5ClaseUTP(){
        controller = new InformesController();
        botones();
        menu();
        tabla();
        ventana();
        // panel1 = new JPanel();
        // panel1.setBounds(0, 0, 500, 100);
        // panel1.setBackground(Color.GREEN);
        // add(panel1);

        // panel2 = new JPanel();
        // panel2.setBounds(0, 200, 100, 200);
        // panel2.setBackground(Color.RED);
        // JTable mostrarResultados = tablaDatosLiderporCiudad();
        // panel2.add(mostrarResultados);
        // add(panel2);
        // panel2.setVisible(false);
        
        // panelRespuesta = new JPanel();
        // panelRespuesta.setBounds(0, btnquery3.getY()+50,500, 500);
        // // panelRespuesta.setBackground(Color.BLACK);
        // panelRespuesta.setVisible(false);
        // add(panelRespuesta);
        // this.pack();
        
        
        
    }

    public void menu(){
        mMenuBar = new JMenuBar();
        setJMenuBar(mMenuBar);
        menu = new JMenu("Consultas");
        mMenuBar.add(menu);
        i1= new JMenuItem("Lideres");
        i2 = new JMenuItem("Proyectos");
        i3 = new JMenuItem("Compras");
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        i1.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
    }

    public void ventana(){
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        setMinimumSize(new Dimension(600,400));
        // setLayout(null);
        // setSize(500, 500);
        // this.setBounds(0, 0, 500, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("VENTANA DE CONSULTAS");
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void botones(){btnquery1 = new JButton();
        btnquery1.addActionListener(this);
        btnquery1.setText("Problema 1");
        btnquery1.setBounds(10, 0, 100, 30);
        add(btnquery1); 
        
        btnquery2 = new JButton();
        btnquery2.addActionListener(this);
        btnquery2.setText("Problema 2");
        btnquery2.setBounds(btnquery1.getX(), btnquery1.getY()+50, 100, 30);
        add(btnquery2);
        
        btnquery3 = new JButton();
        btnquery3.addActionListener(this);
        btnquery3.setText("Problema 3");
        btnquery3.setBounds(btnquery2.getX(), btnquery2.getY()+50, 100, 30);
        add(btnquery3);
    }

    public void tabla(){
        tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
        tabla.setBackground(Color.BLACK);
        tabla.setGridColor(Color.GREEN);
        tabla.setForeground(Color.GREEN);
        tabla.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        add(pane);
    }
    // public void respuesta(){
    //     nuevaVentana = new JFrame();
    //     FlowLayout flowLayout = new FlowLayout();
    //     nuevaVentana.setLayout(flowLayout);
    //     nuevaVentana.setMinimumSize(new Dimension(600,400));
    //     // setLayout(null);
    //     // setSize(500, 500);
    //     // this.setBounds(0, 0, 500, 500); 
    //     nuevaVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     nuevaVentana.setTitle("VENTANA DE CONSULTAS");
    //     nuevaVentana.setResizable(false);
    //     nuevaVentana.setVisible(true);
    //     nuevaVentana.setLocationRelativeTo(null);

    // }
    public void tablaDatosLiderporCiudad(){
        try{
            String [] nombreColumnas = {"ID_LIDER" , "NOMBRE" , "APELLIDO" , "CIUDAD"};
            Object [][] datos = {};
            modelo = new DefaultTableModel(datos, nombreColumnas); 
            List<InformacionLiderVo> ListaDatosLider = controller.informeDatosLider();
            for (InformacionLiderVo i:ListaDatosLider){
                ArrayList<Object> filaNueva = new ArrayList<Object>();
                filaNueva.add(i.getIdLider());
                filaNueva.add(i.getNombre());
                filaNueva.add(i.getApellido());
                filaNueva.add(i.getCiudad());
                modelo.addRow(filaNueva.toArray());
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
    }
    
    public void tablaComprasAProveedores(){
        String [] nombreColumnas = {"ID_COMPRA" , "CONSTRUCTORA" , "BANCO" };
        Object [][] datos = {};
        modelo = new DefaultTableModel(datos, nombreColumnas);

        try{
            List<ComprasProveedoresVo> ListaComprasProveedores = controller.informeComprasProveedor();
            for (ComprasProveedoresVo i:ListaComprasProveedores){
                ArrayList<Object> filaNueva = new ArrayList<Object>();
                filaNueva.add(i.getIdCompra());
                filaNueva.add(i.getConstructora());
                filaNueva.add(i.getBanco());
                modelo.addRow(filaNueva.toArray());
                
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
        }
        catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
    }
    
    public void tablaProyectosCaCam(){
        String [] nombreColumnas = {"ID_PROYECTO" , "CONSTRUCTORA" , "NUMERO HABITACIONES", "CIUDAD"};
        Object [][] datos = {};
        modelo = new DefaultTableModel(datos, nombreColumnas);

        try{
            List<ProyectosCasaCampestreVo> ListaCasaCampestres = controller.informeCasasCampestres();
            for (ProyectosCasaCampestreVo i:ListaCasaCampestres){
                ArrayList<Object> filaNueva = new ArrayList<Object>();
                filaNueva.add(i.getIdProyecto());
                filaNueva.add(i.getConstructora());
                filaNueva.add(i.getHabitaciones());
                filaNueva.add(i.getCiudad());
                modelo.addRow(filaNueva.toArray());
                
            }
            tabla.setModel(modelo);
            modelo.fireTableDataChanged();
            
        }
        catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // JTable mostrarResultados = tablaDatosLiderporCiudad();
        if(e.getSource() == btnquery1){
            tablaDatosLiderporCiudad();
            // panelRespuesta.setVisible(true);
            // btnquery1.setEnabled(false);

            
            // displayRespuesta(tablaDatosLiderporCiudad());

            // displayPublico.add(tablaDatosLiderporCiudad());
            // panel2 = new JPanel();
            // panel2.setBackground(Color.RED);
            // panel2.setBounds(0, 300, 500, 500);
            // panel2.add(tablaDatosLiderporCiudad());
            // this.add(panel2);
            // tablaDatosLiderporCiudad();
                
        }
        if(e.getSource() == btnquery2){
            tablaComprasAProveedores();
            // btnquery2.setEnabled(false);
        }
        if(e.getSource() == btnquery3){
            tablaProyectosCaCam();
            // btnquery3.setEnabled(false);
        }
    }
    
    // public static void main(String[] args) throws Exception {
    //     InterfazUsuarioReto5 ventana = new InterfazUsuarioReto5();
    //     ventana.pack(); // metodo pack(): ventana toma el tamaño de las cosas adentro
    //     ventana.setVisible(true);
    //     ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // }   

    

    
}