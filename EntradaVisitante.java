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



    
