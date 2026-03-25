import java.util.*;

public class PrepareDataset {
    public static DatasetSplit trainTestSplit(List<IrisRecord> dataset, double trainRatio) {
        Map<String, List<IrisRecord>> classGroups = new HashMap<>();
        for (IrisRecord record : dataset) {
            classGroups.putIfAbsent(record.species, new ArrayList<>());
            classGroups.get(record.species).add(record);
        }

        List<IrisRecord> trainingSet = new ArrayList<>();
        List<IrisRecord> testSet = new ArrayList<>();

        for (List<IrisRecord> group : classGroups.values()) {
            int splitIndex = (int) (group.size() * trainRatio);
            trainingSet.addAll(group.subList(0, splitIndex));
            testSet.addAll(group.subList(splitIndex, group.size()));
        }

        return new DatasetSplit(trainingSet, testSet);
    }
}

class DatasetSplit {
    List<IrisRecord> trainingSet;
    List<IrisRecord> testSet;

    public DatasetSplit(List<IrisRecord> trainingSet, List<IrisRecord> testSet) {
        this.trainingSet = trainingSet;
        this.testSet = testSet;
    }
}