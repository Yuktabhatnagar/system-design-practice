package com.yukta.systemdesign.lld.designpatterns.behavioural.observer;

class YouTubeChannel2 {
    public void uploadNewVideo(String videoTitle) {
        // Upload the video
        System.out.println("Uploading: " + videoTitle + "\n");

        // Manually notify users
        System.out.println("Sending email to user1@example.com");
        System.out.println("Pushing in-app notification to user3@example.com");
    }
}

public class WithoutObserver{
    public static void main(String[] args) {
        // Create a channel and upload a new video
        YouTubeChannel2 channel = new YouTubeChannel2();
        channel.uploadNewVideo("Design Patterns in Java");
    }
}
