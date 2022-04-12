package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.LightPostInput;
import com.example.transportationbackend.excelReader.models.PathInputModel;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

import java.util.ArrayList;
import java.util.List;

public class DataExcelRowMapper implements RowMapper<PathInputModel> {

    private final List<LightPostInput> lightPostList = new ArrayList<>();

    @Override
    public PathInputModel mapRow(RowSet rowSet) throws Exception {
        PathInputModel path = new PathInputModel();
        LightPostInput lightPost = new LightPostInput();
        try {
            path.setFirstPoint(rowSet.getColumnValue(0));
            path.setSecondPoint(rowSet.getColumnValue(1));
            path.setWidth(rowSet.getColumnValue(2));
            path.setCablePass(rowSet.getColumnValue(3));
            path.setDistanceEachLightPost(rowSet.getColumnValue(4));
            path.setLightPostOnPathSides(rowSet.getColumnValue(5));

            lightPost.setPower(rowSet.getColumnValue(6));
            lightPost.setHeight(rowSet.getColumnValue(7));
            lightPost.setLightProductionType(rowSet.getColumnValue(8));

        } catch (Exception e) {
            e.printStackTrace();
        }

        lightPostList.add(lightPost);
        path.setLightPostList(lightPostList);
        return path;
    }
}
