package com.nikolaev.data.idea;

import java.util.ArrayList;

public class Wallet {

	private String wallet;
	private ArrayList<Worker> workers;
	private String currentHashRate;
	private String reportedHashRate;
	private String averageHashRate;

	public Wallet(String wallet, ArrayList<Worker> workers, String currentHashRate, String reportedHashRate,
			String averageHashRate) {
		this.wallet = wallet;
		this.workers = workers;
		this.currentHashRate = currentHashRate;
		this.reportedHashRate = reportedHashRate;
		this.averageHashRate = averageHashRate;
	}

	@Override
	public String toString() {
		return "Wallet [wallet=" + wallet + ", workers=" + workers + ", currentHashRate=" + currentHashRate
				+ ", reportedHashRate=" + reportedHashRate + ", averageHashRate=" + averageHashRate + "]";
	}

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
