import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimplePlayList implements PlayList {
private Scanner musicTrack;
private List<MusicTrack> currentAndNextTrack;

public SimplePlayList(Scanner musicTrack) {
    this.currentAndNextTrack = new ArrayList<MusicTrack>();
    this.musicTrack = musicTrack;
}

public PlayListTrack getNextTrack() {
    MusicTrack currentMusicTrackToPlay;
    SimpleMusicTrack musicTrack = new SimpleMusicTrack();
    boolean successfulTrackCreation = ((MusicTrack) musicTrack)
            .getNextTrack(this.musicTrack);
    // Beginning of the PlayList return null and set the next track at the
    // zero index of the collection
    if (this.currentAndNextTrack.size() == 0) {
        if (successfulTrackCreation)
            this.currentAndNextTrack.add((MusicTrack) musicTrack);
        return null;
    } else {
        // gets the the music track at index zero and set as current track
        // set next track at zero index of collection and return the
        // original current track
        currentMusicTrackToPlay = this.currentAndNextTrack.get(0);
        if (successfulTrackCreation)
            this.currentAndNextTrack.set(0, musicTrack);
        else {
            // display the rest tracks added in by the user
            if (this.currentAndNextTrack.size() > 1) {
                this.currentAndNextTrack.set(0,
                        this.currentAndNextTrack.get(1));
                this.currentAndNextTrack.remove(1);
            } else
                this.currentAndNextTrack.remove(0);
        }
    }
    return currentMusicTrackToPlay;
}

public PlayListTrack peekAtNextTrack() {
    if (this.currentAndNextTrack.size() > 0)
        return (PlayListTrack) currentAndNextTrack.get(0);
    else
        return null;
}

public void addTrack(MusicTrack musicTrack) {
    if (musicTrack != null)
        this.currentAndNextTrack.add(musicTrack);
}

public boolean isEmpty() {
    return this.currentAndNextTrack.size() == 0;
}

public boolean equals(Object obj) {
    if (obj instanceof SimplePlayList) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
    return false;
}

public String toString() {
    return ToStringBuilder.reflectionToString(this,
            ToStringStyle.MULTI_LINE_STYLE);
}

@Override
public PlayListTrack getNextTrack() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public PlayListTrack peekAtNextTrack1() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public void addTrack(PlayListTrack track) {
    // TODO Auto-generated method stub

}
}