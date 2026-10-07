package org.iut.mastermind.domain.partie;

public record Joueur(String nom) {

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Joueur) {
            return nom ==  ((Joueur) o).nom ;
        }
        return false ;
    }

}
