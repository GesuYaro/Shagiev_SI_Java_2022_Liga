package file.writer;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class CSVFilePrinter implements ObjectPrinter {

    private final File file;

    @Override
    public <T> void writeObjects(List<T> list) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter);
        csvPrinter.writeObjects(list);
        fileWriter.close();
    }

}
