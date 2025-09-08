package com.x.programming.httpserver.controllers;

import com.x.programming.image.generator.ImageGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/yolo")
@RequiredArgsConstructor
public class YoloController {

    private final ImageGenerator imageGenerator;

    @GetMapping("/say/{name}")
    public String sayYolo(@PathVariable String name) {
        return "Yolo, " + name;
    }

    @GetMapping(value = "/image/", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage() {
        final byte[] imageBytes = imageGenerator.fetchImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        return ResponseEntity.ok().headers(headers).body(imageBytes);
    }

}
