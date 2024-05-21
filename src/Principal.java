import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int salir = 1;
        while (salir != 0){

            Scanner lectura = new Scanner(System.in);
            ConectorAPI consulta = new ConectorAPI();
            System.out.println("Escriba la moneda de su país: ");
            var tipoDeMoneda = lectura.nextLine();
            System.out.println("Ingrese la moneda de conversión: ");
            var monedaConversion = lectura.nextLine();
            System.out.println("Ingrese la cantidad que quiere convertir: ");
            var cantidadConversion = Double.valueOf(lectura.nextInt());

            try {
                Moneda moneda = consulta.buscaMoneda(tipoDeMoneda, monedaConversion, cantidadConversion);
                System.out.println("Moneda: " + tipoDeMoneda);
                System.out.println("Moneda a convertir: " + monedaConversion);
                System.out.println("Cantidad a convertir: " + cantidadConversion);
                System.out.println("La conversión de $" + cantidadConversion + " " + tipoDeMoneda.toUpperCase() + " a " + monedaConversion.toUpperCase() +
                        " es = $" + moneda.conversion_result() + " " + monedaConversion.toUpperCase());
                System.out.println("\nEscirba 0 si desea finalizar y 1 si desea continuar con otra conversión: ");
                salir = lectura.nextInt();
                if (salir == 0){
                    System.out.println("Finalizando la aplicación.");
                }

            }catch (NumberFormatException e){
                System.out.println("Numero no encontrado " + e.getMessage());
                System.out.println("Finalizando la aplicación.");
                salir = 0;

            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
                salir = 0;
            }


        }
    }
}
