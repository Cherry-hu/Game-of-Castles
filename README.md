# Game-of-Castles
Das Thema des Projektes ist die Strategiesimulation Game of Castles, welche an den Brettspielklassiker Risiko1 angelehnt ist. Das Spiel ist fur 2-4 Spieler und hat zum Ziel, ¨ alle Burgen zu erobern. Die Simulation spielt auf einer zweidimensionalen Karte, welche neben Gras und W¨aldern auch Gebirge und Wasser enth¨alt. Auf dieser Karte sind Burgen verschiedener K¨onigreiche verteilt und mit Pfaden untereinander verbunden.

Dokumentation:

Kanten bilden und überprüfen:

generateEdges() :Das Ziel ist es so wenig Überschneidungen zu haben wie möglich. Um das zu erreichen, wird zuerst für jede Burg der Abstand zu allen anderen Burgen berechnet. Diese werden nun absteigend sortiert. Nun werden nur die drei nächsten Burgen miteinander verbunden um dadurch möglich wenig Überschneidung zu bekommen. 

allNodesConnected() Grundsätzlich arbeitet die Methode mit der Nutzung von Flags. Es gibt zwei Schleifen, die äußere ist für die Iteration der Knoten, die innere für die Iteration der Kanten. Damit die äußere Schleife nicht abbricht, muss das Flag am Ende der inneren Schleife auf true gesetzt wurden sein. Um zu überprüfen,ob ein Knoten nun zu anderen Knoten verbunden ist, wird für jeden Knoten einmal alle Kanten mit
contains() auf Verfügbarkeit geprüft. Findet sich einen Treffer, wird das Flag auf true gesetzt und der Vorgang für den nächsten Knoten wird gestartet. Findet sich keine Kante, der den Knoten enthält,
bleibt das Flag auf false, die äußere Schleife wird verlassen und die Funktion gibt letztendlich false zurück. 
