package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Perhaps this you go into a separate file
class PingURL implements Callable<String> {
  String url;
  PingURL(String url) {
    this.url = url;
  }
  @Override
  public String call() throws Exception {
    return "";
  }
}

public class ParallelPinger {
  
  public static List<String> getStatusFromAllServers() throws Exception{
    return null;
  }

  public static void main(String[] args) throws Exception {
    long timeStart = System.nanoTime();
    List<String> results = getStatusFromAllServers();
    for(String r: results){
      System.out.println(r);
    }
    long timeEnd = System.nanoTime();
    long total = (timeEnd - timeStart) / 1_000_000;
    System.out.println("Time to check URLS: " + total + "ms.");
  }
}
