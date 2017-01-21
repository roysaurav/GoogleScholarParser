package driver;

import java.util.*;


public class outputGenerator {
  // list of all headers
  private ArrayList<String> headers = new ArrayList<String>();
  
  // final formated data
  private ArrayList<Formater> HTMLFormattedData = new ArrayList<Formater>();
 /**
  * Class constructor and
  * adds header and class
  */
  public outputGenerator( ) {
    addHeader();
    initializeClass();
  }
  
  
  /**
   * Initialize all the classes
   */
  private void initializeClass() {
    // initiallize all the class
    citationIndexExtractor help = new citationIndexExtractor();
    HTMLFormattedData.add(new authorNameExtractor());
    HTMLFormattedData.add(help.new allCitationIndexExtractor());
    HTMLFormattedData.add(help.new i10IndexExtractor());
    HTMLFormattedData.add(new PublicationTitleExtracter());
    HTMLFormattedData.
    add(new publicationCitationNumberExtraction());
    HTMLFormattedData.add(new coAuthorExtracter());
  }

 /**
  * adds header to the list
  */
  private void addHeader() {
    // adds all the heades in proper order and
    // and the new line
    headers.add(headerConstants.HEADER1+"\n");
    headers.add(headerConstants.HEADER2+"\n");
    headers.add(headerConstants.HEADER3+"\n");
    headers.add(headerConstants.HEADER4+"\n");
    headers.add(headerConstants.HEADER5+"\n");
    headers.add(headerConstants.HEADER6+"\n");
    headers.add(headerConstants.HEADER7+"\n");
  }

/**
 * Generates the required output for printing
 * @param rawHTMLString
 * @return
 */
  public String generate(String rawHTMLString){
    String result = headers.get(0);
    // gets all the relevant data from the class and adds spaces
    for(int i =0; i<HTMLFormattedData.size(); i++){
      // adds header
      result = result + (i+1) + ". " +headers.get(i+1);
      // adds data
      result = result + HTMLFormattedData.get(i).Format(rawHTMLString);
    }
    return result;
  }
}
