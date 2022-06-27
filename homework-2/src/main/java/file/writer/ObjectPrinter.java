package file.writer;

import java.io.IOException;
import java.util.List;

public interface ObjectPrinter {

    public <T> void writeObjects(List<T> list) throws IOException;

}
