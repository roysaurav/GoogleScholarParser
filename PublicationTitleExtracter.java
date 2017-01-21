/**
 * 
 */
package driver;

import java.util.*;
import java.util.regex.Matcher;

/**
 * @author subrat
 *
 */
public class PublicationTitleExtracter implements Formater{

  /**
   * 
   */
  private ArrayList<String> result = new ArrayList<String>();

  /**
   * THis functions scraps all raw HTML
   * data and gets the relvant data using regex
   * @param rawHTMLString
   */
  private void scrap(String rawHTMLString){
    // matcher object
    Matcher matcherPublicationTitle = regexCompiler.
        patternPublicationTitle.matcher(rawHTMLString);
    // finds all matches
    while(matcherPublicationTitle.find()){
      result.add(matcherPublicationTitle.group(1));
    }
  }

  @Override
  public String Format(String rawHTMLString) {
    scrap(rawHTMLString);
    String Formattedresult = "";
    // gets the first three and adds it 
    for(int i=0; i<3 && i<result.size(); i++){
      // formats each result
      Formattedresult += "\t" + (i+1) + "-   " + result.get(i) + "\n";
    }
    return Formattedresult;
  }
  
  

}
