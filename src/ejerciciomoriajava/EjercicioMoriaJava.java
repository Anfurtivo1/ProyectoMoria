
package ejerciciomoriajava;

import static ejerciciomoriajava.TipoSala.*;

/**
 *
 * @author Andrés
 */
public class EjercicioMoriaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mago gandalf= new Mago();
        Elfo legolas = new Elfo();
        Hobbit frodo = new Hobbit();
        Salas moria[] = new Salas[37];
        Salas sala;
        
        
        
        for (int i = 0; i < moria.length; i++) {
            sala= new Salas();
            sala.setTiposala(TipoSala.MAGICA);
            moria[i]=sala;
        }
        
        for (int i = 0; i < moria.length; i++) {
            System.out.println( moria[i].toString());
            if (moria[i].getTiposala().equals(MAGICA)) {
                System.out.println("Sala magica");
            }
        }
        
    }
    
}
