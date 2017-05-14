import java.util.*;
class Logger{
  Map<String,Integer> log;
  public Logger(){
    log=new HashMap<String,Integer>();
  }
  public boolean shouldPrintMessage(int timestamp,String msg){
    if(log.containsKey(msg)){
      if(timestamp-log.get(msg)>=10){
        log.put(msg,timestamp);
        return true;
      }else{
        log.put(msg,timestamp);
        return false;
      }
    }
    log.put(msg,timestamp);
    return true;
  }
}
public class LoggerRateLimiter{
  public static void main(String[] args){
    Logger logger = new Logger();

    // logging string "foo" at timestamp 1
    System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true;
    // logging string "bar" at timestamp 2
    System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;
    // logging string "foo" at timestamp 3
    System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;
    // logging string "bar" at timestamp 8
    System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;
    // logging string "foo" at timestamp 10
    System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;
    // logging string "foo" at timestamp 11
    System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;

  }
}
