import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {
    private int row = 0;
    private int col = 0;
    private int times = 0;

    public void initKeyAdapter() {
        this.row = 0;
        this.col = 0;
        this.times = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        char c = e.getKeyChar();
        if(c == 'w'){
            if(row >= 1 && MazeGUI.mazeLabels[row][col].isUpAlready()){
                MazeGUI.mazeLabels[row][col].disableCurrent();
                row --;
                MazeGUI.mazeLabels[row][col].setCurrent();
                times ++;
                MazeGUI.setShowTimes(String.valueOf(times));
                if(MazeGUI.mazeLabels[row][col].isWin()){
                    new WinFrame();
                    MazeGUI.stopTiming();
                    MazeGUI.removeKeyAdapter();
                }
            }
        }
        if(c == 's'){
            if(row <= 18 && MazeGUI.mazeLabels[row][col].isDownAlready()){
                MazeGUI.mazeLabels[row][col].disableCurrent();
                row ++;
                MazeGUI.mazeLabels[row][col].setCurrent();
                times ++;
                MazeGUI.setShowTimes(String.valueOf(times));
                if(MazeGUI.mazeLabels[row][col].isWin()){
                    new WinFrame();
                    MazeGUI.stopTiming();
                    MazeGUI.removeKeyAdapter();
                }
            }
        }
        if(c == 'a'){
            if(col >= 1 && MazeGUI.mazeLabels[row][col].isLeftAlready()){
                MazeGUI.mazeLabels[row][col].disableCurrent();
                col --;
                MazeGUI.mazeLabels[row][col].setCurrent();
                times ++;
                MazeGUI.setShowTimes(String.valueOf(times));
                if(MazeGUI.mazeLabels[row][col].isWin()){
                    new WinFrame();
                    MazeGUI.stopTiming();
                    MazeGUI.removeKeyAdapter();
                }
            }
        }
        if(c == 'd'){
            if(col <= 23 && MazeGUI.mazeLabels[row][col].isRightAlready()){
                MazeGUI.mazeLabels[row][col].disableCurrent();
                col ++;
                MazeGUI.mazeLabels[row][col].setCurrent();
                times ++;
                MazeGUI.setShowTimes(String.valueOf(times));
                if(MazeGUI.mazeLabels[row][col].isWin()){
                    new WinFrame();
                    MazeGUI.stopTiming();
                    MazeGUI.removeKeyAdapter();
                }
            }
        }
    }
}
