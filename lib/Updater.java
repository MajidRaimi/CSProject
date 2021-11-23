package lib;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Updater extends Main {

    public static void pullRequest() {

        try {

            new ProcessBuilder("cmd", "/c", "git pull origin master").inheritIO().start().waitFor();
            

        } catch (IOException | InterruptedException ex) {
        }

    }

    public static void addRequest() {

        try {

            new ProcessBuilder("cmd", "/c", "git add Database.csv").inheritIO().start().waitFor();
            
        } catch (IOException | InterruptedException ex) {
        }

    }

    public static void commitRequest() {

        Date now = new Date();

        try {

            new ProcessBuilder("cmd", "/c", "git commit -m \"" + now.toString() + "\"").inheritIO().start().waitFor();
            
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void pushRequest() {

        try {

            new ProcessBuilder("cmd", "/c", "git push origin master ").inheritIO().start().waitFor();
            
        } catch (IOException | InterruptedException ex) {
        }

    }

    public static void updateRequest() {

        addRequest();
        commitRequest();
        pullRequest();

    }

}
