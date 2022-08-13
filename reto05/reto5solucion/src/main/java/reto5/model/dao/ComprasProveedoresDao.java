package reto5.model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.ComprasProveedoresVo;
import reto5.util.JDBCUtilities;

public class ComprasProveedoresDao {
    
    public List<ComprasProveedoresVo> listar() throws SQLException{
        ArrayList<ComprasProveedoresVo> respuesta = new ArrayList<ComprasProveedoresVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "select c.ID_Compra , p.Constructora , p.Banco_Vinculado from Proyecto p  inner join Compra c on p.ID_Proyecto = c.ID_Proyecto where p.Ciudad = 'Salento' and c.Proveedor = 'Homecenter'";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ComprasProveedoresVo vo = new ComprasProveedoresVo();
                vo.setIdCompra(rs.getInt("ID_Compra"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setBanco(rs.getString("Banco_Vinculado"));
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
