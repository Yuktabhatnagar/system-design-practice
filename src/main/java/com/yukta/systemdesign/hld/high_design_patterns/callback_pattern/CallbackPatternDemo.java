package com.yukta.systemdesign.hld.high_design_patterns.callback_pattern;

public class CallbackPatternDemo {
    public static void main(String[] args) {
        FileDownloader downloader = new FileDownloader();
        downloader.download("report.pdf", new DownloadCallback() {
            public void onSuccess(String fileName) { System.out.println("Downloaded " + fileName); }
            public void onFailure(String reason) { System.out.println("Download failed: " + reason); }
        });
    }
}

interface DownloadCallback {
    void onSuccess(String fileName);
    void onFailure(String reason);
}

class FileDownloader {
    void download(String fileName, DownloadCallback callback) {
        if (fileName == null || fileName.isBlank()) {
            callback.onFailure("File name is required");
            return;
        }
        callback.onSuccess(fileName);
    }
}
