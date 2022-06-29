# GliAmariAdventure ![Java CI with Maven](https://github.com/Gli-Amari/GliAmariAdventure/workflows/Java%20CI%20with%20Maven/badge.svg) ![Maven Package](https://github.com/Gli-Amari/GliAmariAdventure/workflows/Maven%20Package/badge.svg)

### Trama del gioco
continuare...

### Informazioni del progetto
*Esame*: "Metodi Avanzati di Programmazione" 

*Università*: Università degli Studi di Bari Aldo Moro - Dipartimento di Informatica 

*Studenti*: Giulio Russo, Piersilvio Spicoli, Francesco Pio Scoglietti 

Per la documentazione fare riferimento a [Report.md](./doc/Report.md). La struttura della repository si presenta nel seguente modo:
```
|-- .github
|    |-- workflows
|    |      |-- maven.yml
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
|–– lib
|    |–– flatlaf-2.2.jar
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
