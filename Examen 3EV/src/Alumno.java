import java.util.Objects;

public class Alumno {
    private String nombreCompleto;

    private String dni;

    public Alumno(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return nombreCompleto.equals(alumno.nombreCompleto) && dni.equals(alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCompleto, dni);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
