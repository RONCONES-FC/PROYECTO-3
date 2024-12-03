package Interfaz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PaginaGeneralBienvenida extends JFrame {
    public PaginaGeneralBienvenida() {
        setTitle("Bienvenida - Selección de Rol");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fondo principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#F5F7FA"));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BorderLayout(10, 10));

        // Título
        JLabel lblTitulo = new JLabel("Seleccione su rol:");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.decode("#333333"));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(lblTitulo, BorderLayout.NORTH);

        // Panel central para botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#F5F7FA"));
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton btnEstudiante = crearBoton("Estudiante", "#007BFF", Color.WHITE);
        JButton btnProfesorAdmin = crearBoton("Profesor Administrador", "#007BFF", Color.WHITE);
        JButton btnProfesorMaestro = crearBoton("Profesor Maestro", "#007BFF", Color.WHITE);
        JButton btnAgregarUsuario = crearBoton("Agregar Usuario", "#28A745", Color.WHITE);

        // Agregar botones al panel
        buttonPanel.add(btnEstudiante);
        buttonPanel.add(btnProfesorAdmin);
        buttonPanel.add(btnProfesorMaestro);
        buttonPanel.add(btnAgregarUsuario);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Acción de los botones
        btnEstudiante.addActionListener(e -> {
            new PaginaBienvenida("Estudiante").setVisible(true);
            dispose();
        });

        btnProfesorAdmin.addActionListener(e -> {
            new PaginaBienvenida("Profesor Administrador").setVisible(true);
            dispose();
        });

        btnProfesorMaestro.addActionListener(e -> {
            new PaginaBienvenida("Profesor Maestro").setVisible(true);
            dispose();
        });

        btnAgregarUsuario.addActionListener(e -> {
            new PanelAgregarUsuario().setVisible(true);
        });

        add(mainPanel);
        setLocationRelativeTo(null);
    }

    private JButton crearBoton(String texto, String colorFondo, Color colorTexto) {
        JButton button = new JButton(texto);
        button.setBackground(Color.decode(colorFondo));
        button.setForeground(colorTexto);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }
}
