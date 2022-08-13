package reto5.controller;

import java.sql.SQLException;
import java.util.List;

import reto5.model.dao.ComprasProveedoresDao;
import reto5.model.dao.InformacionLiderDao;
import reto5.model.dao.ProyectosCasaCampestreDao;
import reto5.model.vo.ComprasProveedoresVo;
import reto5.model.vo.InformacionLiderVo;
import reto5.model.vo.ProyectosCasaCampestreVo;

public class InformesController {
    InformacionLiderDao informacionLiderporCiudad = new InformacionLiderDao();
    ComprasProveedoresDao comprasPorProveedores = new ComprasProveedoresDao();
    ProyectosCasaCampestreDao casasCampestresPorCiudades = new ProyectosCasaCampestreDao(); 

    public List<InformacionLiderVo> informeDatosLider() throws SQLException{
        return informacionLiderporCiudad.listar();
    }

    public List<ComprasProveedoresVo> informeComprasProveedor() throws SQLException{
        return comprasPorProveedores.listar();
    }
    
    public List<ProyectosCasaCampestreVo> informeCasasCampestres() throws SQLException{
        return casasCampestresPorCiudades.listar();
    }
}
