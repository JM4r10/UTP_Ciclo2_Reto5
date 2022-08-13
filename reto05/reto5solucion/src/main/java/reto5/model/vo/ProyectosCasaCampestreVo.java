package reto5.model.vo;

public class ProyectosCasaCampestreVo {
    private Integer idProyecto;
    private String constructora;
    private Integer habitaciones;
    private String ciudad;

    public Integer getIdProyecto() {
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public Integer getHabitaciones() {
        return habitaciones;
    }
    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

//     public static void main(String[] args) throws Exception {
//         ProyectosCasaCampestreVo a = new ProyectosCasaCampestreVo();
//         System.out.println(a.getHabitaciones().getClass());
//         a.setHabitaciones(1);
//         System.out.println(a.getHabitaciones().getClass());
//     } 
}
