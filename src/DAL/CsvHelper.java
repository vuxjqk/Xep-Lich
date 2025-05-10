/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author PC
 */
public class CsvHelper {

    public static <T> List<T> readFromCsv(String filePath, Function<String[], T> mapper) {
        List<T> result = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            for (int i = 1; i < records.size(); i++) {
                String[] record = records.get(i);
                result.add(mapper.apply(record));
            }
        } catch (IOException | CsvException e) {

        }

        return result;
    }

    public static <T> void writeToCsv(
            String[] header,
            List<T> dataList,
            String filePath,
            Function<T, String[]> mapper) {

        try (CSVWriter writer = new CSVWriter(
                new FileWriter(filePath),
                ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {

            writer.writeNext(header);
            for (T data : dataList) {
                writer.writeNext(mapper.apply(data));
            }
        } catch (IOException e) {

        }
    }
}
