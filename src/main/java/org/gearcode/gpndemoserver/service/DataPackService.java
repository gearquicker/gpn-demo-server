package org.gearcode.gpndemoserver.service;

import org.gearcode.gpndemoserver.entity.DataPack;
import org.gearcode.gpndemoserver.model.DataRow;
import org.gearcode.gpndemoserver.repository.DataPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataPackService {

    @Autowired
    private DataPackRepository repository;

    public void putDataPack(DataPack dataPack) {
        repository.save(dataPack);
    }

    public List<DataRow> getDataRowsByDate(long from, long to) {
        List<DataRow> ans = new ArrayList<>();
        for (DataPack dataPack : repository.findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(from, to)) {
            ans.addAll(dataPack.getData());
        }
        return ans;
    }

}
