/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administradores;

import datos.Persona;
import java.util.LinkedList;
import org.apache.jasper.tagplugins.jstl.ForEach;

public class adminsitradorPrincipal {
    
    LinkedList<Persona> listaPersonas = new LinkedList<Persona>();

    public void insertarUsuario(String rutaFoto, String nombre, String edad, String carrera, String yearCarrera, String direccion, String telefono, String correo) {
        Persona persona = new Persona(nombre, edad, carrera, yearCarrera, direccion, telefono, correo);
        listaPersonas.add(persona);
    }
    
    public boolean personaRepetida(String correo){
        boolean resultado = false;
        int total = listaPersonas.size();
        Persona persona;
        for (int i = 0; i < total; i++){
            persona = listaPersonas.get(i);
            if (persona.getCorreo().equals(correo))
            {
                resultado = true;
                break;
            }
            
        }
        return resultado;
    }

}
