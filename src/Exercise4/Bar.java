package Exercise4;

import java.awt.*;

//Class which holds all the information of each bar
public class Bar {
    //We only have getters and the variables are private, making Bar an immutable object
    private final int hight;
    private final int width;
    private final int x;
    private final int y;
    private final Color color;

    public Bar(int hight, int width, int x, int y, Color color) {
        this.hight = hight;
        this.width = width;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getHight() {
        return hight;
    }

    public int getWidth() {
        return width;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    //class to draw the bar
    public void draw(Graphics g){
        g.setColor(color);
       g.drawRect(x,y,width,hight);
    }
}
