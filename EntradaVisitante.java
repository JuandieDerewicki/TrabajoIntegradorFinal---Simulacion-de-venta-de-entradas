package TRABAJOFINALLAB;

import java.io.*;
import java.util.LinkedList;

public class EntradaVisitante {
    private int DNIHinchaVisitantes;
    private int DNIVendedorVisitante;
    private double precioPopularVisitante = 150;
    private double precioPlateaVisitante = 300;
    private int recaudaciondeentra_Visitante;
    private int recaudacionPopularVisitante;
    private int recaudacionPlateaVisitante;
    private int capacidadDPlateaVisitante=100;
    private int capacidadDPOPULARVisitante=100;
    private static int contPlatVisi=0;
    private static int contPOPUtVisi=0;
    private LinkedList<HinchaVisitante> PlateaVisitante;
    private LinkedList<HinchaVisitante> PopularVisitante;


    public EntradaVisitante() {
        this.PopularVisitante = new LinkedList<HinchaVisitante>();
        this.PlateaVisitante = new LinkedList<HinchaVisitante>();
    }
    public void venderPopularVisitante(HinchaVisitante hincha, Empleado empleado) {
        if (contPOPUtVisi<capacidadDPOPULARVisitante){
        this.PopularVisitante.add(hincha);
        recaudacionPopularVisitante += precioPopularVisitante;
        contPlatVisi++;
        }
        else {
            System.out.println("se agotaron las entrada a la platea visitante");
        }
    }

    public void venderPlateaVisitante(HinchaVisitante hincha, Empleado empleado) {
        if (contPlatVisi<capacidadDPlateaVisitante) {
            this.PlateaVisitante.add(hincha);
            recaudacionPlateaVisitante += precioPlateaVisitante;
            capacidadDPlateaVisitante++;
        }
        else {
            System.out.println("SE AGOTARON LAS ENTRADAS A LA PLATEA VISITANTE");
        }
    }

    public void verRecaudadovisitantes() {

        recaudaciondeentra_Visitante = recaudacionPlateaVisitante + recaudacionPopularVisitante;
        System.out.println("Lo recaudado en total es= " + recaudaciondeentra_Visitante);

    }
    public void guardar(String NombreDEarchivos, String NombredeSegundaCarpeta){
        try {
            ObjectOutputStream flujodesalida= new ObjectOutputStream(new FileOutputStream(NombreDEarchivos));
            flujodesalida.writeObject(PlateaVisitante);
            flujodesalida.close();
            ObjectOutputStream flujodesalida2= new ObjectOutputStream(new FileOutputStream(NombredeSegundaCarpeta));
            flujodesalida2.writeObject(PopularVisitante);
            flujodesalida2.close();
        } catch (IOException e) {
            System.out.println("no se ha encontrado el archivo");
        }

    }

    public String entradasVendidasVisitantes() {

        System.out.println("Se vendieron " + this.PopularVisitante.size() + " populares");
        System.out.println("Se vendieron " + this.PlateaVisitante.size() + " plateas");

        return null;
    }
 public void encontrarEntrada(int DNI, Empleado empleado) {
        int cont=0;
        int cont1=0;
        boolean encontro = false;
        for (HinchaVisitante c : PlateaVisitante) {
            if (c.getDNI().equals(DNI)) {
                cont++;
                if (cont==1){

                System.out.println("La entrada fue encontrada:" + c);
                System.out.println("La entrada fue encontrada en la platea visitante");
                }

                encontro = true;
                break;
            }

            for (HinchaVisitante x : PopularVisitante) {
                if (x.getDNI().equals(DNI)) {
                    cont1++;
                    if (cont1==1){
                    System.out.println("La entrada fue encontrada:" + x);
                        System.out.println("La entrada fue encontrada en la popular visitante" );}
                    encontro = true;
                    break;
                }
            }
        }

    }




    public void Abrir(String NombredeprimerARCHIVO,String NombredeSegundoArchivo){
        try {

            ObjectInputStream flujodeentrada=new ObjectInputStream(new FileInputStream(NombredeprimerARCHIVO));
            LinkedList<HinchaVisitante> Platearecuperada=(LinkedList<HinchaVisitante>) flujodeentrada.readObject();
            ObjectInputStream flujodeentrada2=new ObjectInputStream(new FileInputStream(NombredeSegundoArchivo));
            LinkedList<HinchaVisitante> Popularrecuperada=(LinkedList<HinchaVisitante>) flujodeentrada2.readObject();
            flujodeentrada.close();
            flujodeentrada2.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public void verEntradasRestantesVisitantes() {
        int num=capacidadDPlateaVisitante-PlateaVisitante.size();
        int num2=capacidadDPOPULARVisitante-PopularVisitante.size();
        System.out.println("EL TOTAL DE ENTRADAS RESTANTE ES DE:"+(num+num2));
        System.out.println(" ENTRADAS RESTANTE DE POPULAR VISITANTE:"+num2);
        System.out.println(" ENTRADAS RESTANTE DE PLATEA VISITANTE:"+num);

    }
    public void VerlistadePRECIOS(){
        System.out.println("LISTA DE PRECIOS PARA HINCHAS");
        System.out.println("EL VALOR DE LA POPULAR ES DE: $"+precioPopularVisitante);
        System.out.println("EL VALOR DE LA PLATEA ES DE: $"+precioPlateaVisitante);

    }


}


   
