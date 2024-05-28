import java.util.Objects;

public final class Asignatura implements Comparable{
    private String nombre;

    private int nota;

    public Asignatura(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asignatura that = (Asignatura) o;
        return nombre.equals(that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre + "-" + nota;
    }

    @Override
    public int compareTo(Object o) {
        Asignatura otra = (Asignatura) o;
        if(this.nota < otra.getNota()) {
            return -1;
        } else if(this.nota > otra.getNota()) {
            return 1;
        }

        return this.nombre.compareTo(otra.getNombre());

    }
}