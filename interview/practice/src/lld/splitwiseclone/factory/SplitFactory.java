package lld.splitwiseclone.factory;

import lld.splitwiseclone.model.SplitType;
import lld.splitwiseclone.strategy.EqualSplit;
import lld.splitwiseclone.strategy.ExactSplit;
import lld.splitwiseclone.strategy.PercentageSplit;
import lld.splitwiseclone.strategy.SplitStrategy;

public class SplitFactory {

    public static SplitStrategy getSplitStrategy(SplitType type){

        switch(type){

            case EQUAL:
                return new EqualSplit();

            case EXACT:
                return new ExactSplit();

            case PERCENTAGE:
                return new PercentageSplit();

            default:
                return new EqualSplit();
        }
    }
}