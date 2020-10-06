
package ejerciciomoriajava;

/**
 *
 * @author Andrés
 */
public class SalaAccion extends Salas{
    private int flechasSuelo=10;
    
        /**
         * 
         * @param flechas
         * @param sala
         * @return Si viven(true) o si mueren(false)
         */
        public boolean matarEnemigos(int flechas,Salas sala){
        int numeroEnemigos=sala.getNumeroEnemigos();
        double porcentaje;
        int aux;
        
        while (flechas>0 || numeroEnemigos>0) {
            flechas--;
            numeroEnemigos--;
                if (flechas==0) {
                    porcentaje=Math.floor(Math.random()*(1-100)*100);
                    aux=(int) porcentaje;
                    if (aux<=80) {//Si se queda sin flechas, hay un 80% de escapar
                            return false;
                    }
                    else{
                        return true;
                    }
                }
        }
        

        
        return true;
    }
    
}
