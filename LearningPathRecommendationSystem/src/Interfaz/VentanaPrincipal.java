package Interfaz;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Sistema Learning Paths");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 3));

        BotonAgregar botonAgregarUsuario = new BotonAgregar("Agregar Usuario");
        BotonVisualizar botonVisualizarProgreso = new BotonVisualizar("Visualizar Progreso");
        JButton btnSalir = new JButton("Salir");

        // Estilo de los botones
        botonAgregarUsuario.setBackground(Color.CYAN);
        botonVisualizarProgreso.setBackground(Color.ORANGE);
        btnSalir.setBackground(Color.RED);

        panelBotones.add(botonAgregarUsuario);
        panelBotones.add(botonVisualizarProgreso);
        panelBotones.add(btnSalir);

        btnSalir.addActionListener(e -> System.exit(0));

        add(panelBotones, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }
}
