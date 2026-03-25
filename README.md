# Iris Perceptron Classifier (Java)

This project implements a simple **Perceptron machine learning model in Java** to classify flowers from the **Iris dataset**.

The model is trained to distinguish **Iris Setosa** from **Iris Versicolor** using four numeric flower features.

## Features

* Implementation of the **Perceptron algorithm**
* Loading and parsing the **Iris dataset**
* Train/test dataset split
* Accuracy evaluation
* Training accuracy per epoch

## Project Structure

```
src/
 ├── EvaluationMetrics.java     # Accuracy calculation
 ├── IrisDataLoader.java        # Dataset loader
 ├── IrisRecord.java            # Data model for iris records
 ├── KNearestNeighbours.java    # (Optional) KNN implementation
 ├── Perceptron.java            # Perceptron model
 ├── PerceptronMain.java        # Main entry point
 └── PrepareDataset.java        # Dataset splitting
```

## Dataset

The project uses the classic **Iris dataset**, which contains measurements of iris flowers:

Features used:

* Sepal length
* Sepal width
* Petal length
* Petal width

Classes used in this project:

* `setosa`
* `versicolor`

## How it Works

1. Load the dataset from `iris.csv`
2. Split the data into **training (70%)** and **testing (30%)**
3. Train a **Perceptron model**
4. Track training accuracy per epoch
5. Evaluate the model on the test dataset

## Example Output

```
Training accuracies by epoch:
Epoch 1: 92.00%
Epoch 2: 96.00%
Epoch 3: 100.00%

Final test accuracy: 96.67%
```

## How to Run

Compile:

```
javac *.java
```

Run:

```
java PerceptronMain
```

## Technologies

* Java
* Basic Machine Learning concepts
* Perceptron algorithm

## Author

Student machine learning practice project.
