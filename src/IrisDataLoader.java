import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class IrisDataLoader {
    public static List<IrisRecord> loadIrisDataset(String filePath) throws IOException {
        List<IrisRecord> records = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            double[] features = new double[4];
            for (int j = 0; j < 4; j++) {
                features[j] = Double.parseDouble(values[j]);
            }
            records.add(new IrisRecord(features, values[4]));
        }

        return records;
    }
}
