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
     * Método para agregar una relación de amistad al grafo
     * @param ID1
     * @param ID2
     * @param Etiqueta
     */
    public void AgregarAmistad(String ID1, String ID2, String Etiqueta){
        NodoAmistad Nodo1 = new NodoAmistad();
        Nodo1.setEtiqueta(Etiqueta);
        Nodo1.setID(ID2);
        buscarVertice(ID1).Aristas.add(Nodo1);
        
        NodoAmistad Nodo2 = new NodoAmistad();
        Nodo2.setEtiqueta(Etiqueta);
        Nodo2.setID(ID1);
        buscarVertice(ID2).Aristas.add(Nodo2);
    }

    //M�todo para buscar un v�rtice en la lista de Perfiles del grafo seg�Nodo el dato indicado
    public NodoPerfil buscarVertice(String v){
        //Recorre la lista de Perfiles
        for (NodoPerfil vertice : this.Perfiles) {
            if (vertice.getDato().equals(v)) {
                return vertice;
            }
        }
        return null;
    }

    //M�todo para buscar una arista en la lista de aristas
    public NodoAmistad buscarArista(String origen, String destino){
        NodoPerfil temp = buscarVertice(origen);  //Busca el v�rtice de origen
        //Busca en la lista de aristas de ese v�rtice para identificar si se encuentra la arista buscada
        for (NodoAmistad Arista : temp.Aristas) {
            if (Arista.getVertice().equals(destino)) {
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

    //M�todo para eliminar un v�rtice del grafo
    public void eliminarVertice(String v){
        this.Perfiles.remove(buscarVertice(v));  //Elimina el v�rtice de la lista de v�rtices
        //Elimina todas las aristas en las que el v�rtice eliminado aparezca como destino
        for (NodoPerfil vertice : Perfiles) {
            eliminarArista(vertice.getDato(), v);
        }
    }

    //M�todo para eliminar una arista de un v�rtice origen a un v�rtice destino dado
    public void eliminarArista(String origen, String destino){
        //Verifica si el grafo es no dirigido
        if((buscarArista(origen,destino) != null) && (buscarArista(destino,origen) != null)){ //Busca si existe arista de origen a destino y viceversa
            //Verifica si el peso de ambas aristas es igual con lo que se asume que es un grafo no dirigido
            if(buscarArista(origen,destino).getEtiqueta().equals(buscarArista(destino,origen).getEtiqueta())){
                    buscarVertice(destino).Aristas.remove(buscarArista(destino, origen));
            }
        }
        //Elimina el arista de la lista de aristas del v�rtice origen
        buscarVertice(origen).Aristas.remove(buscarArista(origen, destino));

    }

    //M�todo para realizar el recorrido en profundidad en el grafo
    public void recorridoProfundidad(String inicial){
        inicializarVisitados();  //Inicializa todos los nodos como no visitados
        System.out.println("Recorrido en profundidad");
        DFS(inicial); //Hace la llamada al m�todo que realiza el algoritmo
        System.out.println();
    }

    private void DFS(String inicial){

        NodoPerfil actual = buscarVertice(inicial); //Busca el v�rtice inicial para el recorrido en la lista de v�rtices

        while(actual != null)  //Ciclo para verificar que todos los v�rtices est�Nodo visitados
        {
            //Si el nodo inicial no est� visitado
            if(!actual.isEsVisitado()){
                System.out.print(actual.getDato() + " "); //Imprime el v�rtice
                actual.setEsVisitado(true);	//Lo actualiza como visitado
            }

            //Revisa todos los nodos adyacentes del nodo reci�Nodo visitado
            for (NodoAmistad Arista : actual.Aristas) {
                if (!buscarVertice(Arista.getVertice()).isEsVisitado()) {
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
        actual = buscarVertice(inicial); //Busca el v�rtice para iniciar el recorrido en la lista de v�rtices del grafo

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
                if(! buscarVertice(actual.Aristas.get(j).getVertice()).isEsVisitado()){ //Si el v�rtice no se ha visitado aun
                    System.out.print(actual.Aristas.get(j).getVertice() + " ");  //Se imprime el v�rtice
                    Cola.add(buscarVertice(actual.Aristas.get(j).getVertice()));    //Se agrega el v�rtice a la cola
                    buscarVertice(actual.Aristas.get(j).getVertice()).setEsVisitado(true);  //Se indica que el v�rtice ha sido visitado
                }
            }

            //Mientras la cola no est� vac�a
            while(Cola.size() > 0)
            {
                NodoPerfil temp1;

                for(int x = 0; x < Cola.getFirst().Aristas.size(); x++){
                    //Obtiene el primer v�rtice en la cola
                    temp1 = buscarVertice(Cola.getFirst().Aristas.get(x).getVertice());
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
