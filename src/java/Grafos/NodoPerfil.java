package Grafos;

import java.awt.Image;
import java.util.LinkedList;

/**
 * Clase que se encarga de almacenar los datos de los perfiles en nodos.
 * @author Joseph Vega Vargas
 * @author Lucía Solís Ceciliano
 * @author Miller Ruíz Urbina
 */
public class NodoPerfil {
    //Variables Globales
    private boolean EsVisitado;
    public LinkedList <NodoAmistad> Relaciones;
    public int TamañoRelaciones, Distancia;
    public NodoPerfil Anterior;
    
    private String ID, Nombre, Apellido1, Apellido2, Carrera, Direccion, 
            Telefono, Email, Contraseña;
    private int Edad, Año;
    private Image Foto; 

    /**
     * Método constructor.
     */
    public NodoPerfil(){
        this.EsVisitado = false;
        this.Relaciones  = new LinkedList<>();
    }

    /**
     * Método que permite obtener si es visitado.
     * @return boolean EsVisitado.
     */
    public boolean isEsVisitado() {
        return EsVisitado;
    }

    /**
     * Método que permite editar si es visitado.
     * @param EsVisitado.
     */
    public void setEsVisitado(boolean EsVisitado) {
        this.EsVisitado = EsVisitado;
    }
    
    /**
     * Método que permite obtener el ID.
     * @return String ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * Método que permite editar el ID.
     * @param ID.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Método que permite obtener el Nombre.
     * @return String Nombre.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Método que permite editar el Nombre.
     * @param Nombre.
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Método que permite obtener el Apellido 1.
     * @return String Apellido1.
     */
    public String getApellido1() {
        return Apellido1;
    }

    /**
     * Método que permite editar el Apellido 1.
     * @param Apellido1.
     */
    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    /**
     * Método que permite obtener el Apellido 2.
     * @return String Apellido2.
     */
    public String getApellido2() {
        return Apellido2;
    }

    /**
     * Método que permite editar el Apellido 2.
     * @param Apellido2.
     */
    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    /**
     * Método que permite obtener la carrera.
     * @return String Carrera.
     */
    public String getCarrera() {
        return Carrera;
    }

    /**
     * Método que permite editar la carrera.
     * @param Carrera.
     */
    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    /**
     * Método que permite obtener la direccion.
     * @return String Direccion.
     */
    public String getDireccion() {
        return Direccion;
    }

    /**
     * Método que permite editar la direccion.
     * @param Direccion.
     */
    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    /**
     * Método que permite obtener el telefono.
     * @return String Telefono.
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * Método que permite editar el telefono.
     * @param Telefono.
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * Método que permite obtener el Email.
     * @return String Email.
     */
    public String getEmail() {
        return Email;
    }

    /**
     * Método que permite editar el Email.
     * @param Email.
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * Método que permite obtener la edad.
     * @return int edad.
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * Método que permite editar la edad.
     * @param Edad.
     */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    /**
     * Método que permite obtener el año.
     * @return int año.
     */
    public int getAño() {
        return Año;
    }

    /**
     * Método que permite editar el año.
     * @param Año.
     */
    public void setAño(int Año) {
        this.Año = Año;
    }

    /**
     * Método que permite obtener la foto.
     * @return Image Foto.
     */
    public Image getFoto() {
        return Foto;
    }

    /**
     * Método que permite editar la foto.
     * @param Foto
     */
    public void setFoto(Image Foto) {
        this.Foto = Foto;
    }
    
    /**
     * Método que permite obtener la contraseña.
     * @return String Contraseña.
     */
    public String getContraseña() {
        return Contraseña;
    }

    /**
     * Método que permite editar la contraseña.
     * @param Contraseña.
     */
    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    /**
     * Método que permite editar la distancia.
     * @return int Distancia.
     */
    public int getDistancia() {
        return Distancia;
    }

    /**
     * Método que permite editar la distancia.
     * @param Distancia
     */
    public void setDistancia(int Distancia) {
        this.Distancia = Distancia;
    }

    /**
     * Método que permite obtener el nodo anterior.
     * @return NodoPerfil Anterior.
     */
    public NodoPerfil getAnterior() {
        return Anterior;
    }

    /**
     * Método que permite editar el nodo anterior.
     * @param Anterior
     */
    public void setAnterior(NodoPerfil Anterior) {
        this.Anterior = Anterior;
    }
}
