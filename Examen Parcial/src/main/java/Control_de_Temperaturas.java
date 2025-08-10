import java.util.Scanner;
    public class Control_de_Temperaturas {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double[] temperaturas = new double[7]; // Arreglo para las temperaturas de 7 días
            String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
            boolean datosIngresados = false; // Para validar si hay datos

            while (true) {
                System.out.println("\n--- Menú de Control de Temperaturas ---");
                System.out.println("1. Ingresar temperaturas");
                System.out.println("2. Mostrar todas las temperaturas");
                System.out.println("3. Mostrar temperatura máxima");
                System.out.println("4. Suma total de temperaturas (Recursivo)");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese las temperaturas para los 7 días:");
                        for (int i = 0; i < 7; i++) {
                            System.out.print(dias[i] + ": ");
                            temperaturas[i] = scanner.nextDouble();
                        }
                        datosIngresados = true;
                        System.out.println("Temperaturas registradas correctamente.");
                        break;

                    case 2:
                        if (!datosIngresados) {
                            System.out.println("Error: No hay datos ingresados.");
                        } else {
                            mostrarTemperaturas(temperaturas, dias);
                        }
                        break;

                    case 3:
                        if (!datosIngresados) {
                            System.out.println("Error: No hay datos ingresados.");
                        } else {
                            double max = temperaturaMaxima(temperaturas);
                            mostrarMaxima(max); // Sin día
                            int indiceMax = buscarIndiceMax(temperaturas);
                            mostrarMaxima(max, dias[indiceMax]); // Con día
                        }
                        break;

                    case 4:
                        if (!datosIngresados) {
                            System.out.println("Error: No hay datos ingresados.");
                        } else {
                            double suma = sumaTemperaturas(temperaturas, 0);
                            System.out.println("Suma total (recursivo): " + suma);
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del programa...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        }

        // Procedimiento para mostrar todas las temperaturas
        public static void mostrarTemperaturas(double[] temps, String[] dias) {
            System.out.println("\n--- Temperaturas Registradas ---");
            for (int i = 0; i < temps.length; i++) {
                System.out.println(dias[i] + ": " + temps[i] + "°C");
            }
        }

        // Función para encontrar la temperatura máxima
        public static double temperaturaMaxima(double[] temps) {
            double max = temps[0];
            for (double temp : temps) {
                if (temp > max) {
                    max = temp;
                }
            }
            return max;
        }

        // Metodo sobrecargado para mostrar la máxima (sin día)
        public static void mostrarMaxima(double temperatura) {
            System.out.println("\nTemperatura máxima: " + temperatura + "°C");
        }

        // Metodo sobrecargado para mostrar la máxima (con día)
        public static void mostrarMaxima(double temperatura, String dia) {
            System.out.println("Temperatura máxima (" + dia + "): " + temperatura + "°C");
        }

        // Función recursiva para sumar temperaturas (punto extra)
        public static double sumaTemperaturas(double[] temps, int index) {
            if (index == temps.length) {
                return 0;
            }
            return temps[index] + sumaTemperaturas(temps, index + 1);
        }

        // Función auxiliar para encontrar el índice de la temperatura máxima
        public static int buscarIndiceMax(double[] temps) {
            int indiceMax = 0;
            for (int i = 1; i < temps.length; i++) {
                if (temps[i] > temps[indiceMax]) {
                    indiceMax = i;
                }
            }
            return indiceMax;
        }
    }
