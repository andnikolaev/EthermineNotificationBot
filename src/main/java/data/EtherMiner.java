package data;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import data.exceptions.LoadFailExceptiojn;
import data.idea.Wallet;


public class EtherMiner {

  private Document getHtmlPageWallet(String ethWallet) throws IOException {
    String url_get_page = "http://ethermine.org/miners/" + ethWallet;
    return Jsoup.connect(url_get_page).get();
  }
  
  public Wallet getWalletInfo(String ethWallet) throws LoadFailExceptiojn {
    Wallet returnWallet = null;
    
    try {
      Document htmlPageWallet = getHtmlPageWallet(ethWallet);
      System.out.println(htmlPageWallet.toString());
      returnWallet = new Wallet(ethWallet);
      returnWallet.setCurrentHashRate(htmlPageWallet.getElementsByAttributeValue("data-original-title", "This is the hashrate as reported by your miner to the pool.").val());
      return returnWallet;
    } catch (IOException e) {
      throw new LoadFailExceptiojn(e.getMessage());
    }
    
    
  }
  
  

}
