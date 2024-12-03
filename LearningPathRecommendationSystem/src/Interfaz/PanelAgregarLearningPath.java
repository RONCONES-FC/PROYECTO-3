package Interfaz;

import Persistencia.PersistenciaLearningPathJson;
import Path.LearningPath;
import Path.Actividad;
import Retroalimentacion.Rating;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanelAgregarLearningPath extends JFrame {
    public PanelAgregarLearningPath() {
        setTitle("Agregar Learning Path");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Fondo principal
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#F5F7FA"));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new GridLayout(9, 2, 10, 10));

        // Etiquetas y campos de texto
        JLabel lblNombreActividad = crearEtiqueta("Nombre de la Actividad:");
        JTextField txtNombreActividad = crearCampoTexto();

        JLabel lblDuracion = crearEtiqueta("Duración en minutos:");
        JTextField txtDuracion = crearCampoTexto();

        JLabel lblDescripcion = crearEtiqueta("Descripción:");
        JTextField txtDescripcion = crearCampoTexto();

        JLabel lblNivelDificultad = crearEtiqueta("Nivel de Dificultad:");
        JTextField txtNivelDificultad = crearCampoTexto();

        JLabel lblVersion = crearEtiqueta("Versión:");
        JTextField txtVersion = crearCampoTexto();

        // Botones
        JButton btnGuardar = crearBoton("Guardar", "#007BFF", Color.WHITE);
        JButton btnCancelar = crearBoton("Cancelar", "#FF4D4F", Color.WHITE);

        // Añadir componentes al panel principal
        mainPanel.add(lblNombreActividad);
        mainPanel.add(txtNombreActividad);
        mainPanel.add(lblDuracion);
        mainPanel.add(txtDuracion);
        mainPanel.add(lblDescripcion);
        mainPanel.add(txtDescripcion);
        mainPanel.add(lblNivelDificultad);
        mainPanel.add(txtNivelDificultad);
        mainPanel.add(lblVersion);
        mainPanel.add(txtVersion);
        mainPanel.add(btnGuardar);
        mainPanel.add(btnCancelar);

        add(mainPanel);

        // Acción del botón Guardar
        btnGuardar.addActionListener(e -> {
            try {
                String nombreActividad = txtNombreActividad.getText();
                int duracion = Integer.parseInt(txtDuracion.getText());
                String descripcion = txtDescripcion.getText();
                String nivelDeDificultad = txtNivelDificultad.getText();
                String version = txtVersion.getText();
                Date fechaActual = new Date();

                if (nombreActividad.isEmpty() || descripcion.isEmpty() || nivelDeDificultad.isEmpty() || version.isEmpty()) {
                    mostrarMensajeError("Por favor, complete todos los campos.");
                    return;
                }

                // Crear un nuevo Learning Path
                LearningPath nuevoPath = new LearningPath(
                        nombreActividad,
                        duracion,
                        descripcion,
                        nivelDeDificultad,
                        version,
                        fechaActual,
                        new ArrayList<>(),
                        fechaActual,
                        new ArrayList<>(),
                        0.0
                );

                // Guardar el Learning Path
                PersistenciaLearningPathJson persistencia = new PersistenciaLearningPathJson();
                List<LearningPath> learningPaths = persistencia.cargarLearningPaths("Datos/learningPaths.json");
                learningPaths.add(nuevoPath);
                persistencia.guardarLearningPaths("Datos/learningPaths.json", learningPaths);

                mostrarMensajeExito("Learning Path agregado con éxito.");
                dispose();
            } catch (NumberFormatException ex) {
                mostrarMensajeError("Error: Duración debe ser un número válido.");
            } catch (Exception ex) {
                mostrarMensajeError("Error al guardar el Learning Path: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Acción del botón Cancelar
        btnCancelar.addActionListener(e -> dispose());

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

    private void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensajeExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}

