package Ejercicios2P.Java.Ejercicio1;

import java.io.*;
import java.net.*;

public class Servidor {
    ServerSocket server;
    BufferedReader in;
    PrintWriter out;

    public Servidor() throws IOException {
        server = new ServerSocket(5000);
        Socket cc = server.accept();

        in = new BufferedReader(new InputStreamReader(cc.getInputStream()));
        out = new PrintWriter(cc.getOutputStream());
    }

    public void read() throws IOException {
        String line = "";
        while (!line.equals("adios")) {
            line = in.readLine();
            switch (line) {
            case "hola":
                System.out.println("Me está saludando....");
                out.println("Hola!");
                out.flush();
                break;
            case "adios":
                System.out.println("Ya te vas?");
                out.println("Adios!");
                out.flush();
                break;
            case "cual es mi calificacion?":
                System.out.println("Solo para eso veniste...:'(");
                out.println("0");
                out.flush();
                break;
            default:
                System.out.println(line);
            }
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        try {
            new Servidor().read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
