package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.iut.mastermind.domain.proposition.Lettre.*;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position spécifiée en paramètre dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        for (int i = 0; i < essai.length(); i++) {
            position = i ;
            char charActuelle = essai.charAt(position);
            resultat.add(position, evaluationCaractere(charActuelle));
        }
    }

    // vrai si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        return resultat.stream()
                .allMatch(lettre -> lettre == PLACEE);
    }

	// méthode obligatoire - à ne pas supprimer
    public List<Lettre> lettresResultat() {
        return Collections.unmodifiableList(resultat);
    }

    // renvoie le statut du caractère (incorrect, mal placé, placé)
    private Lettre evaluationCaractere(char carCourant) {
        if (estPresent(carCourant)) {
            if(estPlace(carCourant)) {
                return PLACEE ;
            } else {
                return NON_PLACEE ;
            }
        } else {
            return INCORRECTE ;
        }
    }

    // vrai si le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        int i = motSecret.indexOf(carCourant);
        return i >= 0 ;
    }

    // vrai si le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        int i = motSecret.indexOf(carCourant) ;
        return i == position ;
    }
}
