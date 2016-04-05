package Coding_Challenge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class GraphBuilder {
	private TreeMap<Date, HashSet<HashSet<String>>> sliding_window_map = new TreeMap<Date, HashSet<HashSet<String>>>();
	private HashMap<String, HashSet<Date>> nodes = new HashMap<String, HashSet<Date>>();
	private HashMap<HashSet<String>, HashSet<Date>> edge_list = new HashMap<HashSet<String>, HashSet<Date>>();
	private Date recent_time = null;
	private final int TIME_WINDOW = 60000;

	public void processTweet(String tweet) {
		TweetParser pt = new TweetParser(tweet);
		Date new_time = pt.getDate();
		ArrayList<String> ht = pt.getHashtags();
		if (new_time != null && ht.size()> 1) {
			if (recent_time== null || (new_time.getTime() - recent_time.getTime()) < TIME_WINDOW) {
				if(recent_time != null)
				{
					recent_time =new_time;
					deleteFromWindow(new_time);
				}
				else
				{
					recent_time =new_time;
				}
				addToWindow(recent_time, ht);
			} else if(recent_time.getTime() - new_time.getTime()< TIME_WINDOW){
				addToWindow(new_time, ht);
			}
		}
		
	}

	public void addToWindow(Date d, ArrayList<String> hashtags) {
		 
		int ht_size = hashtags.size();
			for (int i = 0; i < ht_size; i++) {
				for (int j = i + 1; j < ht_size; j++) {
					String h1 = hashtags.get(i);
					String h2 = hashtags.get(j);
					if(!h1.equals(h2)){
					HashSet<String> new_edge = new HashSet<String>();
					new_edge.add(h1);
					new_edge.add(h2);
					if (sliding_window_map.containsKey(d)) {
						HashSet<HashSet<String>> hs = sliding_window_map.get(d);
						if (!hs.contains(new_edge)) {
							hs.add(new_edge);
							sliding_window_map.put(d, hs);
						}
					}
					else
					{
					HashSet<HashSet<String>> hs = new HashSet<HashSet<String>>();
					hs.add(new_edge);
					sliding_window_map.put(d, hs);
					}
					HashSet<Date> edge_times = new HashSet<Date>();
					if (edge_list.containsKey(new_edge)) {
						edge_times = edge_list.get(new_edge);
					}
					edge_times.add(d);
					edge_list.put(new_edge, edge_times);
					
					
					HashSet<Date> ts = new HashSet<Date>();
					if (nodes.containsKey(h1)) {
						ts = nodes.get(h1);
					}
					ts.add(d);
					nodes.put(h1, ts);
					ts = new HashSet<Date>();
					if (nodes.containsKey(h2)) {
						ts = nodes.get(h2);
					}
					ts.add(d);
					nodes.put(h2, ts);
				}
				}
			}
	}

	public void deleteFromWindow(Date d) {
		Iterator<Entry<Date, HashSet<HashSet<String>>>> iter = sliding_window_map.entrySet().iterator();
		while(iter.hasNext())
		{
			Map.Entry<Date,HashSet<HashSet<String>>> entry = (Entry<Date, HashSet<HashSet<String>>>) iter.next();
			Date dt = entry.getKey();
			if(d.getTime()-dt.getTime()<TIME_WINDOW) break;
			else
			{
				HashSet<HashSet<String>> n = entry.getValue();
				
				for (HashSet<String> s : n) {
					if(edge_list.containsKey(s))
					{
						HashSet<Date> datl = edge_list.get(s);
						datl.remove(dt);
						if(datl.size() == 0) edge_list.remove(s);
					}
					Iterator<String> it = s.iterator();
					while(it.hasNext())
					{
					String hss=it.next();
					if(nodes.containsKey(hss))
					{
					HashSet<Date> ndat = nodes.get(hss);
					if(ndat.contains(dt)) ndat.remove(dt);
					if(ndat.size()==0){
						nodes.remove(hss);
					}
					}
					}
				}
			}
			iter.remove();
		}		
	}

	public String calculateDegree(FileWriter fw) {
		String result = "0.00";
		try {
			if(nodes.size()!=0)
			{
			double degree = 2 * (edge_list.size());
			double avg_deg = degree / (nodes.size());
			 result=String.format("%.2f",avg_deg);
			fw.append(result+"\n");
			}
			else
				fw.append(result+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
