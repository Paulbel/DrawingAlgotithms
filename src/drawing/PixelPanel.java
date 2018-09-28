package drawing;

import javafx.scene.layout.Pane;

public class PixelPanel extends Pane {
    private Position position;

    public PixelPanel(int xIndex, int yIndex) {
        super();
        this.position = new Position(xIndex, yIndex);
        this.setStyle("-fx-background-color: #ffffff;");
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
