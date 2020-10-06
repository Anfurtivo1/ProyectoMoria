
package ejerciciomoriajava;

/**
 *
 * @author Andrés
 */
public class Mago extends Personajes{
    private int poderVara=30;

    public int PoderVara() {
        return poderVara;
    }

    public void recargarVara(int sumarPoder) {
        this.poderVara = sumarPoder;
    }
    
    
    
}
