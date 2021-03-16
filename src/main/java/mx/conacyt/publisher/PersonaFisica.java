package mx.conacyt.publisher;

public class PersonaFisica {
 
    private String cvu;
    private String nombre;

    public PersonaFisica() {
        
    }

    public String getCvu() {
        return cvu;
    }

    public void setCvu(String cvu) {
        this.cvu = cvu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PersonaFisica [cvu=" + cvu + ", nombre=" + nombre + "]";
    }

    
}
