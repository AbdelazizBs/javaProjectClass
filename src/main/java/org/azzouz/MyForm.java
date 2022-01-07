package org.azzouz;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyForm extends JFrame {
    private final JRadioButton radio2;
    private final JRadioButton radio1;
    private final ButtonGroup group;
    private final JTextField n;



    JButton a = new JButton("Ajoutez");
    JButton l = new JButton("Liste");

//*****   Interface MyForm  *****//
    public MyForm() {
        this.setTitle("Examen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("Examen");
        JLabel jLabel1 = new JLabel("Nom :");
        JLabel jLabel2 = new JLabel("Genre :");

        n = new JTextField();



        group = new ButtonGroup();
        radio1 = new JRadioButton("Homme");
        radio2 = new JRadioButton("Femme");
        radio1.setActionCommand("Homme");
        radio2.setActionCommand("Femme");
        group.add(radio1);
        group.add(radio2);


        JPanel pbtn = new JPanel();
        pbtn.setLayout(new GridLayout(2, 4));
        pbtn.add(jLabel1, BorderLayout.LINE_START);
        pbtn.add(new JLabel());
        pbtn.add(new JLabel());
        pbtn.add(n);
        pbtn.add(jLabel2, BorderLayout.LINE_START);
        pbtn.add(new JLabel());
        pbtn.add(radio2);
        pbtn.add(radio1);


        JPanel pbtn1 = new JPanel();
        pbtn1.setLayout(new GridLayout(1, 6));
        pbtn1.add(new JLabel());
        pbtn1.add(new JLabel());
        pbtn1.add(new JLabel());
        pbtn1.add(new JLabel());
        pbtn1.add(l);
        pbtn1.add(a);
        Border border = BorderFactory.createTitledBorder("informations");
        pbtn.setBorder(border);


        Container contentPane = this.getContentPane();
        contentPane.add(pbtn, BorderLayout.CENTER);
        contentPane.add(jLabel, BorderLayout.NORTH);
        contentPane.add(pbtn1, BorderLayout.SOUTH);
        this.setSize(500, 200);
        this.setVisible(true);
        pack();
        show();


        ////****Evenement Class Externe****////
        a.addActionListener(new MyEvents(this));



        //****expression lambda ****///
        l.addActionListener(e -> new MyListe());
    }

    public static void main(String[] args) {

        new MyForm();

    }

    //****To use in MyEvents (actionPerformed --getSource-- ) when we click in ***////
    public JTextField getNomTextField() {
        return n ;
    }


    //****To use in MyEvents (actionPerformed --getSource-- ) when we click in ***////
    public ButtonGroup getGenreButtonGroup() {
        return group;
    }


    //****To use in MyEvents (actionPerformed --getSource-- ) when we click in ***////
    public JButton getAjouterButton() {
        return a ;
    }
}





