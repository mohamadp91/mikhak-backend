package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.RoadInputModel;
import com.example.transportationbackend.models.Road;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

@Service
public class DataProcessor implements ItemProcessor<RoadInputModel, Road> {

    @Override
    public Road process(RoadInputModel item) throws Exception {
        Road road = new Road();
        road.setFirstPoint(item.getFirstPoint());
        road.setSecondPoint(item.getSecondPoint());
        road.setWidth(Float.parseFloat(item.getWidth()));
        return road;
    }
}
