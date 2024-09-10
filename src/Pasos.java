import java.sql.SQLOutput;
import java.util.Scanner;

public class Pasos {

    static int pasos = 0;
    static int opcion = 0;
    static Scanner lector = new Scanner(System.in);

    static String[] usuario = new String[4];

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("----Contador App----");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Registrarse");
        opcion = lector.nextInt();

        switch (opcion){
            case 1:
                iniciarSesion();
                break;

            case 2:
                registrarUsuario();
                break;
        }
    }

    public static boolean comprobarUsuario(String correo, String contraseña){
        boolean estado;
        if(correo.equals(usuario[1]) && contraseña.equals(usuario[2])){
            estado = true;
        }else{
            estado = false;
        }

        return estado;
    }

    public static void registrarUsuario(){
        String nombre;
        String correo;
        String contraseña;

        System.out.println("----Registro----");
        System.out.print("Digite su nombre: ");
        nombre = lector.next();

        System.out.print("Digite su correo: ");
        correo = lector.next();

        System.out.print("Digite su contraseña: ");
        contraseña = lector.next();

        usuario[0] = nombre;
        usuario[1] = correo;
        usuario[2] = contraseña;

        System.out.println("Usuario creado con exito");
        menu();
    }

    public static void iniciarSesion(){
        String correo;
        String contraseña;
        boolean estado;

        System.out.println("----Login---");
        System.out.print("Digite su correo: ");
        correo = lector.next();

        System.out.print("Digite su contraseña: ");
        contraseña = lector.next();

        estado = comprobarUsuario(correo, contraseña);

        if(estado == true){
            System.out.println("Bienvenido: " + usuario[0]);
            contador();
        } else if (estado == false) {
            System.out.println("Usuario no valido o no registrado");
            menu();
        }
    }

    public static void contador(){
        int login = 1;
        while(login == 1){
            int opcion = 1;
            while(opcion == 1){
                System.out.print("Digite la cantidad de pasos realizados hoy: ");
                pasos += lector.nextInt();
                usuario[3] = Integer.toString(pasos);
                System.out.println("----------------------------------------------------");
                System.out.println("Cantidad de pasos realizados hasta el momento: " + usuario[3]);
                System.out.println("----------------------------------------------------");

                System.out.println("¿Desea registrar más pasos?");
                System.out.println("1. Si");
                System.out.println("2. No");
                opcion = lector.nextInt();
            }
            System.out.println("¿Desea desconectarse?");
            System.out.println("1. No");
            System.out.println("2. Si");
            login = lector.nextInt();
        }

        System.out.println("Nombre: " + usuario[0]);
        System.out.println("Correo: " + usuario[1]);
        System.out.println("Contraseña: " + usuario[2]);
        System.out.println("Pasos: " + usuario[3]);
    }
}
