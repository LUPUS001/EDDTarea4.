package ProgramaDocumentado;

import java.util.Scanner;

/**
 * @author Antonio Calvo Llop
 * @since 24/02/2024
 */
public class Main {
    /**
     * Solicita al usuario un número para la criba de Aristoteles y
     * generará los números primos hasta llegar a ese número y los mostrará en pantalla
     * @param args
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();
        int[] primos = generarPrimos(dato);
        mostrarVector("Vector inicial hasta " + dato + ":", crearVectorInicial(dato));
        mostrarVector("Vector de primos hasta " + dato + ":", primos);
    }

    /**
     * Se crea un vector inicial con los números consecutivos hasta el número dado
     * @param max El número máximo hasta el que se generarán los números primos
     * @return vector con los números hasta llegar al número que se ha dado
     */
    public static int[] crearVectorInicial(int max) {
        int[] vector = new int[max];
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            vector[i] = i + 1;
            System.out.print(vector[i] + "\t");
        }
        return vector;
    }

    /**
     * Se muestra un vector por pantalla
     * @param mensaje
     * @param vector
     */
    public static void mostrarVector(String mensaje, int[] vector) {
        System.out.println("\n" + mensaje);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    /**
     * Ahora generaremos los números primos hasta el número que se ha
     * puesto utilizando la criba de Aristoteles
     * @param max El número máximo hasta el que se generarán números primos
     * @return
     */
    public static int[] generarPrimos(int max) {
        if (max < 2)
            return new int[0]; // Vector vacío

        int dim = max + 1; // Tamaño del array
        boolean[] esPrimo = new boolean[dim];

        for (int i = 0; i < dim; i++)
            esPrimo[i] = true;

        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (int j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }

        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }

        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }
}
