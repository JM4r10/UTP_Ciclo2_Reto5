package reto5.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import reto5.model.vo.InformacionLiderVo;
import reto5.util.JDBCUtilities;

public class InformacionLiderDao {
    public List<InformacionLiderVo> listar() throws SQLException{
        ArrayList<InformacionLiderVo> respuesta = new ArrayList<InformacionLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select ID_Lider , Nombre , Primer_Apellido , Ciudad_Residencia from Lider l order by Ciudad_Residencia;";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                InformacionLiderVo vo = new InformacionLiderVo();
                vo.setIdLider(rs.getInt("ID_Lider"));
                vo.setNombre(rs.getString("Nombre"));
                vo.setApellido(rs.getString("Primer_Apellido"));
                vo.setCiudad(rs.getString("Ciudad_Residencia"));
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
    
    
    // public static void main(String[] args) throws Exception{
    //     var x = listar();    
    //     System.out.println(x.size());
                
    // }
}