package com.edu.appswbd.gui;

import javax.swing.*;
import java.awt.event.*;
import com.edu.appwbd.control.control;

public class GUI {

    private JFrame principal;

    public void GUI(){

        JFrame f = new JFrame("Convertidor a JSon");
        f.setSize(700,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        generarGUI(f);
        f.setLayout(null);

        JOptionPane.showMessageDialog(null, "Para archivo XML\n Copie y pegue su texto XML \n--------------------------\n Para objetos Java\n Ingrese 3 palabras separadas con una coma entre si.");

    }

    private void generarGUI(JFrame f){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        final JTextArea text1 = new JTextArea(2000, 40);
        text1.setBounds(10,10,300,400);
        //  Posicion X, Y, Ando, Largo
        final JTextArea text2 = new JTextArea(2000, 40);
        text2.setBounds(400, 10, 300, 400);

        JButton conv = new JButton("Convertir");
        conv.setBounds(310, 160, 90, 30);



        final JComboBox caja = new JComboBox();
        caja.addItem("XML");
        caja.addItem("JAVA");
        caja.setBounds(10, 420, 90, 30);

        panel.add(text1);
        panel.add(conv);
        panel.add(text2);
        panel.setVisible(true);
        panel.add(caja);

        f.getContentPane().add(panel);

        conv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                com.edu.appwbd.control.control c = new com.edu.appwbd.control.control();
                text2.setText(c.control(String.valueOf(text1.getText()), String.valueOf(caja.getSelectedItem())));

                control con = new control();
                if(String.valueOf(caja.getSelectedItem()).equals("XML")){

                    if (!con.getWorksXML()) {

                        JOptionPane.showMessageDialog(null, "Por favor verifiique si su texto XML ingresado es correcto");

                    }

                }else{
                    if (!con.getWorksJAVA()) {
                        JOptionPane.showMessageDialog(null, "Por favor verifiique si su texto JAVA ingresado es correcto");
                        JOptionPane.showMessageDialog(null, "Para objetos Java\n Ingrese 3 palabras separadas con una coma entre si");
                    }

                }
            }
        });

        f.setVisible(true);
    }


}
