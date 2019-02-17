/**
A colored box grid. 
*
*
*
@Diza
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ColoredBoxes2 {

public static void main(String[] args) {
new ColoredBoxes2();
}

public ColoredBoxes2() {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
ex.printStackTrace();
}

JFrame frame = new JFrame("Testing");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(new TestPane());
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}
});
}

public static class TestPane extends JPanel {

    //for step 2, force ROWS = COLS so the shape will be a square
protected static final int ROWS = 14;
protected static final int COLS = 14;
protected static final int BOX_SIZE = 30;

private List<Color> colors;
//********************************Y2D array is created htere******
Color[][] myColor = new Color[ROWS][COLS];

public TestPane() {
int length = ROWS * COLS;
colors = new ArrayList<>(length);

for (int row = 0; row < ROWS; row++) {
for (int col = 0; col < COLS; col++) {
int c1 = (int) (Math.random() * 255);
int c2 = (int) (Math.random() * 255);
int c3 = (int) (Math.random() * 255);
//for step 1, forces border red when row or col == 0 at zero edges, or when row or col == (# of rows/columns - 1) at nonzero edges
//for step 3, forces red diagonal at row == col
if (row == 0 || col == 0 || row == ROWS - 1 || col == COLS - 1 || row == col) {
    myColor[row][col] = new Color(255, 0, 0);
}
else {
    myColor[row][col] = new Color(c1, c2, c3);
}

}}
}

@Override
public Dimension getPreferredSize() {
return new Dimension(COLS * BOX_SIZE, ROWS * BOX_SIZE);
}

@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
Graphics2D g2d = (Graphics2D) g.create();

int xOffset = (getWidth() - (COLS * BOX_SIZE)) / 2;
int yOffset = (getHeight() - (ROWS * BOX_SIZE)) / 2;


for (int row = 0; row < ROWS; row++) {
for (int col = 0; col < COLS; col++) {
int index = (row * COLS) + col;
g2d.setColor(myColor[row][col]);
g2d.fillRect(xOffset + (col * BOX_SIZE), 
yOffset + (row * BOX_SIZE), 
BOX_SIZE, BOX_SIZE);
}
}
g2d.dispose();
}

}

}

 