/**
 * 
 */
package driver;
import java.util.regex.Matcher;

/**
 * @author subrat
 *
 */
public class authorNameExtractor implements Formater {

  // stores the autjor name
  private String authorName;
  
  
  /**
   * THis functions scraps all raw HTML
   * data and gets the relvant data using regex
   * @param rawHTMLString
   */
  private void scrap(String rawHTMLString) {
    // gets the matcherObjecy
    Matcher matcherAuthor = regexCompiler.
        patternAuthorName.matcher(rawHTMLString);
    // finds the matches
    while (matcherAuthor.find())
    {
      // gets the author name
      authorName = matcherAuthor.group(1);
    }    
  }

  @Override
  public String Format(String rawHTMLString) {
    scrap(rawHTMLString);
    // formats it according to correct format
    return "\t" + authorName +"\n";
  }
}
