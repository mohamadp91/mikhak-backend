package com.example.transportationbackend.controller;

import com.example.transportationbackend.CSVReader.CSVReader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping(value = "/transportation")
public class Controller {

    private final String jobQualifier = "readExcelJob";

    @PostMapping(value = "/upload_file")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (Objects.requireNonNull(file.getOriginalFilename()).endsWith(".xlsx")) {
            CSVReader reader = new CSVReader();
        }
    }
}
