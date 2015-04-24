//EnglishHashDictionary.java
//Kim Asenbeck
//Lab11
//4-23-15

import java.util.*;
import java.io.*;

public class EnglishHashDictionary implements Dictionary{
  //The file EnglishHashDictionary.java will provide 
  //the definition of a dictionary based on a Hash Table.
  
  //Instance vars
  public static Hashtable<String, String> dictionary = new Hashtable<String, String>(10); // 10 initial spots
  
  public EnglishHashDictionary(String dict){  //read in text dictionary file. (e.g. EnglishWords.txt)
    
    try{
      Scanner scan = new Scanner(new File(dict));//create new scanner object
      
      while(scan.hasNext()){//read file until there are no more lines
        String word = scan.next();
        dictionary.put(word, word);//each line will become a new word in dictionary
      }
    }
    catch(IOException ex){}
  }
  
  
  /**
   * Adds input String to the dictionary 
   */
  public void addWord(String word){
    
    dictionary.put(word, word);
    
  }
  
  /**
   * Searches the dictionary for the input String.
   * Returns true if found, false otherwise.
   */
  public boolean searchWord(String word){ 
    
    return (dictionary.containsKey(word));
    
  }
  
  /**
   * Removes from the dictionary for the input String.
   * It does nothing if the input word is not in the dictionary.
   */
  public void removeWord(String word){
    
    if (dictionary.containsKey(word)){
      dictionary.remove(word);
    }
    
  }
  
  
}