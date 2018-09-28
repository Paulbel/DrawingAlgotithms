package algotithm;

import drawing.Position;

import java.util.List;

public interface Algorithm {
    List<Position> execute(List<Position> positions);

    int getPointCount();
}
