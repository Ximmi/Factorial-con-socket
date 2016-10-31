package socketfactorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class SocketFactorial {
     public static void main(String[] args) {
//        para conectarns desde otros equipos hay que agregar cambiar 
//        localhost por la ip del servidor
        String ip = "192.168.9.83";
        //se enviara ip y puerto
        int puerto = 1234;
        int factorial=1;
        Scanner scan=new Scanner(System.in);
        String nombre;
        int numfact;
        System.out.println(" socket " + ip + " " + puerto);
        try {
            Socket sk = new Socket(ip, puerto);
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(sk.getInputStream()));
            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(sk.getOutputStream()), true);
                    System.out.println("Hola! se calculará el factorial de un número, escribe tu nombre:");
                    nombre=scan.nextLine();
                    System.out.println("Escribe el número");
                    numfact=scan.nextInt();
                    for (int i=numfact; i>0;i--){
					factorial=factorial*i;
				}
				String mensaje=String.valueOf(factorial);
				        System.out.println(nombre + " el factorial de " + numfact + " es " + mensaje);
//System.out.println("enviando...");
            //salida.println("Nombre usuario: " + " " + "agrege su nombre aqui");
            //System.out.println("recibiendo ... " + entrada.readLine());
            sk.close();
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
    }
}
    

