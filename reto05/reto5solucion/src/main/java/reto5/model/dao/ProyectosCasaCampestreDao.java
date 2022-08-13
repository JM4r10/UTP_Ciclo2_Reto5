package reto5.model.dao;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.ProyectosCasaCampestreVo;
import reto5.util.JDBCUtilities;


public class ProyectosCasaCampestreDao {
    public List<ProyectosCasaCampestreVo> listar() throws SQLException{
        ArrayList<ProyectosCasaCampestreVo> respuesta = new ArrayList<ProyectosCasaCampestreVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select ID_Proyecto , Constructora , Numero_Habitaciones , Ciudad from Proyecto p where Clasificacion is 'Casa Campestre' and Ciudad in ('Santa Marta', 'Cartagena' , 'Barranquilla')";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ProyectosCasaCampestreVo vo = new ProyectosCasaCampestreVo();
                vo.setIdProyecto(rs.getInt("ID_Proyecto"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setHabitaciones(rs.getInt("Numero_Habitaciones"));
                vo.setCiudad(rs.getString("Ciudad"));
                respuesta.add(vo);
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}
