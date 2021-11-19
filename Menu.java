package TRABAJOFINALLAB;
import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Menu extends Entrada{
    private LinkedList<Hincha> Plateacompradasporinternet;
    private LinkedList<Hincha> Popularcompradasporintenet;
    private static int contPla=0;
    private static int contPopu=0;
    private int cantidadDeentradasPopuint=100;
    private int cantidadDeentradasPlaint=100;
    private int recaudacionInternet;
    private int recaudacionPopularint;
    private int recaudacionPlateaint;
    private double precioPopular = 150;
    private double precioPlatea = 300;
    private double precioPopularSOCIO = 100;
    private double precioPlateaSOCIO = 250;
    public Menu(){
        this.Popularcompradasporintenet = new LinkedList<Hincha>();
        this.Plateacompradasporinternet = new LinkedList<Hincha>();
    }
    public void ingresarAlSistema(Hincha hincha){

        System.out.println("Usted ha ingresado al sistema con su cuenta de hincha");

    }

    public void ingresarAlSistema(HinchaSocio hincha){

        System.out.println("Usted ha ingresado al sistema con su cuenta de socio");

    }
    public void VerlistadePRECIOS(){
        System.out.println("LISTA DE PRECIOS PARA HINCHAS");
        System.out.println("EL VALOR DE LA POPULAR ES DE: $"+precioPopular);
        System.out.println("EL VALOR DE LA PLATEA ES DE: $"+precioPlatea);
        System.out.println("EL VALOR DE LA POPULAR ES DE: $"+ precioPopularSOCIO);
        System.out.println("EL VALOR DE LA PLATEA PARA SOCIOS ES DE: $"+ precioPlateaSOCIO);
    }

    public void RealizarCompradeEntradas(Hincha c){
        Scanner sc = new Scanner (System.in);
        System.out.println("Si desea comprar popular ingrese 1");
        System.out.println("Si desea comprar platea ingrese 2");
        int num=sc.nextInt();
        if (num==1){
            if (contPopu<100){
                this.Popularcompradasporintenet.add(c);
                recaudacionPopularint+=precioPopular;

            }
            else {
                System.out.println("las entradas que se vendian por internet se agotaron");
            }


        }else{
            if (contPla<100){
                this.Plateacompradasporinternet.add(c);
                recaudacionPlateaint+=precioPlatea;
            }
            else {
                System.out.println("las entradas que se vendian por internet se agotaron");
            }

        }
        if (num>2){
            System.out.println("la opcion elegida no existe");
        }
        if (num==0){
            System.out.println("la opcion elegida no existe");
        }



    }
    public void RealizarCompradeEntradasSocios(HinchaSocio c){
        Hincha hincha = new Hincha(c);

        Scanner sc = new Scanner (System.in);
        System.out.println("Si desea comprar popular ingrese 1");
        System.out.println("Si desea comprar platea ingrese 2");
        int num=sc.nextInt();
        if (num==1){
            if (contPopu<100){
                this.Popularcompradasporintenet.add(hincha);
                recaudacionPopularint+=precioPopularSOCIO;}
            else {
                System.out.println("las entradas que se vendian por internet se agotaron");
            }


        }
        if (contPla<100){
            this.Plateacompradasporinternet.add(hincha);
            recaudacionPlateaint+=precioPlatea;
        }
        else {
            System.out.println("las entradas que se vendian por internet se agotaron");}
        if (num>2){
            System.out.println("la opcion elegida no existe");
        }
        if (num==0){
            System.out.println("la opcion elegida no existe");
        }



    }
    public void verEntradasRestantesdeInternet() {
        int num=cantidadDeentradasPlaint-Plateacompradasporinternet.size();
        int num2=cantidadDeentradasPopuint-Popularcompradasporintenet.size();
        System.out.println("EL TOTAL DE ENTRADAS RESTANTE ES DE:"+(num+num2));
        System.out.println(" ENTRADAS RESTANTE DE POPULAR:"+num2);
        System.out.println(" ENTRADAS RESTANTE DE PLATEA:"+num);
    }
    public void verLOrecaudado_de_VENTASINT(){
        recaudacionInternet=recaudacionPlateaint+recaudacionPopularint;
        System.out.println("EL TOTAL DE LO RECAUDADO EN LA VENTA DE ENTRADA POR INTERNET ES:"+ recaudacionInternet);
        System.out.println("LO RECAUDADO EN POPULAR:"+recaudacionPopularint);
        System.out.println("LO RECAUDADO EN PLATEAR:"+recaudacionPlateaint);
    }
    public void encontrarEntrada_comprada_internet(int DNI) {
        int cont = 0;
        int cont1 = 0;
        boolean encontro = false;
        for (Hincha c : Plateacompradasporinternet) {
            if (c.getDNI().equals(DNI)) {

                cont++;
                if (cont == 1) {
                    System.out.println("La entrada fue encontrada:" + c);
                    System.out.println("La entrada fue encontrada en la platea local");
                }
                encontro = true;
                break;
            }

            for (Hincha x : Popularcompradasporintenet) {
                if (x.getDNI().equals(DNI)) {

                    cont1++;
                    if (cont1 == 1) {
                        System.out.println("La entrada fue encontrada:" + x);
                        System.out.println("La entrada fue encontrada en la platea local");
                    }
                    encontro = true;
                    break;
                }
            }
        }

    }
    public void guardar(String NombreDEarchivos, String NombredeSegundaCarpeta) {
        try {
            ObjectOutputStream flujodesalida = new ObjectOutputStream(new FileOutputStream(NombreDEarchivos));
            flujodesalida.writeObject(Plateacompradasporinternet);
            flujodesalida.close();
            ObjectOutputStream flujodesalida2 = new ObjectOutputStream(new FileOutputStream(NombredeSegundaCarpeta));
            flujodesalida2.writeObject(Popularcompradasporintenet);
            flujodesalida2.close();
        } catch (IOException e) {
            System.out.println("no se ha encontrado el archivo");
        }

    }
    public void abrir(String NombreDEarchivos, String NombredeSegundaCarpeta) {
        try {

            ObjectInputStream flujodeentrada = new ObjectInputStream(new FileInputStream(NombreDEarchivos));
            LinkedList<Hincha> Platearecuperadaint = (LinkedList<Hincha>) flujodeentrada.readObject();
            ObjectInputStream flujodeentrada2 = new ObjectInputStream(new FileInputStream(NombredeSegundaCarpeta));
            LinkedList<Hincha> Popularrecuperadaint = (LinkedList<Hincha>) flujodeentrada2.readObject();
            flujodeentrada.close();
            flujodeentrada2.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("no se ha encontrado el archivo");
        }


    }


    
}
