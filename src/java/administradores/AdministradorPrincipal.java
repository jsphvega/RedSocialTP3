/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administradores;

import datos.Persona;
import java.util.LinkedList;

public class AdministradorPrincipal {

    private LinkedList<Persona> listaPersonas = new LinkedList<Persona>();

    private static AdministradorPrincipal INSTANCE = null;

    public static AdministradorPrincipal getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized (AdministradorPrincipal.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) {
                    INSTANCE = new AdministradorPrincipal();
                }
            }
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void insertarUsuario(String nombre, String edad, String carrera, String yearCarrera, String direccion, String telefono, String correo, String rutaFoto) {
        Persona persona = new Persona(nombre, edad, carrera, yearCarrera, direccion, telefono, correo, rutaFoto);
        listaPersonas.add(persona);
    }

    public Persona getPersona(String correo) {
        Persona resultado = null;
        int total = listaPersonas.size();
        Persona persona;
        for (int i = 0; i < total; i++) {
            persona = listaPersonas.get(i);
            if (persona.getCorreo().equals(correo)) {
                resultado = persona;
                break;
            }

        }
        return resultado;
    }

    public boolean existePersona(String correo) {
        boolean resultado = false;
        int total = listaPersonas.size();
        Persona persona;
        for (int i = 0; i < total; i++) {
            persona = listaPersonas.get(i);
            if (((persona.getCorreo()).toLowerCase()).equals(correo.toLowerCase())) {
                resultado = true;
                break;
            }

        }
        return resultado;
    }

}
