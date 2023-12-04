import java.util.Random;
import java.util.Scanner;

class AdivinarNumero {

    public static void main(String[] args) {
        play();
    }
    public static void play() {
        Scanner teclado = new Scanner(System.in);
        Random azar = new Random();
        int numAdiv = azar.nextInt(100) + 1;
        int intentosFalt = 10;
        while (intentosFalt > 0) {
            System.out.print("Ingresa un numero del 1 al 100: ");
            int intentos = teclado.nextInt();
            int pista;
            if (intentos == numAdiv) {
                System.out.println("Bien, has adivinado el numero");
                break;
            } else {
                intentosFalt--;
                System.out.println("Te quedan " + intentosFalt + " intentos.");
                System.out.println("");
                if (intentosFalt > 0) {
                    System.out.print("Tienes opcion a una pista  (si/no): ");
                    String pistaInput = teclado.next().toLowerCase();

                    if (pistaInput.equals("si")) {
                        System.out.println("Ingresa el numero de la pista que deseas: "
                                + "\n" + "Seleccione (1). Si quiere saber si el numero es mayor o menor"
                                + "\n" + "Seleccione (2). Si quiere saber si el numero es par o impar"
                                + "\n" + "Seleccione (3). Si quiere saber si el numero es primo"
                                + "\n" + "Seleccione (4). Si quiere saber si el numero es multiplo de algun numero");
                        System.out.println("");
                        pista = teclado.nextInt();
                        switch (pista) {
                            case 1:
                                System.out.println("Te quedan  " + pista + " intentos ");
                                if (numAdiv < intentos) {
                                    System.out.println("-  PISTA:   Intenta con un numero menor");
                                } else {
                                    System.out.println("-  PISTA:   Intenta con un numero mayor");
                                }
                                break;
                            case 2:
                                System.out.println("Te quedan " + pista + " intentos");
                                if (numAdiv % 2 == 0) {
                                    System.out.println("-  PISTA:   El numero es par");
                                } else {
                                    System.out.println("-  PISTA:   El numero es impar");
                                }
                                break;
                            case 3:
                                System.out.println("El numero de pista seleccionado es: " + pista);
                                if (Primo(numAdiv)) {
                                    System.out.println("EL numero es un número primo.");
                                } else {
                                    System.out.println("El numero no es un número primo.");
                                }
                                break;
                            case 4:
                                System.out.println("El numero de pista seleccionado es: " + pista);
                                System.out.print("Ingrese el posible divisor: ");
                                int div = teclado.nextInt();

                                if (Multiplo(numAdiv, div)) {
                                    System.out.println(numAdiv + "Es múltiplo de " + div);
                                } else {
                                    System.out.println("No es múltiplo de " + div);
                                }
                                break;
                        }

                        intentosFalt--;
                        System.out.println("Te quedan: " + intentosFalt+" intentos");
                    }
                }
            }
        }
        if (intentosFalt == 0) {
            System.out.println("Te has quedado sin intentos el numero es: " + numAdiv);
        }
        System.out.println("¿Quieres jugar de nuevo? (si/no): ");
        String nuevoIntento = teclado.next().toLowerCase();

        if (nuevoIntento.equals("si")) {
            play();
        } 
    }
    private static boolean Multiplo(int intento, int div) {
        return intento % div == 0;
    }
    private static boolean Primo(int intento) {
        if (intento <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(intento); i++) {
            if (intento % i == 0) {
                return false;
            }
        }
        return true;
    }
}
