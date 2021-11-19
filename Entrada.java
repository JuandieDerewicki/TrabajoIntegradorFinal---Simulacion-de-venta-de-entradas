package TRABAJOFINALLAB;

import java.io.*;
import java.util.LinkedList;
public class Entrada implements Serializable {
    private int DNIHincha;
    private int DNIVendedor;
    private double precioPopular = 150;
    private double precioPlatea = 300;
    private int recaudacion;
    private int recaudacionPopular;
    private int recaudacionPlatea;
    private int capacidad_popularLocal = 250;
    private int capacidad_plateaLocal = 250;
    private static int contPopu = 0;
    private static int contpla = 0;
    private LinkedList<Hincha> Platea;
    private LinkedList<Hincha> Popular;
    private double precioPopular_socios = 100;
    private double precioPlateasocios = 250;
    private static int contSociosPla = 0;
    private static int contsociosPopulares = 0;


    public Entrada() {
        this.Popular = new LinkedList<Hincha>();
        this.Platea = new LinkedList<Hincha>();
    }


    public void venderPopular(Hincha hincha, Empleado empleado) {
        if (contPopu < 200) {
            this.Popular.add(hincha);
            recaudacionPopular += precioPopular;
            contPopu++;
        } else {
            System.out.println("SE ACABARON LAS ENTRADAS");
        }
    }


    public void venderPlatea(Hincha hincha, Empleado empleado) {
        if (contpla < 200) {
            this.Platea.add(hincha);
            recaudacionPlatea += precioPlatea;
            contpla++;
        } else {
            System.out.println("SE ACABARON LAS ENTRADAS");
        }


    }

    public void verRecaudado() {

        recaudacion = recaudacionPlatea + recaudacionPopular;
        System.out.println("Lo recaudado en total es= " + recaudacion);

    }

    public String entradasVendidas() {

        System.out.println("Se vendieron " + this.Popular.size() + " populares");
        System.out.println("Se vendieron " + this.Platea.size() + " plateas");

        return null;
    }


    public void encontrarEntrada(int DNI, Empleado empleado) {
        int cont = 0;
        int cont1 = 0;
        boolean encontro = false;
        for (Hincha c : Platea) {
            if (c.getDNI().equals(DNI)) {

                cont++;
                if (cont == 1) {
                    System.out.println("La entrada fue encontrada:" + c);
                    System.out.println("La entrada fue encontrada en la populae local");
                }
                encontro = true;
                break;
            }

            for (Hincha x : Popular) {
                if (x.getDNI().equals(DNI)) {

                    cont1++;
                    if (cont1 == 1) {
                        System.out.println("La entrada fue encontrada:" + x);
                        System.out.println("La entrada fue encontrada en la populae local");
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
            flujodesalida.writeObject(Platea);
            flujodesalida.close();
            ObjectOutputStream flujodesalida2 = new ObjectOutputStream(new FileOutputStream(NombredeSegundaCarpeta));
            flujodesalida2.writeObject(Popular);
            flujodesalida2.close();
        } catch (IOException e) {
            System.out.println("no se ha encontrado el archivo");
        }

    }

    public void abrir(String NombreDEarchivos, String NombredeSegundaCarpeta) {
        try {

            ObjectInputStream flujodeentrada = new ObjectInputStream(new FileInputStream(NombreDEarchivos));
            LinkedList<Hincha> Platearecuperada = (LinkedList<Hincha>) flujodeentrada.readObject();
            ObjectInputStream flujodeentrada2 = new ObjectInputStream(new FileInputStream(NombredeSegundaCarpeta));
            LinkedList<Hincha> Popularrecuperada = (LinkedList<Hincha>) flujodeentrada2.readObject();
            flujodeentrada.close();
            flujodeentrada2.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void venderPopularSOCIO(HinchaSocio hincha1, Empleado empleado) {
        Hincha hincha = new Hincha(hincha1);
        this.Popular.add(hincha);
        recaudacionPopular += precioPopular_socios;
        contsociosPopulares++;

    }

    public void venderPlateaSOCIO(HinchaSocio hincha1, Empleado empleado) {
        Hincha hincha = new Hincha(hincha1);
        this.Platea.add(hincha);
        contSociosPla++;

    }

    public void cantdeSocios_qfueronalpart(Empleado empleado) {
        System.out.println("los Socios que compraron la platea son:" + contSociosPla);
        System.out.println("los Socios que compraron la popular son:" + contsociosPopulares);

    }

    public void verEntradasRestantes() {
        int num=capacidad_plateaLocal-Platea.size();
        int num2=capacidad_popularLocal-Popular.size();
        System.out.println("EL TOTAL DE ENTRADAS RESTANTE ES DE:"+(num+num2));
        System.out.println(" ENTRADAS RESTANTE DE POPULAR:"+num2);
        System.out.println(" ENTRADAS RESTANTE DE PLATEA:"+num);

    }
    public void ListaDePrecios(){
        System.out.println("LISTA DE PRECIOS PARA HINCHAS");
        System.out.println("EL VALOR DE LA POPULAR ES DE: $"+precioPopular);
        System.out.println("EL VALOR DE LA PLATEA ES DE: $"+precioPlatea);
        System.out.println("EL VALOR DE LA POPULAR ES DE: $"+precioPopular_socios);
        System.out.println("EL VALOR DE LA PLATEA PARA SOCIOS ES DE: $"+precioPlateasocios);


    }

}
