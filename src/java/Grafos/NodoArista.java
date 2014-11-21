package Grafos;

/**
 * Clase que se encarga de almacenar los datos de las aristas en nodos.
 * @author Joseph Vega Vargas
 * @author Lucía Solís Ceciliano
 * @author Miller Ruíz Urbina
 */
public class NodoArista {
    //Variables Globales
    private String Etiqueta;
    private String ID;

    /**
     * Método que se encarga de obtener la etiqueta.
     * @return String Etiqueta
     */
    public String getEtiqueta() {
        return Etiqueta;
    }

    /**
     * Método que se encarga de obtener el ID.
     * @return String ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Método que se encarga de editar la etiqueta.
     * @param ID.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Método que se encarga de editar el ID.
     * @param Etiqueta
     */
    public void setEtiqueta(String Etiqueta) {
        this.Etiqueta = Etiqueta;
    }
}
