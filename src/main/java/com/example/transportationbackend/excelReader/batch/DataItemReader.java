package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.RoadInputModel;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class DataItemReader extends PoiItemReader<RoadInputModel> {

    private String filePath;

    public DataItemReader(){
        setRowMapper(excelRowMapper());
    }

    private RowMapper<RoadInputModel> excelRowMapper() {
        return new DataExcelRowMapper();
    }

    public void readData(){
        if(filePath != null && !filePath.isEmpty()) {
            try {
                setResource(new FileSystemResource(filePath));
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
}