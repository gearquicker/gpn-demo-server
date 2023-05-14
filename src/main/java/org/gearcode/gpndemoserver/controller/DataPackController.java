package org.gearcode.gpndemoserver.controller;

import org.gearcode.gpndemoserver.entity.DataPack;
import org.gearcode.gpndemoserver.model.DataRow;
import org.gearcode.gpndemoserver.service.DataPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/dataPack")
public class DataPackController {

    @Autowired
    private DataPackService service;

    @PostMapping("/put")
    public void putDataPack(@RequestBody DataPack dataPack) {
        service.putDataPack(dataPack);
    }

    @GetMapping("/get")
    public List<DataRow> getByDate(@RequestParam("from") long from, @RequestParam("to") long to) {
        return service.getDataRowsByDate(from, to);
    }

}
