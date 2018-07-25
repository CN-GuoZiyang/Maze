public class TimeThread extends Thread{
    private int second = 0;
    private int minute = 0;

    @Override
    public void run() {
        while(true){
            try {
                sleep(1000);
                second ++;
                if(second == 60){
                    minute ++;
                    second = 0;
                }
                MazeGUI.setShowTime(String.format("%02d", minute) + ":" + String.format("%02d", second));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
