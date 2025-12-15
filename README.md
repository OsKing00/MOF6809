MOF6809: Une simulation du Microprocesseur Motorola 6809

PRÉSENTATION DU PROJET
----------------------
MOF6809 est un simulateur graphique pour le microprocesseur Motorola 6809
développé en Java. Il permet aux utilisateurs d'écrire du code Assembleur, de
le compiler et de l'exécuter soit en continu, soit étape par étape. L'application
visualise l'état interne du processeur, incluant les registres, les drapeaux
(CCR), la RAM et la ROM.

AUTEURS
-------
Mohammed ABDELKHALEK
Mohamed AOULICHAK
Oussama AIT MENDIL
Fouad AYYAD

Projet Universitaire

=============================================================================
                              FONCTIONNALITÉS
=============================================================================
- **Éditeur de Code** : Zone de texte intégrée pour écrire les mnémoniques Assembleur.
- **Compilateur** : Analyse lexicale et syntaxique pour convertir l'Assembleur en Code Machine.
- **Mémoire Visuelle** : 
    - Visualisation de la RAM (Lecture/Écriture).
    - Visualisation de la ROM (Lecture Seule, stocke le programme compilé).
- **Tableau de Bord des Registres** : Affichage en temps réel de :
    - Accumulateurs (A, B, D).
    - Registres d'Index (X, Y).
    - Pointeurs de Pile (S, U).
    - Compteur Ordinal (PC).
    - Page Directe (DP).
- **Registre de Condition (CCR)** : Affichage bit par bit des drapeaux (H, N, Z, V, C).
- **Modes d'Exécution** :
    - "Execute All" (Tout Exécuter) : Exécute le programme entier en une fois.
    - "Step By Step" (Pas à Pas) : Exécute une instruction à la fois pour le débogage.

=============================================================================
                         PRÉREQUIS ET CONFIGURATION
=============================================================================
PRÉREQUIS :
- Java Development Kit (JDK) 8 ou supérieur.
- Un IDE Java (Eclipse, IntelliJ, NetBeans) ou une Interface en Ligne de Commande.

INSTALLATION :
1. Décompressez le dossier du projet.
2. Assurez-vous que la structure du code source est maintenue :
   /src
     /Main
     /graphicUserInterface
     /programMethodes
3. Note sur les Images : Le code fait référence à des chemins d'images locaux 
   (ex: "Iconn6809.png", "UAL.png"). Assurez-vous que ces images sont placées 
   dans le bon répertoire ou mettez à jour les chemins dans 'GUIClass.java' 
   avant l'exécution.

COMMENT EXÉCUTER :
1. Compilez le projet.
2. Exécutez la classe principale : `Main.MainClass`.

=============================================================================
                          GUIDE D'UTILISATION
=============================================================================
1. Lancez l'application.
2. Dans la "Fenêtre de Code" (Côté droit), saisissez votre code Assembleur.
   (Voir "Instructions Supportées" ci-dessous).
3. Cliquez sur [Compile]. 
   - En cas de succès, les OpCodes apparaîtront dans le tableau ROM.
   - Si des erreurs existent, vérifiez la "Zone d'Erreur" en bas à droite.
4. Cliquez sur [Execute All] pour exécuter le programme immédiatement.
   OU
   Cliquez sur [Step By Step] pour voir les registres se mettre à jour ligne par ligne.
5. Utilisez [Reset] pour remettre les registres à zéro ou [Clear All] pour effacer la zone de code.

=============================================================================
                        INSTRUCTIONS SUPPORTÉES
=============================================================================
Cette version du simulateur se concentre principalement sur le Mode d'Adressage 
IMMÉDIAT (indiqué par le symbole '#').

Mnémoniques Supportés :

1. INSTRUCTIONS DE CHARGEMENT (LOAD) :
   - LDA  #$xx      (Charger l'Accumulateur A - 8 bits)
   - LDB  #$xx      (Charger l'Accumulateur B - 8 bits)
   - LDD  #$xxxx    (Charger le Double Accumulateur D - 16 bits)
   - LDS  #$xxxx    (Charger le Pointeur de Pile S - 16 bits)
   - LDU  #$xxxx    (Charger le Pointeur de Pile Utilisateur U - 16 bits)
   - LDX  #$xxxx    (Charger le Registre d'Index X - 16 bits)
   - LDY  #$xxxx    (Charger le Registre d'Index Y - 16 bits)

2. INSTRUCTIONS ARITHMÉTIQUES :
   - ADDA #$xx      (Ajouter à l'Accumulateur A)
   - ADDB #$xx      (Ajouter à l'Accumulateur B)
   - ADDD #$xxxx    (Ajouter au Double Accumulateur D)
   - SUBA #$xx      (Soustraire de l'Accumulateur A)
   - SUBB #$xx      (Soustraire de l'Accumulateur B)
   - SUBD #$xxxx    (Soustraire du Double Accumulateur D)

* Note : Les valeurs doivent être au format Hexadécimal (ex: $10, $FF, $10CE).

=============================================================================
                          STRUCTURE DU PROJET
=============================================================================
Le code source est organisé en trois paquets principaux :

1. package Main
   - MainClass.java : Le point d'entrée de l'application.

2. package graphicUserInterface
   - GUIClass.java : Gère la JFrame, les JTables, les Boutons et tous les 
     composants visuels utilisant Java Swing. Gère les entrées utilisateurs 
     et affiche les résultats.

3. package programMethodes
   - Memoire.java : Simule les tableaux RAM et ROM.
   - Decodage.java : Gère la conversion Hex vers Int et le mapping des OpCodes.
   - Instructions.java : Analyse le texte d'entrée (Sépare Mnémonique vs Opérande).
   - Erreurs.java : Valide la syntaxe et la taille des opérandes avant exécution.
   - UAL.java : (Unité Arithmétique et Logique) Effectue les calculs et met à 
     jour les drapeaux CCR (Retenue, Débordement, Zéro, Négatif, etc.).
   - Registres.java : Gère l'incrémentation du Compteur Ordinal (PC).

=============================================================================
                             LIMITATIONS
=============================================================================
En raison des contraintes de temps du projet, ce simulateur supporte actuellement 
exclusivement le Mode d'Adressage Immédiat. Les modes Direct, Étendu et Indexé 
sont structurellement préparés mais pas encore entièrement implémentés dans la 
logique de l'interface utilisateur.
=============================================================================
