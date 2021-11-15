package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Canvas canvas;
    @FXML
    Label timer;

    int count = 5;

    int color = 1;

    Color r1 = Color.rgb(40, 0, 0);
    Color r2 = Color.rgb(255, 0, 0);
    Color y1 = Color.rgb(40, 40, 0);
    Color y2 = Color.rgb(255, 255, 0);
    Color g1 = Color.rgb(0, 40, 0);
    Color g2 = Color.rgb(0, 255, 0);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Rectangle rect1 = new Rectangle(95, 50, 210, 500, Color.rgb(77, 77, 77), gc);
        Rectangle rect2 = new Rectangle(125, 20, 150, 40, Color.rgb(77, 77, 77), gc);

        gc.setFill(r2);
        gc.fillOval(125, 65, 150, 150);
        gc.strokeOval(125, 65, 150, 150);

        gc.setFill(y1);
        gc.fillOval(125, 225, 150, 150);
        gc.strokeOval(125, 225, 150, 150);

        gc.setFill(g1);
        gc.fillOval(125, 385, 150, 150);
        gc.strokeOval(125, 385, 150, 150);

        timer.setText(String.format("%d", count));

        Timeline tml = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
            color(gc);
        }));
        tml.setCycleCount(Timeline.INDEFINITE);
        tml.setAutoReverse(false);
        tml.play();
    }

    void color(GraphicsContext gc){
        if (count == 1){
            Color r;
            Color y;
            Color g;
            if(color == 1){
                r = r1;
                y = y2;
                g = g1;
                color = 2;
            }else if(color == 2){
                r = r1;
                y = y1;
                g = g2;
                color = 3;
            }else{
                r = r2;
                y = y1;
                g = g1;
                color = 1;
            }
            gc.setFill(r);
            gc.fillOval(125, 65, 150, 150);
            gc.setFill(y);
            gc.fillOval(125, 225, 150, 150);
            gc.setFill(g);
            gc.fillOval(125, 385, 150, 150);
            count = 5;

        }else{
            count--;
        }

        timer.setText(String.format("%d", count));
    }

}
