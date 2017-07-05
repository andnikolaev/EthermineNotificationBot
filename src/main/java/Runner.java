

import data.EtherMiner;
import data.exceptions.LoadFailExceptiojn;
import data.idea.Wallet;

public class Runner {

	public static void main(String[] args) {
	  
		EtherMiner etherMiner = new EtherMiner();
		try {
      Wallet wallet = etherMiner.getWalletInfo("58801ebec6685d0d5461a30999fa5df91549a59e");
      System.out.println(wallet.getCurrentHashRate());
    } catch (LoadFailExceptiojn e) {
      e.printStackTrace();
    }
		
		
		
		
	}

}
