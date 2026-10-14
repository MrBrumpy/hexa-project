package org.iut.mastermind.domain.partie;

import java.util.Objects;

public record Joueur(String nom) {

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Joueur) {
            return Objects.equals(nom, ((Joueur) o).nom);
        }
        return false ;
    }

}
