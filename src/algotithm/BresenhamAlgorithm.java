package algotithm;

import drawing.Position;

import java.util.ArrayList;
import java.util.List;

public class BresenhamAlgorithm implements Algorithm {
    @Override
    public List<Position> execute(List<Position> positions) {
        List<Position> line = new ArrayList<>();

        Position firstPoint = positions.get(0);
        int x0 = firstPoint.getxIndex();
        int y0 = firstPoint.getyIndex();


        Position secondPosition = positions.get(1);
        int x1 = secondPosition.getxIndex();
        int y1 = secondPosition.getyIndex();


        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);

        int sx = x0 < x1 ? 1 : -1;
        int sy = y0 < y1 ? 1 : -1;

        int err = dx - dy;
        int e2;

        while (true) {
            line.add(new Position(x0, y0));

            if (x0 == x1 && y0 == y1)
                break;

            e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x0 = x0 + sx;
            }

            if (e2 < dx) {
                err = err + dx;
                y0 = y0 + sy;
            }
        }
        return line;
    }

    @Override
    public int getPointCount() {
        return 2;
    }
}
