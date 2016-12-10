package sameDifferentPercentage;

import org.apache.commons.lang3.StringUtils;

public class Comparer {
	public Double compare(String first, String second){
		first = replaceWithRules(first);
		second = replaceWithRules(second);
		int levDiff;
		levDiff = StringUtils.getLevenshteinDistance(first, second);
		int firstLen = first.length();
		int secondLen = second.length();
		int compare = Integer.compare(firstLen, secondLen);
		int biggerLen = 0;
		if(compare==-1){
			biggerLen = secondLen;
		}else if (compare ==1){
			biggerLen = firstLen;
		}
		else if (compare ==0){
			biggerLen = firstLen;
		}
		double percentageSimmilarity = 1 - (double)levDiff/biggerLen;
		return percentageSimmilarity;
	}
	
	public String replaceWithRules(String string){
		string = string.toLowerCase().trim().replaceAll("\\s+","").replaceAll("limited", "ltd");
		return string;
	}
	
}
