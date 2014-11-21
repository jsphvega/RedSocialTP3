package Grafos;

import java.awt.Image;
import java.util.ArrayList;
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
    public int TamañoPerfil = 0;

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
     */
    public void AgregarAmistad(String ID1, String ID2){
        NodoAmistad Nodo1 = new NodoAmistad();
        Nodo1.setID(ID2);
        this.Perfiles.get(BuscaPosPerfil(ID1)+1).Relaciones.add(Nodo1);
        
        NodoAmistad Nodo2 = new NodoAmistad();
        Nodo2.setID(ID1);
        this.Perfiles.get(BuscaPosPerfil(ID2)+1).Relaciones.add(Nodo2);
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
        BuscaPerfil(ID1).Relaciones.remove(BuscaAmistad(ID1, ID2));
        BuscaPerfil(ID2).Relaciones.remove(BuscaAmistad(ID2, ID1));
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
     * Método para buscar un perfil en la lista de Perfiles del grafo.
     * @param ID
     * @return NodoPerfil
     */
    public int BuscaPosPerfil(String ID){
        int Cont = -1;
        //Recorre la lista de Perfiles
        for (NodoPerfil Perfil : this.Perfiles) {
            if (Perfil.getID().equals(ID)) {
                return Cont++;
            }
            Cont++;
        }
        return -1;
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
        for (NodoAmistad Arista : Temp.Relaciones) {
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
     * @return 
     */
    public boolean IsTodosVisitados(){
        for (NodoPerfil vertice : this.Perfiles) {
            if (!vertice.isEsVisitado()) {
                return false;
            }
        }
        return true;	//Si encuentra uno visitado retorna true
    }
    
    /**
     * Algoritmo que determina el camino mas corto utilizando dijkstra.
     * @param ID1
     * @param ID2
     * @return Recorrido mas corto
     */
    public ArrayList<NodoPerfil> dijkstra(NodoPerfil ID1, NodoPerfil ID2){
        //Variables Locales
        Queue ListaRecorrido = new Queue();
        NodoPerfil tDestino = null;
        NodoPerfil nodoDestino = null;
        
        //Se le establece la distancia como 0. Se implementa una cola.
        inicializarVisitados();
        ID1.setDistancia(0);
        ListaRecorrido.add(ID1);

        //Contador para comparar visitados. 
        int cont = ID1.TamañoRelaciones + 1;

        //Iteracion hasta que la cola quede vacia
        while (!ListaRecorrido.isEmpty()){

            int cont2 = 0;
            NodoPerfil nodoTemp;

            //Bucle para asignar los visitados y comparacion
            for(NodoPerfil nodoVist : Perfiles){
                if(nodoVist.isEsVisitado() == true){
                    cont2 ++;
                }
            }
            if(cont2 == cont){
                return null;
            }

            nodoTemp = ListaRecorrido.poll();

            //Lista para cada relacion entre amigos
            LinkedList<NodoAmistad> lista = nodoTemp.Relaciones;

            //Analiza cada nodo con su peso y los pesos de la lista de adyacencia
            //Ademas suma o actualiza si es necesario
            for (NodoAmistad relaciones : lista){

                nodoDestino = new NodoPerfil();
                int distT = nodoTemp.getDistancia();

                if (distT < nodoDestino.getDistancia()){

                    // Actualiza el nodo que sigue y se establece el antecesor
                    ListaRecorrido.remove(nodoDestino);
                    nodoDestino.setDistancia(distT);
                    nodoDestino.setAnterior(nodoTemp);
                    ListaRecorrido.add(nodoDestino);
                }
            }

            //Comparacion que identifica si es el nodo que se busca
            try{
                if(ID2.getID().equals(nodoDestino.getID())){
                    tDestino = nodoDestino;
                break;
                }
            } catch (Exception e){}
        

            // Marca como visitado el nodo
            NodoPerfil nodoVisi = BuscaPerfil(nodoTemp.getID());
            nodoVisi.setEsVisitado(true);
      }

      return getShortPath(tDestino);
    }
    
    /**
    * Algoritmo que determina el camino mas corto utilizando dijkstra
    * @param target Nodo buscado
    * @return Lista del camino
    */
    private ArrayList<NodoPerfil> getShortPath(NodoPerfil target){

        ArrayList<NodoPerfil> path = new ArrayList<>();
        // Itera los nodos antecesores hasta llegar a nulo, encontrando el camino corto

        for (NodoPerfil vertex = target; vertex != null; vertex = vertex.getAnterior()){
            path.add(vertex);
        }


        // Se le da vuelta para mostrar el camino correcto
        //Collections.reverse(path);
        return path;
    }
}
