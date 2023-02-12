package ru.rsreu.Babayan0201;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class StringFragmentDoubler {
	
	private StringFragmentDoubler() {
		
	}
	
	private static String doublePartOfStr(String str, int beginIndex, int substrLength) {
		StringBuilder sbNewStr = new StringBuilder(str);
		String sStringPart = str.substring(beginIndex, beginIndex + substrLength);
		sbNewStr.insert(beginIndex, sStringPart);
		return sbNewStr.toString();
	}
	
	private static String refactorIfStartsWithStartFragment(String startFragment, int beginIndex, int fragmentLength, String str) {
		Resourcer resourcer = ProjectResourcer.getInstance();
		String refactoredString;
		if (str.startsWith(startFragment)) {
			refactoredString = doublePartOfStr(str, beginIndex, fragmentLength);
		} else {
			refactoredString = resourcer.getString("message.noStartFragment");
		}
		return refactoredString;
	}
	
	private static int getLengthOfFragment(String inputStr) {
		int strPartSize = inputStr.length() / 2;
		if (inputStr.length() % 2 != 0) {
			strPartSize++;
		}
		return strPartSize;
	}

	public static String divideStrInto2AndDoublePartIfNeeded(String inputStr, String startFragment, int beginIndex, int fragmentLength) {
		StringBuilder result = new StringBuilder();
		int strPartSize = getLengthOfFragment(inputStr);
		
		String s1stPart = inputStr.substring(0, strPartSize).trim();
		String s2ndPart = inputStr.substring(strPartSize).trim();
		
		result.append(refactorIfStartsWithStartFragment(startFragment, beginIndex, fragmentLength, s1stPart)).append("\n");
		result.append(refactorIfStartsWithStartFragment(startFragment, beginIndex, fragmentLength, s2ndPart)).append("\n");
		
		return result.toString();
	}
	
}
