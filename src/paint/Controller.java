package paint;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

public class Controller implements Initializable{

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField bSize;

    @FXML
    private Canvas canvas;

    boolean brushSelected = false;

    GraphicsContext brushTool;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        brushTool = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(bSize.getText());
            double x = e.getX()-size/2;
            double y = e.getY()-size/2;

            if (brushSelected && !bSize.getText().isEmpty()){
                brushTool.setFill(colorPicker.getValue());
                brushTool.fillRoundRect(x, y, size, size, size, size);
            }

        });
    }

    @FXML
    public void brushSelected(ActionEvent e){
        brushSelected = true;
    }

}
