
package ejerciciomoriajava;

/**
 *
 * @author Andrés
 */
public class Elfo extends Personajes{
    private int flechas=20;

    public int getCarcaj() {
        return flechas;
    }

    public void recargarCarcaj(int flechas) {
        this.flechas = flechas;
    }
    
    public void lanzarFlecha(){
        this.flechas--;
    }
    
    
}
