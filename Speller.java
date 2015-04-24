//Speller.java
//Kim Asenbeck
//Lab11
//4-23-15

import java.util.*;
import java.io.*;
import java.lang.*;

public class Speller { //this class is the spell checker. It does not handle punctuation
  
  //Instance variables
  public Vector<String> misspelled; //this returns a list of unique misspelled words
  public Scanner scan; //For reading in file
  public EnglishHashDictionary hash; //Hashtable which contains the words in the dictionary, based on provided file
  public String file, dictionary; //When the user enters command in command line, the arguments will be initialized as Strings
  
  //Constructor
  public Speller(String file, String dictionary){ //creates a new Speller object
    hash = new EnglishHashDictionary(dictionary);//Create a new EnglishHashDictionary
    this.file = file; 
    misspelled = new Vector<String>(); //this vector will contain all misspelled words
  }
  
  public Vector checker(){//Check every word of a given text file against the dictionary
    //Keep track of unique misspelled words in a list or array, vector, or some other data structure
    try{
      Hashtable<String, Integer> counter = new Hashtable<String, Integer>(10); 
      //Counter hashtable will be used to count the number of times each word was encountered
      scan = new Scanner(new File(file)); //read in from the file 
      while(scan.hasNext()){ //until you run out of lines
        String s = scan.next(); //get the next word
        s = s.toLowerCase();//toLowerCase() returns lowercase version of same word.
        s = s.trim();//trim(), gets rid of extra white space. ex)
        boolean contains = hash.searchWord(s); //find out if the word is in the dictionary
        if (contains == false){ //if it is not in the dictionary
          if (misspelled.contains(s)){ //check to see if the word is already in the list of misspelled words
           counter.put(s, counter.get(s)+1); //increment the count by one
          }
          else { //if it is not yet in the list of misspelled words
            counter.put(s, 1); //add the word to the hashtable
            misspelled.add(s); //and add it to the misspelled words vector
          }
        }
      }
      System.out.println(counter); //print the counter
    }
    catch(IOException ex){}//catch exceptions if they arise

    return misspelled;//return the vector
  }
  
  //main method
  public static void main (String[]args){ 
    Speller spell = new Speller(args[0], args[1]); //create a new speller object with the files from command line
    Vector misspelled = spell.checker(); //return a vector by invoking the checker method
    
    //Print out the results
    System.out.println("Document " + args[0] + " contains " + misspelled.size() + " misspelled words:");
    System.out.println(misspelled); //print vector
  }
  
}

//Example invocation (run from commmand line)
//java Speller AllYouNeedIsLove.txt EnglishWords1.txt
