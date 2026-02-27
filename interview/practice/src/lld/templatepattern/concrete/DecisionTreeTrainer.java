package lld.templatepattern.concrete;

import lld.templatepattern.base.ModelTrainer;

public class DecisionTreeTrainer extends ModelTrainer {

    @Override
    protected void trainModel() {
        System.out.println("[DecisionTree] Building decision tree with max_depth=5");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[DecisionTree] Computing classification report (precision/recall)");
    }
}