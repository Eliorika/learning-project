package ru.rsreu.Babayan0501;

import ru.rsreu.Babayan0501.Flowers.ChamomilePredictionMaker;
import ru.rsreu.Babayan0501.Flowers.SunflowerFibonacciSumCounter;
import ru.rsreu.Babayan0501.Flowers.RoseIntoRedColourer;

public class VariablesInitialisator {
	private static FlowerInBouquetFinder boquet;
	private static ChamomilePredictionMaker chamomileViolet;
	private static ChamomilePredictionMaker chamomileWhite;

	private VariablesInitialisator() {
	}

	public static FlowerInBouquetFinder getBoquet() {
		return boquet;
	}

	public static ChamomilePredictionMaker getChamomileViolet() {
		return chamomileViolet;
	}

	public static ChamomilePredictionMaker getChamomileWhite() {
		return chamomileWhite;
	}
	
	public static void initializeAllVariables() {

		ColourInformationKeeper colourRed = new ColourInformationKeeper(Colour.RED, 20);
		ColourInformationKeeper colourPink = new ColourInformationKeeper(Colour.PINK, 10);
		ColourInformationKeeper colourWhite = new ColourInformationKeeper(Colour.WHITE, 30);
		ColourInformationKeeper colourViolet = new ColourInformationKeeper(Colour.VIOLET, 20);

		RoseIntoRedColourer rose = new RoseIntoRedColourer(colourPink, 10, 100, true);
		SunflowerFibonacciSumCounter sunflower = new SunflowerFibonacciSumCounter(colourRed, 5, 150);
		chamomileViolet = new ChamomilePredictionMaker(colourViolet, 1, 80);
		chamomileWhite = new ChamomilePredictionMaker(colourWhite, 8, 90);
		boquet = new FlowerInBouquetFinder(true, false, rose, sunflower, chamomileWhite);
	}

}
