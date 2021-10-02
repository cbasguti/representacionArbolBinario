package arbolBB;
/**
 *
 * @author Sebastián Gutiérrez
 */
public class NodoBinario {
    private NodoBinario hijoIzq;
    private NodoBinario hijoDer;
    private NodoBinario padre;
    private int dato;

    public NodoBinario(int dato){
        this.dato = dato;
        hijoDer = null;
        hijoIzq = null;
        padre = null;
    }

    public void asignaDato(int dato){
        this.dato = dato;
    }
    
    public void asignaPadre(NodoBinario padre){
        this.padre = padre;
    }

    public void asignaLigaIzq(NodoBinario hijoIzq){
        this.hijoIzq = hijoIzq;
    }

    public void asignaLigaDer(NodoBinario hijoDer){
        this.hijoDer = hijoDer;
    }

    public int retornaDato(){
        return dato;
    }
    
    public NodoBinario retornaPadre(){
        return padre;
    }

    public NodoBinario retornaLigaIzq(){
        return hijoIzq;
    }

    public NodoBinario retornaLigaDer(){
        return hijoDer;
    }
}
