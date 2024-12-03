package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonVisualizar extends JButton {
    public BotonVisualizar(String texto) {
        super(texto);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PanelVisualizarProgreso().setVisible(true);
            }
        });
    }
}
