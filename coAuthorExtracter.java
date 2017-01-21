package driver;

import java.util.*;
import java.util.regex.Matcher;

public class coAuthorExtracter implements Formater{
  
  // set of single HTML file coAutor
  private HashSet<String> coAuthor = new HashSet<String>();
  // set of all HTML file coAuthor
  private static HashSet<String> allCoAuthor = new HashSet<String>();

  
  /**
   * THis functions scraps all raw HTML
   * data and gets the relvant data using regex
   * @param rawHTMLString
   */
  private void scrap(String rawHTMLString) {
    // matcher obejct
    Matcher matcherCoAuthor = regexCompiler.
        patternCoAuthor.matcher(rawHTMLString);
    // finds all matcher
    while (matcherCoAuthor.find())
    {
      coAuthor.add(matcherCoAuthor.group(1).trim());
    }
    // removes unnessary things
    coAuthor.remove("Citations");
    // adds all coAuthor
    allCoAuthor.addAll(coAuthor);
  }

  @Override
  public String Format(String rawHTMLString) {
    scrap(rawHTMLString);
    // calulates total 
    String totalCoAuthors = Integer.toString(coAuthor.size());
    // formats it
    return "\t" + totalCoAuthors ;
  }
  
  public static String formatAllCoAuthors(){
    // converts to list and format it
    String[] allCoAuthorsList = new String[allCoAuthor.size()]; 
    allCoAuthor.toArray(allCoAuthorsList);
    // sorts all coAuthors
    Arrays.sort(allCoAuthorsList);
    int totalNoCoAuthors = allCoAuthorsList.length;
    String result = "(Total: " + totalNoCoAuthors + "):\n";
    // creates a lists and adds new line to it
    for(int i =0; i<totalNoCoAuthors; i++){
      result = result + allCoAuthorsList[i]+"\n";
    }
    return result;
  }
}
