package com.yukta.systemdesign.hld;

import java.util.HashMap;
import java.util.Map;

public class UrlShortenerDesign {

    public static void main(String[] args) {
        UrlShortenerService service = new UrlShortenerService("https://short.ly/");

        String shortUrl = service.shorten("https://example.com/articles/system-design");

        System.out.println(shortUrl);
        System.out.println(service.resolve(shortUrl));
    }
}

class UrlShortenerService {

    private final String domain;
    private final Map<String, String> codeToUrl = new HashMap<>();
    private long sequence = 1;

    UrlShortenerService(String domain) {
        this.domain = domain;
    }

    String shorten(String longUrl) {
        String code = Base62Encoder.encode(sequence++);
        codeToUrl.put(code, longUrl);
        return domain + code;
    }

    String resolve(String shortUrl) {
        String code = shortUrl.substring(domain.length());
        String longUrl = codeToUrl.get(code);

        if (longUrl == null) {
            throw new IllegalArgumentException("Unknown short URL: " + shortUrl);
        }

        return longUrl;
    }
}

class Base62Encoder {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String encode(long value) {
        StringBuilder encoded = new StringBuilder();

        while (value > 0) {
            int index = (int) (value % ALPHABET.length());
            encoded.append(ALPHABET.charAt(index));
            value = value / ALPHABET.length();
        }

        return encoded.reverse().toString();
    }
}
