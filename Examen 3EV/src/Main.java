import java.util.*;
public class Main {
    public static void main(String[] args) {
        ej2();
    }

    public static Map<String, Integer> traspasarPersonas(String[] nombres, String[] apellidos, int[] edades){
        Map<String, Integer> mapa  = new HashMap<>();
        for (int i = 0; i < nombres.length; i++) {
            mapa.put(nombres[i].concat(apellidos[i]), edades[i]);
        }

        return mapa;
    }

    private static void ej2() {
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        Map<Alumno, List<Asignatura>> coleccion = new HashMap<>();
        do {
            System.out.print("-------MENU-------" + '\n' + "1. Añadir nuevo alumno"
                    + '\n' + "2. Añadir nota de nueva asignatura" + '\n' + "3. Modificar nota de asignatura existente"
                    + '\n' + "4. Eliminar nota de asignatura existente" + '\n' + "5. Eliminar alumno" + '\n' +
                    "6. Mostrar notas del alumno" + '\n' + "7. Salir" + '\n' + "Elige una opcion: ");
            opcion = Integer.parseInt(scan.nextLine());
            switch (opcion) {
                case 1: addAlumno(coleccion); break;
                case 2: addNuevaNota(coleccion); break;
                case 3: addNotaExistente(coleccion); break;
                case 4: deleteNota(coleccion); break;
                case 5: deleteAlumno(coleccion); break;
                case 6: mostrarNotas(coleccion); break;
                case 7: break;
                default: break;
            }
        } while(opcion != 7);
    }

    private static void addAlumno(Map<Alumno, List<Asignatura>> coleccion) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("DNI: ");
        String dni = scan.nextLine();
        Alumno al = new Alumno(nombre, dni);
        if(!coleccion.containsKey(al)) {
            coleccion.put(al, new ArrayList<>());
        } else {
            System.out.println("Ya existe ese alumno");
        }
    }


    private static void addNuevaNota(Map<Alumno, List<Asignatura>> coleccion) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("DNI: ");
        String dni = scan.nextLine();
        Alumno al = new Alumno(nombre, dni);
        if(coleccion.containsKey(al)) {
            System.out.print("Nombre de asignatura: ");
            String nombreAsig = scan.nextLine();
            System.out.print("Puntuación de asignatura: ");
            int nota = Integer.parseInt(scan.nextLine());
            Asignatura asig = new Asignatura(nombreAsig, nota);
            List<Asignatura> asignaturasAlumno = coleccion.get(al);
            if(asignaturasAlumno.contains(asig)) {
                for(int i=0; i<asignaturasAlumno.size(); i++) {
                    Asignatura as = asignaturasAlumno.get(i);
                    if(as.equals(asig)) {
                        as.setNota(asig.getNota());
                        break;
                    }
                }
            } else {
                System.out.println("El alumno existe, pero la asignatura no");
            }
        } else {
            System.out.println("No existe ese alumno, no añado nada");
        }
    }

    private static void addNotaExistente(Map<Alumno, List<Asignatura>> coleccion) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("DNI: ");
        String dni = scan.nextLine();
        Alumno al = new Alumno(nombre, dni);
        if (coleccion.containsKey(al)) {
            System.out.println("Nombre de la asignatura: ");
            String nombreAsig = scan.nextLine();
            System.out.println("Puntuacion de asignatura: ");
            int nota = Integer.parseInt(scan.nextLine());
            Asignatura asig = new Asignatura(nombreAsig, nota);
            List<Asignatura> asignaturasAlumno = coleccion.get(al);
            if (asignaturasAlumno.contains(asig)) {
                for (int i = 0; i < asignaturasAlumno.size(); i++) {
                    Asignatura as = asignaturasAlumno.get(i);
                    if (as.equals(asig)) {
                        as.setNota(asig.getNota());
                        break;
                    }
                }
            } else {
                System.out.println("EL alumno existe, pero la asignatura no");
            }
        } else {
            System.out.println("No existe ese alumno, no añado nada");
        }
    }

    private static void deleteNota(Map<Alumno, List<Asignatura>> coleccion) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("DNI: ");
        String dni = scan.nextLine();
        Alumno al = new Alumno(nombre, dni);
        if(coleccion.containsKey(al)) {
            System.out.print("Nombre de asignatura: ");
            String nombreAsig = scan.nextLine();
            System.out.print("Puntuación de asignatura: ");
            int nota = Integer.parseInt(scan.nextLine());
            Asignatura asig = new Asignatura(nombreAsig, nota);
            List<Asignatura> asignaturasAlumno = coleccion.get(al);
            if(asignaturasAlumno.contains(asig)) {
                asignaturasAlumno.remove(asig);
            } else {
                System.out.println("El alumno existe, pero la asignatura no");
            }
        } else {
            System.out.println("No existe ese alumno, no añado nada");
        }
    }

    private static void deleteAlumno(Map<Alumno, List<Asignatura>> coleccion) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("DNI: ");
        String dni = scan.nextLine();
        Alumno al = new Alumno(nombre, dni);
        if(coleccion.containsKey(al)) {
            coleccion.remove(al);
        } else {
            System.out.println("No existe ese alumno, no borro nada");
        }
    }


    private static void mostrarNotas(Map<Alumno, List<Asignatura>> coleccion) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();
        System.out.print("DNI: ");
        String dni = scan.nextLine();
        Alumno al = new Alumno(nombre, dni);
        if(coleccion.containsKey(al)) {
            List<Asignatura> lista = coleccion.get(al);
            Collections.sort(lista);
            for(Asignatura asignatura: lista) {
                System.out.println(asignatura);
            }
        } else {
            System.out.println("No existe ese alumno, no muestro nada");
        }
    }





}