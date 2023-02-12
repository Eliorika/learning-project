package ru.rsreu.Babayan0501;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class ColourInformationKeeper {

	private Colour colourName;
	private int extraCharge;
	public ColourInformationKeeper(Colour colourName, int extraCharge) {
		if (extraCharge < 0) {
			throw new IllegalArgumentException(getErrorExplanation());
		}
		this.colourName = colourName;
		this.extraCharge = extraCharge;
	}
	
	private static String getErrorExplanation() {
		Resourcer resourcer = ProjectResourcer.getInstance();
		return resourcer.getString("message.errorNotGreatorThanZeroExtraCharge");
	}
	
	public Colour getColour() {
		return this.colourName;
	}
	
	public void setColour(Colour colourName) {
		this.colourName = colourName;
	}
	
	public int getExtraCharge() {
		return this.extraCharge;
	}
	
}
