# IBAN-Validierung
Kompetenzen: Array, Schleifen, Berechnungen, Algorithmen, Ein-Ausgabe

## Aufgabenstellung
Eine fiktive Bundesregierung möchte den Staatsbürgern Geld auf ihr Konto überweisen. Dazu
muss von jedem Staatsbürger die Kontonummer (IBAN) erfasst werden. Da sich Personen jedoch
hin und wieder vertippen, möchte man auf Nummer sicher gehen und eine Validierung
implementieren lassen. Dabei soll die erfasste IBAN-Nummer auf Korrektheit überprüft werden.
Überprüfung von IBAN

Jedes Bankkonto (in der EU) hat eine Kontonummer, welche IBAN genannt wird. IBAN steht für
internationale Bankkontonummer und ist über eine sogenannte ISO-Norm (ISO 13616-1:2020)
standardisiert. Damit ist geregelt, dass die IBAN in vielen Ländern gleich aufgebaut ist.
Weitere Informationen findet man unter https://de.wikipedia.org/wiki/Internationale_Bankkonton
ummer

In Österreich beginnt die IBAN mit AT (für Austria) und ist 20 Zeichen lang. Die IBAN-Nummer ist
auf jeder Bankomatkarte abgebildet und wird verwendet, wenn einem Empfänger Geld
überwiesen werden soll. Hierzu braucht man die IBAN-Nummer des Empfängers. Damit man
etwa aus Versehen, z.B.: aufgrund von einem Tippfehler nicht Geld auf ein falsches Konto
überweist, beinhaltet die IBAN eine Prüfsumme. Mithilfe von diesem wird überprüft, ob die
gesamte Kontonummer korrekt ist.

Es soll nun ein Programm geschrieben werden, welches die Prüfsumme validiert (überprüft).
