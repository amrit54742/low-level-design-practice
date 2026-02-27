package lld.templatepattern.base;

public abstract class ModelTrainer {

    // Template Method
    public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preprocessData();
        trainModel();
        evaluateModel();
        saveModel();
    }

    protected void loadData(String path) {
        System.out.println("[Common] Loading dataset from " + path);
    }

    protected void preprocessData() {
        System.out.println("[Common] Splitting into train/test and normalizing");
    }

    protected abstract void trainModel();
    protected abstract void evaluateModel();

    protected void saveModel() {
        System.out.println("[Common] Saving model to disk as default format");
    }
}