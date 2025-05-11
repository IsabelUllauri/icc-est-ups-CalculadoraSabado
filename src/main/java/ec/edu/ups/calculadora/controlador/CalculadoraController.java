package ec.edu.ups.calculadora.controlador;
import ec.edu.ups.calculadora.modelo.Calculadora;
import ec.edu.ups.calculadora.vista.CalculadoraView;

import java.awt.event.*;


public class CalculadoraController implements ActionListener, ItemListener, WindowListener {

    private CalculadoraView calculadoraView;
    private Calculadora calculadora;

    public CalculadoraController(CalculadoraView calculadoraView, Calculadora calculadora){
        this.calculadoraView = calculadoraView;
        this.calculadora = calculadora;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }


    @Override
    public void itemStateChanged(ItemEvent e) {

    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
