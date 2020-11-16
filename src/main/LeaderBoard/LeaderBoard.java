package main.LeaderBoard;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LeaderBoard {
    final private String path="src/main/LeaderBoard/LeaderBoard.csv";
    final private String tempFile = "src/main/LeaderBoard/temp.csv";
    String line = "";
    private static Scanner scanner;
    public String playerNames[]= new String[15];
    public String scores[] = new String[15];
    public String dates[] = new String[15];

    public LeaderBoard(){
        try {
            loadDatafromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadDatafromFile() throws FileNotFoundException {
        scanner = new Scanner(new File(path));
        scanner.useDelimiter("[,\n]");
        int i=0;
        Arrays.fill(playerNames,"-");
        Arrays.fill(dates,"-");
        Arrays.fill(scores,"-");

        while (scanner.hasNext()){
            playerNames[i] = scanner.next();
            dates[i] = scanner.next();
            scores[i] = scanner.next();
            i++;
        }
    }

    public void insertNewRecord(String newName, int newScore){
        File oldFile = new File(path);
        File newFile = new File(tempFile);
        String oldName;
        int oldScore;
        boolean isInserted = false;

        try{
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            scanner = new Scanner(new File(path));
            scanner.useDelimiter("[,\n]");

            while (scanner.hasNext()){
                oldName = scanner.next();
                oldScore = Integer.parseInt(scanner.next());
                if((newScore> oldScore) && !isInserted){
                    pw.println(newName+","+newScore);
                    pw.println(oldName+","+oldScore);
                    isInserted = true;
                }else{
                    pw.println(oldName+","+oldScore);
                }
            }
            if(!isInserted){
                pw.println(newName+","+newScore);
            }

            scanner.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(path);
            newFile.renameTo(dump);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
