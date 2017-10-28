package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Package {

    public static final ArrayList<String> games = new ArrayList<>();
    public static void addGame(){
        games.add("League of Legends");
        games.add("Heroes of Newerth");
        games.add("Blade & Soul");
        games.add("Vindictus");
        games.add("Point Blank");
        games.add("FIFA Online 3");
    }

    public static ArrayList<Integer> addPackage(int[] array){
        ArrayList<Integer> p = new ArrayList<>();
        for(int i : array){
            p.add(i);
        }
        return p;
    }

    public static class LoLPackage{

        public static final String currency = "RP";
        public static final int rp235 = 235;
        public static final int rp475 = 475;
        public static final int rp800 = 800;
        public static final int rp1635 = 1635;
        public static final int rp3330 = 3330;
        public static final int[] rps = {rp235, rp475, rp800, rp1635, rp3330};
        public static final ArrayList<Integer> rpList = addPackage(rps);

    }

    public static class HonPackage{
        public static final String currency = "Gold Coin";
        public static final int gc300 = 300;
        public static final int gc660 = 660;
        public static final int gc1025 = 1025;
        public static final int gc1750 = 1750;
        public static final int gc2900 = 2900;
        public static final int gc3700 = 3700;
        public static final int[] gcs = {gc300, gc660, gc1025, gc1750, gc2900, gc3700};
        public static final ArrayList<Integer> gcList = addPackage(gcs);
    }

    public static class BnsPackage{
        public static final String currency = "Diamonds";
        public static final int dm10000 = 10000;
        public static final int dm15000 = 15000;
        public static final int dm30000 = 30000;
        public static final int dm50000 = 50000;
        public static final int dm100000 = 100000;
        public static final int dm300000 = 300000;
        public static final int[] dms = {dm10000, dm15000, dm30000, dm50000, dm100000, dm300000};
        public static final ArrayList<Integer> dmList = addPackage(dms);
    }

    public static class PBPackage{
        public static final String currency = "PB Cash";
        public static final int pbc10000 = 10000;
        public static final int pbc15000 = 15000;
        public static final int pbc30000 = 30000;
        public static final int pbc50000 = 50000;
        public static final int pbc100000 = 100000;
        public static final int[] pbcs = {pbc10000, pbc15000, pbc30000, pbc50000, pbc100000};
        public static final ArrayList<Integer> pbList = addPackage(pbcs);
    }

    public static class VinPackage{
        public static final String currency = "NX";
        public static final int nx225 = 225;
        public static final int nx300 = 300;
        public static final int nx450 = 450;
        public static final int nx800 = 800;
        public static final int nx1650 = 1650;
        public static final int nx3600 = 3600;
        public static final int[] nxs = {nx225, nx300, nx450, nx800, nx1650, nx3600};
        public static final ArrayList<Integer> nxList = addPackage(nxs);
    }

    public static class FIFAPackage{
        public static final String curerncy = "FO Cash";
        public static final int fo10000 = 10000;
        public static final int fo15000 = 15000;
        public static final int fo30000 = 30000;
        public static final int fo50000 = 50000;
        public static final int fo100000 = 100000;
        public static final int fo300000 = 300000;
        public static final int[] fos = {fo10000, fo15000, fo30000, fo50000, fo100000, fo300000};
        public static final ArrayList<Integer> foList = addPackage(fos);
    }
}
