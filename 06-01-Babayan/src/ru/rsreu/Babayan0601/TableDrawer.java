package ru.rsreu.Babayan0601;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class TableDrawer {
	private TableDrawer() {
	}

	private static void drawHeader() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		System.out.printf("%1$-7s|%2$-10s|%3$-11s\n", resourcer.getString("message.number"),
				resourcer.getString("message.author"), resourcer.getString("message.discipline"));

	}

	private static void drawBody(Object[] objects) {
		for (int i = 0; i < objects.length; i++) {
			System.out.print(objects[i].toString() + "\n");
		}
	}

	public static void drawTable(Object[] objects) {
		drawHeader();
		drawBody(objects);
	}

}
