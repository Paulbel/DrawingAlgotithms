package drawing;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import algotithm.Algorithm;
import algotithm.BresenhamAlgorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PixelGridPanel extends GridPane {
    private Iterator<PixelPanel> pixelPanelIterator;
    private List<PixelPanel> pixelList;
    private Algorithm algorithm;
    private List<Position> selectedList;
    private List<PixelPanel> countedPixels;

    public PixelGridPanel(int height, int width) {
        super();
        pixelList = new ArrayList<>();
        algorithm = new BresenhamAlgorithm();
        selectedList = new ArrayList<>();
        countedPixels = new ArrayList<>();
        for (int xIndex = 0; xIndex < width; xIndex++) {
            for (int yIndex = 0; yIndex < height; yIndex++) {
                PixelPanel pane = new PixelPanel(xIndex, height - yIndex - 1);
                //pane.getChildren().add(new Label(pane.getPosition().getxIndex() + "->" + pane.getPosition().getyIndex()));
                pixelList.add(pane);
                pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandlerImpl(this));

                pane.setMinHeight(10);
                pane.setMinWidth(10);
                this.add(pane, xIndex, yIndex);
            }
        }

    }

    public void clear() {
        countedPixels.forEach(x -> x.setStyle("-fx-background-color: #ffffff;"));
        countedPixels = new ArrayList<>();
    }

    public void addSelectedPanel(PixelPanel pixelPanel) {
        int pointCount = algorithm.getPointCount();
        if (selectedList.size() < pointCount) {
            selectedList.add(pixelPanel.getPosition());
            pixelPanel.setStyle("-fx-background-color: #ff0000;");
        }

        if (pointCount == selectedList.size()) {
/*            selectedList.remove(listSize-1);
            selectedList.add(pixelPanel.getPosition());*/
            executeAlgorithm();
        }
    }

    public void clearSelectedList() {
        selectedList = new ArrayList<>();
    }


    public Algorithm getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public PixelPanel getPixel(Position position) throws NoPixelFoundException {
        return pixelList.stream().filter(x -> x.getPosition().equals(position)).findFirst().orElseThrow(NoPixelFoundException::new);
    }


    public void executeAlgorithm() {
        if (selectedList.size() == algorithm.getPointCount()) {


            for (Position position : algorithm.execute(selectedList)) {
                for (PixelPanel pixelPanel : pixelList) {
                    if (pixelPanel.getPosition().equals(position)) {
                        pixelPanel.setStyle("-fx-background-color: #4286f4;");
                        countedPixels.add(pixelPanel);
                    }
                }
            }

        }
        selectedList.clear();
    }


    private class EventHandlerImpl implements EventHandler<MouseEvent> {
        private PixelGridPanel gridPanel;

        EventHandlerImpl(PixelGridPanel pixelGridPanel) {
            this.gridPanel = pixelGridPanel;
        }

        @Override
        public void handle(MouseEvent event) {
            PixelPanel pixelPanel = (PixelPanel) event.getSource();
            System.out.println(pixelPanel.getPosition().getxIndex() + " " + pixelPanel.getPosition().getyIndex());
            gridPanel.addSelectedPanel(pixelPanel);
        }
    }

}
