# GliAmariAdventure ![Java CI with Maven](https://github.com/Gli-Amari/GliAmariAdventure/workflows/Java%20CI%20with%20Maven/badge.svg) ![Maven Package](https://github.com/Gli-Amari/GliAmariAdventure/workflows/Maven%20Package/badge.svg)

### Trama del gioco
Bari, Lello si risveglia a Casa Amari consapevole del fatto che affronterà un’altra noiosissima giornata universitaria insieme al suo gruppo composto da Frank, Pier e Giulio. Il primo è un tipo molto riflessivo, responsabile ma con carisma e pesonalità. Pier è molto curioso tant’è che è in grado di porsi domande su qualsiasi cosa gli accada nella vita mentre Giulio, soprannominato spaccatutto, è dotato di forza e inteliggenza. Il connubbio perfetto. Tuttavia ogni tanto è necessario che spacchi qualcosa. Questo gruppo molto affiatato rimarrà coinvolto in una guerra imminente a causa di una minaccia aliena e verrà spedito al fronte. Insieme cercheranno di sconfiggere la minaccia affrontando numerose intemperie.

### Informazioni del progetto
*Esame*: "Metodi Avanzati di Programmazione" 

*Università*: Università degli Studi di Bari Aldo Moro - Dipartimento di Informatica 

*Studenti*: Giulio Russo, Piersilvio Spicoli, Francesco Pio Scoglietti 

Per la documentazione fare riferimento a [Report.md](./doc/Report.md). La struttura della repository si presenta nel seguente modo:
```
|-- .github
|    |-- workflows
|    |      |-- maven.yml
|    |      |-- maven-publish.yml
|-- .vscode
|    |-- settings.json
|-- doc
|    |-- file
|    |      |-- ChiSiamo.txt
|    |      |-- HelpC.txt
|    |--diagrams
|    |      |-- mConcettuale.png
|    |      |-- mSoftware.png
|    |      |-- mPackages.png
|    |-- Report.md
|    |-- GitHubFlow.md
|–– img
|    |–– Copertina.jpg
|    |-- Logo.png
|–– lib
|    |–– flatlaf-2.2.jar
|--resource
|    |-- database
|    |      |-- dbAmari.mv.db
|    |      |-- dbAmari.trace.db
|    |-- dialog
|    |      |-- stanza15Galatone.txt
|    |      |-- stanza12Ufficiale.txt
|    |      |-- stanza11Pippo.txt
|    |      |-- stanza10Lanubile.txt
|    |      |-- stanza5Giulio.txt
|    |      |-- stanza4Frank.txt
|    |      |-- stanza3Pier.txt
|    |-- riferimenti tabelle
|    |      |-- npc.txt
|    |      |-- oggetti.txt
|    |      |-- stanza.txt
|    |-- StrangerThings_Season1_Opening-IntroHD.wav
|–– src
|    |–– main
|    |–– test
|-- target
|    |-- classes
|    |-- generated-source
|    |-- maven-archiver
|    |-- maven-status
|    |-- test-classes
|    |-- GliAmariAdventure-1.0-SNAPSHOT.jar
|-- .gitignore
|-- LICENSE
|-- pom.xml
|-- settings.xml
|-- README.md
```

di seguito spieghiamo le varie directory:
1. `.github/workflows/ingsw2122.yml` dettaglia le direttive per assicurare la continuous integration attraverso l’uso di GitHub Actions;
2. `doc` contiene i file utilizzati durante il funzionamento del gioco, la documentazione del progetto, i diagrammi ideati durante la fase progettuale e il reminder del github flow per lavorare in remoto al progetto
3. `img` contiene l'immagine di copertina del videogioco
4. `lib/flatlaf-2.2.jar` contiene l'impostazione del _look and feel_, caricata come dipendenza nel file `pom.xml` del progetto
5. `src` è la cartella principale del progetto, in cui scrivere tutto il codice dell’applicazione. In `main/` ci saranno i file sorgente e `test/` conterrà gli eventuali test di unità previsti.
6. `target` contiene il file `.jar` eseguibile da terminale
7. `.gitignore` specifica tutti i file che devono essere esclusi dal sistema di controllo versione.
8. `settings.xml` specifica la dipendenza per la creazione del package maven sul progetto
9. `resource/database` contiene i file binari su cui il jdbc di H2 lavora 
10. `resource/dialog` contiene tutti i dialoghi presenti in gioco
11. `resource/riferiemnti tabelle` contiene tutti i riferimenti alle tabelle presenti nel gioco
