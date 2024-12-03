package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAgregar extends JButton {
    public BotonAgregar(String texto) {
        super(texto);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PanelAgregarUsuario().setVisible(true);
            }
        });
    }
}
