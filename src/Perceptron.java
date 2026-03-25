import java.util.*;

public class Perceptron {
    public double[] weights;
    public double threshold;
    public double alpha;
    public double beta;
    public int dimension;

    public Perceptron(int dimension, double alpha, double threshold) {
        this.dimension = dimension;
        this.alpha = alpha;
        this.threshold = threshold;
        this.weights = new double[dimension];
        this.beta = 0;

        Random rand = new Random();
        for (int i = 0; i < dimension; i++) {
            weights[i] = rand.nextDouble() * 0.1 - 0.05;
        }
        beta = rand.nextDouble() * 0.1 - 0.05;
    }

    public int predict(double[] inputs) {
        double sum = beta;
        for (int i = 0; i < dimension; i++) {
            sum += inputs[i] * weights[i];
        }
        return sum >= threshold ? 1 : 0;
    }

    public List<Double> train(List<double[]> inputs, List<Integer> labels) {
        List<Double> accuracies = new ArrayList<>();
        boolean converged = false;
        int epoch = 0;
        int maxEpochs = 100;

        while (!converged && epoch < maxEpochs) {
            converged = true;
            for (int i = 0; i < inputs.size(); i++) {
                double[] input = inputs.get(i);
                int predicted = predict(input);
                int target = labels.get(i);

                if (predicted != target) {
                    converged = false;
                    double error = target - predicted;
                    for (int j = 0; j < dimension; j++) {
                        weights[j] += alpha * error * input[j];
                    }
                    beta += alpha * error;
                }
            }

            int correct = 0;
            for (int i = 0; i < inputs.size(); i++) {
                if (predict(inputs.get(i)) == labels.get(i)) {
                    correct++;
                }
            }
            accuracies.add((double) correct / inputs.size());
            epoch++;
        }
        return accuracies;
    }
}
