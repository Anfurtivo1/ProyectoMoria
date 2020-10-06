
package ejerciciomoriajava;

/**
 *
 * @author Andrés
 */
public class Personajes {
    private String nombre;
    private boolean estado=true;
    private Habilidad tipoHabilidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Habilidad getTipoHabilidad() {
        return tipoHabilidad;
    }

    public void setTipoHabilidad(Habilidad tipoHabilidad) {
        this.tipoHabilidad = tipoHabilidad;
    }

    @Override
    public String toString() {
        return "Personajes{" + "nombre=" + nombre + ", estado=" + estado + ", tipoHabilidad=" + tipoHabilidad + '}';
    }
    
    
    
}
