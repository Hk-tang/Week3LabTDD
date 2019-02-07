package cmput402.tdd;

import java.util.ArrayList;
import java.util.HashMap;

import cmput402.tdd.service.Search;

public class Utility {

	public HashMap<String, Float>  countAverageScore(Search search){
		HashMap<String, ArrayList<Integer>> results = search.returnAll();
		HashMap<String, Float> averages = new HashMap<String, Float>();

		for (String player : results.keySet()) {
			float avg = (float) results.get(player).get(1)/results.get(player).get(0);
			averages.put(player, avg);
		}
		return averages;
	}
	
	public HashMap<String, Integer>  findTopScorer(Search search){
		HashMap<String, ArrayList<Integer>> results = search.returnAll();
		HashMap<String, Integer> topScorer = new HashMap<String, Integer>();

		for (String player : results.keySet()) {
			Integer score = results.get(player).get(1);
			if (topScorer.size() == 0) {
				topScorer.put(player, score);
			}
			else if (score > topScorer.get(topScorer.keySet().iterator().next())) {
				topScorer.clear();
				topScorer.put(player, score);
			}
		}
		return topScorer;
	}
	
}
