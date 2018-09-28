package drawing;

import java.util.Objects;

public class Position {
    private int xIndex;
    private int yIndex;

    public Position(int xIndex, int yIndex) {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int getxIndex() {
        return xIndex;
    }

    public void setxIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public int getyIndex() {
        return yIndex;
    }

    public void setyIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xIndex == position.xIndex &&
                yIndex == position.yIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xIndex, yIndex);
    }
}
