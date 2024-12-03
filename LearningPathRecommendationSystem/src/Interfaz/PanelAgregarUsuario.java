package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAgregarUsuario extends JFrame {
    public PanelAgregarUsuario() {
        setTitle("Agregar Usuario");
        setSize(400, 300);
        setLayout(new GridLayout(3, 2));

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnCancelar = new JButton("Cancelar");

        // Acción para agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String password = new String(txtPassword.getPassword());
                // Aquí se conecta con el modelo para agregar el usuario
                JOptionPane.showMessageDialog(null, "Usuario agregado: " + nombre);
                dispose();
            }
        });

        // Acción para cancelar
        btnCancelar.addActionListener(e -> dispose());

        // Agregar componentes
        add(lblNombre);
        add(txtNombre);
        add(lblPassword);
        add(txtPassword);
        add(btnAgregar);
        add(btnCancelar);

        setLocationRelativeTo(null);
    }
}
