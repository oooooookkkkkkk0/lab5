package utils;

import java.util.Scanner;

public class Console {
    private static Scanner defScanner = new Scanner(System.in);

    public String readln() {
        //if (fileScanner != null) {
            //if (fileScanner.hasNext()) return fileScanner.nextLine();
            //fileScanner = null;
        //}
        return defScanner.nextLine();
    }

    public void println(Object obj) {
        System.out.println(obj);
    }
}
