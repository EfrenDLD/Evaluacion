import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de materias: ");
        int numMaterias = scanner.nextInt();
        String[] materiaCal = new String[numMaterias];

        for (int i = 0; i < numMaterias; i++) {
            System.out.print("Ingrese el nombre de la materia y la calificación : ");
            materiaCal[i] = scanner.next() + " [" + scanner.nextDouble() + "]";
        }

        Main m = new Main();
        double[] calificacion = m.obtenerCalificaciones(materiaCal);
        String[] nombres = m.obtenerNombreMateria(materiaCal);
        int size = calificacion.length;
        double prom = 0;
        for (int i = 0; i < size; i++) {
            prom += calificacion[i] / size;
            System.out.println("\n\n Nombre de materia: " + nombres[i] + " \n Calificación de parcial: " + calificacion[i]);
        }
        System.out.println("\n\n El promedio del parcial es: " + m.truncar(prom));
    }

    public double[] obtenerCalificaciones(String[] arr) {
        int size = arr.length;
        double[] cal = new double[size];
        for (int i = 0; i < size; i++) {
            int p1 = arr[i].indexOf("[");
            int p2 = arr[i].indexOf("]");
            String c = arr[i].substring(p1 + 1, p2);
            cal[i] = Double.parseDouble(c);
        }
        return cal;
    }

    public String[] obtenerNombreMateria(String[] arr) {
        int size = arr.length;
        String[] mat = new String[size];
        for (int i = 0; i < size; i++) {
            int p1 = arr[i].indexOf(" ");
            String c = arr[i].substring(0, p1);
            mat[i] = c;
        }
        return mat;
    }

    public String truncar(double numero) {
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(numero);
    }
}
