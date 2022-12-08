package org.campus02;

import java.util.Arrays;
import java.util.Scanner;

public class IbanValidationService {
    private String iBan;
    private int calculatedCheckSum;

    public IbanValidationService(String iBan) {
        this.iBan = iBan;
        this.calculatedCheckSum = -1;
    }

    /**
     * liefert die ersten beiden Zeichen des iBan's retour
     *
     * @return ländercode
     */
    public String getCountryCode() {
        return iBan.substring(0, 2);
    }

    /**
     * lese die zeichen an position 2 und 3 aus => Checksumme als String
     * convertiere String to int
     *
     * @return Checksumme
     */
    public int getCheckSum() {
        String part = iBan.substring(2, 4);
//        return Integer.valueOf(part); => ist eine Möglichkeit
        return Integer.parseInt(part); // zweite Möglichkeit
    }

    /**
     * lese Kontonummer aus
     *
     * @return Kontonummer
     */
    public String getAccountNumber() {
        return iBan.substring(4);
    }

    /**
     * Umwandlung des Ländercodes
     *
     * @return Ländercode in Zahlen (als String)
     */
    public String getCountryCodeNumber() {
        String countryCode = getCountryCode();
        int firstCountryCodePart = countryCode.charAt(0);
        int secondCountryCodePart = countryCode.charAt(1);
        return (firstCountryCodePart - 55) + "" + (secondCountryCodePart - 55) + "00";
    }

    /**
     * kombiniere AccountNumber mit CountryCodeNumber
     *
     * @return kombinierte Werte
     */
    public String getFullCode() {
        return getAccountNumber() + getCountryCodeNumber();
    }

    /**
     * Wandle fullCode in Zahlenwerte um
     * @return array von Zahlenwerten abgeleitet von fullCode
     */
    public int[] buildArray() {
        String fullCode = getFullCode();
        int[] values = new int[fullCode.length()];
        for (int i = 0; i < fullCode.length(); i++) {
             values[i] = fullCode.charAt(i) - 48;
        }
        return values;
    }

    /**
     * berechnet die Checksumme
     * (vorgang siehe Angabe)
     *
     * @return errechnete Checksumme
     */
    public int calcCheckSum() {
        int helper = 0;
        int[] numbersForChecksum = buildArray();
        for (int number : numbersForChecksum) {
            helper = ((helper * 10) + number) % 97;
        }
        calculatedCheckSum = 98 - helper;
        return calculatedCheckSum;
    }

    /**
     * prüft, ob der iban korrekt ist
     * @return true, wenn Checksummen überein stimmen
     */
    public boolean isIbanCorrect() {
        return getCheckSum() == calculatedCheckSum;
    }
}
