package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.excelReader.models.LightPostInput;
import com.example.transportationbackend.excelReader.models.PathInputModel;
import com.example.transportationbackend.models.LightPost;
import com.example.transportationbackend.models.PathEntity;
import com.example.transportationbackend.models.enums.CablePass;
import com.example.transportationbackend.models.enums.LightPostSides;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DataProcessor implements ItemProcessor<LightPostInput, LightPost> {

    private final String lightPostSidesString = "دوطرفه";
    private final String CablePassString = "bottom";

    @Override
    public LightPost process(LightPostInput lp) throws Exception {
        PathEntity pathEntity = new PathEntity();
        LightPost lpEntity = new LightPost();
        List<LightPost> lpList = new ArrayList<>();

        try {
            lpEntity.setLightPostId(Double.parseDouble(lp.getLightPostId()));
            lpEntity.setHeight(Double.parseDouble(lp.getHeight()));
            lpEntity.setPower(Double.parseDouble(lp.getPower()));
            lpEntity.setLightProductionType(lp.getLightProductionType());
            lpEntity.setPath(pathEntity);

            if (equalStrings(lightPostSidesString, lp.getSides()))
                lpEntity.setSides(LightPostSides.TWO_SIDES);
            else
                lpEntity.setSides(LightPostSides.ONE_SIDE);

            lpList.add(lpEntity);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("an error occurred in processor read light post");
        }

        try {
            PathInputModel path = lp.getPath();
            pathEntity.setPathId(Double.parseDouble(path.getPathId()));
            pathEntity.setFirstPoint(path.getFirstPoint());
            pathEntity.setSecondPoint(path.getSecondPoint());
            pathEntity.setWidth(Double.parseDouble(path.getWidth()));
            pathEntity.setDistanceEachLightPost(Double.parseDouble(path.getDistanceEachLightPost()));

            if (equalStrings(CablePassString, path.getCablePass()))
                pathEntity.setCablePass(CablePass.BOTTOM);
            else
                pathEntity.setCablePass(CablePass.TOP);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("an error occurred in processor read path");
        }

        pathEntity.setLightPosts(lpList);
        lpEntity.setPath(pathEntity);

        return lpEntity;
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
