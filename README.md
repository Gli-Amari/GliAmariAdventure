# GliAmariAdventure ![Java CI with Maven](https://github.com/Gli-Amari/GliAmariAdventure/workflows/Java%20CI%20with%20Maven/badge.svg) ![Maven Package](https://github.com/Gli-Amari/GliAmariAdventure/workflows/Maven%20Package/badge.svg)

### Trama del gioco
Bari, Lello è in procinto di partire per la guerra insieme al suo gruppo noto come “Gli Amari” formato da Lello, Frank, Giulio e Pier. Frank è un tipo molto riflessivo, responsabile ma con carisma e pesonalità. Pier è molto curioso tant’è che è in grado di porsi domande su qualsiasi cosa gli accada nella vita mentre Giulio, soprannominato spaccatutto, è dotato di forza e inteliggenza. Il connubbio perfetto. Tuttavia ogni tanto è necessario che spacchi qualcosa. A Casa Amari è arrivata una “cartolina” che chiama alle armi chiunque sia in grado di combattere. Una minaccia aliena proveniente dallo spazio sta per attaccare. Navi nemiche chiamate razziatori hanno intenzione di fare piazza pulita del pianeta Terra. Queste navi seguono gli ordini di quella principale nota come “In Amber Clad”. Numerose intemperie aspettano i nostri amari...

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
|    |      |-- ConceptClassDiagram
|    |      |        |-- ConceptClassDiagram.mdj
|    |      |-- ClassDiagram
|    |      |        |-- vista1.png
|    |      |        |-- vista2.png
|    |-- Report.md
|    |-- Copertina2.jpg
|    |-- Report del progetto.docx
|    |-- Report del progetto.pdf
|    |-- GitHubFlow.md
|-- dialog
|    |-- amari.txt
|    |-- galatone.txt
|    |-- soldato.txt
|    |-- ufficiale.txt
|–– img
|    |–– Copertina.jpg
|    |-- Logo.png
|–– lib
|    |–– flatlaf-2.2.jar
|--resource
|    |-- databases
|    |      |-- dbAmari.mv.db
|    |      |-- dbAmari.trace.db
|    |-- StrangerThings_Season1_Opening-IntroHD.wav
|    |-- Itwasagodday.wav
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
6. `.gitignore` specifica tutti i file che devono essere esclusi dal sistema di controllo versione.
7. `settings.xml` specifica la dipendenza per la creazione del package maven sul progetto
8. `resource/database` contiene i file binari su cui il jdbc di H2 lavora 
9. `resource/dialog` contiene tutti i dialoghi presenti in gioco
