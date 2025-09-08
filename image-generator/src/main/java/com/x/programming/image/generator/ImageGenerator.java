package com.x.programming.image.generator;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ImageGenerator {

    private final RestTemplate restTemplate;

    public byte[] fetchImage() {
        String imageUrl = "https://picsum.photos/200";
        return restTemplate.getForObject(imageUrl, byte[].class);
    }

}
