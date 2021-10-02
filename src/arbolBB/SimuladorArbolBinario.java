
package arbolBB;

import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author Sebastián Gutiérrez
 */
public class SimuladorArbolBinario {

    ArbolBB miArbol = new ArbolBB();

    public SimuladorArbolBinario() {
    }

    public boolean insertar(Integer dato) {
        this.miArbol.agregaRegistro(dato);
        return true;
    }
    
    
    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.miArbol.existe(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

    public JPanel getDibujo() {
        return this.miArbol.getdibujo();
    }
}
