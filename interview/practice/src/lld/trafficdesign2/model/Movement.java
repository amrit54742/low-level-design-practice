package lld.trafficdesign2.model;

import java.util.Objects;

public class Movement {


    private Direction from;
    private Direction to;

    public Movement(Direction from, Direction to) {
        this.from = from;
        this.to = to;
    }

    public Direction getFrom() {
        return from;
    }

    public Direction getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movement)) return false;
        Movement movement = (Movement) o;
        return from == movement.from && to == movement.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }


}
