package algotithm;

import drawing.Position;

import java.util.ArrayList;
import java.util.List;

public class DDAAlgorithm implements Algorithm {


    @Override
    public List<Position> execute(List<Position> inputPositions) {
        List<Position> positions = new ArrayList<>();
        positions.add(inputPositions.get(0));
        Position firstPoint = inputPositions.get(0);
        Position secondPoint = inputPositions.get(1);
        int dx, dy, steps;
        double xc, yc, x, y, k;
        dx = secondPoint.getxIndex() - firstPoint.getxIndex();
        dy = secondPoint.getyIndex() - firstPoint.getyIndex();
        if (dx > Math.abs(dy))
            steps = Math.abs(dx);
        else {
            steps = Math.abs(dy);
        }
        xc = ((double) dx / steps);
        yc = ((double) dy / steps);
        x = firstPoint.getxIndex();
        y = firstPoint.getyIndex();
        for (k = 1; k <= steps; k++) {
            x = x + xc;
            y = y + yc;
            positions.add(new Position((int) x, (int) y));
        }
        return positions;
    }

    @Override
    public int getPointCount() {
        return 2;
    }
}
