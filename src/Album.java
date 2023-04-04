// By Ritvik Kumar Kothapalli

import java.util.Random;

public class Album implements Comparable<Album> {
    private int id;
    private String[] artists;
    private String title;
    private int numSongs;

    public Album(int id, String[] artists, String title, int numSongs) {
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    public int getId() {
        return id;
    }

    public String[] getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public int getNumSongs() {
        return numSongs;
    }

    @Override
    public String toString() {
        String artistStr = String.join(", ", artists);
        return String.format("ID: %d -- %d songs -- [%s]", id, numSongs, artistStr);
    }

    @Override
    public int compareTo(Album other) {
        return Integer.compare(numSongs, other.numSongs);
    }
}
