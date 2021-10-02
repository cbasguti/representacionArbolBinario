package arbolBB;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Sebastián Gutiérrez
 */

public class ArbolBB {

    private NodoBinario raiz;
    int num_nodos;
    int alt;
    private List<String> recorrido;
    private List<String> hojas;

    public ArbolBB() {
        raiz = null;
        recorrido = new ArrayList<>();
        hojas = new ArrayList<>();
    }
    // Metodo para insertar un dato en el arbol
    public void agregaRegistro(int x){
        NodoBinario nuevo, p, q;
        nuevo = new NodoBinario(x);
        if (raiz == null){
            raiz = nuevo;
        }
        else{
            q = null;
            p = raiz;
            while(p != null){
                if(x > p.retornaDato()){
                    q = p;
                    p = p.retornaLigaDer();
                }
                else{
                    q = p;
                    p = p.retornaLigaIzq();
                }
            }
            if(x > q.retornaDato()){
                q.asignaLigaDer(nuevo);
            }
            else{
                q.asignaLigaIzq(nuevo);
            }
            nuevo.asignaPadre(q);
        }
    }

    public NodoBinario getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoBinario raiz) {
        this.raiz = raiz;
    }
    
    public void recorreInorden(NodoBinario r){
        if(r != null){
            recorreInorden(r.retornaLigaIzq());
            recorrido.add(String.valueOf(r.retornaDato()));
            recorreInorden(r.retornaLigaDer());
        }
    }
    
    public void recorrePosorden(NodoBinario r){
        if(r != null){
            recorrePosorden(r.retornaLigaIzq());
            recorrePosorden(r.retornaLigaDer());
            recorrido.add(String.valueOf(r.retornaDato()));
        }
    }
    
    public void recorrePreorden(NodoBinario r){
        if(r != null){
            recorrido.add(String.valueOf(r.retornaDato()));
            recorrePreorden(r.retornaLigaIzq());
            recorrePreorden(r.retornaLigaDer());
        }
    }

    public int gradoNodo(NodoBinario x){
        int grado;
        grado = 0;
        if(x.retornaLigaDer() != null){
            grado++;
        }
        if(x.retornaLigaIzq() != null){
            grado++;
        }
        return grado;
    }
    
    public NodoBinario buscaNodo(String nodo){
        int dato = 0;
        try{
            dato = Integer.parseInt(nodo);
        }
        catch (NumberFormatException ex){
        }
        NodoBinario p;
        p = raiz;
        while(p != null){
            if(dato == p.retornaDato()){
                return p;
            }
            else if(dato > p.retornaDato()){
                p = p.retornaLigaDer();
            }
            else{
                p = p.retornaLigaIzq();
            }
        }
        return null;
    }
    
    public List<String> ancestrosNodo(NodoBinario x){
        List<String> ancestros = new ArrayList<>();
        NodoBinario p;
        p = x.retornaPadre();
        while(p != null){
            String datoNodo = String.valueOf(p.retornaDato());
            ancestros.add(datoNodo);
            p = p.retornaPadre();
        }
        return ancestros;
    }
    
    public int hojasArbol(NodoBinario r){
        int contador;
        contador = 0;
        if(r != null){
            if((r.retornaLigaDer() == null) && (r.retornaLigaIzq() == null)){
                hojas.add(String.valueOf(r.retornaDato()));
                return 1;
            }
            contador = contador + hojasArbol(r.retornaLigaIzq());
            contador = contador + hojasArbol(r.retornaLigaDer());
        }
        return contador;
    }

    public int gradoArbol(NodoBinario r){
        int contador, aux;
        contador = 0;
        if(r != null){
            if((r.retornaLigaDer() == null) && (r.retornaLigaIzq() != null)){
                contador = 1;
                return contador;
            }
            if((r.retornaLigaDer() != null) && (r.retornaLigaIzq() == null)){
                contador = 1;
                return contador;
            }
            if((r.retornaLigaDer() != null) && (r.retornaLigaIzq() != null)){
                contador = 2;
                return contador;
            }
            contador = gradoArbol(r.retornaLigaIzq());
            aux = gradoArbol(r.retornaLigaDer());
            if(aux > contador){
                contador = aux;
            }
        }
        return contador;

    }

    public int alturaArbol(NodoBinario r){
        if (r == null)
            return 0;
        else
        {
            int alturaIzq = alturaArbol(r.retornaLigaIzq());
            int alturaDer = alturaArbol(r.retornaLigaDer());
  
            if (alturaIzq > alturaDer)
                return (alturaIzq + 1);
             else
                return (alturaDer + 1);
        }
    }

    // Metodo para verificar si existe un nodo en el árbol
    public boolean existe(int dato) {
        NodoBinario aux = raiz;
        while (aux != null) {
            if (dato == aux.retornaDato()) {
                return true;
            } else if (dato > aux.retornaDato()) {
                aux = aux.retornaLigaDer();
            } else {
                aux = aux.retornaLigaIzq();
            }
        }
        return false;
    }
    
    public void borraRecorrido(){
        recorrido.clear();
    }
    
    public List<String> retornaRecorrido(){
        return recorrido;
    }
    
    public List<String> retornaHojas(){
        return hojas;
    }
    
     public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
