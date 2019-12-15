import javax.swing.*;
import java.awt.*;

public class Flow extends Frame {
    public Flow() throws HeadlessException {
        setTitle("流布局");
        setSize(240,240);
        setLayout(new FlowLayout(FlowLayout.LEFT,20,30));
        this.add(new JButton("A"));
        this.add(new JButton("B"));
        this.add(new JButton("C"));
        this.add(new JButton("D"));
        this.add(new JButton("E"));
        this.add(new JButton("F"));
        setVisible(true);
    }
}
