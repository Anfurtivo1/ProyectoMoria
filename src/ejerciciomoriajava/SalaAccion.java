
package ejerciciomoriajava;

/**
 *
 * @author Andrés
 */
public class SalaAccion extends Salas{
    private int flechasSuelo=10;

    public SalaAccion(int poderMaligno) {
        super(poderMaligno);
    }

    public int getFlechasSuelo() {
        return flechasSuelo;
    }
    
    
    
        /**
         * @param legolas
         * @param flechas
         * @param sala
         * @return Si viven(true) o si mueren(false)
         */
        public boolean matarEnemigos(Salas sala,Elfo legolas){
        int numeroEnemigos=sala.getNumeroEnemigos();
        double porcentaje;
        int aux;
        
            for (int i = 0; i < numeroEnemigos; i++) {
                legolas.lanzarFlecha();
                if (legolas.getCarcaj()==0) {
                    porcentaje=Math.floor(Math.random()*101);
                    aux=(int) porcentaje;
                    if (aux<=80) {//Si se queda sin flechas, hay un 80% de escapar
                            return false;
                    }
                    else{
                        return true;
                    }
                }
            }
        
        /*while (flechas>0 || numeroEnemigos>0) {
            legolas.lanzarFlecha();
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
        }*/
        return true;
    }
    
}
