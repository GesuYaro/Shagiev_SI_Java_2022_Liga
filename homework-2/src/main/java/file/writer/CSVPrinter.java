package file.writer;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@RequiredArgsConstructor
public class CSVPrinter implements ObjectPrinter {

    private final Writer writer;

    @Override
    public <T> void writeObjects(List<T> list) throws IOException {
        try {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(list);
            writer.flush();
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

}
