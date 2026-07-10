package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;

import java.util.*;

// ========== Video class representing a single video ==========
class Video1 {
    private String title;

    public Video1(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// ========== YouTubePlaylist class (Aggregate) ==========
class YouTubePlaylist1 {
    private List<Video1> videos = new ArrayList<>();

    // Method to add video to playlist
    public void addVideo(Video1 video) {
        videos.add(video);
    }

    // Method to expose internal video list
    public List<Video1> getVideos() {
        return videos;
    }
}

// ========== Iterator interface ==========
interface PlaylistIterator {
    boolean hasNext();
    Video1 next();
}

// ========== Concrete Iterator class ==========
class YouTubePlaylistIterator implements PlaylistIterator {
    private List<Video1> videos;
    private int position;

    // Constructor takes the list to iterate on
    public YouTubePlaylistIterator(List<Video1> videos) {
        this.videos = videos;
        this.position = 0;
    }

    // Check if more videos are left to iterate
    @Override
    public boolean hasNext() {
        return position < videos.size();
    }

    // Return the next video in sequence
    @Override
    public Video1 next() {
        return hasNext() ? videos.get(position++) : null;
    }
}

// ========== Main method (Client code) ==========
public class IteratorDemo {
    public static void main(String[] args) {
        // Create a playlist and add videos
        YouTubePlaylist1 playlist = new YouTubePlaylist1();
        playlist.addVideo(new Video1("LLD Tutorial"));
        playlist.addVideo(new Video1("System Design Basics"));

        // Client directly creates the iterator using internal list (not ideal)
        PlaylistIterator iterator = new YouTubePlaylistIterator(playlist.getVideos());

        // Use the iterator to loop through the playlist
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}

