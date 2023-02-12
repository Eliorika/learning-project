package ru.rsreu.Babayan0501.Flowers;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

import ru.rsreu.Babayan0501.ColourInformationKeeper;

public class ChamomilePredictionMaker extends AbstractFlower {

	public ChamomilePredictionMaker(ColourInformationKeeper colour, int days, float basicCost) {
		super(colour, days, basicCost, determineType());
	}
	
	private static String determineType() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		return resourcer.getString("message.chamomile");
	}

	public boolean getPrediction(String question) {
		return question.length() % 2 == 0;
	}
	
	@Override
	public float freshnessLevelCounter(int days) {
		return (1 / (float) days);
	}
	
}
