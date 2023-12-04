
import java.util.Scanner;
import java.util.Random;

class SistemaUTPL {

    double ape;
    double adc;
    double aa;
    String name;
    String ci;

    SistemaUTPL(String name, String ci) {
        this.ape = Math.random() * 3.5 + 6.5;
        this.adc = Math.random() * 3.5 + 6.5;
        this.aa = Math.random() * 3;
        this.name = name;
        this.ci = ci;
    }

    double porcentajeAprueba() {
        double porcentajeFinal = (ape + ape + aa) / 3;
        return porcentajeFinal * 10;
    }

    boolean Aprueba() {
        return porcentajeAprueba() >= 70;
    }
}

class Asignatura {

    String name;

    Asignatura(String name) {
        this.name = name;
    }
}

class Calificaciones {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresar la Cantidad de Estudiantes");
        int numEst = teclado.nextInt();
        teclado.nextLine();

        SistemaUTPL[] estudiante = new SistemaUTPL[numEst];

        Random azar = new Random();
        int pasa = 0;
        int noPasa = 0;
        double calif, califExam, califRecupera;
        double ape;
        double adc;
        double aa;
        califExam = azar.nextDouble(10);
        for (int i = 0; i < numEst; i++) {
            String name = "Estudiante ->" + (i + 1);
            String ci = String.valueOf(new Random().nextInt(1000000000));

            SistemaUTPL student = new SistemaUTPL(name, ci);

            System.out.println("Estudiante N#: " + student.name);
            System.out.println("Cedula de Identidad: " + student.ci);
            System.out.println("Calificacion APE: " + student.ape);
            System.out.println("Calificacion ADC: " + student.adc);
            System.out.println("Calificacion AA: " + student.aa);
            calif = (student.ape * 0.35) + (student.adc * 0.35) + (student.aa * 0.3);
            System.out.println("LA CALIFICACION TOTAL ES: " + calif);

            if (student.Aprueba()) {
                System.out.println("Aprobado ");
                pasa++;
            } else {
                System.out.println("Debe rend+ir examen de recuperacion");
                califRecupera = (califExam * 0.35) + (calif * 0.6);
                System.out.println("Calificacion del Examn de Recuperacion " + califExam);
                if (califRecupera < 7) {
                    System.out.println("AH REPROBADO");
                    System.out.println("CALIFICACION: " + calif);
                    noPasa++;
                } else {
                    System.out.println("HAS APROBADO :)");
                    pasa++;
                }
            }
            estudiante[i] = student;
        }
        System.out.println("ESTADISTICAS");
        System.out.println("Estadistica de Estudiantes Aprobados y Reprobados ");
        System.out.println("Han Aprobado: " + pasa);
        System.out.println("Han Reprobado: " + noPasa);
        System.out.println("Porcentaje de Estudiantes Aprobados: " + ((double) pasa / numEst) * 100 + "%");
        System.out.println("Porcentaje de Estudiantes Reprobados: " + ((double) noPasa / numEst) * 100 + "%");
    }
}
