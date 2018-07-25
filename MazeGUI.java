import javax.swing.*;
import java.awt.*;

public class MazeGUI extends JFrame {
    private static JPanel mainPanel;
    public static MazeLabel[][] mazeLabels;       //25*20
    private JButton startBtn;
    private JButton primStart;
    private static MyKeyAdapter myKeyAdapter;
    private JLabel times;
    private static JLabel showTimes;
    private JLabel time;
    private static JLabel showTime;
    private String introductionStr;
    private JLabel introduction;
    private static TimeThread timeThread;

    public MazeGUI() {
        mainPanel = new JPanel();
        mazeLabels = new MazeLabel[20][25];
        startBtn = new JButton("深度优先算法开始");
        primStart = new JButton("随机Prim算法开始");
        myKeyAdapter = new MyKeyAdapter();
        times = new JLabel("移动次数");
        showTimes = new JLabel("0");
        time = new JLabel("所用时间");
        showTime = new JLabel("00:00");
        timeThread = new TimeThread();
        initFrame();
        initPanel();
        initTable();
        initComp();
        setVisible(true);
    }

    public static String getTime() {
        return showTime.getText();
    }

    public static String getTimes() {
        return showTimes.getText();
    }

    public static void stopTiming() {
        if(timeThread != null){
            if(timeThread.isAlive()){
                timeThread.stop();
            }
        }
    }

    public static void removeKeyAdapter() {
        mainPanel.removeKeyListener(myKeyAdapter);
    }

    private void initFrame() {
        setSize(900, 622);
        setLocationRelativeTo(null);
        setTitle("Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initPanel() {
        mainPanel.setLayout(null);
        setContentPane(mainPanel);
    }

    private void initTable() {
        for(int row = 0; row < 20; row ++){
            for(int col = 0; col < 25; col ++){
                mazeLabels[row][col] = new MazeLabel();
                mazeLabels[row][col].setBounds(150 + col * 30, row * 30, 30, 30);
                mazeLabels[row][col].row = row;
                mazeLabels[row][col].col = col;
                mainPanel.add(mazeLabels[row][col]);
            }
        }
    }

    private void initComp(){
        startBtn.setBounds(12, 20, 135, 40);
        startBtn.addActionListener(e -> {
            MazeTools.generateNewMaze();
            myKeyAdapter.initKeyAdapter();
            removeKeyAdapter();
            mainPanel.addKeyListener(myKeyAdapter);
            mainPanel.requestFocus();
            startTiming();
            showTimes.setText("0");
        });
        mainPanel.add(startBtn);
        primStart.setBounds(12, 80, 135,40);
        primStart.addActionListener(e -> {
            PrimGenerate.primGenerate();
            myKeyAdapter.initKeyAdapter();
            removeKeyAdapter();
            mainPanel.addKeyListener(myKeyAdapter);
            mainPanel.requestFocus();
            startTiming();
            showTimes.setText("0");
        });
        mainPanel.add(primStart);
        times.setBounds(0, 200, 150, 30);
        times.setVerticalAlignment(SwingConstants.CENTER);
        times.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(times);
        showTimes.setBounds(0, 230, 150, 50);
        showTimes.setFont(new Font("宋体", Font.PLAIN, 40));
        showTimes.setVerticalAlignment(SwingConstants.CENTER);
        showTimes.setHorizontalAlignment(SwingConstants.CENTER);
        showTimes.setForeground(Color.RED);
        mainPanel.add(showTimes);
        time.setBounds(0, 300, 150 ,30);
        time.setVerticalAlignment(SwingConstants.CENTER);
        time.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(time);
        showTime.setBounds(0, 330, 150, 50);
        showTime.setVerticalAlignment(SwingConstants.CENTER);
        showTime.setHorizontalAlignment(SwingConstants.CENTER);
        showTime.setFont(new Font("宋体", Font.PLAIN, 40));
        showTime.setForeground(Color.RED);
        mainPanel.add(showTime);
        introductionStr = new String("<html><body><center>深度优先算法<br>" +
                "又称为递归回溯算法<br>" +
                "生成的迷宫主路较为明显<br>" +
                "难度较小<br><br>" +
                "随机Prim算法<br>" +
                "生成的迷宫岔路较多<br>" +
                "难度较大</center></html></body>");
        introduction = new JLabel(introductionStr);
        introduction.setBounds(0, 430, 150, 200);
        introduction.setHorizontalAlignment(SwingConstants.CENTER);
        introduction.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(introduction);
    }

    private void startTiming() {
        showTime.setText("00:00");
        showTimes.setText("0");
        stopTiming();
        timeThread = new TimeThread();
        timeThread.start();
    }

    public static void setShowTimes(String times){
        showTimes.setText(times);
    }

    public static void setShowTime(String time){
        showTime.setText(time);
    }
}
