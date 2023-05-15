package org.gearcode.gpndemoserver.service;

import org.gearcode.gpndemoserver.entity.DataPack;
import org.gearcode.gpndemoserver.model.DataRow;
import org.gearcode.gpndemoserver.repository.DataPackRepository;
import org.gearcode.gpndemoserver.utils.ZipHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataPackService {

    private final DataPackRepository repository;

    @Autowired
    public DataPackService(DataPackRepository repository) {
        this.repository = repository;
    }

    public void putDataPack(DataPack dataPack) {
        repository.save(dataPack);
    }

    public File getZipWithDataByDate(long from, long to) {
        try {
            return ZipHelper.getZipFile(dataToString(getDataRowsByDate(from, to)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<DataRow> getDataRowsByDate(long from, long to) {
        List<DataRow> ans = new ArrayList<>();
        for (DataPack dataPack : repository.findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(from, to)) {
            ans.addAll(dataPack.getData());
        }
        return ans;
    }

    private String dataToString(List<DataRow> data) {
        StringBuilder builder = new StringBuilder();
        builder.append("time").append("\t")
                .append("ax").append("\t")
                .append("ay").append("\t")
                .append("az").append("\t")
                .append("gx").append("\t")
                .append("gy").append("\t")
                .append("gz").append("\t")
                .append("mic").append("\n");
        for (DataRow row : data) {
            builder.append(row.getTime()).append("\t")
                    .append(row.getAx()).append("\t")
                    .append(row.getAy()).append("\t")
                    .append(row.getAz()).append("\t")
                    .append(row.getGx()).append("\t")
                    .append(row.getGy()).append("\t")
                    .append(row.getGz()).append("\t")
                    .append(row.getMic()).append("\n");
        }
        return builder.toString();
    }

}
