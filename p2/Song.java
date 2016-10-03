import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * The <code>Song</code> class represents a song. Each song
 * has a title, artist, play time, and file name.
 *
 * Here is an example of how a song can be created.
 *
 * <p><blockquote><pre>
 *     Song song = new Song("Amsterdam", "Paul Oakenfold", 318, "music/Amsterdam.mp3");
 * </pre></blockquote><p>
 *
 * Here is an example of how a song can be used.
 * <p><blockquote><pre>
 *     System.out.println("Artist: " + song.getArtist());
 *     System.out.println(song);
 * </pre></blockquote><p>
 *
 * @author amit
 */
public class Song
{
	private String title;
	private String artist;
	private int playTime; // in seconds
	private String fileName;
	
	/**
	 * Constructor: Builds a song using the given parameters.
	 * @param title song's title
	 * @param artist song's artist
	 * @param playTime song's length in seconds
	 * @param fileName song file to load
	 */
	public Song(String title, String artist, int playTime, String fileName)
	{
		this.title = title;
		this.artist = artist;
		this.playTime = playTime;
		this.fileName = fileName;
	}

	/**
     * Returns the title of this <code>Song</code>.
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}

	/**
     *  Returns the artist of this <code>Song</code>.
	 * @return the artist
	 */
	public String getArtist()
	{
		return artist;
	}

	/**
     *  Returns the play time of this <code>Song</code> in seconds.
	 * @return the playTime
	 */
	public int getPlayTime()
	{
		return playTime;
	}

	/**
     *  Returns the file name of this <code>Song</code>.
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return  String.format("%-20s %-20s %-25s %10s",title, artist, fileName, playTime);
		
	}	
		
		/**
 * 
 * Plays a sound sample and waits for it to finish
 * @author amit
 */

	public void play() throws InterruptedException
	{
		    try {
		    	File sounds = new File(fileName);          
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sounds);
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        
		    } catch(Exception e) {
		        System.out.println("PlayMusic: Error with playing sound:" + e);
		        e.printStackTrace();
		    }
		    
		    // there are better ways of waiting for a song to finish playing
		    // but we will see them later
		    int playTime = 30; // seconds
		    for (int i = 0; i < playTime * 10; i++) {
		        Thread.sleep(100); // in millisecs
		    	
	
	
	}

    }
}
