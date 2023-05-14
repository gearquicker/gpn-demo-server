package org.gearcode.gpndemoserver.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.gearcode.gpndemoserver.model.DataRow;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.List;

@Converter
public class DataRowsConverter implements AttributeConverter<List<DataRow>, String> {

    private final Gson gson;

    public DataRowsConverter() {
        this.gson = new GsonBuilder().serializeSpecialFloatingPointValues().create();
    }


    @Override
    public String convertToDatabaseColumn(List<DataRow> dataRows) {
        return gson.toJson(dataRows);
    }

    @Override
    public List<DataRow> convertToEntityAttribute(String s) {
        return gson.fromJson(s, new TypeToken<List<DataRow>>(){}.getType());
    }
}
