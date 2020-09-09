package Oblig1;

import java.lang.UnsupportedOperationException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1) throw new java.util.NoSuchElementException("a.length(" + a.length + ") < 1!"); //Om tabellen har mindre än ett element så kastas ett avvik.
        int sistaIndex = a.length - 1; //Indexen på det sista elementet i tabellen är hela längden - 1.
        int maxVarde = a[0]; //Startar med ett maxvärde på index nummer 0 i tabellen.
        int sistaVarde = a[sistaIndex]; //Det sista värdet i tabellen ligger på den sista indexen.

        for(int i=1; i < a.length; ++i) { //Går igenom hela tabellen med en lökke.
            if (a[i] >= maxVarde) { //Om värdet på den indexen vi är på just nu i lökken är större eller samma som vårt maxvärde går vi in i den här if:en.
                if (i == sistaIndex) { //Om i är i slutet av tabellen, dvs på den sista indexen så går vi in i den här if:en.
                    if (sistaVarde > maxVarde) { //Om värdet som ligger i den sista indexen är större än vårt nuvarande maxvärde så sätter vi maxvärdet till detta värde.
                        maxVarde = sistaVarde;
                    }
                }
                else{ // Om det inte är den sista indexen så sätter vi maxvärdet till värdet i den nuvarande indexen.
                    maxVarde = a[i];
                }
            }
            else{ // Om värdet i den nuvarande indexen är mindre än vårt nuvarande maxvärde så sorterar vi så att det byter plats med vårt nuvarande maxvärde i tabellen.
                a[i-1] = a[i];
                a[i] = maxVarde;
            }
        }
        return a[sistaIndex]; //Returnerar värdet på den sista indexen i tabellen.
    }
    // Antal sammenligninger i en tabell med n värden startar vi först med n-1 sammenligningen, nästa omgång blir det n-2 sammenligninger osv.
    //Detta gör att vi kan använda oss av en generell benämning såsom n(n - 1)/2.

    public static int ombyttinger(int[] a) {
        if (a.length < 1) throw new java.util.NoSuchElementException("a.length(" + a.length + ") < 1!"); //Om tabellen är mindre än 1 element kastas ett avvik.
        int ombyte = 0; //En räknare som ska hålla koll på hur många gånger vi byter om på två värden.
        int sistaIndex = a.length - 1; //Den sista indexen i vår tabell.
        int maxVarde = a[0]; //Vårt maxvärde som vi ska uppdatera och sortera längst bak.
        int sistaVarde = a[sistaIndex]; //Värdet på indexen i tabellen.

        for(int i=1; i < a.length; ++i) { //Går igenom tabellen för att sortera.
            if (a[i] >= maxVarde) { //Samma som innan i uppgiften.
                if (i == sistaIndex) { //Samma som innan i uppgiften.
                    if (sistaVarde > maxVarde) { //Samma som innan i uppgiften.
                        maxVarde = sistaVarde;
                    }
                }
                else{ //Samma som innan i uppgiften
                    maxVarde = a[i];
                }
            }
            else{ //Samma som innan i uppgiften, men att vi här plussar på vår räknare som ska hålla koll på hur många ombyten vi gör i tabellen.
                a[i-1] = a[i];
                a[i] = maxVarde;
                ombyte++;
            }
        }
        return ombyte; //Returnerar antal ombyten.
    }

    // Det blir flest ombyttinger når en permutation från talet 1 till n har talen från högst till lägst i motsatt ordning. Skrivs generellt som n(n − 1)/2.
    //Det blir minst ombytningar när alla talen i permutasjonen ligger i stigande ordning, dvs 0.
    //Genomsnittet av ombytningar räknas mellan de två ytterpunkterna. Antingen så har vi 0 ombytningar eller så har vi n(n - 1)/2.
    //Om vi tar en random ombytning av alla möjliga kombinationer och kallar den för x, så kommer den motsatta ombytningen ha alla ombytningar x inte har.
    //Detta blir n(n - 1)/2 - x. Detta gör att de två motsatta kombinationerna ger genomsnittet n(n - 1)/4. Detta är resultatet på alla random ombytningar.

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int maxVarde = 0; //Sätter ett preliminärt maxvärde.
        int antalVarden = 0; //En räknare som ska räkna hur många olika värden det är i vår tabell.

        for(int i=0; i < a.length; ++i){ //Går igenom hela tabellen.
            if(a.length == 0){ //Om vår tabell har 0 element så returnerar räknaren att det är 0 värden i tabellen.
                antalVarden = 0;
            }
            else if (a[i] < maxVarde) throw new IllegalStateException("Tabellen är inte stigande"); //Om talen i tabellen inte är sorterade i stigande ordning så kastas en exception.
            else{ //Om tabellen är sorterad i stigande ordning så ökas maxvärdet efter varje iteration och räknaren uppdateras.
                if(a[i] > maxVarde){
                    maxVarde = a[i];
                    antalVarden++;
                }
            }
        }
        return antalVarden; //Returnerar antal olika värden i tabellen.
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0){ //Om tabellen är tom så returneras 0 då det är 0 värden i tabellen.
            return 0;
        }
        int antalVarden = 1; //Sätter vår preliminära räknare av värden till 1 då det är minst 1 värde om inte tabellen är tom.

        for(int i=1; i < a.length; ++i){ //Går igenom hela tabellen med två for-lökker.
            boolean finnsTal = false; //En variabel för att hålla reda på om vårt tal redan finns i vår jämförelse av tal.
            for(int j = 0; j < i; ++j){ //Går igenom och jämför talen i "i" och "j" mot varandra för att undvika dubletter.
                if (a[i] == a[j]){ //Om värdet i indexen i "i" är det samma som i indexen i "j" så sätter vi vår booleanvariabel till sann och hoppar ut av vår inre lökke.
                    finnsTal = true;
                    break;
                }
            }
            if(!finnsTal){ //När vi har gått igenom vår inre lökke så kollar vi om variabeln finnsTal är falsk. Om så så plussar vi på vår räknare och försätter med den yttre lökken.
                antalVarden++;
            }
        }
        return antalVarden; //Returnerar antal olika värden i tabellen.
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {


        /*
        int left = 0;
        int right = a.length -1;

        while (left < right){
            while (a[left]%2 == 0 && left < right)
                left++;
            while (a[right]%2 == 1 && left < right)
                right--;
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }*/
        /*int countEven = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]%2 == 0){
                countEven++;
            }
        }
        int i = 0;
        int j = i+1;
        while (i != countEven){
            if (a[i]%2 == 0){
                i++;
                j = i + 1;
            }else if (a[i]%2 == 1 && j < a.length){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }*/
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
