package restApiLearning;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class TEST {

	public static void main(String[] args) {
		JustPlayed list = new JustPlayed(4);
		list.addMusic("user1", "S1");
		list.addMusic("user1", "S2");
		list.addMusic("user1", "S3");
		list.addMusic("user2", "S1");
		list.addMusic("user2", "S2");
		list.addMusic("user2", "S3");
		System.out.println(list.getJustPlayed("user1"));
		list.addMusic("user1", "S4");
		System.out.println(list.getJustPlayed("user1"));
		list.addMusic("user1", "S2");
		System.out.println(list.getJustPlayed("user1"));
		list.addMusic("user1", "S1");
		System.out.println(list.getJustPlayed("user1"));
		list.addMusic("user2", "S4");
		System.out.println(list.getJustPlayed("user2"));

	}

}

class JustPlayed {
	private int capacity;
	private Map<String, LinkedList<String>> saved;

	public JustPlayed(int capacity) {
		this.capacity = capacity;
		saved = new LinkedHashMap<>();
	}

	public void addMusic(String user, String song) {
		LinkedList<String> playlist = saved.getOrDefault(user, new LinkedList<>());
		playlist.remove(song);
		playlist.addLast(song);
		if (playlist.size() == capacity) {
			playlist.removeFirst();
		}
		saved.put(user, playlist);
	}

	public void removeUser(String user) {
		saved.remove(user);
	}

	public String getJustPlayed(String user) {
		LinkedList<String> playlist = saved.get(user);
		if (playlist == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (String song : playlist) {
			sb.append(song).append(",");
		}

		return sb.substring(0, sb.length() - 1);
	}
}
