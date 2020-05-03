package task_2.utility;

import task_2.bean.Position;

import java.util.Comparator;

public class PositionComparator implements Comparator<Position> {
    @Override
    public int compare(Position o1, Position o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
