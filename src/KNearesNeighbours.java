import java.util.*;

public class KNearesNeighbours {
    private int k;
    private List<double[]> trainingVectors;
    private List<String> trainingClasses;

    public KNearesNeighbours(int k, List<double[]> trainingVectors, List<String> trainingClasses) {
        this.k = k;
        this.trainingVectors = trainingVectors;
        this.trainingClasses = trainingClasses;
    }

    public String predict(double[] observation) {
        List<Double> distances = new ArrayList<>();
        List<String> classes = new ArrayList<>();

        for (int i = 0; i < trainingVectors.size(); i++) {
            double distance = calculateEuclideanDistance(observation, trainingVectors.get(i));
            distances.add(distance);
            classes.add(trainingClasses.get(i));
        }

        sortDistances(distances, classes);
        List<String> nearestClasses = classes.subList(0, Math.min(k, classes.size()));
        return findPredictedClass(nearestClasses);
    }

    private double calculateEuclideanDistance(double[] vector1, double[] vector2) {
        double sum = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            sum += Math.pow(vector1[i] - vector2[i], 2);
        }
        return Math.sqrt(sum);
    }

    private void sortDistances(List<Double> distances, List<String> classes) {
        for (int i = 0; i < distances.size()-1; i++) {
            for (int j = 0; j < distances.size()-i-1; j++) {
                if (distances.get(j) > distances.get(j+1)) {
                    Collections.swap(distances, j, j+1);
                    Collections.swap(classes, j, j+1);
                }
            }
        }
    }

    private String findPredictedClass(List<String> classes) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String cls : classes) {
            frequencyMap.put(cls, frequencyMap.getOrDefault(cls, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        List<String> candidates = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                candidates.add(entry.getKey());
            }
        }

        Random rand = new Random();
        return candidates.get(rand.nextInt(candidates.size()));
    }
}
