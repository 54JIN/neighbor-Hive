import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class sCDP2 extends JFrame {
 private JTextField cmdJarvis = new JTextField();
 private JButton addButton = new JButton("ADD");
 private ImageIcon image1;
 private DefaultListModel jarvisResponse = new DefaultListModel();
 private JList response;
 int width1;
 int height1;
 Calendar calendar;
 SimpleDateFormat timeFormat;
 SimpleDateFormat monthFormat;
 SimpleDateFormat dayFormat;
 JLabel timeLabel;
 JLabel monthLabel;
 JLabel dayLabel;
 String time;
 String timeMonth;
 String timeDay;
 JLayeredPane lPane;
 scrap jarvis;
 public void MainWindow(){
     setTitle("title");
     Dimension screenSize = getToolkit().getDefaultToolkit().getScreenSize();
     width1 = (int)(screenSize.getWidth());
     height1 = (int)(screenSize.getHeight());
     setSize((width1),height1);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     createWindow();
     setMaximumSize(new Dimension(width1,height1));
     addListeners();
     setVisible(true);
     addComponentListener(new ResizeListner());
     //System.out.println(getSize());
     setTime();
 }
 private void createWindow(){
     lPane = new JLayeredPane();
     lPane.setBounds(0,0,width1,height1);
     lPane.add(leftPanel(width1,height1),Integer.valueOf(0));
     lPane.add(centerPanel(width1,height1),Integer.valueOf(0));
     lPane.add(rightPanel(width1,height1), Integer.valueOf(0));
     lPane.add(window(width1,height1),Integer.valueOf(1));
     lPane.add(jarvisResponsePanel(width1,height1),Integer.valueOf(1));
     lPane.add(todaysDate(width1,height1),Integer.valueOf(1));
     add(lPane);
 }
 private void addListeners(){
     addButton.addActionListener(new AddAction());
 }
 class AddAction implements ActionListener{
     public void actionPerformed(ActionEvent e) {
         String name = cmdJarvis.getText().trim();
         if (name.length() > 0){
             jarvisResponse.addElement(name.toUpperCase());
             jarvis = new scrap();
             name = jarvis.getAnswer(name.toUpperCase());
             jarvisResponse.addElement(name.toUpperCase());
             cmdJarvis.setText("");
             cmdJarvis.requestFocus();
         }
     }
 }
 private JLayeredPane jarvisResponsePanel(int width1, int height1){
     JLayeredPane jarvisPanel = new JLayeredPane();
     //g.fillArc(width1*196/1152, height1* 156/700, (width1/3*60/384), (width1/3*60/384), 180, 180);
     jarvisPanel.setBounds(width1/3*2,(height1*426/700),(width1*394/1152),(height1*274/700));
     JLabel askJarvis = new JLabel("Jarvis Command: ");
     askJarvis.setForeground(Color.WHITE);
     askJarvis.setBounds(0,(height1*426/700)-230,110,15);
     jarvisPanel.add(askJarvis,Integer.valueOf(0));
     cmdJarvis.setBounds(111,(height1*426/700)-230,width1/3-(width1/3-275),15);
     jarvisPanel.add(cmdJarvis,Integer.valueOf(1));
     addButton.setBounds(width1/3-118,(height1*426/700)-230,width1/3-(width1/3-35),15);
     jarvisPanel.add(addButton,Integer.valueOf(2));
     response = new JList(jarvisResponse);
     response.setOpaque(true);
     response.setBackground(new Color(32,27,27));
     response.setForeground(new Color(65,223,222));
     response.setBounds(0,0,100,100);
     JScrollPane r = new JScrollPane(response);
     r.setBounds(0,0,width1/3,(height1*426/700)-250);
     jarvisPanel.add(r);
     return jarvisPanel;
 }
 private JLayeredPane todaysDate(int width1, int height1){
     JLayeredPane panel = new JLayeredPane();
     /*JLabel label1 = new JLabel();
     label1.setOpaque(true);
     label1.setBounds(0,0,316,700);
     label1.setBackground(new Color(32,27,27));
     panel.add(label1);*/
     panel.setBounds(width1*180/1152, height1* 152/700,200,102);
     monthFormat = new SimpleDateFormat("MMMM");
     dayFormat = new SimpleDateFormat("dd");
     monthLabel = new JLabel();
     dayLabel = new JLabel();
     monthLabel.setText(monthFormat.format(Calendar.getInstance().getTime()));
     dayLabel.setText(dayFormat.format(Calendar.getInstance().getTime()));
     monthLabel.setForeground(new Color(65,223,222));
     dayLabel.setForeground(new Color(65,223,222));
     monthLabel.setBounds(width1*0/1152,height1* 0/700,200,32);
     dayLabel.setBounds(width1*26/1152,height1* 22/700,width1*200/1152,height1*56/1152);
     monthLabel.setFont(new Font("Calisto MT", Font.PLAIN, width1*19/1152));
     dayLabel.setFont(new Font("Apple Casual", Font.PLAIN, width1*34/1152));
     panel.add(monthLabel);
     panel.add(dayLabel);
     return panel;
 }
 private JLayeredPane centerPanel(int width1, int height1){
     JLayeredPane centerPanel = new JLayeredPane();
     centerPanel.setBounds((width1/3),0,((width1/3)),height1);
     JLabel label1 = new JLabel();
     label1.setOpaque(true);
     label1.setBounds(0,0,((width1/3)),height1);
     label1.setBackground(new Color(32,27,27));
     centerPanel.add(label1);
     return centerPanel;
 }
 private JLayeredPane rightPanel(int width1, int height1){
     JLayeredPane rightPanel = new JLayeredPane();
     rightPanel.setBounds((width1/3*2),0,((width1/3)),height1);
     JLabel label1 = new JLabel();
     label1.setOpaque(true);
     label1.setBounds(0,0,((width1/3*2)),height1);
     label1.setBackground(new Color(32,27,27));
     class Panel2 extends JLayeredPane{
         Panel2(){
             setPreferredSize(new Dimension(444,420));
         }
         @Override
         public void paint(Graphics g){
             super.paint(g);
             setBackground(new Color(32,27,27));
             g.setColor(new Color(65,223,222));
             g.drawString("BLAH", 20, 20);
             //Arc Reactor
             //g.fillArc(width1*196/1152, height1* 156/700, (width1/3*60/384), (width1/3*60/384), 180, 180);
             g.setColor(new Color(65,223,222));
             g.fillOval(width1*85/1152, height1* 156/700, (width1/3*191/384), (width1/3*191/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*91/1152, height1* 161/700, (width1/3*181/384), (width1/3*181/384));
             g.setColor(new Color(65,223,222));
             g.fillOval(width1*96/1152, height1* 166/700, (width1/3*171/384), (width1/3*171/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*117/1152, height1* 189/700, (width1/3*127/384), (width1/3*127/384));
             g.setColor(new Color(65,223,222,48));
             g.fillOval(width1*124/1152, height1* 195/700, (width1/3*114/384), (width1/3*114/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*127/1152, height1* 198/700, (width1/3*107/384), (width1/3*107/384));
             g.setColor(new Color(65,223,222,48));
             g.fillOval(width1*130/1152, height1* 201/700, (width1/3*101/384), (width1/3*101/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*146/1152, height1* 217/700, (width1/3*71/384), (width1/3*71/384));
             g.setColor(new Color(65,223,222));
             g.fillOval(width1*152/1152, height1* 224/700, (width1/3*58/384), (width1/3*58/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*167/1152, height1* 241/700, (width1/3*26/384), (width1/3*26/384));
             //Weather Component Graphics
             g.setColor(new Color(65,223,222));
             g.fillOval(width1*257/1152,  height1* 29/700, (width1/3*108/384), (width1/3*108/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*262/1152,  height1* 35/700, (width1/3*97/384), (width1/3*97/384));
             g.setColor(new Color(65,223,222,48));
             g.fillArc(width1*267/1152,  height1* 40/700, (width1/3*86/384), (width1/3*86/384), 90, 270);
             g.setColor(new Color(32,27,27));
             g.fillArc(width1*276/1152,  height1* 48/700, (width1/3*69/384), (width1/3*69/384), 90, 270);
             g.setColor(new Color(65,223,222));
             g.fillArc(width1*274/1152,  height1* 40/700, (width1/3*80/384), (width1/3*80/384), 0, 90);
             g.setColor(new Color(32,27,27));
             g.fillArc(width1*274/1152,  height1* 42/700, (width1/3*78/384), (width1/3*78/384), 0, 90);
             g.setColor(new Color(65,223,222));
             g.fillArc(width1*277/1152,  height1* 44/700, (width1/3*73/384), (width1/3*73/384), 0, 90);
             g.setColor(new Color(32,27,27));
             g.fillArc(width1*282/1152,  height1* 52/700, (width1/3*60/384), (width1/3*60/384), 0, 90);
             //List
             g.setColor(new Color(65,223,222));
             g.fillRect((width1*284/1152), (height1*144/700), (width1/3)*5/384, height1*150/700);
             g.fillRect((width1*287/1152), (height1*144/700), (width1/3)*157/384, height1*4/700);
             g.fillRect((width1*285/1152), (height1*351/700), (width1/3)*157/384, height1*4/700);
             g.fillRect((width1*284/1152), (height1*297/700), (width1/3)*5/384, height1*15/700);
             g.fillRect((width1*284/1152), (height1*316/700), (width1/3)*5/384, height1*15/700);
             g.fillRect((width1*284/1152), (height1*335/700), (width1/3)*5/384, height1*20/700);
         }
     }
     Panel2 p = new Panel2();
     p.setBounds(0,0,(width1/3),height1);
     rightPanel.add(p);
     rightPanel.add(label1);
     return rightPanel;
 }
 private JLayeredPane leftPanel(int width1, int height1){
     JLayeredPane leftPanel = new JLayeredPane();
     leftPanel.setBounds(0,0,((width1/3)),height1);
     //background color
     JLabel label1 = new JLabel();
     label1.setOpaque(true);
     label1.setBounds(0,0,((width1/3)),height1);
     //label1.setBackground(new Color(32,27,27));
     label1.setBackground(new Color(32,27,27));
     //
     class Panel2 extends JLayeredPane{
         Panel2(){
             setPreferredSize(new Dimension(444,420));
         }
         @Override
         public void paint(Graphics g){
             super.paint(g);
             setBackground(new Color(32,27,27));
             //First Circle
             g.setColor(new Color(65,223,222));
             g.fillOval(width1*153/1152, height1*112/700, (width1/3*146/384), (width1/3*146/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*158/1152, height1*116/700, (width1/3*137/384), (width1/3*137/384));
             g.setColor(new Color(65,223,222));
             g.fillOval(width1*163/1152,height1* 122/700, (width1/3*126/384), (width1/3*126/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*167/1152,height1* 126/700, (width1/3*118/384), (width1/3*118/384));
             g.setColor(new Color(65,223,222));
             g.fillArc(width1*163/1152, height1* 122/700, (width1/3*128/384), (width1/3*128/384), 270, 90);
             g.setColor(new Color(32,27,27));
             g.fillArc(width1*178/1152, height1* 137/700, (width1/3*96/384), (width1/3*96/384), 270, 90);
             g.setColor(new Color(65,223,222));
             g.fillArc(width1*192/1152, height1* 152/700, (width1/3*68/384), (width1/3*68/384), 180, 180);
             g.setColor(new Color(32,27,27));
             g.fillArc(width1*196/1152, height1* 156/700, (width1/3*60/384), (width1/3*60/384), 180, 180);
             g.setColor(new Color(65,223,222));
             g.drawString("BLAH", 20, 20);
             //Second Circle
             g.setColor(new Color(65,223,222,48));
             g.fillOval(width1*165/1152, height1* 340/700, (width1/3*98/384), (width1/3*98/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*167/1152, height1* 342/700, (width1/3*94/384), (width1/3*94/384));
             g.setColor(new Color(65,223,222,48));
             g.fillOval(width1*170/1152, height1* 345/700, (width1/3*88/384), (width1/3*88/384));
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*181/1152, height1* 357/700, (width1/3*65/384), (width1/3*65/384));
             g.setColor(new Color(65,223,222));
             //g.fillOval(width1*189/1152, height1* 365/700, (width1/3*49/384), (width1/3*49/384));
             g.fillArc(width1*189/1152,  height1* 365/700, (width1/3*48/384), (width1/3*48/384), 90, 270);
             g.setColor(new Color(32,27,27));
             g.fillOval(width1*194/1152, height1* 370/700, (width1/3*39/384), (width1/3*39/384));
             g.setColor(new Color(32,27,27));
             //g.fillRect(width1*214/1152, height1* 364/700, (width1/3*1/384), (width1/3*1/384));
            // g.fillRect(width1*232/1152, height1* 387/700, (width1/3*7/384), (width1/3*7/384));
             //g.fillRect(width1*213/1152, height1* 365/700, (width1/3*21/384), (width1/3*21/384));
             //g.fillRect(width1*234/1152, height1* 376/700, (width1/3*4/384), (width1/3*4/384));     
         }
     }
     Panel2 p = new Panel2();
     p.setBounds(0,0,((width1/3)),height1);
     leftPanel.add(p);
     leftPanel.add(label1);
     return leftPanel;
 }
 private JLayeredPane window(int width1, int height1){
     JLayeredPane panel = new JLayeredPane();
     /*JLabel label1 = new JLabel();
     label1.setOpaque(true);
     label1.setBounds(0,0,316,700);
     label1.setBackground(new Color(32,27,27));
     panel.add(label1);*/
     panel.setBounds(width1*285/1152,height1*105/700,200,32);
     timeFormat = new SimpleDateFormat("hh:mm:ss a");
     timeLabel = new JLabel();
     timeLabel.setText(timeFormat.format(Calendar.getInstance().getTime()));
     timeLabel.setForeground(new Color(65,223,222));
     timeLabel.setBounds(0,0,200,32);
     panel.add(timeLabel);
     return panel;
 }
 class ResizeListner extends ComponentAdapter{
  public void componentResized(ComponentEvent e){
      int width1 = (int)(e.getComponent().getWidth());
      System.out.println(width1);
      int height1 = (int)(e.getComponent().getHeight());
      System.out.println(height1);
      JFrame frame = new JFrame();
      remove(lPane);
      lPane = new JLayeredPane();
     lPane.setBounds(0,0,width1,height1);
     lPane.add(leftPanel(width1,height1),Integer.valueOf(0));
     lPane.add(centerPanel(width1,height1),Integer.valueOf(0));
     lPane.add(rightPanel(width1,height1), Integer.valueOf(0));
     lPane.add(window(width1,height1),Integer.valueOf(1));
     lPane.add(jarvisResponsePanel(width1,height1),Integer.valueOf(1));
     lPane.add(todaysDate(width1,height1),Integer.valueOf(1));
     add(lPane);
      lPane.setBounds(0, 0, width1, height1);
      setVisible(true);
  }
 }
 public void setTime(){
     while(true){
      time = timeFormat.format(Calendar.getInstance().getTime());
      timeLabel.setText(time);
      timeMonth = monthFormat.format(Calendar.getInstance().getTime());
      monthLabel.setText(timeMonth);
      timeDay = dayFormat.format(Calendar.getInstance().getTime());
      dayLabel.setText(timeDay);
      try{
          Thread.sleep(1000);
      }
      catch(InterruptedException e){
          e.printStackTrace();
      }
     }
 }
}
/*
public void setTime(){
     while(true){
      time = timeFormat.format(Calendar.getInstance().getTime());
      timeLabel.setText(time);
      try{
          Thread.sleep(1000);
      }
      catch(InterruptedException e){
          e.printStackTrace();
      }
     }
 }
*/