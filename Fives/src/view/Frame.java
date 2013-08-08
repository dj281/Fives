package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Player;

public class Frame extends JFrame
{
  private Panel panel = new Panel();
  private Frame frame;
  
  public Frame(){
      setVisible(true);
      setSize(new Dimension(550,250));
      setPreferredSize(new Dimension(550,250));
      setResizable(false);
      add(panel);
      setContentPane(panel);
      pack();
      this.frame = this;
      createJMenuBar();
  }
  
  private void createJMenuBar(){
    JMenuBar mainMenu = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem addPlayer = new JMenuItem("Add Player");
    addPlayer.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        if(panel.getPlayers().size()<10){
        JTextField f = new JTextField(5);
        JTextField l = new JTextField(5);
        JTextField p = new JTextField(5);
        JTextField r = new JTextField(5);
        JPanel popup = new JPanel(new GridLayout(2,4));
        popup.add(new JLabel("First Name: "));
        popup.add(f);
        popup.add(new JLabel("Surname: "));
        popup.add(l);
        popup.add(new JLabel("Playing (Y/N): "));
        popup.add(p);
        popup.add(new JLabel("Rating: "));
        popup.add(r);
        int returnVal = JOptionPane.showConfirmDialog(frame,popup,"Add Player",JOptionPane.OK_CANCEL_OPTION);
        if(returnVal== JOptionPane.OK_OPTION){
          int i = 0;
          if(r.getText()!=null && r.getText()!="" && r.getText()!=" "){
          i = Integer.parseInt(r.getText());
          }
          else{
          i = 0;  
          }
          Player player = new Player(f.getText(),l.getText(),p.getText(),i);
        panel.addPlayer(player);
        }
        }
        else{
          JOptionPane.showMessageDialog(frame, "Already have 10 players, maybe next week");
        }
      }
    });
    JMenuItem close = new JMenuItem("Close");
    close.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame.dispose();
      }
    });
    fileMenu.add(addPlayer);
    fileMenu.add(close);
    mainMenu.add(fileMenu);
    setJMenuBar(mainMenu);
  }
}
