/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

public class Persona {

    private String nombre;
    private String edad;
    private String carrera;
    private String anoCarrera;
    private String direccion;
    private String telefono;
    private String correo;
    private String rutaFoto;

    public Persona(String nombre, String edad, String carrera, String anoCarrera, String direccion, String telefono, String correo, String rutaFoto) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.anoCarrera = anoCarrera;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.rutaFoto = rutaFoto;
    }



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getAnoCarrera() {
        return anoCarrera;
    }

    public void setAnoCarrera(String anoCarrera) {
        this.anoCarrera = anoCarrera;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

}
