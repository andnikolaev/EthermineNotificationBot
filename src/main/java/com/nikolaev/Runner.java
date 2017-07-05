package com.nikolaev;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.nikolaev.data.idea.Wallet;
import com.nikolaev.data.idea.Worker;

public class Runner {

	public static Wallet mainMethod() {

		// EtherMiner etherMiner = new EtherMiner();
		Wallet wallet = null;
		try {
			String waletName = "d11639b82d0ff5f636252bc41392ccf7656c6fcd";
			String url_get_page = "http://ethermine.org/miners/" + waletName;
			// Jsoup.connect(url_get_page).get();

			Document htmlPageWallet = Jsoup.connect(url_get_page).userAgent(
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.get();
			// Для удобства только элемент home смотрим
			Element newsHeadlines = htmlPageWallet.getElementById("home");
			System.out.println(newsHeadlines.toString());
			// Наши мегахэши дергаем
			Elements test = newsHeadlines.getElementsByClass("just_span");
			for (Element element : test) {
				System.out.println(element.text());
			}

			Element worker = htmlPageWallet.getElementById("workers");
			Elements workers = worker.children().get(1).select("tr");

			ArrayList<Worker> workersList = new ArrayList<Worker>();

			for (Element element : workers) {
				Elements worker_info = element.select("td");
				Worker worker2 = new Worker(worker_info.get(0).text(), worker_info.get(1).text(),
						worker_info.get(2).text(), worker_info.get(3).text(), worker_info.get(4).text(),
						worker_info.get(5).text(), worker_info.get(6).text(), worker_info.get(7).text());
				workersList.add(worker2);
			}
			System.out.println(workersList.toString());
			wallet = new Wallet(waletName, workersList, test.get(0).text(), test.get(1).text(), test.get(2).text());
			return wallet;
			// System.out.println(wallet);
			// TimerTask asd = new Timer
			// Timer asd = new Timer();

			// System.out.println(newsHeadlines.getElementsByClass("just_span"));

			// Wallet wallet =
			// etherMiner.getWalletInfo("64d1c0dda5d63664fe4b461feceb698ee5ae9fb6");
			// System.out.println(wallet.getCurrentHashRate());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

}
