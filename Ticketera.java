package TRABAJOFINALLAB;

public class Ticketera {
    public static void main(String[] args) {
        // write your code here

        Empleado empleado1 = new Empleado(4324243, "Matias", "Guagni");
        Hincha hincha1 = new Hincha(43241221, "Maxi", "Ruiz Diaz");
        Hincha hincha2 = new Hincha(325635212, "Jose", "Perez");
        Hincha hincha3 = new Hincha(654645456, "Manuel", "Dominguez");
        Hincha hincha4 = new Hincha(121322132, "Rodrigo", "Roca");
        HinchaVisitante hincha1v=new HinchaVisitante(55563,"LUIZ","HDH");
        Hincha PAJA = new Hincha(55632,"LUCAS","JOL");
        EntradaVisitante ENTRADA3= new EntradaVisitante();
        Empleado en= new Empleado(44659,"HDF","Ruiz d");
        Entrada entrada = new Entrada();

        entrada.venderPopular(hincha1, empleado1);
        entrada.venderPlatea(hincha2, empleado1);
        entrada.venderPlatea(hincha3, empleado1);
        entrada.venderPopular(hincha4, empleado1);
        entrada.entradasVendidas();
        entrada.verRecaudado();
        //entrada.guardar();
        ENTRADA3.venderPlateaVisitante(hincha1v,en);
        ENTRADA3.encontrarEntrada(55563,en);
        Menu N5= new Menu();
        N5.RealizarCompradeEntradas(PAJA);
        N5.verEntradasRestantes();



    }
}