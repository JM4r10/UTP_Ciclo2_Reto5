package reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import reto5.controller.InformesController;
import reto5.model.vo.ComprasProveedoresVo;
import reto5.model.vo.InformacionLiderVo;
import reto5.model.vo.ProyectosCasaCampestreVo;

public class InterfazUsuarioReto5 extends JFrame implements ActionListener, MouseListener{
    private InformesController controller = new InformesController();
    private JButton btnquery1,btnquery2,btnquery3;
    private JButton [] arrayButtons = {btnquery1,btnquery2,btnquery3};
    private JTable tabla;
    private JPanel panel1, panel2, panel3;
    private JLabel lblPn1, lblPn2, lblConsulta;
    private DefaultTableModel modelo;
    private ImageIcon logoUTP = new ImageIcon("G:\\estudios\\programacion\\MinTic\\ciclo02\\retos\\reto05\\utp_solid.png");
    
    
    public InterfazUsuarioReto5(){
        panelInator();
        labelInator();
        buttonInator();
        tableInator();
        frameInator();
    }

    public void panelInator(){
        panel1 = new JPanel();
        panel1.setBounds(10, 10, 200, 150);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createRaisedBevelBorder());
        add(panel1);
        
        panel2 = new JPanel();
        panel2.setBounds(215, 10, 500, 150);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBorder(BorderFactory.createRaisedBevelBorder());
        add(panel2);

        panel3 = new JPanel();
        panel3.setBounds(15, 160, 700, 240);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setBorder(BorderFactory.createRaisedBevelBorder());
        panel3.setVisible(false);
        
        add(panel3);
    }

    public void labelInator(){
        lblPn1 = new JLabel("Seleccione el informe deseado");
        lblPn1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel1.add(lblPn1);         
        
        lblPn2 = new JLabel("Especificaciones del Informe");
        lblPn2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel2.add(lblPn2);

        lblConsulta = new JLabel();
        lblConsulta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        lblConsulta.setFont(new FontUIResource("", Font.ITALIC, 12));
        panel2.add(lblConsulta);
    }

    public void labelConsultaCreador(int numeroInforme){        
        switch(numeroInforme){            
            case 1: 
                lblConsulta.setText("<html>Generar un informe basándose en la tabla con la información espectiva al “Líder”.<br /><br />El listado debe contener: el ID_Lider, el Nombre, el Primer_Apellido y la Ciudad_Residencia.<br /><br /> Este informe debe estar ordenado por la “Ciudad_Residencia” de forma alfabética.");
                break;

            case 2: 
                lblConsulta.setText("<html>Realizar un informe basándose en la información de los proyectos cuya clasificación sea “Casa Campestre” y que estén ubicados en las ciudades de “Santa Marta”, “Cartagena” y “Barranquilla”.<br /><br />Este informe debe contener: el ID_Proyecto, la Constructora, el Nùmero_Habitaciones y la respectiva Ciudad.");
                break;

            case 3: 
                lblConsulta.setText("<html>Realizar un informe basándose en las compras realizadas por los proyectos con el proveedor “Homecenter” y para la ciudad “Salento”.<br /><br />Este informe debe incluir: ID_Compra, Constructora y Banco_Vinculado. ");
                break;
                
            default: lblConsulta.setText("");    
        } 
    }

    public void buttonInator(){
        for (int i = 0; i< arrayButtons.length; i++){
            arrayButtons[i] = new JButton();
            arrayButtons[i].addActionListener(this);
            arrayButtons[i].addMouseListener(this);
            arrayButtons[i].setText("Informe " + (i+1));
            panel1.add(arrayButtons[i]);
            panel1.add(Box.createHorizontalStrut(5)); 
        }
    }
    
    public void tableInator(){
        tabla = new JTable(modelo);
        JTableHeader tablaCabezal = tabla.getTableHeader();
        tablaCabezal.setBackground(new ColorUIResource(50,205,50));
        tablaCabezal.setForeground(Color.black);
        tablaCabezal.setFont(new Font("Dialog", Font.BOLD, 12));
        tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
        tabla.setBackground(Color.BLACK);
        tabla.setGridColor(Color.GREEN);
        tabla.setForeground(Color.GREEN);
        tabla.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
        tabla.addMouseListener(this);
        panel3.add(tabla);
        JScrollPane pane = new JScrollPane(tabla);
        panel3.add(pane);
    }

    public void frameInator(){
        setIconImage(logoUTP.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(740, 440);
        setTitle("PANEL DE CONSULTAS");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void tablaDatosLiderporCiudad(){
        try{
            String [] nombreColumnas = {"ID LIDER" , "NOMBRE" , "APELLIDO" , "CIUDAD"};
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
        panel3.setVisible(true);
    }
    
    public void tablaComprasAProveedores(){
        
        String [] nombreColumnas = {"ID COMPRA" , "CONSTRUCTORA" , "BANCO" };
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
        panel3.setVisible(true);
    }
    
    public void tablaProyectosCaCam(){

        String [] nombreColumnas = {"ID PROYECTO" , "CONSTRUCTORA" , "# HABITACIONES", "CIUDAD"};
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
        panel3.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == arrayButtons[0]){
            tablaDatosLiderporCiudad();
        }
        if(e.getSource() == arrayButtons[1]){
            tablaProyectosCaCam();
        }
        if(e.getSource() == arrayButtons[2]){
            tablaComprasAProveedores();            
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == arrayButtons[0]){
            labelConsultaCreador(1);
            
        }
        if(e.getSource() == arrayButtons[1]){            
            labelConsultaCreador(2);
            
        }
        if(e.getSource() == arrayButtons[2]){            
            labelConsultaCreador(3);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        lblConsulta.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
}
