import java.util.ArrayList;
import java.util.Random;

public class MazeTools{
    private static int row;
    private static int col;
    private static int top;
    private static Random random;

    public static void generateNewMaze(){
        for(int row = 0; row < 20; row ++){
            for(int col = 0; col < 25; col ++){
                MazeGUI.mazeLabels[row][col].initAll();
            }
        }
        top = 0;
        row = 0;
        col = 0;
        random = new Random();
        ArrayList<MazeLabel> mazeLabels = new ArrayList<>();
        mazeLabels.add(MazeGUI.mazeLabels[0][0]);
        while(top >= 0){
            int[] val = new int[]{-1, -1, -1, -1};
            int times = 0;
            boolean flag = false;
            MazeLabel current = mazeLabels.get(top);
            row = current.row;
            col = current.col;
            current.setAlready();
            out:while(times < 4){
                int dir = random.nextInt(4);
                if(val[dir] == dir){
                    continue;
                }else{
                    val[dir] = dir;
                }
                switch (dir){
                    case 0:
                        if(row >= 1 && MazeGUI.mazeLabels[row - 1][col].getAlready() == false){
                            current.setUpAlready();
                            MazeGUI.mazeLabels[row - 1][col].setDownAlready();
                            mazeLabels.add(MazeGUI.mazeLabels[row - 1][col]);
                            top++;
                            flag = true;
                            break out;
                        }
                        break;
                    case 1:
                        if(row <= 18 && MazeGUI.mazeLabels[row + 1][col].getAlready() == false){
                            current.setDownAlready();
                            MazeGUI.mazeLabels[row + 1][col].setUpAlready();
                            mazeLabels.add(MazeGUI.mazeLabels[row + 1][col]);
                            top++;
                            flag = true;
                            break out;
                        }
                        break;
                    case 2:
                        if(col >= 1 && MazeGUI.mazeLabels[row][col - 1].getAlready() == false){
                            current.setLeftAlready();
                            MazeGUI.mazeLabels[row][col - 1].setRightAlready();
                            mazeLabels.add(MazeGUI.mazeLabels[row][col - 1]);
                            top++;
                            flag = true;
                            break out;
                        }
                        break;
                    case 3:
                        if(col <= 23 && MazeGUI.mazeLabels[row][col + 1].getAlready() == false){
                            current.setRightAlready();
                            MazeGUI.mazeLabels[row][col + 1].setLeftAlready();
                            mazeLabels.add(MazeGUI.mazeLabels[row][col + 1]);
                            top++;
                            flag = true;
                            break out;
                        }
                        break;
                }
                times ++;
            }
            if(!flag){
                mazeLabels.remove(top);
                top --;
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
