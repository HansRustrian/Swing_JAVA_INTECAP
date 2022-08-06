package com.mycompany.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

//SE PUEDE EXTENDER Y CREAR UN METODO PARA QUE NO SE CREE EL OBJETO:
public class formulario extends JFrame{
    
    JTable tabla = new JTable();
    
    JScrollPane sp = new JScrollPane();
    
    JPanel p1 = new JPanel();
    
    public void crear(){
        setSize(800,400);
        setVisible(true);
        setTitle("Ejemplo");
        
        //ES PARA COLOCAR LAS LOCALIZACIONES RELATIVAS DENTRO DEL MAPA 
        //ES PARA UTILIZAR LAS COORDENADAS CORRECTAS EN EL MAPA
        setLocationRelativeTo(null);
        
        //PARA CERRAR LAS VENTANAS Y MATAR LAS EJECUCIONES EN MEMORIA SE USA ESTE CODIGO:
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //EL JPANEL SE USA PARA DARLE VIDA A TODO EL FONDO DE NUESTRO PANEL
        JPanel p1 = new JPanel();
        
        //ES PARA PODER UTILIZAR LAS COORDENADAS CORRECTAS EN EL MAPA
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        add(p1);
        
        JLabel l1 = new JLabel("Ingresa tu nombre");
        //setBounds nos sirve para dar la posicion de la etiqueta
        //COORDENADA EN X, COORDENADA EN Y, ANCHO Y ALTURA
        //X = POSICION DE LA ETIQUETA EN EJE X
        //Y = POSICION DE LA ETIQUETA EN EJE Y
        //LARGO = LARGO DE LA ETIQUETA DENTRO DEL JFRAME
        //ANCHO = ANCHO DE LA ETIQUETA DENTRO DEL JFRAME    
        l1.setBounds(30, 20, 150, 40);
        p1.add(l1);
        //La siguiente etiqueta es para darle color al texto anterior
        l1.setForeground(Color.LIGHT_GRAY);
        
        //JTEXTFIEL ES PARA CREAR CUADROS DE TEXTO DENTRO DE LA INTERFAZ
        JTextField t1 = new JTextField();
        t1.setBounds(190, 20, 150, 25);
        //t1.setText("Hola Yanik");
        p1.add(t1);
        System.out.println(t1.getText());
        
        JButton b1 = new JButton("Imprimir");
        b1.setBounds(350, 20, 120, 50);
        p1.add(b1);
        
        //Es para darle acciones a un boton
        ActionListener imprimir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println(t1.getText());
            }
        };
        
        b1.addActionListener(imprimir);
        
        
    }
    

    public static void main(String[] args) {
        //SI SE EXTIENDE DE JFRAME NO SE CREA EL OBJETO
        //JFrame f = new JFrame("Ejemplo");
        //Aqui se le puede dar nombre o como en la linea de arriba
        //f.setTitle("Ejemplo");
        //f.setSize(700, 400);
        //f.setVisible(true);
        
        //COMO EXTENDIMOS DE JFRAME SOLO LLAMAMOS AL METODO
        formulario f = new formulario();
        f.crear();
        
    }

}
