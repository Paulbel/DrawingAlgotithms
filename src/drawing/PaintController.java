package drawing;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class PaintController implements Initializable {
    @FXML
    private Pane pane;


    @FXML
    private MenuItem clearButton;

    private PixelGridPanel pixelGridPanel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pixelGridPanel = new PixelGridPanel(50, 100);
        pane.getChildren().add(pixelGridPanel);
        pixelGridPanel.setGridLinesVisible(true);
        clearButton.setOnAction(x -> {
            pixelGridPanel.clear();
            System.out.println("go");
        });

    }

}
