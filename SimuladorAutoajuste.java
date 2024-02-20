import java.util.Random;

class Ventilador {
    private int velocidad;

    public Ventilador(int velocidadInicial) {
        this.velocidad = velocidadInicial;
    }

    public void ajustarVelocidad(int nuevaVelocidad) {
        velocidad = nuevaVelocidad;
        System.out.println("El ventilador ajustó su velocidad a " + velocidad + " RPM.");
    }

    public void autoajustar(int temperatura) {
        if (temperatura > 30) {
            ajustarVelocidad(1000); // Si la temperatura es alta, aumentar la velocidad
        } else if (temperatura < 20) {
            ajustarVelocidad(500); // Si la temperatura es baja, reducir la velocidad
        } else {
            ajustarVelocidad(750); // Si la temperatura está en un rango normal, mantener una velocidad intermedia
        }
    }
}

public class SimuladorAutoajuste {
    public static void main(String[] args) {
        Ventilador ventilador = new Ventilador(750); // Velocidad inicial del ventilador

        // Simulación de autoajuste de parámetros basada en cambios aleatorios de temperatura
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int temperatura = random.nextInt(31); // Temperatura aleatoria entre 0 y 30 grados Celsius
            System.out.println("Temperatura ambiente: " + temperatura + "°C");
            ventilador.autoajustar(temperatura);
            System.out.println();
            try {
                Thread.sleep(2000); // Esperar 2 segundos entre cada simulación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
