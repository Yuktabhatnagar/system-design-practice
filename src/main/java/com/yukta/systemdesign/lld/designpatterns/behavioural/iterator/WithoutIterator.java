package com.yukta.systemdesign.lld.designpatterns.behavioural.iterator;

import java.util.*;

// A simple Video class with title
class Video {
    String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// YouTubePlaylist class holds a list of Video objects
class YouTubePlaylist {
    private List<Video2> videos = new ArrayList<>();

    // Add a video to the playlist
    public void addVideo(Video2 video) {
        videos.add(video);
    }

    // Expose the video list
    public List<Video2> getVideos() {
        return videos;
    }
}

// Client Code
public class WithoutIterator {
    public static void main(String[] args) {
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video2("LLD Tutorial"));
        playlist.addVideo(new Video2("System Design Basics"));

        // Loop through videos and print titles
        for (Video2 v : playlist.getVideos()) {
            System.out.println(v.getTitle());
        }
    }
}
