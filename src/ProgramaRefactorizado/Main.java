package ProgramaRefactorizado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();
        int[] primos = generarPrimos(dato);
        mostrarVector("Vector inicial hasta " + dato + ":", crearVectorInicial(dato));
        mostrarVector("Vector de primos hasta " + dato + ":", primos);
    }

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

    public static void mostrarVector(String mensaje, int[] vector) {
        System.out.println("\n" + mensaje);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    public static int[] generarPrimos(int max) {
        if (max < 2)
            return new int[0];

        int dim = max + 1;
        boolean[] esPrimo = new boolean[dim];

        for (int i = 0; i < dim; i++)
            esPrimo[i] = true;

        esPrimo[0] = esPrimo[1] = false;

        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
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
