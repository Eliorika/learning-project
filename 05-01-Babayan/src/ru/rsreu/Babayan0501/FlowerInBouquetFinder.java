package ru.rsreu.Babayan0501;

import java.util.Arrays;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Babayan0501.Flowers.AbstractFlower;

public class FlowerInBouquetFinder {
	private AbstractFlower[] arrayBody;
	private float cost;
	private boolean ribbonPresence;
	private boolean coverPresence;

	public FlowerInBouquetFinder(boolean ribbonPresence, boolean coverPresence, AbstractFlower... args) {
		this.arrayBody = new AbstractFlower[args.length];
		setArrayElements(args);
		this.coverPresence = coverPresence;
		this.ribbonPresence = ribbonPresence;
		this.cost = countCost();
	}

	private float countCost() {
		float cost = 0;
		for (int i = 0; i < this.arrayBody.length; i++) {
			cost += this.arrayBody[i].getCost();
		}
		return cost;
	}

	private void setArrayElements(AbstractFlower... args) {
		for (int i = 0; i < args.length; i++) {
			this.arrayBody[i] = args[i];
		}
	}

	public String toString() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		StringBuilder result = new StringBuilder();
		
		for (AbstractFlower abstractFlower : arrayBody) {
			result.append(abstractFlower.toString()).append("\n");
		}

		result.append(resourcer.getString("message.RibbonPresence")).append(this.ribbonPresence).append("\n");
		result.append(resourcer.getString("message.CoverPresence")).append(this.coverPresence).append("\n");
		result.append(resourcer.getString("message.bouquetCost")).append(this.cost);
		return result.toString();
	}

	public int findFlower(AbstractFlower flower) {
		this.sort();
		return Arrays.binarySearch(this.arrayBody, flower);
	}
	
	public String getInfromationAboutFlowerPresence(AbstractFlower flower) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		StringBuilder result = new StringBuilder();
		
		if (this.findFlower(flower) >= 0) {
			result.append(resourcer.getString("message.isFound")).append("\n");
		} else {
			result.append(resourcer.getString("message.notFound")).append("\n");
		}
		return result.toString();
	}

	public void sort() {
		Arrays.sort(this.arrayBody);
	}
}
