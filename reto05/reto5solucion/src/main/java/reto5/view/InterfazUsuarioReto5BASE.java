package reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import reto5.controller.InformesController;
import reto5.model.vo.ComprasProveedoresVo;
import reto5.model.vo.InformacionLiderVo;
import reto5.model.vo.ProyectosCasaCampestreVo;

public class InterfazUsuarioReto5BASE extends JFrame implements ActionListener{
    private InformesController controller;
    private JButton btnquery1,btnquery2,btnquery3;
    // private JPanel panel1, panel2;
    

    public InterfazUsuarioReto5BASE(){
        controller = new InformesController();
        
        
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

        btnquery1 = new JButton();
        btnquery1.addActionListener(this);
        btnquery1.setText("Problema 1");
        btnquery1.setBounds(20, 50, 100, 30);
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
        
        // this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(150, 200);
        // this.setBounds(0, 0, 500, 500); 
        this.setTitle("PANEL DE CONSULTAS");
        this.setVisible(true);
        
        
    }
    
    public JTable tablaDatosLiderporCiudad(){
        String [] nombreColumnas = {"ID_LIDER" , "NOMBRE" , "APELLIDO" , "CIUDAD"};
        Object [][] datos = {};
        DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumnas);
        JTable tablaLiderCiudad = new JTable(modelo);
        
        
        try{
            List<InformacionLiderVo> ListaDatosLider = controller.informeDatosLider();
            for (InformacionLiderVo i:ListaDatosLider){
                ArrayList<Object> filaNueva = new ArrayList<Object>();
                filaNueva.add(i.getIdLider());
                filaNueva.add(i.getNombre());
                filaNueva.add(i.getApellido());
                filaNueva.add(i.getCiudad());
                modelo.addRow(filaNueva.toArray());
                
            }
            // tablaLiderCiudad.setPreferredScrollableViewportSize(new Dimension(250, 100));
            // tablaLiderCiudad.setFont(new Font("Andalé Mono", Font.PLAIN, 20));
            // add(tablaLiderCiudad);
            
        }
        catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
        return tablaLiderCiudad;

    }
    
    public JTable tablaComprasAProveedores(){
        String [] nombreColumnas = {"ID_COMPRA" , "CONSTRUCTORA" , "BANCO" };
        Object [][] datos = {};
        DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumnas);
        JTable tablaComprasProveedores = new JTable(modelo);
        

        try{
            List<ComprasProveedoresVo> ListaComprasProveedores = controller.informeComprasProveedor();
            for (ComprasProveedoresVo i:ListaComprasProveedores){
                ArrayList<Object> filaNueva = new ArrayList<Object>();
                filaNueva.add(i.getIdCompra());
                filaNueva.add(i.getConstructora());
                filaNueva.add(i.getBanco());
                modelo.addRow(filaNueva.toArray());
                
            }
            // tablaComprasProveedores.setPreferredScrollableViewportSize(new Dimension(250, 100));
            // tablaComprasProveedores.setBackground(Color.BLACK);
            // tablaComprasProveedores.setGridColor(Color.GREEN);
            // tablaComprasProveedores.setForeground(Color.GREEN);
            // tablaComprasProveedores.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
            
        }
        catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
        return tablaComprasProveedores;

    }
    
    public JTable tablaProyectosCaCam(){
        String [] nombreColumnas = {"ID_PROYECTO" , "CONSTRUCTORA" , "NUMERO HABITACIONES", "CIUDAD"};
        Object [][] datos = {};
        DefaultTableModel modelo = new DefaultTableModel(datos, nombreColumnas);
        JTable tablaProyectosCampestres = new JTable(modelo);
        
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
            // tablaProyectosCampestres.setPreferredScrollableViewportSize(new Dimension(250, 100));
            // add(tablaLiderCiudad);
            
        }
        catch(Exception e){
            System.out.println("Error "+ e.getMessage());
        }
        return tablaProyectosCampestres;

    }

    private void displayRespuesta(JTable tablaSolicitada){
        JFrame displayPublico = new JFrame();
        
        
        displayPublico.setTitle("RESULTADOS DE LA BUSQUEDA");
        displayPublico.setVisible(true);
        
        
        
        JScrollPane scrollPanel = new JScrollPane(tablaSolicitada);
        tablaSolicitada.setPreferredScrollableViewportSize(new Dimension(500, 100));
        displayPublico.getContentPane().setBackground(Color.BLACK); 
        displayPublico.add(scrollPanel);
        displayPublico.pack();
        // JPanel panelTabla = new JPanel();
        // displayPublico.add(panelTabla);
        // panelTabla.add(tablaSolicitada);
        // panelTabla.setBounds(0, 0, 500, 200);
        // tablaSolicitada.setBounds(0, 0, 500, 200);
        // displayPublico.setResizable(true);
        // displayPublico.setSize(420, 420);
        // panelTabla.setBackground(Color.BLACK); 
        // tablaSolicitada.setBackground(Color.BLACK);
        // tablaSolicitada.setGridColor(Color.GREEN);
        // tablaSolicitada.setForeground(Color.GREEN);
        // tablaSolicitada.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 12));
        // displayPublico.setBounds(200, 200, 500, 500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JTable mostrarResultados = tablaDatosLiderporCiudad();
        if(e.getSource() == btnquery1){
            displayRespuesta(tablaDatosLiderporCiudad());
            btnquery1.setEnabled(false);
            
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
            displayRespuesta(tablaComprasAProveedores());
            btnquery2.setEnabled(false);
        }
        if(e.getSource() == btnquery3){
            displayRespuesta(tablaProyectosCaCam());
            btnquery3.setEnabled(false);
        }
    }
    
}
