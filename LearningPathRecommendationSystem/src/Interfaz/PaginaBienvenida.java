package Interfaz;

import Usuario.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PaginaBienvenida extends JFrame {
    public PaginaBienvenida(String rol) {
        setTitle("Inicio de Sesión - " + rol);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fondo principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#F5F7FA"));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel lblTitulo = new JLabel("Inicio de Sesión - " + rol);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.decode("#333333"));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(lblTitulo, BorderLayout.NORTH);

        // Panel central para etiquetas y campos de texto
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#F5F7FA"));
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JLabel lblUsuario = crearEtiqueta("Usuario:");
        JTextField txtUsuario = crearCampoTexto();

        JLabel lblPassword = crearEtiqueta("Contraseña:");
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBorder(BorderFactory.createLineBorder(Color.decode("#DDDDDD")));

        centerPanel.add(lblUsuario);
        centerPanel.add(txtUsuario);
        centerPanel.add(lblPassword);
        centerPanel.add(txtPassword);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Panel inferior para botones
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.decode("#F5F7FA"));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnIniciar = crearBoton("Iniciar Sesión", "#007BFF", Color.WHITE);
        JButton btnSalir = crearBoton("Salir", "#FF4D4F", Color.WHITE);

        bottomPanel.add(btnIniciar);
        bottomPanel.add(btnSalir);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Acción del botón Iniciar
        btnIniciar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String password = new String(txtPassword.getPassword());

            Usuario usuarioAutenticado = Usuario.autenticarUsuario(usuario, password, "Datos/usuarios.json");
            if (usuarioAutenticado != null) {
                JOptionPane.showMessageDialog(this, "Bienvenido, " + usuarioAutenticado.getUsuario());
                dispose();
                // Cambiar a la página correspondiente según el rol
                if (rol.equalsIgnoreCase("Estudiante")) {
                    new PaginaEstudiante().setVisible(true);
                } else if (rol.equalsIgnoreCase("Profesor Administrador")) {
                    new PaginaProfesorAdmin().setVisible(true);
                } else if (rol.equalsIgnoreCase("Profesor Maestro")) {
                    new PaginaProfesorMaestro().setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Acción del botón Salir
        btnSalir.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.decode("#333333"));
        return label;
    }

    private JTextField crearCampoTexto() {
        JTextField textField = new JTextField();
        textField.setBorder(BorderFactory.createLineBorder(Color.decode("#DDDDDD")));
        return textField;
    }

    private JButton crearBoton(String texto, String colorFondo, Color colorTexto) {
        JButton button = new JButton(texto);
        button.setBackground(Color.decode(colorFondo));
        button.setForeground(colorTexto);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        return button;
    }
}


