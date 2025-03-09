/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.buscaminas.simón.ananian.y.juan.maldifassi;

/**
 *
 * @author enith
 */
public class Vertice {
    private String columna;
    private int fila;
    private Lista listaAdy;
    private boolean mina;
    private boolean marcar;
    private boolean barrida;
    private String contenido;

    public Vertice(String columna, int fila) {
        this.columna = columna;
        this.fila = fila;
        this.listaAdy = new Lista();
        this.mina = false;
        this.marcar = false;
        this.contenido = "";
        this.barrida = false;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public Lista getListaAdy() {
        return listaAdy;
    }

    public void setListaAdy(Lista listaAdy) {
        this.listaAdy = listaAdy;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isMarcar() {
        return marcar;
    }

    public void setMarcar(boolean marcar) {
        this.marcar = marcar;
    }
    
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public boolean isBarrida() {
        return barrida;
    }

    public void setBarrida(boolean barrida) {
        this.barrida = barrida;
    }
    
    public String getNombre(){
        return this.columna + this.fila;
    }
    
    public boolean buscarAdy(String nombre){
        boolean encontrado = false;
        Nodo aux = this.listaAdy.getpFirst();
        while(aux != null){
            Vertice verticeActual = (Vertice) aux.getDato();
            if(verticeActual.getNombre().equalsIgnoreCase(nombre)){
                encontrado = true;
                break;
            }
            aux = aux.getpNext();
        }
        return encontrado;
    }
    
    public void agregarAdy(Vertice vertice){
        if(!this.buscarAdy(vertice.getNombre())){
            this.listaAdy.insertarFinal(vertice); 
        }
    }
    
    public String minasAdy(){
        int count = 0;
        Nodo aux = this.listaAdy.getpFirst();
        while(aux != null){
            Vertice verticeActual = (Vertice) aux.getDato();
            if(verticeActual.isMina()){
                count++;
            }
            aux = aux.getpNext();
        }
        return String.valueOf(count);
    }
    
    public String adycentesStr(){
        if (!this.listaAdy.isEmpty()) {
            Nodo aux = this.listaAdy.getpFirst();
            String adyacentesStr = "";
            while (aux != null) {
                Vertice verticeActual = (Vertice) aux.getDato();
                adyacentesStr += verticeActual.getNombre() + " ---> ";

                aux = aux.getpNext();
            }
            return adyacentesStr;
        }

        return "No tiene adyacentes";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(this.getNombre());
        sb.append(", listaAdy: ").append(this.adycentesStr());
        sb.append(", mina: ").append(mina);
        sb.append(", marcar: ").append(marcar);
        sb.append(", contenido: ").append(contenido);
        sb.append('}');
        return sb.toString();
    }
}
