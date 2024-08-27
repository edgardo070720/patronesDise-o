package Presentation;
import Entity.*;
import BLL.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static GuiaService service = new GuiaService();
    public static void main(String[] args) {
        int opction;
        int control=0;
        while (control==0) {
            menu();
            Scanner sc = new Scanner(System.in);
            opction = sc.nextInt();
            switch(opction) {
                case 1:guiaSeve();break;
                case 2:;break;
                case 3:guiasConsult();break;
                case 4:control=1;break;
                default: System.out.println("¡Invalid option!");
            }

        }
    }
    public static void menu(){
        System.out.println("--------menu----------");
        System.out.println("|1. Guardar Guia     |");
        System.out.println("|2. Registrar entrega|");
        System.out.println("|3. Consultar Guias  |");
        System.out.println("|4. Salir            |");
        System.out.println("----------------------");
    }
    public static void guiaSeve(){
        Scanner sc = new Scanner(System.in);
        Remitente remitente = new Remitente();
        Destinatario destinatario = new Destinatario();
        Paquete paquete;
        Guia guia = new Guia();
        System.out.println("--------guardar guia------------");
         System.out.println("1.Datos del Remitente");
         System.out.println("Ingrese identificacion: ");
         remitente.setId(sc.nextLine());
         System.out.println("Ingrese nombre: ");
         remitente.setNombre(sc.nextLine());
         System.out.println("Ingrese departamento: ");
         remitente.setDepartamento(sc.nextLine());
         System.out.println("Ingrese telefono: ");
         remitente.setTelefono(sc.nextLine());
         System.out.println("2.Datos del Destinatario");
         System.out.println("Ingrese identificacion: ");
         destinatario.setId(sc.nextLine());
         System.out.println("Ingrese compañia: ");
         destinatario.setCompania(sc.nextLine());
         System.out.println("Ingrese contacto: ");
         destinatario.setContacto(sc.nextLine());
         System.out.println("Ingrese calle: ");
         destinatario.setCalle(sc.nextLine());
         System.out.println("Ingrese col: ");
         destinatario.setCol(sc.nextLine());
         System.out.println("Ingrese ciudad: ");
         destinatario.setCiudad(sc.nextLine());
         System.out.println("Ingrese estado: ");
         destinatario.setEstado(sc.nextLine());
         System.out.println("Ingrese pais: ");
         destinatario.setPais(sc.nextLine());
         System.out.println("Ingrese codigo postal: ");
         destinatario.setCodigoPostal(sc.nextLine());
         System.out.println("Ingrese telefono: ");
         destinatario.setTelefono(sc.nextLine());
         System.out.println("3. Datos del Paquete ");
         System.out.println("Seleccione tipo de paquete");
         System.out.println("1. paquete");
         System.out.println("2. caja");
         System.out.println("3. sobre ");
         int opcion = sc.nextInt();
         paquete=definirInstancia(opcion);
         paquete.setTipoPaquete(opcion);
         System.out.println("Ingrese identificacion: ");
         paquete.setIdPaquete(sc.nextLine());
         System.out.println("Ingrese cantidad: ");
         paquete.setCantidad(sc.nextInt());
         System.out.println("Ingrese peso: ");
         paquete.setPeso(sc.nextDouble());
         paquete.setDhl(definirDhl());
        System.out.println("4. Datos de la Guia");
        System.out.println("Ingrese numeor de envio: ");
        guia.setNumEnvio(sc.nextInt());
        System.out.println("Ingrese fecha de envio(dd/MM/yyyy): ");
        guia.setFecha(sc.next());
        guia.setRemitente(remitente);
        guia.setDestinatario(destinatario);
        guia.setPaquete(paquete);
        guia.setValorEnvio(paquete.calcularValor());
        System.out.println("El valor de su envio es: " + guia.getValorEnvio());
        System.out.println("respuesta: "+service.addGuia(guia));
        System.out.println("----------------------------------------------");


    }
    private static boolean definirDhl(){
        Scanner sc = new Scanner(System.in);
        char optionDhl='f';

        while (optionDhl!='s'||optionDhl!='n') {
            System.out.println("¿su paquete proviene del extranjero? (s/n) ");
            optionDhl=sc.next().charAt(0);
            switch (optionDhl) {
                case 's':return true;
                case 'n':return false;
                default:System.out.println("Opcion no valida");break;
            }
        }
        return false;
    }
    private static Paquete definirInstancia(int option){
        switch (option) {
            case 1:return new SudPaquete();
            case 2:return new SudSobre();
            case 3:return new SudCaja();
        }
        return null;
    }
    private static void guiasConsult(){
        if(service.getListGuia().getGuias()!=null){
            List<Guia> guias= service.getListGuia().getGuias();
            for (Guia guia : guias) {
               System.out.println(guia+","+guia.getRemitente()+","+guia.getDestinatario()+","+guia.getPaquete());
            }
        }else{
            System.out.println("error: "+service.getListGuia().getMessage());
        }


    }

}