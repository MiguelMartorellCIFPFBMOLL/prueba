package libreria;

import java.util.ArrayList;
import java.util.List;

public class biblioteca {
    private String nombre;
    private List<libro> listaLibros;
    private List<persona> listaPersonal;

    public biblioteca(String nombre) {
        setNombre(nombre);
        this.listaLibros = new ArrayList<>();
        this.listaPersonal = new ArrayList<>();
    }

    public biblioteca(biblioteca biblioteca) {
        this(biblioteca.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (!Character.isUpperCase(nombre.charAt(0))) {
            throw new IllegalArgumentException("El nombre debe empezar con mayúscula.");
        }
        this.nombre = nombre;
    }

    public List<libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<libro> listaLibros) {
        if (listaLibros == null) {
            throw new IllegalArgumentException("La lista de libros no puede ser nula.");
        }
        this.listaLibros = listaLibros;
    }

    public List<persona> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<persona> listaPersonal) {
        if (listaPersonal == null) {
            throw new IllegalArgumentException("La lista de personal no puede ser nula.");
        }
        this.listaPersonal = listaPersonal;
    }

    public void mostrarLibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("📚 No hay libros en la biblioteca.");
        } else {
            for (libro libro : listaLibros) {
                System.out.println(libro);
            }
        }
    }

    public void mostrarLibrosDisponibles() {
        boolean hayLibrosDisponibles = false;
        for (libro libro : listaLibros) {
            if (libro.getNumCopiasDisponibles() > 0) {
                System.out.println(libro);
                hayLibrosDisponibles = true;
            }
        }
        if (!hayLibrosDisponibles) {
            System.out.println("📚 No hay libros disponibles actualmente.");
        }
    }

    public libro buscarLibroPorISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("❌ ISBN no válido.");
            return null;
        }

        for (libro l : listaLibros) {
            if (l.getIsbn().trim().equalsIgnoreCase(isbn.trim())) { // ✅ Se usa trim() para evitar errores de espacios
                return l;
            }
        }
        System.out.println("❌ No se encontró un libro con el ISBN " + isbn);
        return null;
    }


    public void buscarLibroPorTitulo(String titulo) { // 📌 Método añadido
        boolean encontrado = false;
        for (libro libro : listaLibros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("❌ No se encontró ningún libro con ese título.");
        }
    }

    public void eliminarLibro(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            System.out.println("❌ El ISBN no puede estar vacío.");
            return;
        }
        libro libroEliminar = buscarLibroPorISBN(isbn);
        if (libroEliminar == null) {
            System.out.println("❌ No se encontró un libro con ese ISBN.");
            return;
        }
        if (libroEliminar.getNumCopiasDisponibles() == 0) {
            System.out.println("❌ No se puede eliminar el libro porque está prestado.");
            return;
        }
        listaLibros.remove(libroEliminar);
        System.out.println("✅ Libro eliminado correctamente.");
    }
}


