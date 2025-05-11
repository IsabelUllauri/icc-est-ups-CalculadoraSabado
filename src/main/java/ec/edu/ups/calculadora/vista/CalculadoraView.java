package ec.edu.ups.calculadora.vista;
import ec.edu.ups.calculadora.modelo.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculadoraView extends Frame{
    private Panel panelGeneral;
    private Panel panelSuperior;
    private Panel panelIntermedio;
    private Panel panelInferior;

    private Label label1;
    private Label label2;
    private Label labelresultado;

    private TextField tf1;
    private TextField tf2;
    private TextField tfresultado;

    private Checkbox checkboxsuma;
    private Checkbox checkboxresta;
    private Checkbox checkboxmultiplicada;
    private Checkbox checkboxdivision;

    private Button botoncalcular;
    private Button botonlimpiar;


    private Calculadora calculadora;

    public CalculadoraView(){

        setTitle("Calculadora del Sabado");
        setSize(500,500);
        setLocationRelativeTo(null);

        calculadora = new Calculadora();

        panelGeneral = new Panel(new BorderLayout());

        panelSuperior = new Panel(new GridLayout(3,2));
        panelInferior = new Panel(new GridLayout(1,2));
        panelIntermedio = new Panel(new GridLayout(2,2));

        panelGeneral.add(panelSuperior, BorderLayout.NORTH);
        panelGeneral.add(panelIntermedio,BorderLayout.CENTER);
        panelGeneral.add(panelInferior, BorderLayout.SOUTH);

        //panel superior
        //creamos etiquetas
        label1 = new Label("numero 1: ");
        label2 = new Label("numero 2: ");
        labelresultado = new Label("resulatado: ");

        //cajas de texto
        tf1 = new TextField("0.00",10);
        tf2 = new TextField("0.00",10);
        tfresultado = new TextField("0.00",10);

        //tfresultado.setEditable(false);//no se puede editar
        tfresultado.setEnabled(false);

        //agregar al panel
        panelSuperior.add(label1);
        panelSuperior.add(tf1);

        panelSuperior.add(label2);
        panelSuperior.add(tf2);

        panelSuperior.add(labelresultado);
        panelSuperior.add(tfresultado);

        //panelintermedio
        checkboxsuma= new Checkbox("sumar", false);
        checkboxmultiplicada= new Checkbox("multiplicar", false);
        checkboxdivision= new Checkbox("dividir", false);
        checkboxresta= new Checkbox("restar", false);

        //al panel intermedio
        panelIntermedio.add(checkboxsuma);
        panelIntermedio.add(checkboxmultiplicada);
        panelIntermedio.add(checkboxdivision);
        panelIntermedio.add(checkboxresta);

        //panel inferior
        //creamos los dos botones
        botoncalcular = new Button("Calcular");
        botonlimpiar = new Button("Limpiar");

        //agregamos al panel
        panelInferior.add(botoncalcular);
        panelInferior.add(botonlimpiar);



        add(panelGeneral);
        setVisible(true);

        //listeners
        checkboxsuma.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarCheckbox((Checkbox) e.getSource());

            }
        });

        checkboxresta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarCheckbox((Checkbox) e.getSource());
            }
        });

        checkboxmultiplicada.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarCheckbox((Checkbox) e.getSource());
            }
        });

        checkboxdivision.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                validarCheckbox((Checkbox) e.getSource());
            }
        });

        botoncalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkboxsuma.getState() == true) {
                    sumar();
                } else if (checkboxresta.getState() == true) {
                    restar();
                } else if (checkboxmultiplicada.getState() == true) {
                    multiplicacion();
                } else if (checkboxdivision.getState() == true) {
                    division();
                }
            }
        });

        botonlimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("0.00");
                tf2.setText("0.00");
                tfresultado.setText("0.00");
                checkboxsuma.setState(false);
                checkboxmultiplicada.setState(false);
                checkboxdivision.setState(false);
                checkboxresta.setState(false);
            }
        });

    }


    public void sumar(){
        double valor1 = Double.parseDouble(tf1.getText());
        double valor2 = Double.parseDouble(tf2.getText());

        calculadora.setValor1(valor1);
        calculadora.setValor2(valor2);

        double resultado = calculadora.sumar();
        tfresultado.setText(String.valueOf(resultado));


    }

    public void restar(){
        double num1 = Double.parseDouble(tf1.getText());
        calculadora.setValor1(num1);
        double num2 = Double.parseDouble(tf2.getText());
        calculadora.setValor2(num2);

        double resultado = calculadora.restar();
        tfresultado.setText(String.valueOf(resultado));
    }

    public void multiplicacion(){
        double num1 = Double.parseDouble(tf1.getText());
        calculadora.setValor1(num1);
        double num2 = Double.parseDouble(tf2.getText());
        calculadora.setValor2(num2);
        double resultado = calculadora.multiplicar();
        tfresultado.setText(String.valueOf(resultado));
    }

    public void division() {
        double num1 = Double.parseDouble(tf1.getText());
        calculadora.setValor1(num1);
        double num2 = Double.parseDouble(tf2.getText());
        calculadora.setValor2(num2);

        if (num2 != 0) {
            double resultado = calculadora.dividir(); // asegúrate de tener este método en la clase Calculadora
            tfresultado.setText(String.valueOf(resultado));
        } else {
            tfresultado.setText("Error: División por cero");
        }
    }


    public void validarCheckbox(Checkbox checkbox) {
        if(checkbox.getState() == true && checkbox.getLabel().equalsIgnoreCase("Sumar")){
            checkboxresta.setState(false);
            checkboxdivision.setState(false);
            checkboxmultiplicada.setState(false);
        }

        if(checkbox.getState() == true && checkbox.getLabel().equalsIgnoreCase("Restar")){
            checkboxsuma.setState(false);
            checkboxdivision.setState(false);
            checkboxmultiplicada.setState(false);
        }

        if(checkbox.getState() == true && checkbox.getLabel().equalsIgnoreCase("Multiplicar")){
            checkboxsuma.setState(false);
            checkboxresta.setState(false);
            checkboxdivision.setState(false);
        }

        if(checkbox.getState() == true && checkbox.getLabel().equalsIgnoreCase("Dividir")){
            checkboxsuma.setState(false);
            checkboxresta.setState(false);
            checkboxmultiplicada.setState(false);
        }
    }


}
