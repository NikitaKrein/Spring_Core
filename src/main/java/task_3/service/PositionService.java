package task_3.service;

import task_3.bean.Position;
import task_3.utility.PositionComparator;

import java.util.Set;
import java.util.TreeSet;

public class PositionService {
    private PositionComparator positionComparator = new PositionComparator();
    private Set<Position> positions = new TreeSet<>(positionComparator);

    public Set<Position> getPositions() {
        return positions;
    }

    public void create(Position position){
        if (position == null) throw new NullPointerException();
        positions.add(position);
    }

    public Position read(String name) {
        if (name == null) throw new NullPointerException();
        Position ans = null;
        for (Position position : positions) {
            if (position.getName().equals(name)) {
                ans = position;
            }
        }
        return ans;
    }

    public void update(Position lastPosition, Position newPosition){
        if (lastPosition == null || newPosition == null) throw new NullPointerException();
        delete(lastPosition);
        create(newPosition);
    }

    public void delete(Position position){
        if (position == null) throw new NullPointerException();
        positions.remove(position);
    }
}
