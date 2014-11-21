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
    
    
    

    


    //M�todo para buscar el primer v�rtice del grafo que est� sin visitar
    public NodoPerfil buscarVerticeNOVisitado(){

        //Recorre la lista de v�rtices
        for (NodoPerfil vertice : this.Perfiles) {
            if (!vertice.isEsVisitado()) {
                //Si encuentra una no visitado lo retorna
                return vertice;
            }
        }
        return null; //Si todos est�Nodo visitados retorna null
    }

    //M�todo para imprimir el grafo recorriendo la lista de v�rtices y por cada v�rtice imprimiendo la lista de aristas que tiene
    public void imprimeGrafo(){
        NodoPerfil actual;
        for (NodoPerfil vertice : this.Perfiles) {
            actual = vertice;
            System.out.println("Vertice : " + actual.getDato());
            for (NodoAmistad Arista : actual.Aristas) {
                System.out.println("Arista de "+actual.getDato()+ " a " + Arista.getVertice() + " con etiqueta " + Arista.getEtiqueta());
            }
        }
    }

    //M�todo para inicializar todos los nodos como no visitados
    public void inicializarVisitados(){
        for (NodoPerfil vertice : this.Perfiles) {
            vertice.setEsVisitado(false);
        }
    }

    //M�todo para verificar si todos los nodos del grafo est�Nodo visitados
    public boolean todosVisitados(){
        for (NodoPerfil vertice : this.Perfiles) {
            if (!vertice.isEsVisitado()) {
                return false;
            }
        }
        return true;	//Si encuentra uno visitado retorna true
    }

    
    

    //M�todo para realizar el recorrido en profundidad en el grafo
    public void recorridoProfundidad(String inicial){
        inicializarVisitados();  //Inicializa todos los nodos como no visitados
        System.out.println("Recorrido en profundidad");
        DFS(inicial); //Hace la llamada al m�todo que realiza el algoritmo
        System.out.println();
    }

    private void DFS(String inicial){

        NodoPerfil actual = BuscaPerfil(inicial); //Busca el v�rtice inicial para el recorrido en la lista de v�rtices

        while(actual != null)  //Ciclo para verificar que todos los v�rtices est�Nodo visitados
        {
            //Si el nodo inicial no est� visitado
            if(!actual.isEsVisitado()){
                System.out.print(actual.getDato() + " "); //Imprime el v�rtice
                actual.setEsVisitado(true);	//Lo actualiza como visitado
            }

            //Revisa todos los nodos adyacentes del nodo reci�Nodo visitado
            for (NodoAmistad Arista : actual.Aristas) {
                if (!BuscaPerfil(Arista.getVertice()).isEsVisitado()) {
                    DFS(Arista.getVertice()); //Hace la llamada recursiva para realizar el recorrido en el nodo adyacente
                }
            }
            //Verifica si queda alg�Nodo nodo sin visitar
            actual = buscarVerticeNOVisitado();
        }
    }

	//M�todo para recorrer el grafo en anchura
    public void recorridoAnchura(String inicial){

        NodoPerfil actual;
        LinkedList <NodoPerfil> Cola = new LinkedList<>();	//Estructura auxiliar para hacer el recorrido

        inicializarVisitados(); //Inicializa todos los nodos como no visitados

        System.out.println("Recorrido en anchura");
        actual = BuscaPerfil(inicial); //Busca el v�rtice para iniciar el recorrido en la lista de v�rtices del grafo

        //Ciclo para verificar que todos los nodos est�Nodo visitados
        while(actual != null)
        {
            //Si el nodo actual no ha sido visitado
            if(!actual.isEsVisitado()){
                System.out.print(actual.getDato() + " "); //Imprime el v�rtice
                actual.setEsVisitado(true); //Indica que el v�rtice fue visitado
                Cola.add(actual);  //Agrega el v�rtice a la cola(estructura auxiliar)
            }
            //Busca todos los v�rtices adyacentes al v�rtice reci�Nodo visitado
            for(int j = 0; j < actual.Aristas.size(); j++){
                if(! BuscaPerfil(actual.Aristas.get(j).getVertice()).isEsVisitado()){ //Si el v�rtice no se ha visitado aun
                    System.out.print(actual.Aristas.get(j).getVertice() + " ");  //Se imprime el v�rtice
                    Cola.add(BuscaPerfil(actual.Aristas.get(j).getVertice()));    //Se agrega el v�rtice a la cola
                    BuscaPerfil(actual.Aristas.get(j).getVertice()).setEsVisitado(true);  //Se indica que el v�rtice ha sido visitado
                }
            }

            //Mientras la cola no est� vac�a
            while(Cola.size() > 0)
            {
                NodoPerfil temp1;

                for(int x = 0; x < Cola.getFirst().Aristas.size(); x++){
                    //Obtiene el primer v�rtice en la cola
                    temp1 = BuscaPerfil(Cola.getFirst().Aristas.get(x).getVertice());
                    if(!temp1.isEsVisitado()){  //Verifica si el primero de la cola no ha sido visitado
                        System.out.print(temp1.getDato() + " "); //Imprime el v�rtice
                        temp1.setEsVisitado(true);	//Indica que el v�rtice se ha visitado
                        Cola.add(temp1);	//Agrega el v�rtice al final de la cola
                    }
                }
                //Elimina el primer v�rtice de la cola
                Cola.removeFirst();
            }
            actual = buscarVerticeNOVisitado();//Verifica si aun quedan v�rtices sin visitar
        }
        System.out.println();
    }
}
