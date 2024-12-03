package Interfaz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PaginaEstudiante extends JFrame {
    public PaginaEstudiante() {
        setTitle("Página de Estudiante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fondo principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#F5F7FA"));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblTitulo = new JLabel("Bienvenido, Estudiante");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.decode("#333333"));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnVisualizarProgreso = crearBoton("Visualizar Progreso", "#007BFF", Color.WHITE);
        JButton btnSalir = crearBoton("Salir", "#FF4D4F", Color.WHITE);

        mainPanel.add(lblTitulo);
        mainPanel.add(btnVisualizarProgreso);
        mainPanel.add(btnSalir);

        add(mainPanel);

        // Acción del botón Visualizar Progreso
        btnVisualizarProgreso.addActionListener(e -> new PanelVisualizarProgreso().setVisible(true));

        // Acción del botón Salir
        btnSalir.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
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
