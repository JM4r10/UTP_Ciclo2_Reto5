package reto5.model.vo;

public class InformacionLiderVo {
    private Integer idLider;
    private String nombre;
    private String apellido;
    private String ciudad; 

    public Integer getIdLider() {
        return idLider;
    }
    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    // public String toString(){
    //     return String.format("%d %s %s %s", idLider, nombre, apellido, ciudad);
    // }
}

