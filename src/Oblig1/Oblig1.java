package Oblig1;

import java.lang.UnsupportedOperationException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1) throw new java.util.NoSuchElementException("a.length(" + a.length + ") < 1!");
        int sistaIndex = a.length - 1;
        int maxVarde = a[0];
        int sistaVarde = a[sistaIndex];
        for(int i=1; i < a.length; ++i) {
            if (a[i] >= maxVarde) {
                if (i == sistaIndex) {
                    if (sistaVarde > maxVarde) {
                        maxVarde = sistaVarde;
                    }
                }
                else{
                    maxVarde = a[i];
                }
            }
            else{
                a[i-1] = a[i];
                a[i] = maxVarde;
            }
        }
        return a[sistaIndex];
    }
    // Antal sammenligninger er:

    public static int ombyttinger(int[] a) {
        if (a.length < 1) throw new java.util.NoSuchElementException("a.length(" + a.length + ") < 1!");
        int ombyte = 0;
        int sistaIndex = a.length - 1;
        int maxVarde = a[0];
        int sistaVarde = a[sistaIndex];
        for(int i=1; i < a.length; ++i) {
            if (a[i] >= maxVarde) {
                if (i == sistaIndex) {
                    if (sistaVarde > maxVarde) {
                        maxVarde = sistaVarde;
                    }
                }
                else{
                    maxVarde = a[i];
                }
            }
            else{
                a[i-1] = a[i];
                a[i] = maxVarde;
                ombyte++;
            }
        }
        return ombyte;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int maxVarde = 0;
        int antalVarden = 0;

        for(int i=0; i < a.length; ++i){
            if(a.length == 0){
                antalVarden = 0;
            }
            else if (a[i] < maxVarde) throw new IllegalStateException("Tabellen är inte stigande");
            else{
                if(a[i] > maxVarde){
                    maxVarde = a[i];
                    antalVarden++;
                }
            }
        }
        return antalVarden;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0){
            return 0;
        }
        int antalVarden = 1;

        for(int i=1; i < a.length; ++i){
            boolean finnsTal = false;
            for(int j = 0; j < i; ++j){
                if (a[i] == a[j]){
                    finnsTal = true;
                    break;
                }
            }
            if(!finnsTal){
                antalVarden++;
            }
        }
        return antalVarden;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
