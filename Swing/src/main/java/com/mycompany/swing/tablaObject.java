package com.mycompany.swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.apache.commons.lang3.StringUtils;

public class tablaObject extends JFrame {

    //ATRIBUTOS
    JTable tabla = new JTable();
    JScrollPane sp = new JScrollPane();
    JPanel p1 = new JPanel();
    Object filas[][] = new Object[50][3];
    int x = 0;
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();

    private void crear() {

        setTitle("Mostrar Tablas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 600);
        setVisible(true);
        p1.setLayout(null);
        p1.setBackground(Color.CYAN);
        add(p1);

        JLabel l1 = new JLabel("Ingresa el Codigo");
        l1.setBounds(550, 20, 150, 40);
        p1.add(l1);
        l1.setForeground(Color.BLACK);

        JLabel l2 = new JLabel("Ingresa el Nombre");
        l2.setBounds(550, 60, 150, 40);
        l2.setForeground(Color.BLACK);
        p1.add(l2);

        JLabel l3 = new JLabel("Ingresa el Lugar");
        l3.setBounds(550, 100, 150, 40);
        l3.setForeground(Color.BLACK);
        p1.add(l3);

        //JTextField t1 = new JTextField();
        t1.setBounds(700, 30, 150, 25);
        p1.add(t1);
        System.out.println(t1.getText());

        //JTextField t2 = new JTextField();
        t2.setBounds(700, 70, 150, 25);
        p1.add(t2);
        System.out.println(t2.getText());

        //JTextField t3 = new JTextField();
        t3.setBounds(700, 110, 150, 25);
        p1.add(t3);
        System.out.println(t3.getText());

        JButton b1 = new JButton("Grabar");
        b1.setBounds(700, 150, 120, 50);
        p1.add(b1);

        ActionListener imprimir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                //SI NO ESTAN VACIOS LOS 3 CAMPOS PASA DE LO CONTRARIO MANDA MENSAJE DE ERROR
                if (!(t1.getText().equals("")) && !(t2.getText().equals("")) && !(t3.getText().equals(""))) {
                    grabar(Integer.parseInt(t1.getText()), t2.getText(), t3.getText());
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                } else {

                    //SE MANDA COMO MENSAJE DE ALERTA A LA PANTALLA QUE SE INGRESAN MAL LOS DATOS
                    JOptionPane.showMessageDialog(null, "Campos no pueden estar vacios");
                }
            }
        };

        b1.addActionListener(imprimir);

//        JButton b2 = new JButton("Limpiar");
//        b2.setBounds(700, 220, 120, 50);
//        p1.add(b2);
//
//        ActionListener eliminar = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                boolean salir = true;
//                int d = 0;
//                while (salir == false) {
//                    if (d == 50) {
//                        System.out.println("Tabla de registros limpia");
//                        salir = false;
//                    } else {
//                        filas[d][0] = null;
//                        filas[d][1] = null;
//                        filas[d][2] = null;
//                        d++;
//                        sp.setVisible(false);
//                        tabla();
//                    }
//                }
//            }
//        };
//
//        b2.addActionListener(eliminar);

    }

    private void tabla() {

        String columnas[] = {"CODIGO", "NOMBRE", "LUGAR"};
        //Object filas[][] = new Object[50][3];

        tabla = new JTable(filas, columnas);
        sp = new JScrollPane(tabla);
        sp.setBounds(10, 20, 500, 300);
        p1.add(sp);
        sp.setVisible(true);

    }

    private void grabar(int codigo, String nombre, String lugar) {

        if (x == 50) {
            System.out.println("Ya no se permiten mas registros");
        } else {
            filas[x][0] = codigo;
            filas[x][1] = nombre;
            filas[x][2] = lugar;
            x++;

            //PARA ACTUALIZAR LA TABLA SE HACE FALSO EL SCROLLPANE PARA QUE DESAPAREZCA
            sp.setVisible(false);
            //Y VOLVEMOS A LLAMAR A LA CREACION DE LA TABLA PARA QUE REFRESQUE LOS DATOS EN TABLA
            tabla();
        }
//        System.out.println(t1.getText());
//        System.out.println(t2.getText());
//        System.out.println(t3.getText());
    }

    public void ejecutar() {

        crear();
        tabla();
    }

    public static void main(String[] args) {
        tablaObject t = new tablaObject();
        t.ejecutar();
    }

}
