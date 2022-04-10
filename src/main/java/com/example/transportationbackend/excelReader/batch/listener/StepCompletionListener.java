package com.example.transportationbackend.excelReader.batch.listener;

import org.springframework.batch.core.annotation.AfterRead;

public class StepCompletionListener {

    @AfterRead
    public void afterJob() {
    }

}
