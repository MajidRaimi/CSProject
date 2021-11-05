package lib;

import java.io.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class OS extends Main{
    // Read CSV File
    public static void readFile(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = "";

        try {
            int firstLine = 0;
            while ((line = br.readLine()) != null) {
                if (firstLine == 0) {
                    firstLine++;
                    continue;
                }
                String[] value = line.trim().split(",");

                User addedUser = new User(value[0], value[1], value[2], Double.parseDouble(value[3]), value[4],
                        Integer.parseInt(value[5]));

                arrUsers.add(addedUser);

            }
        } catch (Exception e) {
            System.out.println("There Is No Data");
        }

    }

    // Write CSV File
    public static void writeFile(String path) throws IOException {
        PrintWriter pw = new PrintWriter(new File(path));
        StringBuilder sb = new StringBuilder();

        sb.append("First Name");
        sb.append(",");
        sb.append("Second Name");
        sb.append(",");
        sb.append("Last Name");
        sb.append(",");
        sb.append("Balance");
        sb.append(",");
        sb.append("Card Number");
        sb.append(",");
        sb.append("PIN Number");

        sb.append("\n");

        for (int i = 0; i < Main.arrUsers.size(); i++) {
            sb.append(Main.arrUsers.get(i).getFName());
            sb.append(",");
            sb.append(Main.arrUsers.get(i).getSName());
            sb.append(",");
            sb.append(Main.arrUsers.get(i).getLName());
            sb.append(",");
            sb.append(Main.arrUsers.get(i).getBalance());
            sb.append(",");
            sb.append(Main.arrUsers.get(i).getCardNumber());
            sb.append(",");
            sb.append(Main.arrUsers.get(i).getCardPIN());
            sb.append("\n");
        }

        pw.write(sb.toString());
        pw.close();

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

    public static void changeConsoleColor(int number) {
        // Change Console Color
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "color " + number).inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void loadingBar(int time) throws Exception {

        time = time / 4;
        for (int i = 0; i < time; i++) {
            System.out.print("Loading .");
            TimeUnit.SECONDS.sleep(1);
            clrscr();
            System.out.print("Loading ..");
            TimeUnit.SECONDS.sleep(1);
            clrscr();
            System.out.print("Loading ...");
            TimeUnit.SECONDS.sleep(1);
            clrscr();
            System.out.print("Loading ....");
            TimeUnit.SECONDS.sleep(1);
            clrscr();
            System.out.print("Loading .....");
            clrscr();
        }

    }

}
