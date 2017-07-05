package data.idea;

import java.util.ArrayList;

import org.glassfish.grizzly.threadpool.AbstractThreadPool.Worker;

public class Wallet {
  
  private String wallet;
  private ArrayList<Worker> workers;
  private String currentHashRate;
  private String reportedHashRate;
  private String averageHashRate;
  
  public String getCurrentHashRate() {
    return currentHashRate;
  }

  public void setCurrentHashRate(String currentHashRate) {
    this.currentHashRate = currentHashRate;
  }

  public String getReportedHashRate() {
    return reportedHashRate;
  }

  public void setReportedHashRate(String reportedHashRate) {
    this.reportedHashRate = reportedHashRate;
  }

  public String getAverageHashRate() {
    return averageHashRate;
  }

  public void setAverageHashRate(String averageHashRate) {
    this.averageHashRate = averageHashRate;
  }

  public Wallet(String wallet) {
    this.wallet = wallet;
    this.workers = new ArrayList<>();
  }

  public Wallet(String wallet, ArrayList<Worker> workers) {
    this.wallet = wallet;
    this.workers = workers;
  }
  
  public void addWorker(Worker newWorker) {
    workers.add(newWorker);
  }

  public ArrayList<Worker> getWorkers() {
    return workers;
  }

  public String getWallet() {
    return wallet;
  }
  
  

}
