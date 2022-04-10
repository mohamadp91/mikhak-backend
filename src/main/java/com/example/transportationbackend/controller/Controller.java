package com.example.transportationbackend.controller;

import com.example.transportationbackend.services.FileManager;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping(value = "/transportation")
public class Controller {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private FileManager fileManager;

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
                .addString("filePath",filePath.toString())
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
