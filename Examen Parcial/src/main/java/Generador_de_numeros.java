import java.util.Scanner;
public class Generador_de_numeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el número de niveles
        System.out.print("Ingrese el número de niveles: ");
        int niveles = scanner.nextInt();

        // Validar que sea un número positivo
        if (niveles < 1) {
            System.out.println("Error: El número debe ser positivo.");
        } else {
            // Generar escalera ascendente
            System.out.println("\nEscalera Ascendente:");
            generarEscaleraAscendente(niveles);

            // Generar escalera descendente
            System.out.println("\nEscalera Descendente:");
            generarEscaleraDescendente(niveles);
        }

        scanner.close();
    }

    // Método para generar la escalera ascendente (1 hasta n)
    public static void generarEscaleraAscendente(int n) {
        for (int i = 1; i <= n; i++) {
            imprimirLinea(i);
        }
    }

    // Método para generar la escalera descendente (n hasta 1)
    public static void generarEscaleraDescendente(int n) {
        for (int i = n; i >= 1; i--) {
            imprimirLinea(i);
        }
    }

    // Método para imprimir una línea de la escalera (ej: "1.2.3")
    public static void imprimirLinea(int nivel) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(i);
            if (i < nivel) {
                System.out.print("."); // Agrega punto entre números
            }
        }
        System.out.println(); // Salto de línea al final
    }
}