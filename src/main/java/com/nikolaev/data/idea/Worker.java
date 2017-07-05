package com.nikolaev.data.idea;

public class Worker {
	private String name;
	private String reporHashrate;
	private String currentHashrate;
	private String averageHashrate;
	private String validShares;
	private String staleShares;
	private String invalidShares;
	private String lastSeen;

	public Worker(String name, String reporHashrate, String currentHashrate, String averageHashrate, String validShares,
			String staleShares, String invalidShares, String lastSeen) {
		this.name = name;
		this.reporHashrate = reporHashrate;
		this.currentHashrate = currentHashrate;
		this.averageHashrate = averageHashrate;
		this.validShares = validShares;
		this.staleShares = validShares;
		this.invalidShares = invalidShares;
		this.lastSeen = lastSeen;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", reporHashrate=" + reporHashrate + ", currentHashrate=" + currentHashrate
				+ ", averageHashrate=" + averageHashrate + ", validShares=" + validShares + ", staleShares="
				+ staleShares + ", invalidShares=" + invalidShares + ", lastSeen=" + lastSeen + "]";
	}

}
