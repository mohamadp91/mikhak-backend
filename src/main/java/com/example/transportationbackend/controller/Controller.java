package com.example.transportationbackend.controller;

import com.example.transportationbackend.models.LightPost;
import com.example.transportationbackend.models.PathEntity;
import com.example.transportationbackend.repositories.LightPostRepository;
import com.example.transportationbackend.repositories.PathRepository;
import com.example.transportationbackend.services.FileManager;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/transportation")
public class Controller {

    @Autowired
    private PathRepository pathRepository;

    @Autowired
    private LightPostRepository lpRepository;


    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private FileManager fileManager;

    @GetMapping("/paths")
    public List<PathEntity> getPath() {
        return pathRepository.findAll();
    }

    @GetMapping("/lightposts")
    public List<LightPost> getLightPosts() {
        return lpRepository.findAll();
    }

    @PostMapping(value = "/upload_file")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (fileManager.isExcelFile(file)) {
            Path filePath = fileManager.saveFile(file);
            runJob(filePath);
        }
    }

    private void runJob(Path filePath) {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("ID", UUID.randomUUID().toString())
                .addString("filePath", filePath.toString())
                .toJobParameters();

        try {
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException
                | JobRestartException
                | JobInstanceAlreadyCompleteException
                | JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }
}
