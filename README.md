<div align="center">

# MOF6809

### Simulateur du Microprocesseur Motorola 6809

[![Java](https://img.shields.io/badge/Java-8+-007396?style=flat-square&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20Linux%20%7C%20macOS-lightgrey?style=flat-square)](/)
[![License](https://img.shields.io/badge/License-Academic-blue?style=flat-square)](/)

---

**Application graphique de simulation permettant l'écriture, la compilation et l'exécution de programmes en assembleur 6809 avec visualisation en temps réel des registres et de la mémoire.**

[Fonctionnalites](#fonctionnalites) | [Installation](#installation) | [Documentation](#documentation) | [Equipe](#equipe)

</div>

---

## A propos

MOF6809 est un simulateur educatif du microprocesseur **Motorola 6809**, developpe en Java avec une interface graphique Swing. Ce projet permet aux etudiants et passionnes d'informatique de comprendre le fonctionnement interne d'un processeur 8 bits sans necessiter de materiel physique.

Le Motorola 6809, lance en 1978, est considere comme l'un des processeurs 8 bits les plus avances de son epoque, offrant des caracteristiques habituellement reservees aux architectures 16 bits.

---

## Fonctionnalites

### Editeur de Code
- Zone de texte integree pour la saisie de code assembleur
- Conversion automatique en majuscules
- Support du mot-cle `END` pour marquer la fin du programme

### Compilateur
- Analyse lexicale et syntaxique complete
- Detection et affichage des erreurs avec numero de ligne
- Generation du code machine hexadecimal

### Simulation Memoire
| Zone | Plage d'adresses | Taille | Type |
|------|------------------|--------|------|
| ROM | `$FC00` - `$FFFF` | 1024 octets | Lecture seule |
| RAM | `$0000` - `$04FF` | 1280 octets | Lecture/Ecriture |

### Registres Simules
| Registre | Taille | Description |
|----------|--------|-------------|
| A | 8 bits | Accumulateur principal |
| B | 8 bits | Accumulateur secondaire |
| D | 16 bits | Double accumulateur (A:B) |
| X | 16 bits | Registre d'index X |
| Y | 16 bits | Registre d'index Y |
| S | 16 bits | Pointeur de pile systeme |
| U | 16 bits | Pointeur de pile utilisateur |
| PC | 16 bits | Compteur ordinal |
| DP | 8 bits | Page directe |
| CCR | 8 bits | Registre de condition |

### Drapeaux CCR
| Bit | Nom | Description |
|-----|-----|-------------|
| C | Carry | Retenue sortante |
| V | Overflow | Depassement signe |
| Z | Zero | Resultat nul |
| N | Negative | Resultat negatif |
| H | Half Carry | Demi-retenue |

### Modes d'Execution
- **Execute All** : Execution complete du programme
- **Step By Step** : Execution instruction par instruction pour le debogage

---

## Installation

### Prerequis
- Java Development Kit (JDK) 8 ou superieur
- IDE Java recommande : Eclipse, IntelliJ IDEA ou NetBeans

### Compilation et Execution

```bash
# Cloner le repository
git clone https://github.com/OsKing00/MOF6809.git

# Acceder au repertoire
cd MOF6809

# Compiler le projet
javac -d bin src/Main/*.java src/graphicUserInterface/*.java src/programMethodes/*.java

# Executer l'application
java -cp bin Main.MainClass
```

---

## Structure du Projet

```
MOF6809/
|-- src/
|   |-- module-info.java
|   |-- Main/
|   |   +-- MainClass.java              # Point d'entree
|   |-- graphicUserInterface/
|   |   +-- GUIClass.java               # Interface graphique (1121 lignes)
|   +-- programMethodes/
|       |-- Decodage.java               # Conversion opcodes (281 lignes)
|       |-- Erreurs.java                # Validation syntaxique (376 lignes)
|       |-- Instructions.java           # Parsing assembleur (130 lignes)
|       |-- Memoire.java                # Gestion RAM/ROM (100 lignes)
|       |-- Registres.java              # Calcul PC (25 lignes)
|       +-- UAL.java                    # Unite Arithmetique et Logique (2907 lignes)
|-- resources/
|   +-- images/
|       |-- Icon.png
|       +-- Logo.png
|-- rapport/
|   +-- rapport.tex                     # Documentation technique LaTeX
+-- README.md
```

---

## Documentation

### Modes d'Adressage Supportes

| Mode | Symbole | Exemple | Description |
|------|---------|---------|-------------|
| Immediat | `#` | `LDA #$99` | Valeur directe dans l'instruction |
| Direct | `<` | `LDA <$20` | Adresse sur 1 octet (page zero) |
| Etendu | `>` ou rien | `LDA $1234` | Adresse complete sur 2 octets |
| Inherent | - | `CLRA` | Pas d'operande |

### Jeu d'Instructions

#### Instructions de Chargement
```asm
LDA  #$xx           ; Charger A avec valeur 8 bits
LDB  #$xx           ; Charger B avec valeur 8 bits
LDD  #$xxxx         ; Charger D avec valeur 16 bits
LDS  #$xxxx         ; Charger S avec valeur 16 bits
LDU  #$xxxx         ; Charger U avec valeur 16 bits
LDX  #$xxxx         ; Charger X avec valeur 16 bits
LDY  #$xxxx         ; Charger Y avec valeur 16 bits
```

#### Instructions Arithmetiques
```asm
ADDA #$xx           ; A = A + valeur
ADDB #$xx           ; B = B + valeur
ADDD #$xxxx         ; D = D + valeur
SUBA #$xx           ; A = A - valeur
SUBB #$xx           ; B = B - valeur
SUBD #$xxxx         ; D = D - valeur
MUL                 ; D = A x B
```

#### Instructions Logiques
```asm
ANDA #$xx           ; A = A AND valeur
ANDB #$xx           ; B = B AND valeur
ORA  #$xx           ; A = A OR valeur
ORB  #$xx           ; B = B OR valeur
```

#### Instructions de Comparaison
```asm
CMPA #$xx           ; Comparer A avec valeur
CMPB #$xx           ; Comparer B avec valeur
CMPD #$xxxx         ; Comparer D avec valeur
CMPX #$xxxx         ; Comparer X avec valeur
CMPY #$xxxx         ; Comparer Y avec valeur
CMPS #$xxxx         ; Comparer S avec valeur
CMPU #$xxxx         ; Comparer U avec valeur
```

#### Instructions de Stockage
```asm
STA  >$xxxx         ; Stocker A en memoire
STB  >$xxxx         ; Stocker B en memoire
STD  >$xxxx         ; Stocker D en memoire
STS  >$xxxx         ; Stocker S en memoire
STU  >$xxxx         ; Stocker U en memoire
STX  >$xxxx         ; Stocker X en memoire
STY  >$xxxx         ; Stocker Y en memoire
```

#### Instructions de Transfert
```asm
TFR  A,B            ; Transferer A vers B
TFR  B,A            ; Transferer B vers A
EXG  A,B            ; Echanger A et B
```

#### Instructions Inherentes
```asm
ABX                 ; X = X + B
CLRA                ; A = 0
CLRB                ; B = 0
DECA                ; A = A - 1
DECB                ; B = B - 1
INCA                ; A = A + 1
INCB                ; B = B + 1
NOP                 ; Aucune operation
```

#### Instructions de Pile
```asm
PSHS                ; Empiler sur pile S
PSHU                ; Empiler sur pile U
PULS                ; Depiler de pile S
PULU                ; Depiler de pile U
```

### Exemple de Programme

```asm
LDA  #$10
LDB  #$20
ADDA #$05
TFR  A,B
MUL
STD  >$0100
END
```

**Explication :**
1. Charge la valeur `$10` (16) dans A
2. Charge la valeur `$20` (32) dans B
3. Ajoute `$05` (5) a A, resultat : A = `$15` (21)
4. Transfere A vers B, resultat : B = `$15` (21)
5. Multiplie A par B, resultat : D = `$01C9` (441)
6. Stocke D a l'adresse `$0100`

---

## Limitations Connues

- Mode d'adressage indexe non implemente
- Instructions de branchement (BEQ, BNE, BRA) non supportees
- Pas de gestion des interruptions
- Jeu d'instructions partiel (environ 40% des 59 instructions du 6809)

---

## Technologies

| Composant | Technologie |
|-----------|-------------|
| Langage | Java 8+ |
| Interface | Java Swing |
| Architecture | Procedurale / Facade |
| Documentation | LaTeX |

---

## Equipe

| Membre | Role |
|--------|------|
| Mohammed ABDELKHALEK | Developpement |
| Mohamed AOULICHAK | Developpement |
| Oussama AIT MENDIL | Developpement |
| Fouad AYYAD | Developpement |

---

## Licence

Ce projet a ete realise dans un cadre universitaire a des fins educatives.

---

<div align="center">

**Faculte des Sciences et Techniques de Settat**

Universite Hassan Premier

Annee Academique 2025-2026

</div>
