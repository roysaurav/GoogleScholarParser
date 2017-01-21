package driver;

import java.util.*;
import java.util.regex.Matcher;

public class citationIndexExtractor {
  
  // column all
  private ArrayList<Integer> columnAll = new ArrayList<Integer>();
  private ArrayList<Integer> columnSince2009 = new ArrayList<Integer>();
  
  /**
   * THis functions scraps all raw HTML
   * data and gets the relvant data using regex
   * @param rawHTMLString
   */
  private void scrap(String rawHTMLString) {
    int All;
    int Since2009;
    // matcher obejct
    Matcher matcherCitationIndexExtractor = regexCompiler.
        patternCitationIndexExtractor.matcher(rawHTMLString);
    // finds all matches
    while(matcherCitationIndexExtractor.find()){
      // gets the all column
      All = Integer.parseInt(matcherCitationIndexExtractor.group(1));
      columnAll.add(All);
      matcherCitationIndexExtractor.find();
      // gets the year column
      Since2009 = Integer.parseInt(matcherCitationIndexExtractor.group(1));
      columnSince2009.add(Since2009);
    }
  }
  
  public class allCitationIndexExtractor implements Formater{

    @Override
    public String Format(String rawHTMLString) {
      // formats results
      scrap(rawHTMLString);
      String result = "\t"+Integer.toString(columnAll.get(0));
      return result + "\n";
    }
  }
  
  public class i10IndexExtractor implements Formater{

    @Override
    public String Format(String rawHTMLString) {
      // formats results
      scrap(rawHTMLString);
      String result = "\t"+Integer.toString(columnSince2009.get(2));
      return result + "\n";
    }
    
  }

}
