package lld.templatepattern;

import lld.templatepattern.base.ModelTrainer;
import lld.templatepattern.concrete.DecisionTreeTrainer;
import lld.templatepattern.concrete.NeuralNetworkTrainer;

public class TemplateMethodPattern {

    public static void main(String[] args) {

        System.out.println("=== Neural Network Training ===");
        ModelTrainer nnTrainer = new NeuralNetworkTrainer();
        nnTrainer.trainPipeline("data/images/");

        System.out.println("\n=== Decision Tree Training ===");
        ModelTrainer dtTrainer = new DecisionTreeTrainer();
        dtTrainer.trainPipeline("data/iris.csv");
    }
}