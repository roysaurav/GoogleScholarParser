package driver;

import java.util.*;
import java.util.regex.Matcher;

public class publicationCitationNumberExtraction implements Formater{
  
  private ArrayList<Integer> CitationNumbers = new ArrayList<Integer>();
  
  
  /**
   * THis functions scraps all raw HTML
   * data and gets the relvant data using regex
   * @param rawHTMLString
   */
  private void scrap(String rawHTMLString) {
    // creates a matcher object
    Matcher matcherPublicationCitationNumber = regexCompiler.
        patternPublicationCitationNumber.matcher(rawHTMLString);
    int CitationNumber;
    // gets all the citation numbers
    while(matcherPublicationCitationNumber.find()){
      // converts the string to number
      CitationNumber = Integer.
          parseInt(matcherPublicationCitationNumber.group(1));
      // adds the number to arrat
      CitationNumbers.add(CitationNumber);
    }
  }

  @Override
  public String Format(String rawHTMLString) {
    scrap(rawHTMLString);
    int firstFiveTotal = 0;
    // iterates and add the first five interger
    for(int i =0; i<5 && i <CitationNumbers.size(); i++){
      firstFiveTotal = firstFiveTotal + CitationNumbers.get(i);
    }
    // formats the string
    String firstFiveSum = "\t"+Integer.toString(firstFiveTotal) + "\n";
    return firstFiveSum;
  }
}
