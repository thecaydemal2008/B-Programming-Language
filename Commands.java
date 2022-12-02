public class Commands{

  protected static String[] commands = {"say","close"};
  
  public static String[] getCommands(){
    return commands;
  }
  public void close(){
    System.out.println("Closing...");
    System.exit(0);
  }
  public void say(String words){
    System.out.println(words);
  }
  
}