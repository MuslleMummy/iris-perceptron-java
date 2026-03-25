import java.util.*;

public class EvaluationMetrics {
    public static double measureAccuracy(List<String> actualClasses, List<String> predictedClasses) {
        int correctPredictions = 0;
        for (int i = 0; i < actualClasses.size(); i++) {
            if (actualClasses.get(i).equals(predictedClasses.get(i))) {
                correctPredictions++;
            }
        }
        return (double) correctPredictions / actualClasses.size();
    }
}