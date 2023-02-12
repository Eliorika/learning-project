package ru.rsreu.Babayan0501.Flowers;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Babayan0501.Colour;
import ru.rsreu.Babayan0501.ColourInformationKeeper;

public class RoseIntoRedColourer extends AbstractFlower {
	private boolean thorns;

	public RoseIntoRedColourer(ColourInformationKeeper colour, int days, float basicCost,
			boolean thornsPresense) throws IllegalArgumentException {
		super(colour, days, basicCost, determineType());
	}

	private static String determineType() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		return resourcer.getString("message.rose");
	}

	private void changeColour(Colour colourName) {
		this.setColourName(colourName);
	}

	public void colourRoseToRed() {
		this.changeColour(Colour.RED);
	}

	@Override
	public float countCost(float basicCost, float freshnessLevel, ColourInformationKeeper colour) {
		float cost = (float) (basicCost + freshnessLevel * basicCost + colour.getExtraCharge());
		if (!this.thorns) {
			cost *= 2;
		}
		return cost;
	}
	
	@Override
	public float freshnessLevelCounter(int days) {
		return (float) Math.sqrt(days);
	}

}
