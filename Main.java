import java.util.Scanner;
import java.io.*;
import javax.swing.*;

class Main {

  public static void main(String[] args) {
    try {
      beginParsing("./MainFile.B+");
    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showDialogMessage();
    }
  }

  private static void beginParsing(String programFile) throws FileNotFoundException {

    FileInputStream fileInput = new FileInputStream(new File(programFile));
    Scanner fileReader = new Scanner(fileInput);
    String[] commands = Commands.getCommands();

    while (fileReader.hasNext()) {
      String[] words = fileReader.nextLine().split(" ");
      // String command = fileReader.next();
      // System.out.println(command);

      if (words[0].equalsIgnoreCase("say")) {
        System.out.println("\n");
        for (int i = 0; i < words.length; i++) {
          if (i == 0) {
            // Nothing because the command is whats stored in words[0] although this index
            // will be quite usefull later with parameters
          } else {
            System.out.print(words[i] + " ");
          }
        }
      } else if (words[0].equalsIgnoreCase("close")) {
        System.out.println("\n\n" + "Closing...");
        System.exit(0);
      } else if (words[0].equalsIgnoreCase("call")) {
        main(words);
      } else if (words[0].equalsIgnoreCase("compare-equal")) {
        System.out.println("");
        System.out.println(Integer.parseInt(words[1]) == Integer.parseInt(words[2]));
      } else if (words[0].equalsIgnoreCase("compare-1-less-than-2")) {
        System.out.println("");
        System.out.println(Integer.parseInt(words[1]) < Integer.parseInt(words[2]));
      } else if (words[0].equalsIgnoreCase("compare-2-less-than-1")) {
        System.out.println("");
        System.out.println(Integer.parseInt(words[1]) > Integer.parseInt(words[2]));
      } else if (words[0].equalsIgnoreCase("say-err")){
        System.out.println("\n");
        for (int i = 0; i < words.length; i++) {
          if (i == 0) {
            // Nothing because the command is whats stored in words[0] although this index
            // will be quite usefull later with parameters
          } else {
            System.err.print((words[i] + " "));
          }
        }
      }
    }
  }
}