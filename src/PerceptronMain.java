import java.util.*;
import java.io.IOException;
import javax.swing.*;

public class PerceptronMain {
    public static void main(String[] args) {
        try {
            List<IrisRecord> dataset = IrisDataLoader.loadIrisDataset("iris.csv");
            DatasetSplit split = PrepareDataset.trainTestSplit(dataset, 0.7);

            List<double[]> trainInputs = new ArrayList<>();
            List<Integer> trainLabels = new ArrayList<>();
            for (IrisRecord record : split.trainingSet) {
                trainInputs.add(record.features);
                trainLabels.add(record.species.equals("setosa") ? 1 : 0);
            }
            Perceptron perceptron = new Perceptron(4, 0.1, 0.5);
            List<Double> accuracies = perceptron.train(trainInputs, trainLabels);

            List<String> predictions = new ArrayList<>();
            List<String> actuals = new ArrayList<>();
            for (IrisRecord record : split.testSet) {
                predictions.add(perceptron.predict(record.features) == 1 ? "setosa" : "versicolor");
                actuals.add(record.species);
            }

            System.out.println("Training accuracies by epoch:");
            for (int i = 0; i < accuracies.size(); i++) {
                System.out.printf("Epoch %2d: %.2f%%\n", i+1, accuracies.get(i)*100);
            }
            System.out.printf("\nFinal test accuracy: %.2f%%\n",
                    EvaluationMetrics.measureAccuracy(actuals, predictions)*100);


        } catch (IOException e) {
            System.err.println("Error loading dataset: " + e.getMessage());
        }
    }
}