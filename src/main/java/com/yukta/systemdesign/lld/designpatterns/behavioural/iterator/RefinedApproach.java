package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;
import java.util.*;

// ========== Video class representing a single video ==========
class Video2 {
    private String title;

    public Video2(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// ================ Playlist interface ================
// (acts as a contract for collections that are iterable)
interface Playlist {
    // Method to return an iterator for the collection
    PlaylistIterator2 createIterator();
}

// ========== YouTubePlaylist class (Aggregate) ==========
// Implements Playlist to guarantee it provides an iterator
class YouTubePlaylist2 implements Playlist {
    private List<Video2> videos = new ArrayList<>();

    // Method to add a video to the playlist
    public void addVideo(Video2 video) {
        videos.add(video);
    }

    // Instead of exposing the list, return an iterator
    @Override
    public PlaylistIterator2 createIterator() {
        return new YouTubePlaylistIterator2(videos);
    }
}

// ========== Iterator interface (defines traversal contract) ==========
interface PlaylistIterator2 {
    boolean hasNext();   // Checks if more elements are left
    Video2 next();        // Returns the next element
}


// ========== Concrete Iterator class ==========
// Implements the actual logic for traversing the YouTubePlaylist
class YouTubePlaylistIterator2 implements PlaylistIterator2 {
    private List<Video2> videos;
    private int position;

    // Constructor takes the collection to iterate over
    public YouTubePlaylistIterator2(List<Video2> videos) {
        this.videos = videos;
        this.position = 0;
    }

    // Check if more videos are left
    @Override
    public boolean hasNext() {
        return position < videos.size();
    }

    // Return the next video in the playlist
    @Override
    public Video2 next() {
        return hasNext() ? videos.get(position++) : null;
    }
}

// ========== Main method (Client code) ==========
public class RefinedApproach {
    public static void main(String[] args) {
        // Create a playlist and add videos to it
        YouTubePlaylist2 playlist = new YouTubePlaylist2();
        playlist.addVideo(new Video2("LLD Tutorial"));
        playlist.addVideo(new Video2("System Design Basics"));

        // Client simply asks for an iterator — no access to internal data structure
        PlaylistIterator2 iterator = playlist.createIterator();

        // Iterate through the playlist using the provided interface
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}

