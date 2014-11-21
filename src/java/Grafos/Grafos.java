package Grafos;

import java.awt.Image;
import java.util.LinkedList;

/**
 * Clase que se encarga de los procesos del grafo.
 * @author Joseph Vega Vargas
 * @author Lucía Solís Ceciliano
 * @author Miller Ruíz Urbina
 */
public class Grafos {
    //Variables Globales
    public LinkedList <NodoPerfil> Perfiles;

    /**
     * Método Constructor de la clase.
     */
    public Grafos(){
        this.Perfiles = new LinkedList<>();
    }

    /**
     * Método que permite agregar un perfil al grafo.
     * @param ID
     * @param Apellido1
     * @param Nombre
     * @param Apellido2
     * @param Carrera
     * @param Telefono
     * @param Direccion
     * @param Email
     * @param Edad
     * @param Contraseña
     * @param Año
     * @param Foto
     */
    public void AgregaPerfil(String ID, String Nombre, String Apellido1, 
            String Apellido2, String Carrera, String Direccion, String Telefono, 
            String Email, String Contraseña, int Edad, int Año, Image Foto){
        
        NodoPerfil Nodo = new NodoPerfil();
        Nodo.setID(ID);
        Nodo.setNombre(Nombre);
        Nodo.setApellido1(Apellido1);
        Nodo.setApellido2(Apellido2);
        Nodo.setCarrera(Carrera);
        Nodo.setDireccion(Direccion);
        Nodo.setTelefono(Telefono);
        Nodo.setEmail(Email);
        Nodo.setContraseña(Contraseña);
        Nodo.setFoto(Foto);
        Nodo.setAño(Año);
        Nodo.setEdad(Edad);
        
        Perfiles.add(Nodo);
    }

    /**
     * Método que permite agregar una relación de amistad al grafo
     * @param ID1
     * @param ID2
     * @param Etiqueta
     */
    public void AgregarAmistad(String ID1, String ID2, String Etiqueta){
        NodoAmistad Nodo1 = new NodoAmistad();
        Nodo1.setEtiqueta(Etiqueta);
        Nodo1.setID(ID2);
        BuscaPerfil(ID1).Aristas.add(Nodo1);
        
        NodoAmistad Nodo2 = new NodoAmistad();
        Nodo2.setEtiqueta(Etiqueta);
        Nodo2.setID(ID1);
        BuscaPerfil(ID2).Aristas.add(Nodo2);
    }

    /**
     * Método que permite eliminar un vértice del grafo.
     * @param ID
     */
    public void EliminarPerfil(String ID){
        this.Perfiles.remove(BuscaPerfil(ID));
        
        //Elimina todas las amistades en las que el perfil eliminado aparezca
        for (NodoPerfil Perfil : Perfiles) {
            EliminarAmistad(Perfil.getID(), ID);
        }
    }

    /**
     * Método para eliminar una amistad de un perfil ID1 a un perfil ID2
     * @param ID1
     * @param ID2
     */
    public void EliminarAmistad(String ID1, String ID2){
        BuscaPerfil(ID1).Aristas.remove(BuscaAmistad(ID1, ID2));
        BuscaPerfil(ID2).Aristas.remove(BuscaAmistad(ID2, ID1));
    }
    
    /**
     * Método para buscar un perfil en la lista de Perfiles del grafo.
     * @param ID
     * @return NodoPerfil
     */
    public NodoPerfil BuscaPerfil(String ID){
        //Recorre la lista de Perfiles
        for (NodoPerfil Perfil : this.Perfiles) {
            if (Perfil.getID().equals(ID)) {
                return Perfil;
            }
        }
        return null;
    }
    
    /**
     * Método que busca una amistada en la lista
     * @param ID1
     * @param ID2
     * @return NodoAmistad
     */
    public NodoAmistad BuscaAmistad(String ID1, String ID2){
        NodoPerfil Temp = BuscaPerfil(ID1);  //Busca el perfil de ID1
        
        //Busca en la lista de aristas de ese perfil para identificar si se 
        //encuentra la amistad buscada.
        for (NodoAmistad Arista : Temp.Aristas) {
            if (Arista.getID().equals(ID2)) {
                return Arista;
            }
        }
        return null;
    }
    
    /**
     * Método para inicializar todos los nodos como no visitados
     */
    public void inicializarVisitados(){
        for (NodoPerfil vertice : this.Perfiles) {
            vertice.setEsVisitado(false);
        }
    }

    /**
     * Método para verificar todos los nodos del grafo
     */
    public boolean IsTodosVisitados(){
        for (NodoPerfil vertice : this.Perfiles) {
            if (!vertice.isEsVisitado()) {
                return false;
            }
        }
        return true;	//Si encuentra uno visitado retorna true
    }
}
