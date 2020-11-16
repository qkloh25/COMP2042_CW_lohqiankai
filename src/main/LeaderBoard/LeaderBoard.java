package main.LeaderBoard;

import java.io.*;
import java.util.Scanner;

public class LeaderBoard {
    final private String path="src/main/LeaderBoard/LeaderBoard.csv";
    final private String tempFile = "src/main/LeaderBoard/temp.csv";
    String line = "";

    private static Scanner scanner;

    public LeaderBoard(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                String[] value = line.split(",");
                System.out.println(value[1]);

            }
        }
        catch(IOException e){
            e.printStackTrace();
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
