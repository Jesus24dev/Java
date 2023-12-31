
package calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculadora extends JFrame {
    
    private JPanel panel;
    private JLabel fondo, titulo, primerSub, segundoSub;
    private JTextField num1, num2;
    private JButton suma, resta, multiplicar, dividir, borrar;
    private JTextArea resultado;
    
    public Calculadora(){
        setSize(500, 500);
        setTitle("Calculadora");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        componentes();
    }
            
    private void componentes(){
        crearPanel();
        creaEtiquetas();
        creaCampos();
        creaBotones();
        mostrarResultado();
        agregaFondo();
    }
    
    private void crearPanel(){
        panel = new JPanel();
        
        panel.setLayout(null);
        getContentPane().add(panel);
    }
    
    private void creaEtiquetas(){
        fondo = new JLabel();
        titulo = new JLabel();
        primerSub = new JLabel();
        segundoSub = new JLabel();
        
        titulo.setText("Calculadora");
        titulo.setFont(new Font("System", Font.ITALIC,32));
        titulo.setBounds(150,10,180,40);
        titulo.setForeground(Color.WHITE);
        panel.add(titulo);
        
        primerSub.setText("Ingrese el primer numero");
        primerSub.setFont(new Font("System", Font.BOLD,16));
        primerSub.setBounds(10,40,200,40);
        primerSub.setForeground(Color.WHITE);
        panel.add(primerSub);
        
        segundoSub.setText("Ingrese el segundo numero");
        segundoSub.setFont(new Font("System", Font.BOLD,16));
        segundoSub.setBounds(10,100,210,40);
        segundoSub.setForeground(Color.WHITE);
        panel.add(segundoSub);
         
    }
    
    private void creaCampos(){
        num1 = new JTextField();
        num2 = new JTextField();
        
        num1.setBounds(10, 80, 100, 20);
        num2.setBounds(10, 140, 100, 20);
        
        panel.add(num1);
        panel.add(num2);
        
    }
    
    private void creaBotones(){
        suma = new JButton();
        suma.setText("Sumar");
        suma.setBounds(280, 250, 80, 40);
        suma.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(suma);
        
        resta = new JButton();
        resta.setText("Restar");
        resta.setBounds(280, 300, 80, 40);
        resta.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(resta);
        
        multiplicar = new JButton();
        multiplicar.setText("Multiplicar");
        multiplicar.setBounds(370, 250, 100, 40);
        multiplicar.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(multiplicar);
        
        dividir = new JButton();
        dividir.setText("Dividir");
        dividir.setBounds(370, 300, 100, 40);
        dividir.setFont(new Font("arial", Font.BOLD, 12));
        panel.add(dividir);
        
        borrar = new JButton();
        borrar.setText("Borrar");
        borrar.setBounds(10, 380, 80, 40);
        borrar.setFont(new Font("arial", Font.BOLD, 12));

        panel.add(borrar);
        
        try{
        funciones();
        } catch(NumberFormatException e){
            System.out.println("Error");
        }
    }
    
   
    
    private void mostrarResultado(){
        resultado = new JTextArea();
        resultado.setBounds(280, 70, 150, 80);
        resultado.setFont(new Font("Cooper", Font.BOLD, 12));
        resultado.setForeground(Color.BLACK);
        resultado.setEditable(false);
        
        panel.add(resultado);
    }
    
    private void agregaFondo(){
        ImageIcon fondoImg = new ImageIcon("background.jpg");
        fondo.setIcon(new ImageIcon(fondoImg.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        fondo.setBounds(0,0,500,500);
        panel.add(fondo);
    }
    
    private void funciones(){
        funcionSuma();
        funcionResta();
        funcionMultiplicar();
        funcionDividir();
        funcionBorrar();
    }
    
    private void funcionSuma(){
        
        ActionListener sumaResultado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double resultadoSuma = Double.parseDouble(num1.getText()) + Double.parseDouble(num2.getText());
                    resultado.setText("El resultado de la\nsuma es: \n\n"+resultadoSuma);
                }catch(NumberFormatException error){
                    resultado.setText("Ingrese solo numeros");
                }
            }
        };
        suma.addActionListener(sumaResultado);
    }
    
    private void funcionResta(){
        
        ActionListener restaResultado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double resultadoResta = Double.parseDouble(num1.getText()) - Double.parseDouble(num2.getText());
                    resultado.setText("El resultado de la\nresta es: \n\n"+resultadoResta);
                }catch(NumberFormatException error){
                    resultado.setText("Ingrese solo numeros");
                }
            }
        };
        resta.addActionListener(restaResultado);
    }
    
    private void funcionMultiplicar(){
        
        ActionListener multiplicarResultado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double resultadoMultiplicar = Double.parseDouble(num1.getText()) * Double.parseDouble(num2.getText());
                    resultado.setText("El resultado de la\nmultiplicacion es: \n\n"+resultadoMultiplicar);
                }catch(NumberFormatException error){
                    resultado.setText("Ingrese solo numeros");
                }
            }
        };
        multiplicar.addActionListener(multiplicarResultado);
    }
    
    private void funcionDividir(){
        
        ActionListener dividirResultado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double resultadoDividir = Double.parseDouble(num1.getText()) / Double.parseDouble(num2.getText());
                    resultado.setText("El resultado de la\ndivision es: \n\n"+resultadoDividir);
                }catch(NumberFormatException error){
                    resultado.setText("Ingrese solo numeros");
                }
            }
        };
        dividir.addActionListener(dividirResultado);
    }
    
    private void funcionBorrar(){
        ActionListener borrarDatos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.setText(" ");
                num2.setText(" ");
                resultado.setText(" ");
            }
        };
        borrar.addActionListener(borrarDatos);
    }
}
