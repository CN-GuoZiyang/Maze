import javax.swing.*;
import java.awt.*;

public class WinFrame extends JFrame {
    private String time;
    private String times;
    private JPanel winPanel;
    private JLabel winLabel;
    private JLabel timeLabel;
    private JLabel timesLabel;
    private JButton closeBtn;
    /**
     * 获胜提示界面的无参构造方法
     */
    public WinFrame(){
        setTitle("You Win!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setSize(350, 175);
        winPanel = new JPanel();
        winPanel.setLayout(null);
        setContentPane(winPanel);
        winLabel = new JLabel("<html><body>恭喜，你赢了。" +
                "<br>本关共用时&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "&nbsp;&nbsp;&nbsp;&nbsp;" +
                "移动次数</body></html>");
        winLabel.setBounds(5, 5, 300, 30);
        winPanel.add(winLabel);
        time = MazeGUI.getTime();     //从GUI界面读取时间并显示
        timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("宋体", Font.PLAIN, 60));
        timeLabel.setBounds(5, 20, 200, 100);
        winPanel.add(timeLabel);
        times = MazeGUI.getTimes();     //从GUI界面读取时间并显示
        timesLabel = new JLabel(times);
        timesLabel.setFont(new Font("宋体", Font.PLAIN, 60));
        timesLabel.setBounds(210, 20, 200, 100);
        winPanel.add(timesLabel);
        closeBtn = new JButton("确定");
        closeBtn.setBounds(140, 105, 80, 40);
        closeBtn.addActionListener(e -> {
            setVisible(false);
        });
        winPanel.add(closeBtn);
        setVisible(true);
    }
}
