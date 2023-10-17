import Exceptions.FullStackException;
import Exceptions.EmptyStackException;
import java.util.Random;
import java.util.Scanner;

        public class SieteYMedio {
            public static void main(String[] args) throws FullStackException, EmptyStackException {

                Stack<Double> mazo = new StackImpl<>(10); // Utiliza tu implementación de Stack

                double puntajeJugador = 0;
                double puntajeCrupier = 0;

                // Mezclar las cartas
                mezclarMazo(mazo);

                // Repartir dos cartas al jugador y al crupier
                puntajeJugador += tomarCarta(mazo);
                puntajeJugador += tomarCarta(mazo);
                puntajeCrupier += tomarCarta(mazo);
                puntajeCrupier += tomarCarta(mazo);

                Scanner scanner = new Scanner(System.in);

                while (puntajeJugador < 7.5) {
                    System.out.println("Tienes " + puntajeJugador + " puntos. ¿Quieres otra carta? (S/N)");
                    String eleccion = scanner.next();

                    if ("S".equalsIgnoreCase(eleccion)) {
                        puntajeJugador += tomarCarta(mazo);
                    } else {
                        break;
                    }
                }

                scanner.close();

                // El crupier toma cartas automáticamente hasta llegar a 5.5 o más
                while (puntajeCrupier < 5.5) {
                    puntajeCrupier += tomarCarta(mazo);
                }

                // Determinar al ganador
                System.out.println("Puntuación del jugador: " + puntajeJugador);
                System.out.println("Puntuación del crupier: " + puntajeCrupier);

                if ((puntajeJugador <= 7.5 && puntajeCrupier > 7.5) || (puntajeJugador <= 7.5 && puntajeJugador > puntajeCrupier)) {
                    System.out.println("¡El jugador gana!");
                } else {
                    System.out.println("¡El crupier gana!");
                }
            }

            // Función para mezclar las cartas
            private static void mezclarMazo(Stack<Double> mazo) throws FullStackException {
                Random random = new Random();
                double[] cartas = {1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5};

                for (int i = 0; i < cartas.length; i++) {
                    int indice = random.nextInt(cartas.length);
                    double temp = cartas[i];
                    cartas[i] = cartas[indice];
                    cartas[indice] = temp;
                }

                for (double carta : cartas) {
                    try {
                        mazo.push(carta);
                    } catch (FullStackException e) {

                        System.out.println("El mazo está lleno. Puede mezclar de nuevo o tomar una acción adecuada.");

                    }
                }
            }

            private static double tomarCarta(Stack<Double> mazo) throws EmptyStackException {
                try {
                    return mazo.pop();
                } catch (EmptyStackException e) {
                    // Maneja la excepción aquí si la pila está vacía.
                    System.out.println("El mazo está vacío. Puede mezclar de nuevo o tomar una acción adecuada.");
                    throw e;
                }
            }


            // Función para tomar una carta del mazo

        }