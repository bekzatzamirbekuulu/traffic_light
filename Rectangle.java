package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape{

    protected int width;
    protected int height;

    public Rectangle(int x, int y, int width, int height, Color color, GraphicsContext gc){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        draw(gc);
    }
    @Override
    public void draw(GraphicsContext gc){
        gc.setFill(color);
        gc.fillRect(x, y, width, height);
    }

}
