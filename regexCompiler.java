package driver;

import java.util.regex.Pattern;

public class regexCompiler {

  public static Pattern patternCoAuthor ;
  
  public static Pattern patternPublicationTitle;
  
  public static Pattern patternAuthorName ;
  
  public static Pattern  patternPublicationCitationNumber ;
  
  public static Pattern  patternCitationIndexExtractor ;
  
  
  public regexCompiler(){
    patternCoAuthor = Pattern
        .compile(regexExpresions.CoAuthorExtraction);
    
    patternPublicationTitle = Pattern
        .compile(regexExpresions.publicationTitleExtraction);
    
    patternAuthorName = Pattern
        .compile(regexExpresions.authorNameExtraction);
    
    patternPublicationCitationNumber = Pattern
        .compile(regexExpresions.publicationCitationNumberExtraction);
    
    patternCitationIndexExtractor = Pattern
        .compile(regexExpresions.citationIndexExtractor);
  }
  
}
