package ru.rsreu.Babayan0201;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class Runner {
	
private Runner() {
		
	}

	public static void main(String[] args) {
		
//		Scanner in = new Scanner(System.in);
//		Resourcer resourcer = ProjectResourcer.getInstance();
//
//		System.out.print("Enter number of strings: n = ");
//		int stringCount = Integer.parseInt(in.next());
//		in.nextLine();
//
//		String[] stringArray = new String[stringCount];
//		for (int i = 0; i < stringArray.length; i++) {
//			System.out.println("Enter " + (i + 1) + ". string: ");
//			stringArray[i] = in.nextLine();
		
		List<String> numbers = new ArrayList(Arrays.asList("first", "second", "third"));
		for (String number : numbers) {
		    if ("third".equals(number)) {
		        numbers.add("fourth");
		    }
		}
		System.out.println(numbers.size());
		}

		
//		for (int i = 0; i < stringArray.length; i++) {
//			if (!stringArray[i].isEmpty()) {
//				stringArray[i].trim();
//				System.out.printf("%s%d:\n", resourcer.getString("message.inputFragment"), (i + 1));
//				String startFragment = in.next();
//				startFragment.trim();
//				
//				System.out.printf("%s%d (%s):\n", resourcer.getString("message.inputBeginIndex"), (i + 1), resourcer.getString("message.startId"));
//				int beginIndex = Integer.parseInt(in.next()) - 1;
//				if (beginIndex > stringArray[i].length() / 2) {
//					System.out.printf("%s\n", resourcer.getString("message.bigValErrStrIndex"));
//					beginIndex = 0;
//				}
//				
//				System.out.printf("%s%d (%s):\n", resourcer.getString("message.inputFragLength"), (i + 1), resourcer.getString("message.startId"));
//				int fragmentLength = Integer.parseInt(in.next());
//				if (fragmentLength > stringArray[i].length() / 2 - beginIndex) {
//					System.out.printf(resourcer.getString("message.bigValErrStrLength"));
//					fragmentLength = 1;
//				}
//				
//				System.out.printf("\n%s: %s", resourcer.getString("message.originalStr"),  stringArray[i]);
//				System.out.printf("\n:\n", resourcer.getString("message.result"));
//				String result = StringFragmentDoubler.divideStrInto2AndDoublePartIfNeeded(stringArray[i], startFragment, beginIndex, fragmentLength);
//				System.out.println(result);
//			} else {
//				System.out.println(resourcer.getString("message.emptyStr"));
//			}
//		}
//		in.close();
//	}
}
