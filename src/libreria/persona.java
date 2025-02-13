package libreria;

public class persona {
	    private String nombre;
	    private String apellidos;
	    private String nif;
	    private String contrasena;

	    public persona(String nombre, String apellidos, String nif, String contrasena) {
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.nif = nif;
	        setContrasena(contrasena);
	    }

	    public persona(persona persona) {
	        this(persona.nombre, persona.apellidos, persona.nif, persona.contrasena);
	    }

	    // Getters y Setters
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellidos() {
	        return apellidos;
	    }

	    public void setApellidos(String apellidos) {
	        this.apellidos = apellidos;
	    }

	    public String getNif() {
	        return nif;
	    }

	    public void setNif(String nif) {
	        this.nif = nif;
	    }

	    public String getContrasena() {
	        return contrasena;
	    }

	    public void setContrasena(String contrasena) {
	        if (contrasena.length() < 8) {
	            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres.");
	        }
	        this.contrasena = contrasena;
	    }

	    @Override
	    public String toString() {
	        return "Persona [Nombre=" + nombre + ", Apellidos=" + apellidos + ", NIF=" + nif + "]";
	    }
}


