package TRABAJOFINALLAB;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Menu extends Entrada {
    private LinkedList<Hincha> Plateacompradasporinternet;
    private LinkedList<Hincha> Popularcompradasporintenet;
    private static int contPla = 0;
    private static int contPopu = 0;
    private int cantidadDeentradasPopuint = 100;
    private int cantidadDeentradasPlaint = 100;
    private int recaudacionInternet;
    private int recaudacionPopularint;
    private int recaudacionPlateaint;
    private double precioPopular = 150;
    private double precioPlatea = 300;
    private double precioPopularSOCIO = 100;
    private double precioPlateaSOCIO = 250;

    public Menu() {
        this.Popularcompradasporintenet = new LinkedList<Hincha>();
        this.Plateacompradasporinternet = new LinkedList<Hincha>();
    }

    public void ingresarAlSistema(Hincha hincha) {

        System.out.println("Usted ha ingresado al sistema con su cuenta de hincha");

    }

    public void ingresarAlSistema(HinchaSocio hincha) {

        System.out.println("Usted ha ingresado al sistema con su cuenta de socio");

    }

    public void VerlistadePRECIOS() {
        System.out.println("LISTA DE PRECIOS PARA HINCHAS");
        System.out.println("EL VALOR DE LA POPULAR ES DE: $" + precioPopular);
        System.out.println("EL VALOR DE LA PLATEA ES DE: $" + precioPlatea);
        System.out.println("EL VALOR DE LA POPULAR ES DE: $" + precioPopularSOCIO);
        System.out.println("EL VALOR DE LA PLATEA PARA SOCIOS ES DE: $" + precioPlateaSOCIO);
    }

    public void RealizarCompradeEntradas(Hincha c) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Si desea comprar popular ingrese 1");
        System.out.println("Si desea comprar platea ingrese 2");
        int num = sc.nextInt();
        if (num == 1) {
            if (contPopu < 100) {
                this.Popularcompradasporintenet.add(c);
                recaudacionPopularint += precioPopular;

            } else {
                System.out.println("las entradas que se vendian por internet se agotaron");
            }


        } else {
            if (contPla < 100) {
                this.Plateacompradasporinternet.add(c);
                recaudacionPlateaint += precioPlatea;
            } else {
                System.out.println("las entradas que se vendian por internet se agotaron");
            }

        }
        if (num > 2) {
            System.out.println("la opcion elegida no existe");
        }
        if (num == 0) {
            System.out.println("la opcion elegida no existe");
        }


    }

    public void RealizarCompradeEntradasSocios(HinchaSocio c) {
        Hincha hincha = new Hincha(c);

        Scanner sc = new Scanner(System.in);
        System.out.println("Si desea comprar popular ingrese 1");
        System.out.println("Si desea comprar platea ingrese 2");
        int num = sc.nextInt();
        if (num == 1) {
            if (contPopu < 100) {
                this.Popularcompradasporintenet.add(hincha);
                recaudacionPopularint += precioPopularSOCIO;
            } else {
                System.out.println("las entradas que se vendian por internet se agotaron");
            }

}
