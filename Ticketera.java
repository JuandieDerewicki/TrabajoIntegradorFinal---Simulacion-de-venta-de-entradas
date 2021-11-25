package TRABAJOFINALLAB;

import java.util.Scanner;

public class Ticketera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Entrada entrada = new Entrada();
        EntradaVisitante entradaVisitante=new EntradaVisitante();
        Empleado empleado = new Empleado(44456325, "jose", "LOPEZ");
        int cont = 0;
        String apellido = " ";
        String nombre = "  ";
        int dni = 0;
        while (cont == 0) {
            System.out.println("Bienvenido a la boleteria\n" + "QUIERE RETIRA ENTRADA LOCAL O VISITANTE?\n");
            //System.out.println("QUIERE RETIRA ENTRADA LOCAL O VISITANTE?");
            System.out.println("1:Local");
            System.out.println("2:Visitante");
            int cont1 = sc.nextInt();
            if (cont1 == 1) {
                System.out.println("SI USTED ES SOCIO\n" + "ingrese 1\n" + "SI no es socio\n" + "ingresa 2\n");
                int cont3 = sc.nextInt();
                if (cont3 == 1) {
                    System.out.println("ingrese su nombre");
                    nombre = sc.next();
                    System.out.println("ingrese su apellido");
                    apellido = sc.next();
                    System.out.println("ingrese su Dni");
                    dni = sc.nextInt();
                    HinchaSocio hincha = new HinchaSocio(dni, nombre, apellido);
                    entrada.ListaDePreciosSocios();
                    System.out.println("1_Plateas\n" + "2_Popular");
                    int tipodeentrada = sc.nextInt();
                    if (tipodeentrada == 1) {
                        entrada.venderPlateaSOCIO(hincha, empleado);

                        if (tipodeentrada == 0) {
                            System.out.println("ERROR A LA HORA SE SELECCIONAR ENTRADA");
                        }
                        if (tipodeentrada > 3) {
                            System.out.println("ERROR A LA HORA SE SELECCIONAR ENTRADA");
                        }
                        System.out.println("Desea seguir comprando?");
                        System.out.println("1_No quiere seguir comprando");
                        System.out.println("2_Quiere seguir comprando");
                        cont=sc.nextInt();
                        if(cont==2){
                            cont=0;
                        }
                        if (cont==1){
                            System.out.println("Gracias por comprar");
                            cont=10;
                            cont1=100;

                        }
                    }
                    if (tipodeentrada == 2) {
                        entrada.venderPopularSOCIO(hincha, empleado);
                        System.out.println("Desea seguir comprando?");
                        System.out.println("1_No quiere seguir comprando");
                        System.out.println("2_Quiere seguir comprando");
                        cont=sc.nextInt();
                        if(cont==2){
                            cont=0;
                        }
                        if (cont==1){
                            System.out.println("Gracias por comprar");
                            cont=10;
                            cont1=100;

                        }
                    }


                } else {
                    System.out.println("ingrese su nombre");
                    nombre = sc.next();
                    System.out.println("ingrese su apellido");
                    apellido = sc.next();
                    System.out.println("ingrese su Dni");
                    dni = sc.nextInt();
                    Hincha hincha = new Hincha(dni, nombre, apellido);

                    entrada.ListaDePrecios();
                    System.out.println("1_Plateas\n" + "2_Popular");
                    int tipodeentrada2 = sc.nextInt();
                    if (tipodeentrada2 == 1) {
                        entrada.venderPlatea(hincha, empleado);

                        if (tipodeentrada2 == 0) {
                            System.out.println("ERROR A LA HORA SE SELECCIONAR ENTRADA");
                        }
                        if (tipodeentrada2 > 3) {
                            System.out.println("ERROR A LA HORA SE SELECCIONAR ENTRADA");
                        }
                        System.out.println("Desea seguir comprando?");
                        System.out.println("1_No quiere seguir comprando");
                        System.out.println("2_Quiere seguir comprando");
                        cont=sc.nextInt();
                        if(cont==2){
                            cont=0;
                        }
                        if (cont==1){
                            System.out.println("Gracias por comprar");
                            cont=10;
                            cont1=100;

                        }
                    }
                    if (tipodeentrada2 == 2) {
                        entrada.venderPopular(hincha, empleado);
                        System.out.println("Desea seguir comprando?");
                        System.out.println("1_No quiere seguir comprando");
                        System.out.println("2_Quiere seguir comprando");
                        cont=sc.nextInt();
                        if(cont==2){
                            cont=0;
                        }
                        if (cont==1){
                            System.out.println("Gracias por comprar");
                            cont=10;
                            cont1=100;

                        }
                    }

                }

            }
            if (cont1 == 2) {
                System.out.println("ingrese su nombre");
                nombre = sc.next();
                System.out.println("ingrese su apellido");
                apellido = sc.next();
                System.out.println("ingrese su Dni");
                dni = sc.nextInt();
                HinchaVisitante hincha = new HinchaVisitante(dni, nombre, apellido);
                entradaVisitante.VerlistadePRECIOSVisitantes();
                System.out.println("1_Plateas\n" + "2_Popular");
                int tipodeentrada = sc.nextInt();
                if (tipodeentrada == 1) {
                    entradaVisitante.venderPlateaVisitante(hincha, empleado);

                    if (tipodeentrada == 0) {
                        System.out.println("ERROR A LA HORA SE SELECCIONAR ENTRADA");
                    }
                    if (tipodeentrada > 3) {
                        System.out.println("ERROR A LA HORA SE SELECCIONAR ENTRADA");
                    }
                    System.out.println("Desea seguir comprando?");
                    System.out.println("1_No quiere seguir comprando");
                    System.out.println("2_Quiere seguir comprando");
                    cont=sc.nextInt();
                    if(cont==2){
                        cont=0;
                    }
                    if (cont==1){
                        System.out.println("Gracias por comprar");
                        cont=10;
                        cont1=100;

                    }


                }
                if (tipodeentrada == 2) {
                    entradaVisitante.venderPopularVisitante(hincha, empleado);
                    System.out.println("Desea seguir comprando?");
                    System.out.println("1_No quiere seguir comprando");
                    System.out.println("2_Quiere seguir comprando");
                    cont=sc.nextInt();
                    if(cont==2){
                        cont=0;
                    }
                    if (cont==1){
                        System.out.println("Gracias por comprar");
                        cont=10;
                        cont1=100;

                    }

                }


                // write your code here


            }


        }



        System.out.println("BUSCAR ENTRADA\n"+"si quiere buscar su entrada:Ponga 1\n"+"si no quiere buscar su entrada:Ponga 2\n");
        int contador=sc.nextInt();
        while (contador==1){
        System.out.println("INGRESA TU DNI");
        dni= sc.nextInt();
        entrada.encontrarEntrada(dni,empleado);
        entradaVisitante.encontrarEntrada(dni,empleado);
        System.out.println("QUIERES BUSCAR ALGUNA ENTRADA MAS?");
            System.out.println("1_SI QUIERES SEGUIR BUSCANDO");
            System.out.println("2_NO QUERES BUSCAR MAS");
            int contadoq=sc.nextInt();
                    if(contadoq==1){
                        contador=1;
                    }
        if (contadoq==2){
            contador=1000;


        }



        }
  entrada.verEntradasRestantes();
        System.out.println("'\n");
        System.out.println("'\n");

        entrada.entradasVendidas();
        System.out.println("\n");
        entrada.verRecaudado();
        System.out.println("\n");
        entrada.ListarcontenidPlatea();
        System.out.println("\n");
        entrada.ListarcontenidosPopular();
        System.out.println("\n");
        System.out.println("DATOS DE PLATEAS Y POPULAR VISITANTE");
        System.out.println("\n");
        entradaVisitante.entradasVendidasVisitantes();
        System.out.println("\n");
        entradaVisitante.verEntradasRestantesVisitantes();
        System.out.println("\n");
        entradaVisitante.verRecaudadovisitantes();
        System.out.println("\n");
        entradaVisitante.ListarcontenidoVisitantesPlateas();
        System.out.println("\n");
        entradaVisitante.ListarcontenidoVisitantesPopular();
        System.out.println("\n");
        empleado.info();
        entrada.guardar();
        entradaVisitante.guardar();


    }
}