package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.LightPostInput;
import com.example.transportationbackend.excelReader.models.PathInputModel;
import com.example.transportationbackend.models.LightPost;
import com.example.transportationbackend.models.PathEntity;
import com.example.transportationbackend.models.enums.CablePass;
import com.example.transportationbackend.models.enums.LightPostOnPathSides;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DataProcessor implements ItemProcessor<PathInputModel, PathEntity> {

    private final String lightPostOnPathSidesString = "دوطرفه ";
    private final String CablePassString = "bottom";

    @Override
    public PathEntity process(PathInputModel item) throws Exception {
        PathEntity pathEntity = new PathEntity();
        List<LightPost> lightPostList = new ArrayList<>();

        try {
            for (LightPostInput lightPostInputModel : item.getLightPostList()) {
                LightPost lightPostEntity = new LightPost(Double.parseDouble(lightPostInputModel.getHeight())
                        ,Double.parseDouble(lightPostInputModel.getPower())
                        ,lightPostInputModel.getLightProductionType()
                        ,pathEntity);

                lightPostList.add(lightPostEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in 2");
        }

        try {
            pathEntity.setFirstPoint(item.getFirstPoint());
            pathEntity.setSecondPoint(item.getSecondPoint());
            pathEntity.setWidth(Double.parseDouble(item.getWidth()));
            pathEntity.setDistanceEachLightPost(Double.parseDouble(item.getDistanceEachLightPost()));

            if (equalStrings(lightPostOnPathSidesString, item.getLightPostOnPathSides()))
                pathEntity.setLightPostOnPathSides(LightPostOnPathSides.TWO_SIDES);
            else
                pathEntity.setLightPostOnPathSides(LightPostOnPathSides.ONE_SIDE);

            if (equalStrings(CablePassString, item.getCablePass()))
                pathEntity.setCablePass(CablePass.BOTTOM);
            else
                pathEntity.setCablePass(CablePass.TOP);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error in 1");
        }


        pathEntity.setLightPosts(lightPostList);
        return pathEntity;
    }

    private boolean equalStrings(String src, String destination) {
        String srcTrim = src.trim();
        String destinationTrim = destination.trim();

        if (src.equals(destination)
                || srcTrim.equals(destinationTrim)
                || src.contains(destinationTrim)
                || src.endsWith(destinationTrim)) {
            return true;
        }
        return false;
    }

}
