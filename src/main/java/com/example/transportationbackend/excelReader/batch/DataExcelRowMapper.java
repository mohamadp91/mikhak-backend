package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.RoadInputModel;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

public class DataExcelRowMapper implements RowMapper<RoadInputModel> {

    @Override
    public RoadInputModel mapRow(RowSet rowSet) throws Exception {
        RoadInputModel road = new RoadInputModel();

        try {
            road.setFirstPoint(rowSet.getColumnValue(0));
            road.setSecondPoint(rowSet.getColumnValue(1));
            road.setWidth(rowSet.getColumnValue(2));
            road.setDistanceEachLightPost(rowSet.getColumnValue(3));
            road.setLightPostOnRoadSides(rowSet.getColumnValue(4));
            road.setLp_height(rowSet.getColumnValue(5));
            road.setLp_power(rowSet.getColumnValue(6));
            road.setLp_lightProductionType(rowSet.getColumnValue(7));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return road;
    }
}
