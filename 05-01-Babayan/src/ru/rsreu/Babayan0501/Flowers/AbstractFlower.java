package ru.rsreu.Babayan0501.Flowers;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Babayan0501.Colour;
import ru.rsreu.Babayan0501.ColourInformationKeeper;

public abstract class AbstractFlower implements Comparable<AbstractFlower> {

	private ColourInformationKeeper flowerColour;
	private Float freshnessLevel;
	private float cost;
	private String type;

	public AbstractFlower(ColourInformationKeeper colour, int days, float basicCost, String type) {

		if (days <= 0) {
			throw new IllegalArgumentException(getErrorFreshnessLevelExplanation());
		}

		this.flowerColour = colour;
		this.freshnessLevel = freshnessLevelCounter(days);
		this.cost = countCost(basicCost, this.freshnessLevel, colour);
		this.type = type;
	}

	private static String getErrorFreshnessLevelExplanation() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		return resourcer.getString("message.errorNotGreatorThanZeroFreshnesslevel");
	}

	public String toString() {
		StringBuilder info = new StringBuilder();
		Resourcer resourcer = ProjectResourcer.getInstance();
		info.append(resourcer.getString("message.type")).append(this.type).append("\n");
		info.append(resourcer.getString("message.freshnessLevel")).append(this.freshnessLevel).append("\n");
		info.append(resourcer.getString("message.colour")).append(this.flowerColour.getColour()).append("\n");
		info.append(resourcer.getString("message.cost")).append(this.cost).append("\n");
		return info.toString();
	}

	@Override
	public int compareTo(AbstractFlower flower2) {
		int result = this.freshnessLevel.compareTo(flower2.freshnessLevel);
		return result;
	}

	public float getCost() {
		return this.cost;
	}

	public void setColourName(Colour colourName) {
		this.flowerColour.setColour(colourName);
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Colour getColourName() {
		return this.flowerColour.getColour();
	}

	public float getfreshnessLevel() {
		return this.freshnessLevel;
	}

	public void setFreshnessLevel(Float freshnessLevel) {
		this.freshnessLevel = freshnessLevel;
	}

	public float countCost(float basicCost, float freshnessLevel, ColourInformationKeeper colour) {
		float cost = (float) (basicCost + freshnessLevel * basicCost + colour.getExtraCharge());
		return cost;
	}

	public float freshnessLevelCounter(int days) {
		return days * days / 2;
	}

}
