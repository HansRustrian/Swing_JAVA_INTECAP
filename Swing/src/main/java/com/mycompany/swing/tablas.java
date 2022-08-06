package com.mycompany.swing;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class tablas extends JFrame {

    //PARA DECLARAR UNA TABLA 
    JTable tabla = new JTable();
    
    //PARA USAR UN SCROLL QUE NOS PERMITA MOVERNOS ENTRE DATOS
    JScrollPane sp = new JScrollPane();
    
    //SI SE DECLARA EL PANEL EN EL METODO GLOBAL SE PUEDE USAR EN TODOS LOS
    //METODOS INTERNOS, PERO SI SE CREA DENTRO DE UN METODO ESPECIFICO NO SE
    //PUEDE USAR EN OTRO METODO, POR ESO P1 LO CREAMOS GLOBAL
    JPanel p1 = new JPanel();

    private void crear() {
        
        //AQUI SE DAN LOS VALORES AL PANEL EN GENERAL
        setTitle("Mostrar Tablas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 400);
        setVisible(true);
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);
        add(p1);

    }

    private void tabla() {
        
        //AQUI CREAMOS LOS VALORES QUE LE DAREMOS AL PANEL SEGUN LAS COLUMNAS QUE NECESITAMOS
        String columnas[] = {"NOMBRE", "APELLIDO", "TELEFONO"};
        Object filas[][] = {{"Erick", "Baeza", 77777777}, {"Blanca", "Recinos", 12547801},
        {"Jorge", "Garcia", 11111111}, {"Noemi", "Giron", 10101011}, {"Juan", "Rowe", 75151151}};

        //LE PASAMOS LA INFORMACION AL PANEL PARA QUE SE DESPLIEGUE LA INFORMACION
        tabla = new JTable(filas, columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(10, 20, 500, 300);
        p1.add(sp);
        sp.setVisible(true);

    }

    public void ejecutar() {
        
        //CREAMOS EL METODO QUE EJECUTE EN ORDEN QUE NECESITEMOS LA INFORMACION
        crear();
        tabla();
    }

    public static void main(String[] args) {
        tablas t = new tablas();
        t.ejecutar();
    }

}
