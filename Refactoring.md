# Refactoring

## Joueur
- Remplacement de la comparaison des noms avec `==` par `Objects.equals()` pour comparer correctement le contenu des chaînes de caractères.

## Partie
- Modification de la méthode `reprendre()` pour prendre en compte le nombre d'essais lors de la reprise d'une partie.
- Ajout d'une vérification de l'état de la partie dans `tourDeJeu()` pour empêcher de jouer après sa fin.

## Reponse
- Vérification de la longueur de la proposition avant de la comparer au mot secret.
- Gestion des occurrences des lettres répétées pour éviter de compter plusieurs fois une même occurrence.
- Suppression des méthodes `evaluationCaractere()`, `estPresent()` et `estPlace()`, remplacées par une comparaison en deux étapes : lettres bien placées, puis lettres mal placées.

## MotSecret
- Modification de `compareProposition()` pour retourner `null` lorsque la comparaison échoue, notamment lorsque les longueurs des mots sont différentes.