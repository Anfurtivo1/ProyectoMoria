
package ejerciciomoriajava;

import static ejerciciomoriajava.TipoSala.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Stack;

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
        SalaAccion salaA;
        Stack pila =new Stack();
        int contador=0;
        boolean pruebaMagica;
        boolean pruebaAccion;
        boolean pruebaHabilidad;
        int poderMaligno;
        int pruebasNoSuperadas=0;
        int pruebasSuperadas=0;
        int sumarPoderVara;
        /* Creamos un objeto DataOutputStream vinculándolo a un objeto FileOutputStream 
        para ESCRIBIR en un archivo en disco*/
        DataOutputStream salida;
        
        
        
        for (int i = 0; i < moria.length; i++) {
            poderMaligno=(int)Math.floor(Math.random()*40);
            if (contador<=20) {
                sala= new Salas(poderMaligno);
                sala.setTiposala(TipoSala.MAGICA);
                moria[i]=sala;   
            }
            if (contador<=30 && contador >=20) {
                sala= new Salas(poderMaligno);
                sala.setTiposala(TipoSala.HABILIDAD);
                moria[i]=sala;
            }
                
            if (contador<=37 && contador>=30) {
                salaA= new SalaAccion(poderMaligno);
                salaA.setTiposala(TipoSala.ACCION);
                moria[i]=salaA;
            }
            pila.add(moria[i]);
            contador++;
        }
        
        for (int i = 0; i < moria.length; i++) {
            //System.out.println( moria[i].toString());
            if (moria[i].getTiposala().equals(MAGICA)) {
                System.out.println("");
                sumarPoderVara=(int)Math.floor(Math.random()*10);
                gandalf.recargarVara(sumarPoderVara+gandalf.PoderVara());
                pruebaMagica=moria[i].comprobarPeligroMagico(gandalf.PoderVara(), moria[i]);
                if (pruebaMagica && gandalf.isEstado()) {
                    System.out.println("Gandalf ha realizado una sala con peligro magico y la ha superado");
                    pruebasSuperadas++;
                }else{
                    System.out.println("Gandalf ha muerto");
                    gandalf.setEstado(false);
                    pruebasNoSuperadas++;
                    break;
                }
                
                pila.pop();
            }
            if (moria[i].getTiposala().equals(HABILIDAD)) {
                System.out.println("");
                pruebaHabilidad=moria[i].combate(frodo);
                if (pruebaHabilidad && frodo.isEstado()) {
                    System.out.println("Frodo ha realizado una sala con peligro Habilidad y la ha superado");
                    pruebasSuperadas++;
                }
                else{
                    System.out.println("Frodo ha muerto");
                    frodo.setEstado(false);
                    pruebasNoSuperadas++;
                    break;
                }
                
                
                pila.pop();
            }
            if (moria[i].getTiposala().equals(ACCION)) {
                System.out.println("");
                SalaAccion aux=(SalaAccion)moria[i];
                pruebaAccion=aux.matarEnemigos(moria[i],legolas);
                
                if (pruebaAccion && legolas.isEstado()) {
                    System.out.println("Legolas ha realizado una sala con peligro Accion y la ha superado");
                    pruebasSuperadas++;
                    legolas.recargarCarcaj(aux.getFlechasSuelo()+legolas.getCarcaj());
                }
                else{
                    System.out.println("Legolas ha muerto");
                    legolas.setEstado(false);
                    pruebasNoSuperadas++;
                    break;
                }
                pila.pop();
            }
            
   
        }
        if (pruebasNoSuperadas>0) {
            try{
                salida = new DataOutputStream(new FileOutputStream("moria.txt",true));
                pruebasNoSuperadas=36-pruebasSuperadas;
                salida.writeChar('\n');
                //System.out.println("No se ha podido atravesar Moria");
                salida.writeChars("No se ha podido atravesar Moria");
                salida.writeChar('\n');
                //System.out.println("Se han superado "+pruebasSuperadas+" pruebas");
                salida.writeChars("Se han superado "+pruebasSuperadas+" pruebas");
                salida.writeChar('\n');
                //System.out.println("No se han podido superar "+ pruebasNoSuperadas+" pruebas");
                salida.writeChars("No se han podido superar "+ pruebasNoSuperadas+" pruebas");
                salida.writeChar('\n');
                salida.close(); 
            }catch(Exception e){
                System.out.println("Error en "+e);
            }
                
            }
        
        if (pruebasNoSuperadas==0) {
            try{
                salida = new DataOutputStream(new FileOutputStream("moria.txt",true));
                salida.writeChar('\n');
                //System.out.println("************Se ha superado Moria*************");
                salida.writeChars("************Se ha superado Moria*************");
                salida.close(); 
            }catch(Exception e){
                System.out.println("Error en "+e);
            }
            
        }
    }
    
}
