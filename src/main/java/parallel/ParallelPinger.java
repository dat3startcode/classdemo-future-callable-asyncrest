package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Perhaps this should go into a separate file
class PingURL implements Callable<String> {
  String url;
  PingURL(String url) {
    this.url = url;
  }
  @Override
  public String call() throws Exception {
    //Implement the method here that reguests the url and returns the appropriate response.
    return "";
  }
}

public class ParallelPinger {
    /*
    STEPS
    1. Implement the call method in PingURL to actually ping the url
    2. Create and executor service
    3. Get the list of URLs to contact from the static method in SequentalPinger
    4. Make a List of <Future<String>>
    5. Create your Callables, and start them via a method on the executor and add the returned future to the list
    6. Call a "relevant" method on all your futures to get the response, and to the List you eventually will return
    */
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
