import java.io.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
public class OS {
    // Read CSV File
    public static void readFile(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = "";

        while ((line = br.readLine()) != null) {
            String[] value = line.trim().split(",");

        }

    }
    // Write CSV File
    public static void writeFile(String path) throws IOException {
        PrintWriter pw = new PrintWriter(new File(path));
        StringBuilder sb = new StringBuilder();

        sb.append("Name");
        sb.append(",");
        sb.append("Age");
        sb.append("\n");

        pw.write(sb.toString());
        pw.close();
        System.out.println("Done");

    }
    // Clear Console 
    public static void clrscr() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }
    
    // TODO: Create A Function That Change Console Color 

    
    public static void changeConsoleColor(int number) {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "color " + number).inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void loadingBar(int time) throws Exception {

            time = time / 4 ; 
            for(int i = 0 ; i < time ; i++){
                System.out.print("Loading _----");
                TimeUnit.SECONDS.sleep((long) 0.9);
                clrscr();
                System.out.print("Loading -_---");
                TimeUnit.SECONDS.sleep((long) 0.9);
                clrscr();
                System.out.print("Loading --_--");
                TimeUnit.SECONDS.sleep((long) 0.9);
                clrscr();
                System.out.print("Loading ---_-");
                TimeUnit.SECONDS.sleep((long) 0.9);
                clrscr();
                System.out.print("Loading ----_");
                clrscr();
            }

        }




    }



