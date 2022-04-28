package com.example.transportationbackend.excelReader.batch;

import com.example.transportationbackend.models.LightPost;
import com.example.transportationbackend.models.PathEntity;
import com.example.transportationbackend.repositories.LightPostRepository;
import com.example.transportationbackend.repositories.PathRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataItemWriter implements ItemWriter<LightPost> {

    @Autowired
    private PathRepository pathRepository;

    @Autowired
    private LightPostRepository lpRepository;

    private PathEntity savedPath;

    @Override
    public void write(List<? extends LightPost> lpLists) throws Exception {
        for (LightPost lp : lpLists) {

            if (!isLightPostExists(lp.getLightPostId())) {

                Double pathId = lp.getPath().getPathId();
                if (isPathExists(pathId)) {
                    savedPath = pathRepository.findByPathId(pathId);
                } else {
                    savedPath = lp.getPath();
                    pathRepository.save(savedPath);
                }
                lp.setPath(savedPath);
                lpRepository.save(lp);
            }
        }
    }


    public boolean isLightPostExists(Double id) {
        return lpRepository.existsByLightPostId(id);
    }

    public boolean isPathExists(Double id) {
        return pathRepository.existsByPathId(id);
    }
}
