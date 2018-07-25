import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MazeLabel extends JLabel{
    private boolean upAlready;
    private boolean downAlready;
    private boolean leftAlready;
    private boolean rightAlready;
    private boolean already;
    private boolean isCurrent;
    private boolean isTarget;
    public int row;
    public int col;

    public MazeLabel(){
        initAll();
    }

    public void initAll() {
        already = false;
        upAlready = false;
        downAlready = false;
        leftAlready = false;
        rightAlready = false;
        isCurrent = false;
        isTarget = false;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.clearRect(0, 0, 30, 30);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.GREEN);
        if(!upAlready){
            g2.drawLine(1, 1, 29, 1);
        }
        if(!downAlready){
            g2.drawLine(1, 29, 29, 29);
        }
        if(!leftAlready){
            g2.drawLine(1, 1, 1, 29);
        }
        if(!rightAlready){
            g2.drawLine(29, 1, 29, 29);
        }
        if(isTarget){
            Ellipse2D.Double circle = new Ellipse2D.Double(5, 5, 20, 20);
            Paint p = g2.getPaint();
            g2.setPaint(Color.YELLOW);
            g2.fill(circle);
            g2.setPaint(p);
        }
        if(isCurrent){
            Ellipse2D.Double circle = new Ellipse2D.Double(5, 5, 20, 20);
            Paint p = g2.getPaint();
            g2.setPaint(Color.RED);
            g2.fill(circle);
            g2.setPaint(p);
        }
    }


    public boolean isUpAlready() {
        return upAlready;
    }

    public void setUpAlready() {
        this.upAlready = true;
    }

    public boolean isDownAlready() {
        return downAlready;
    }

    public void setDownAlready() {
        this.downAlready = true;
    }

    public boolean isLeftAlready() {
        return leftAlready;
    }

    public void setLeftAlready() {
        this.leftAlready = true;
    }

    public boolean isRightAlready() {
        return rightAlready;
    }

    public void setRightAlready() {
        this.rightAlready = true;
    }

    public boolean getAlready() {
        return already;
    }

    public void setAlready() {
        this.already = true;
    }

    public void setTarget() {
        this.isTarget = true;
    }

    public void setCurrent() {
        this.isCurrent = true;
        repaint();
    }

    public void disableCurrent(){
        this.isCurrent = false;
        repaint();
    }

    public boolean isWin() {
        return isCurrent && isTarget;
    }
}
