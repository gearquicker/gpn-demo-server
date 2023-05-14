package org.gearcode.gpndemoserver.entity;

import org.gearcode.gpndemoserver.converter.DataRowsConverter;
import org.gearcode.gpndemoserver.model.DataRow;

import javax.persistence.*;
import java.util.List;

@Entity
public class DataPack {

    @Id
    @GeneratedValue
    private long id;
    private long startTime;
    private long endTime;
    @Convert(converter = DataRowsConverter.class)
    @Column(columnDefinition = "text")
    private List<DataRow> data;

    public DataPack() {
    }

    public DataPack(long startTime, long endTime, List<DataRow> data) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public List<DataRow> getData() {
        return data;
    }

    public void setData(List<DataRow> data) {
        this.data = data;
    }

}
