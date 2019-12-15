import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener {
    public Mouse() {
        Frame f = new Frame("显示鼠标位置");
        f.setSize(320,320);
        f.addMouseListener(this);
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    //鼠标按下
    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("鼠标横坐标位置：" + e.getX());
        System.out.println("鼠标纵坐标位置：" + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
