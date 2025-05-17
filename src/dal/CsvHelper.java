/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class CsvHelper {

    public static <T> List<T> readCsv(String filePath, Function<String[], T> mapper) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            return reader.readAll().stream()
                    .skip(1)
                    .map(mapper)
                    .collect(Collectors.toList());
        } catch (IOException | CsvException e) {
            return List.of();
        }
    }

    public static <T> void writeCsv(String filePath, String[] header, List<T> dataList, Function<T, String[]> mapper) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(header);
            dataList.forEach(data -> writer.writeNext(mapper.apply(data)));
        } catch (IOException e) {

        }
    }
}
