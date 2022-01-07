package org.azzouz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MyEvents implements ActionListener {
    private final MyForm mf;

    public MyEvents(MyForm mf) {
        this.mf = mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == mf.getAjouterButton()) {


            var nom = mf.getNomTextField().getText();
            var genre = mf.getGenreButtonGroup().getSelection().getActionCommand();

            if (nom.isEmpty() ) {
                JOptionPane.showMessageDialog(mf, " Entrez votre ", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }

            var personne = new Personne(nom, genre);
            try {
                MyDatabase.getInstance().ajouter(personne);
                System.out.println("successfuly add in Database"+personne.getNom());

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
}
