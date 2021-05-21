package ejercicios1p.java.bloc_notas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BlocNota extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BlocNota() {
        initComponents();
    }

    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // Creación de los paneles superior, central e inferior
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_inferior = new Panel();

        // Asignación del Layout en los paneles
        panel_superior.setLayout(new FlowLayout());
        panel_central.setLayout(new BorderLayout());
        panel_inferior.setLayout(new BorderLayout());

        // Creacion del TextArea
        txt_out = new TextArea();

        // Creación del TextField
        txt_init = new TextField();
        txt_init.setEditable(false);

        // Creación de los botones
        btn_asigColor = new Button("Color");
        btn_addCom = new Button("Comillas");
        btn_tamFont = new Button("Fuente");
        btn_open = new Button("Abrir");
        btn_save = new Button("Guardar");
        btn_exit = new Button("Salir");
        btn_info = new Button("Acerca de BN");

        setLayout(new BorderLayout());

        // Implementación de lo botones en el panel superior
        panel_superior.add(btn_asigColor, FlowLayout.LEFT);
        panel_superior.add(btn_exit, FlowLayout.CENTER);
        panel_superior.add(btn_info, FlowLayout.RIGHT);
        panel_superior.add(btn_save, FlowLayout.CENTER);
        panel_superior.add(btn_open, FlowLayout.CENTER);
        panel_superior.add(btn_addCom, FlowLayout.CENTER);
        panel_superior.add(btn_tamFont, FlowLayout.CENTER);
        this.add(panel_superior, BorderLayout.NORTH);

        // Implementación del TextArea en el panel central
        panel_central.add(txt_out, BorderLayout.CENTER);
        this.add(panel_central, BorderLayout.CENTER);

        // Implementación del TextFiel en el panel inferior
        panel_inferior.add(txt_init, BorderLayout.SOUTH);
        this.add(panel_inferior, BorderLayout.SOUTH);

        btn_asigColor.addActionListener(this);
        btn_addCom.addActionListener(this);
        btn_tamFont.addActionListener(this);
        btn_open.addActionListener(this);
        btn_save.addActionListener(this);
        btn_exit.addActionListener(this);
        btn_info.addActionListener(this);

        // Creación de la ventana
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        changeTitle();
        this.setVisible(true);
    }

    // Título por defecto al crear una nueva nota
    public void changeTitle() {

        title_aux = "";

        String initTitle = ": Bloc de notas";
        if (title_aux.compareTo("") == 0)
            title_aux = "S\u00edn t\u00edtulo";
        initTitle = title_aux + initTitle;
        setTitle(initTitle);
    }

    // Método que abre el archivo selecionado
    public String OpenFile(File file) {
        String document = "";
        try {
            files_input = new FileInputStream(file);
            int op;
            while ((op = files_input.read()) != -1) {
                char character = (char) op;
                document += character;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return document;
    }

    // Método que guardo el archivo
    public String SaveFile(File file, String document) {
        String msj = null;
        try {
            files_output = new FileOutputStream(file);
            byte[] txt = document.getBytes();
            files_output.write(txt);
            msj = "Archivo guardado";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return msj;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object btnOnPress = e.getSource();

        // Implementacion del botón de Asignacion de color de texto
        if (btnOnPress == btn_asigColor) {
            color = new Colores(txt_out);
            color.setVisible(true);
            color.getForeground();
        }

        if (btnOnPress == btn_exit) {
            dispose();
        }

        // Implementacion de las comillas - Contiene un bug
        if (btnOnPress == btn_addCom) {
            String selectText = txt_out.getSelectedText();
            String com = txt_out.getText();
            if (selectText.equals("")) {
                txt_out.setText(com.replace(selectText, '"' + selectText + '"'));
                txt_init.setText("Se a\u00f1adio comillas a : " + selectText);
            } else {
                txt_init.setText("No hay texto seleccionado");
            }
        }

        // Implementación del boton Abrir
        if (btnOnPress == btn_open) {
            if (selecction.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
                file = selecction.getSelectedFile();
                title_aux = "";
                String initTitle = ": Bloc de notas";
                if (file.canRead()) {
                    if (file.getName().endsWith("txt")) {
                        String documentOpen = OpenFile(file);
                        txt_out.setText(documentOpen);
                        initTitle = file.getName() + initTitle;
                        setTitle(initTitle);
                        txt_init.setText(file.getName() + " se ha abierto");
                    } else {
                        JOptionPane.showMessageDialog(null, "Archivo no compatible");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Archivo no compatible.");
            }
        }

        // Implementacion del botron Guardar
        if (btnOnPress == btn_save) {
            if (selecction.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
                file = selecction.getSelectedFile();
                title_aux = "";
                String initTitle = ": Bloc de notas";
                if (file.getName().endsWith("txt")) {
                    String documentSave = txt_out.getText();
                    String msj = SaveFile(file, documentSave);
                    if (msj != null) {
                        JOptionPane.showMessageDialog(null, msj);
                        initTitle = file.getName() + initTitle;
                        setTitle(initTitle);
                        txt_init.setText(file.getName() + " se ha abierto");
                    } else {
                        JOptionPane.showMessageDialog(null, "Archivo no compatible");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Guardar documento");
                }
            }
        }

        // Implementación del botón de Asignación de tamaño de fuente
        if (btnOnPress == btn_tamFont) {
            fontM = new Fonts(txt_out);
            fontM.getFont();
            fontM.setVisible(true);
        }

        // Implementación del botón Información
        if (btnOnPress == btn_info) {
            about = new About();
            about.setVisible(true);
        }
    }

    public static void main(String[] args) {
        BlocNota bn = new BlocNota();
    }

    private TextArea txt_out;
    private TextField txt_init;

    private Button btn_asigColor;
    private Button btn_addCom;
    private Button btn_tamFont;
    private Button btn_open;
    private Button btn_save;
    private Button btn_exit;
    private Button btn_info;

    private Panel panel_superior;
    private Panel panel_central;
    private Panel panel_inferior;

    private Fonts fontM;
    private String title_aux;
    private JFileChooser selecction = new JFileChooser();
    private File file;
    private FileInputStream files_input;
    private FileOutputStream files_output;

    private Colores color;
    private About about;
}
