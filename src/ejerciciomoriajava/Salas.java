
package ejerciciomoriajava;

/**
 *
 * @author Andrés
 */
public class Salas {
    private int poderMaligno;
    private int numeroEnemigos=10;
    public static int contador=0;
    private TipoSala tiposala;


    public int getPoderMaligno() {
        return poderMaligno;
    }

    public void setPoderMaligno(int poderMaligno) {
        this.poderMaligno = poderMaligno;
    }

    public int getNumeroEnemigos() {
        return numeroEnemigos;
    }

    public void setNumeroEnemigos(int numeroEnemigos) {
        this.numeroEnemigos = numeroEnemigos;
    }

    public TipoSala getTiposala() {
        return tiposala;
    }

    public void setTiposala(TipoSala tiposala) {
        this.tiposala = tiposala;
    }
    
    
    
     /**
     * 
     * @param poderVara
     * @param sala
     * @return Si viven(true) o si mueren(false)
     */
    public boolean comprobarPeligroMagico(int poderVara,Salas sala){
        double porcentaje;
        int aux;
        //Si el poder es mayor, se gana
        if (poderVara>sala.getPoderMaligno()) {
            return true;
        }
        //Si el poder es igual, se gana el 60% por ciento
        if (poderVara==sala.getPoderMaligno()) {
            porcentaje=Math.floor(Math.random()*(1-100)*100);
            aux=(int) porcentaje;
            if (aux<=60) {//Si se ha conseguido un 60%, hay un 80% de escapar
                porcentaje=Math.floor(Math.random()*(1-100)*100);
                aux=(int) porcentaje;
                if (aux<=80) {
                    return false;
                }
            }
            else{
                return true;
            }
        }
        //Si el poder es menor, se gana el 30%
        if (poderVara<sala.getPoderMaligno()) {
            porcentaje=Math.floor(Math.random()*(1-100)*100);
            aux=(int) porcentaje;
            if (aux<=30) {//Si se ha conseguido un 30%, hay un 80% de escapar
                porcentaje=Math.floor(Math.random()*(1-100)*100);
                aux=(int) porcentaje;
                if (aux<=80) {
                    return false;
                }
            }
            else{
                return true;
            }
        }
        
        return true;
    }
    
    
     /**
     * 
     * @param hobbit
     * @return Si viven(true) o si mueren(false)
     */
    public boolean combate(Hobbit hobbit){
        double porcentaje;
        int aux;
        
        porcentaje=Math.floor(Math.random()*(1-100)*100);
        aux=(int) porcentaje;
        if (aux<=50) {//Si se queda sin flechas, hay un 80% de escapar
            hobbit.ponerseAnillo();
            porcentaje=Math.floor(Math.random()*(1-100)*100);
            aux=(int) porcentaje;
            if (aux<=90) {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            porcentaje=Math.floor(Math.random()*(1-100)*100);
            aux=(int) porcentaje;
            if (aux<=20) {
               if (aux<=80) {
                return false;
                }
                else{
                    return true;
                }
            }
            else{
                return true;
            }
        }
        
    }
    
    

    @Override
    public String toString() {
        return "Salas{" + "poderMaligno=" + poderMaligno + ", numeroEnemigos=" + numeroEnemigos + '}';
    }
    
    
    
}
