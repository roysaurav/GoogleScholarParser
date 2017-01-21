//**********************************************************
//Assignment3:
//UTORID user_name: roysaura
//
//Author: Saurav Roy
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyParser {

/**
* @param args
*/
public static void main(String[] args) {
 StarterHelp(args);
}


/*
* This is a debug/helper method to help you get started. Once you understand
* how this method is being used, you are free to refactor it, modify it, or
* change it, or remove it entirely in any way you like.
*/
private static void StarterHelp(String[] args) {
 // gets each html file name
 String inputFiles[] = args[0].split(",");
 String result = "";
 // iterates through each filename
 for (String inputFile : inputFiles) {
   // generates result from each filename
   result += generateResult(inputFile);   
 }
 // add all co-Authors to the result and formats it
 result += "\n"+headerConstants.HEADER1 + "\n";
 result += "7. "+headerConstants.HEADER8;
 result += coAuthorExtracter.formatAllCoAuthors();
 //checks for outfile
 if(args.length == 1){
   // prints the result
   System.out.print(result);
 }else if(args.length == 2){
   // writes the result to given file
   fileWriter(args[1],result);
 }
 
}


private static void fileWriter(String filname, String result) {
  // initialize the a file writer
  PrintWriter writer = null;
  try {
    // writes to fileName
    writer = new PrintWriter(filname,"UTF-8");
  } catch (Exception e) {
    System.out.println("filname error");
  }
  // writes to file
  writer.print(result);
  // close the writer
  writer.close();
}


private static String generateResult(String inputFile) {
  String result = "";
  // html data object
  getHTMLData HTMLdata = new getHTMLData();
  String rawHTMLString ="";
 try {
   // gets all the HTML object
   rawHTMLString = HTMLdata.getHTML(inputFile);
   // gets the output
   outputGenerator x = new outputGenerator();
   // adds a new line in the end
   result = result + x.generate( rawHTMLString)+"\n";
 } catch (Exception e) {
   System.out.println("malformed URL or cannot open connection to "
       + "given URL");
 }
  return result;
}


}
