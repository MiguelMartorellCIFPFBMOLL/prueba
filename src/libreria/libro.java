package libreria;

import java.util.List;

public class libro {  
    private static int contadorLibros = 0;
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int numCopias;
    private int numCopiasDisponibles;

    public libro() {}

    public libro(String isbn, String titulo, String autor, String editorial, int numCopias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        setNumCopias(numCopias);
        this.numCopiasDisponibles = numCopias;
        contadorLibros++;
    }

    public libro(libro libro) {
        this(libro.isbn, libro.titulo, libro.autor, libro.editorial, libro.numCopias);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        if (numCopias < 1) {
            throw new IllegalArgumentException("El número de copias no puede ser menor a 1.");
        }
        this.numCopias = numCopias;
    }

    public int getNumCopiasDisponibles() {
        return numCopiasDisponibles;
    }

    public void setNumCopiasDisponibles(int numCopiasDisponibles) {
        this.numCopiasDisponibles = numCopiasDisponibles;
    }

    public static int getContadorLibros() {
        return contadorLibros;
    }

    public void prestarLibro() {
        if (numCopiasDisponibles > 0) {
            numCopiasDisponibles--;
            System.out.println("📕 Libro prestado con éxito: " + titulo);
        } else {
            System.out.println("❌ No hay copias disponibles para prestar.");
        }
    }

    public void devolverLibro() {
        if (numCopiasDisponibles < numCopias) {
            numCopiasDisponibles++;
            System.out.println("📗 Libro devuelto con éxito: " + titulo);
        } else {
            System.out.println("❌ No se puede devolver más copias de las existentes.");
        }
    }

    public static void agregarLibro(libro libro, List<libro> listaLibros) {
        listaLibros.add(libro);
        System.out.println("✅ Libro agregado a la biblioteca: " + libro.getTitulo());
    }

    public static void eliminarLibro(String isbn, List<libro> listaLibros) {
        listaLibros.removeIf(libro -> libro.getIsbn().equals(isbn));
        System.out.println("✅ Libro eliminado de la biblioteca (si existía y no estaba prestado).\n");
    }

    public static int buscarLibroPorISBN(String isbn, List<libro> listaLibros) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getIsbn().equals(isbn)) {
                return i;
            }
        }
        return -1;
    }

    public static void buscarLibroPorTitulo(String titulo, List<libro> listaLibros) {
        for (libro libro : listaLibros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                System.out.println(libro);
            }
        }
    }

    @Override
    public String toString() {
        return "📖 " + titulo + " - " + autor + " (ISBN: " + isbn + ") " +
               "Editorial: " + editorial + " | Copias: " + numCopias + 
               " | Disponibles: " + numCopiasDisponibles;
    }
}



