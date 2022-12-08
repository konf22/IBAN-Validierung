package org.campus02;

import java.util.Arrays;
import java.util.Scanner;

public class IbanValidationDemo {

    public static void main(String[] args) {
        // ibans: "AT611904300234573201", "AT022050302101023600";
        // iban einlesen
        String ibanToCheck = getIbanFromCommandLine();

        // beginne Validierung
        IbanValidationService ibanValidationService = new IbanValidationService(ibanToCheck);
        System.out.println("Eingabe von IBAN:");
        System.out.println(ibanToCheck);
        System.out.println();
        System.out.println("Ländercode: " + ibanValidationService.getCountryCode() + " (" + ibanValidationService.getCountryCodeNumber() + ")");
        System.out.println("Prüfsumme: " + ibanValidationService.getCheckSum());
        System.out.println("Kontonummer: " + ibanValidationService.getAccountNumber());
        System.out.println("Prüfzahl: " + ibanValidationService.getFullCode());
        System.out.println("Zahlenwert: " + Arrays.toString(ibanValidationService.buildArray()));
        System.out.println("Errechnete Prüfsumme: " + ibanValidationService.calcCheckSum());
        System.out.println();
        String message = ibanValidationService.isIbanCorrect() ? "korrekt!" : "NICHT korrekt!";
        System.out.println("Der eingegebene IBAN ist " + message);

        // (ibanValidationService.isIbanCorrect() ? "korrekt!" : "NICHT korrekt!")
        // ibanValidationService.isIbanCorrect() => prüft, ob iban korrekt ist (return value: true oder false)
        // nach ? => wird ausgeführt bei true
        // nach : => wird ausgeführt bei false

        // entspricht folgender if-Bedingung
//        String message = "";
//        if (ibanValidationService.isIbanCorrect()) {
//            message = "korrekt!";
//        } else {
//            message = "NICHT korrekt!";
//        }
    }

    private static String getIbanFromCommandLine() {
        System.out.println("Geben Sie einen IBAN zur Überprüfung ein:");
        Scanner scanner = new Scanner(System.in);
        String ibanToCheck = scanner.next();
        System.out.println();
        return ibanToCheck;
    }
}
