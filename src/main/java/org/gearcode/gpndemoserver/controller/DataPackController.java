package org.gearcode.gpndemoserver.controller;

import org.gearcode.gpndemoserver.entity.DataPack;
import org.gearcode.gpndemoserver.service.DataPackService;
import org.gearcode.gpndemoserver.utils.TempFileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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
    public void getZipWithDataByDate(@RequestParam("from") long from, @RequestParam("to") long to, HttpServletResponse response) throws IOException {
        File file = service.getZipWithDataByDate(from, to);
        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        TempFileHelper.deleteFile(file);
    }

}
