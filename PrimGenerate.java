import java.util.ArrayList;
import java.util.Random;

public class PrimGenerate {
    private static int row;
    private static int col;
    private static Random random;

    public static void primGenerate(){
        for(int row = 0; row < 20; row ++){
            for(int col = 0; col < 25; col ++){
                MazeGUI.mazeLabels[row][col].initAll();
            }
        }

        row = 0;
        col = 0;
        random = new Random();
        ArrayList<String> wallStack = new ArrayList<>();
        MazeGUI.mazeLabels[0][0].setAlready();
        wallStack.add("0,0,1,0");
        wallStack.add("0,0,0,1");
        while(!wallStack.isEmpty()){
            int randomNum = random.nextInt(wallStack.size());
            String tempStr = wallStack.get(randomNum);
            int x1 = Integer.parseInt(tempStr.split(",")[0]);
            int y1 = Integer.parseInt(tempStr.split(",")[1]);
            int x2 = Integer.parseInt(tempStr.split(",")[2]);
            int y2 = Integer.parseInt(tempStr.split(",")[3]);
            if(MazeGUI.mazeLabels[x2][y2].getAlready() ^ MazeGUI.mazeLabels[x1][y1].getAlready()){
                if(x2 < x1){
                    MazeGUI.mazeLabels[x1][y1].setUpAlready();
                    MazeGUI.mazeLabels[x2][y2].setDownAlready();
                }
                if(x2 > x1){
                    MazeGUI.mazeLabels[x1][y1].setDownAlready();
                    MazeGUI.mazeLabels[x2][y2].setUpAlready();
                }
                if(y2 < y1){
                    MazeGUI.mazeLabels[x1][y1].setLeftAlready();
                    MazeGUI.mazeLabels[x2][y2].setRightAlready();
                }
                if(y2 > y1){
                    MazeGUI.mazeLabels[x1][y1].setRightAlready();
                    MazeGUI.mazeLabels[x2][y2].setLeftAlready();
                }
                row = x2;
                col = y2;
                MazeGUI.mazeLabels[row][col].setAlready();
                if(row >= 1) {
                    wallStack.add(row + "," + col + "," + String.valueOf(row - 1) + "," + col);
                }
                if(row <= 18){
                    wallStack.add(row + "," + col + "," + String.valueOf(row + 1) + "," + col);
                }
                if(col >= 1){
                    wallStack.add(row + "," + col + "," + row + "," + String.valueOf(col - 1));
                }
                if(col <= 23){
                    wallStack.add(row + "," + col + "," + row + "," + String.valueOf(col + 1));
                }
            }else{
                wallStack.remove(randomNum);
            }
        }
        int targetRow = random.nextInt(10) + 10;
        int targetCol = random.nextInt(12) + 13;
        MazeGUI.mazeLabels[targetRow][targetCol].setTarget();
        MazeGUI.mazeLabels[targetRow][targetCol].repaint();
        MazeGUI.mazeLabels[0][0].setCurrent();
        MazeGUI.mazeLabels[0][0].repaint();
    }
}
