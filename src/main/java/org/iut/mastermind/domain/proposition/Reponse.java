package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.iut.mastermind.domain.proposition.Lettre.*;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position spécifiée en paramètre dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé

    public boolean compare(String essai) {
        if (essai.length() != motSecret.length()) {
            return false;
        }

        resultat.clear();

        List<Character> lettresRestantes = new ArrayList<>();
        for (int i = 0; i < essai.length(); i++) {
            resultat.add(INCORRECTE);
            if (essai.charAt(i) == motSecret.charAt(i)) {
                resultat.set(i, PLACEE);
            } else {
                lettresRestantes.add(motSecret.charAt(i));
            }
        }

        for (int i = 0; i < essai.length(); i++) {
            if (resultat.get(i) != PLACEE) {
                char caractere = essai.charAt(i);

                if (lettresRestantes.contains(caractere)) {
                    resultat.set(i, NON_PLACEE);
                    lettresRestantes.remove(Character.valueOf(caractere));
                }
            }
        }

        return true;
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
}
