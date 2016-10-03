import java.text.*;
import java.util.*; 
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/**
 *plays a sound sample and waits for it to finish
 *@author Utsav Roy
 */

public class PlayList
{

	/**
	 *Constructor: Builds a song using the given parameters.
	 * @param title song's title 
	 * @param artist song's artist
	 * @param playTime song's length in seconds
	 * @param fileName song file to load
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		File file = new File("input.txt");

		//Song Discription for song1 
		String title1, artist1, fileName1, playTime1, length_Min1, length_sec1;

		//Song Discription for song2 
		String title2, artist2, fileName2, playTime2, length_Min2, length_sec2;

		//Song Discription for song3 
		String title3, artist3, fileName3, playTime3, length_Min3, length_sec3;

		//Play time for song1
		int time_index1, length_MinInt1, length_secInt1 = 0, total_sec1;

		//Play time for song2
		int time_index2, length_MinInt2, length_secInt2 = 0, total_sec2;

		//Play time for song3
		int time_index3, length_MinInt3, length_secInt3 = 0, total_sec3;

		//value of 1 minute in seconds
		final int t = 60;

		//Maximum song length and minimum song length
		int max_length, min_length;

		//Value for Average time
		double song1_Time, song2_Time, song3_Time, average;

		//songs close to 240 seconds
		int close_to = 240;

		//Song1
		//Song's title
		System.out.println("Enter title: ");
		title1 = scan.nextLine();

		//Song's Artist
		System.out.println("Enter artist: ");
		artist1 = scan.nextLine();

		//Songs's length in (mm:ss) format
		System.out.println("Enter play time in (mm:ss): ");
		playTime1 = scan.nextLine();

		//Song's filename
		System.out.println("Enter fileName: ");
		fileName1 = scan.nextLine();

		//Calculate value of time in Seconds
		time_index1 = playTime1.indexOf(':');
		length_Min1 = playTime1.substring(0, time_index1);
		length_sec1 = playTime1.substring(time_index1+1); 
		length_MinInt1 = Integer.valueOf(length_Min1);
		length_secInt1 = Integer.valueOf(length_sec1);
		total_sec1 = length_MinInt1*t + length_secInt1;

		System.out.println();


		/**
		 * @param Song1
		 */

		Song song1 = new Song(title1, artist1, total_sec1 ,fileName1);

		//Song2
		//Song's title
		System.out.println("Enter title: ");
		title2 = scan.nextLine();

		//Song's Artist
		System.out.println("Enter artist: ");
		artist2 = scan.nextLine();

		//Songs's length in (mm:ss) format
		System.out.println("Enter play time in (mm:ss): ");
		playTime2 = scan.nextLine();

		//Song's filename
		System.out.println("Enter fileName: ");
		fileName2 = scan.nextLine();

		//Calculate value of time in Seconds
		time_index2 = playTime2.indexOf(':');
		length_Min2 = playTime2.substring(0,time_index2);
		length_sec2 = playTime2.substring(time_index2+1); 
		length_MinInt2 = Integer.valueOf(length_Min2);
		length_secInt2 = Integer.valueOf(length_sec2);
		total_sec2 = length_MinInt2*t + length_secInt2;

		System.out.println();

		/**
		 * @param Song2
		 */

		Song song2 = new Song(title2, artist2, total_sec2, fileName2);


		//Song3
		//Song's title
		System.out.println("Enter title: ");
		title3 = scan.nextLine();

		//Song's Artist
		System.out.println("Enter artist: ");
		artist3 = scan.nextLine();

		//Songs's length in (mm:ss) format
		System.out.println("Enter play time in (mm:ss): ");
		playTime3 = scan.nextLine();

		//Song's filename
		System.out.println("Enter fileName: ");
		fileName3 = scan.nextLine();

		//Calculate value of time in Seconds
		time_index3 = playTime3.indexOf(':');
		length_Min3 = playTime3.substring(0,time_index3);
		length_sec3 = playTime3.substring(time_index3+1); 
		length_MinInt3 = Integer.valueOf(length_Min3);
		length_secInt3 = Integer.valueOf(length_sec3);
		total_sec3 = length_MinInt3*t + length_secInt3;

		System.out.println();

		/**
		 * @param Song3
		 */

		Song song3 = new Song(title3, artist3, total_sec3, fileName3);

		/**
		 * @param return the values in decimal (double)
		 */

		//Calculate average play time 
		song1_Time = song1.getPlayTime();
		song2_Time = song2.getPlayTime();
		song3_Time = song3.getPlayTime();

		average = (song1_Time + song2_Time + song3_Time)/3;

		//Formating in two decimal format
		DecimalFormat fmt = new DecimalFormat("0.00");

		//printing out the value
		System.out.println("Average playtime: " + fmt.format(average));

		//calculating the maximum and mininum length
		//maximum
		max_length = Math.max(song1.getPlayTime(), Math.max(song2.getPlayTime(), song3.getPlayTime()));

		//minimum
		min_length = Math.min(song1.getPlayTime(), Math.min(song2.getPlayTime(), song3.getPlayTime()));

		/**
		 * @param Math.abs for playtime
		 */

		//finding out Closest to 240
		if (Math.abs(close_to - song1.getPlayTime()) 
				< Math.abs(close_to - song2.getPlayTime()) 
				&& Math.abs(close_to - song1.getPlayTime()) 
				< Math.abs(close_to - song3.getPlayTime())) {

			System.out.println("\nSong with playtime closest to " + close_to + " secs is: " 
					+ song1.getTitle());

		} else if (Math.abs(close_to - song2.getPlayTime()) 
				< Math.abs(close_to - song1.getPlayTime()) 
				&& Math.abs(close_to - song2.getPlayTime()) 
				< Math.abs(close_to - song3.getPlayTime())) {

			System.out.println("\nSong with playtime closest to " + close_to + " secs is: " 
					+ song2.getTitle());

		} else {
			System.out.println("\nSong with playtime closest to " + close_to + " secs is: " 
					+ song3.getTitle());
		}


		//Setting up table for songs
		// formating the string
		System.out
		.println("=================================================================================");
		String header = String.format("%-20s %-20s %-25s %10s", "Title",
				"Artist", "FileName", "PlayTime");

		System.out.println(header);
		System.out
		.println("=================================================================================");
		
		
		/**
		 * @return playtime == minimum length 	
		 */

		
		if (song1.getPlayTime() == min_length) {
			System.out.println(song1.toString()); 
			song1.play();
		}
		if (song2.getPlayTime() == min_length) {
			System.out.println(song2.toString());
			song2.play();
		}
		if (song3.getPlayTime() == min_length) {
			System.out.println(song3.toString());
			song3.play();
		}
		
		/**
		* @return if playtime != maximum or minimum length 
		*/
		
		if (song1.getPlayTime() != min_length
				&& song1.getPlayTime() != max_length) {	
			System.out.println(song1.toString());
			song1.play();
		}
		if (song2.getPlayTime() != min_length 
				&& song2.getPlayTime() != max_length) {
			System.out.println(song2.toString());
			song2.play();
		}	
		if (song3.getPlayTime() != min_length 
				&& song3.getPlayTime() != max_length) {
			System.out.println(song3.toString());
			song3.play();
		}
		
		/**
		* @return playtime == maximum length
		*/
		
		if (song1.getPlayTime() == max_length) {
			System.out.println(song1.toString());
			song1.play();
		}
		if (song2.getPlayTime() == max_length) {
			System.out.println(song2.toString());
			song2.play();
		}
		if (song3.getPlayTime() == max_length) {
			System.out.println(song3.toString());
			song3.play();
		}
		
		//Close the scanner
		scan.close();
		
		//last border of the table
		System.out
		.println("=================================================================================");
			
		
	}
	
}