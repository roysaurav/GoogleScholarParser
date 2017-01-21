package driver;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class getHTMLData {
  // create object to store html source text as it is being collected
  StringBuilder html = new StringBuilder();
  String line;
  regexExpresions expr = new regexExpresions();
  /**
   * gets the whole html in 
   * @param urlString
   * @return
   * @throws Exception
   */
  public String getHTML(String urlString) throws Exception  {

    try {
      getOfflinePage(urlString);
      expr.update(1);
    } catch (Exception e) {
      getlivepage(urlString);
      expr.update(0);
    }
    // convert StringBuilder into a String and return it
    return html.toString();
   }

 
  private void getOfflinePage(String urlString) throws Exception {
    // open connection to given url
    URL url = new File(urlString).toURI().toURL();
    // create BufferedReader to buffer the given url's HTML source
    BufferedReader htmlbr =
        new BufferedReader(new InputStreamReader(url.openStream()));
    // read each line of HTML code and store in StringBuilder
    while ((line = htmlbr.readLine()) != null) {
      html.append(line);
    }
    htmlbr.close();
  }


  private void getlivepage(String urlString) throws Exception {
    // open connection to given url
    URL oracle = new URL(urlString);
    // create BufferedReader to buffer the given url's HTML source
    BufferedReader in =
        new BufferedReader(new InputStreamReader(oracle.openStream()));
    // read each line of HTML code and store in StringBuilder
    while ((line = in.readLine()) != null) {
      html.append(line);
    }
    // close the input file.
    in.close();
  }

}
