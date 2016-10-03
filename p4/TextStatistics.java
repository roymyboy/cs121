import java.io.File;                          
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 
 * @author utroy
 *
 */

public class TextStatistics implements TextStatisticsInterface
{
  /**
  * Initializing Variable 
  */
  
  private int wordCount = 0;
  private int lineCount = 0;
  private int charCount = 0;
  private int totalWordLength = 0;
  private String fileContent = "";
  private int[] wordLength = new int[24];
  private int[] charCountArray = new int[26];
  private String token = " ,.;:'\"&!?-_\n\t12345678910[]{}()@#$%^*/+-";
  private String title = "";
  private String bigWord = "";
  
	/**
	* Constructor 
	*/ 
	public TextStatistics(File file)
	{
		try
		{
		title = file+"";
		readFile(file);
		}
		catch(FileNotFoundException e){
			System.err.println(e.getMessage());
		}
	}
	
	/**
	* Scans the file when proivided filename
	* @param filename 
	*/
	public void readFile(File file) throws FileNotFoundException
	{
		try
		{
			Scanner thisFile = new Scanner(file);
			String line;
			String word;
			while(thisFile.hasNextLine())
			{
				line = thisFile.nextLine().toLowerCase();
				fileContent += line + " ";
				lineCount++;					//reading line
				charCount += line.length()+1; 			//reding character count
				for(int i=0; i<line.length(); i++)
				{
					char current = line.charAt(i);
					if(current >= 'a' && current <= 'z')
					{
						charCountArray[current - 'a']++;
					}
				}
			}
				//StringTokenizer for differenciating words 
				StringTokenizer tokenizer = new StringTokenizer(fileContent, token);
				wordCount = tokenizer.countTokens();
				
			while(tokenizer.hasMoreTokens())    //parsing into word
			{
				word = tokenizer.nextToken().toLowerCase();
				
				//Print largest word
				if (word.length() > bigWord.length())
				{ 
					bigWord = word; 
				} 
				wordLength[word.length()]++;    //word frequency
				totalWordLength += word.length(); //count word length
				
			}
			
		} catch (FileNotFoundException e)
		  {
			throw new FileNotFoundException("Invalid file Path: " + e.getMessage());
		  }
	}
	
  	/**
	 * @return the number of characters in the text file
	 */
	public int getCharCount()
	{
		return charCount;
	}

	/**
	 * @return the number of words in the text file
	 */
	public int getWordCount()
	{
		return wordCount;
	}

	/**
	 * @return the number of lines in the text file
	 */
	public int getLineCount()
	{
		return lineCount; 
	}

	/**
	 * @return the letterCount array with locations [0]..[25] for 'a' through 'z'
	 */
	public int[] getLetterCount()
	{
		return charCountArray;
	}

	/**
	 * @return the wordLengthCount array with locations [0]..[23] with location [i] 
	 * storing the number of words of length i in the text file. Location [0] is not used.
	 * Location [23] holds the count of words of length 23 and higher.
	 */
	public int[] getWordLengthCount()
	{
		return wordLength;
	}

	/**
	 * @return the average word length in the text file
	 */
	public double getAverageWordLength()
	{
		double average = (double)totalWordLength/wordCount;
		return  average;
	}
	
	/**
	* the contents of all the method are placed in format to print out.
	*
	*/
	public String toString()
	{
	    String str = "";
	     
		   str = "Statistics for " + title + "\n";
		   str+= "=============================================\n";
		   str+=  lineCount + "  lines\n";
		   str+=  wordCount + "  words\n";
		   str+=  charCount  +	" characters\n";
		   str+= "---------------------------------------------\n";
		   Character a = 'a', n = 'n';		   
		   for (int i = 0; i < charCountArray.length / 2; i++)
		   {
			str += a.toString() +  "= " + charCountArray[i];
			a = (char)(a+1);
			str += "\t" + n.toString() + "= " + charCountArray[i + 13] + "\n";
			n = (char)(n+1);
		   }
		   str+= "---------------------------------------------\n";
		   str+= "\tlength\tfrequency\n";
		   str+= "\t-------\t--------\n";
		   for (int i = 0; i <  wordLength.length; i++)
		   	if (wordLength[i] > 0)
		   	{
			  str += "\t" + i +"\t" + wordLength[i] +"\n";
	   		}
		   DecimalFormat fmt = new DecimalFormat(".##");
		   str+= "Average word length = " + fmt.format(getAverageWordLength());
		   str+= "\n===================================================\n";
		   str+= "\n";
		   str+= "Biggest word is: " + bigWord +"\n" + "Its word length is: " + bigWord.length();
		   str+= "\n";

	    return str; 
	}
}