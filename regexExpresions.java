/**
 * 
 */
package driver;

/**
 * @author subrat
 *
 */
public class regexExpresions {
  
  // gets the name of author
  public static String authorNameExtraction ;
  // gets the name of co-Authors
  public static String CoAuthorExtraction ;
 // gets the name of all publication title
  public static String publicationTitleExtraction ;
  // gets the number of all publicationCitationNumberExtraction;
  public static String  publicationCitationNumberExtraction ;
  // gets the all the citationIndexExtractor
  public static String citationIndexExtractor ;
  
  /**
   * updates the regex string
   * @param i
   */
  public void update(int i){
    if(i == 0){
      livepage();
    }else{
      offlinePage();
    }
    // compiles all the regex
    regexCompiler compile = new regexCompiler();
  }
  
  
  /**
   * initialize all the regex string for offline page
   */
  private void offlinePage(){
    
    authorNameExtraction = "<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">(.*?)</span>";
    
    CoAuthorExtraction = "<a class=\"cit-dark-link\" href=\"h"
        + "ttp.*?\" title=\".*?\">(.*?)</a>";
    
    publicationTitleExtraction = "<tr class=\"cit-table it"
        + "em\">.*?<a href=\"http.*?>(.*?)</a>.*?/tr";
    
    publicationCitationNumberExtraction = "<td i"
        + "d=\"col-citedby\"><a class=\"cit-dark-link\" href=\"http.*?\">"
        + "(.*?)</a></td>";
    
    citationIndexExtractor = "<td class=\"c"
        + "it-borderleft cit-data\">(.*?)</td>";
  }
  
  /**
   * initialize all the regex string for live page
   */
  private void livepage(){
    
    authorNameExtraction = "<div id=\"gsc_prf_in\">(.*?)</div>";
    
    CoAuthorExtraction = "<a class=\"gsc_rsb_aa\" href=\"/"
        + ".*?\">(.*?)</a>";
    
    publicationTitleExtraction = "<td class=\"gsc_a_t"
        + "\">.*?<a href=\"/.*?\" class=\"gsc_a_at\">(.*?)</a>.*?</tr>";
    
    publicationCitationNumberExtraction = "<td class=\"gsc_a_c\">"
        + "<a href=\"http.*?\" class=\"gsc_a_ac\">"
        + "(.*?)</a></td>";
    
    citationIndexExtractor = "<td class=\"gsc_rsb_std\">(.*?)</td>";
  }
 }
