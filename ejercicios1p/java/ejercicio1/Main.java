package ejercicios1p.java.ejercicio1;
//package ejercicios.ejercicio1;

//Profe, yo lo puedo ejecutar sin necesidad de poner el package
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Main() {
        this.setSize(300, 200);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        Main window = new Main();
        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }
}