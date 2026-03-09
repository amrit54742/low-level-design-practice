package lld.splitwiseclone.strategy;

import lld.splitwiseclone.model.Split;

import java.util.ArrayList;
import java.util.List;

public class PercentageSplit implements SplitStrategy {

    @Override
    public List<Split> calculateSplit(double totalAmount,
                                      List<String> userIds,
                                      List<Double> values) {

        List<Split> splits = new ArrayList<>();

        for(int i=0;i<userIds.size();i++){
            double amount = (totalAmount * values.get(i))/100.0;
            splits.add(new Split(userIds.get(i), amount));
        }

        return splits;
    }
}
