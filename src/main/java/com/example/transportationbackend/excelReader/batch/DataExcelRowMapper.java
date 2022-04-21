package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.LightPostInput;
import com.example.transportationbackend.excelReader.models.PathInputModel;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.support.rowset.RowSet;

public class DataExcelRowMapper implements RowMapper<LightPostInput> {

    @Override
    public LightPostInput mapRow(RowSet rowSet) throws Exception {

        PathInputModel path = new PathInputModel();
        LightPostInput lightPost = new LightPostInput();

        try {
            path.setPathId(rowSet.getColumnValue(0));
            path.setFirstPoint(rowSet.getColumnValue(1));
            path.setSecondPoint(rowSet.getColumnValue(2));
            path.setWidth(rowSet.getColumnValue(3));
            path.setCablePass(rowSet.getColumnValue(4));
            path.setDistanceEachLightPost(rowSet.getColumnValue(5));

            lightPost.setLightPostId(rowSet.getColumnValue(6));
            lightPost.setSides(rowSet.getColumnValue(6));
            lightPost.setPower(rowSet.getColumnValue(8));
            lightPost.setHeight(rowSet.getColumnValue(9));
            lightPost.setLightProductionType(rowSet.getColumnValue(10));

        } catch (Exception e) {
            e.printStackTrace();
        }
        lightPost.setPath(path);

        return lightPost;
    }
}
