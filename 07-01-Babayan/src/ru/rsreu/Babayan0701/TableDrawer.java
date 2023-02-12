package ru.rsreu.Babayan0701;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class TableDrawer {
	private TableDrawer() {
	}

	
	private static String drawHeader() {
		StringBuilder result = new StringBuilder();
		Resourcer resourcer = ProjectResourcer.getInstance();
		result.append(String.format("%1$-7s|%2$-10s|%3$-11s\n", resourcer.getString("message.number"),
				resourcer.getString("message.author"), resourcer.getString("message.discipline")));
		return result.toString();

	}

	private static String drawBody(Object... objects) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < objects.length; i++) {
			result.append(objects[i].toString()).append("\n");
		}
		return result.toString();
	}

	public static String drawTable(Object... objects) {
		StringBuilder result = new StringBuilder();
		result.append(drawHeader());
		result.append(drawBody(objects));
		return result.toString();
	}
}
