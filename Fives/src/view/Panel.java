package view;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

import model.Player;
import model.TableModel;

public class Panel extends JPanel
{
  private TableModel model = new TableModel();
  private TableRowSorter<TableModel> sorter;
  private JTable t;
  private ArrayList<Player> players = new ArrayList<Player>();
  public Panel(){
  super(new GridLayout(1,0));
  t = new JTable(model);
  sorter = new TableRowSorter<TableModel>(model);
  sorter.toggleSortOrder(2);
  t.setRowSorter(sorter);
  JScrollPane sp = new JScrollPane(t);
  add(sp);
}
  public void addPlayer(Player p){
    Object[][] oldData = model.getData();
    Object[][] newData = new Object[1][4];
    if(oldData!=null){
      newData = new Object[oldData.length+1][];
    }
    int h = 0;
    if(oldData!=null){
     h = oldData.length; 
    }
    for(int x=0;x<h;x++){
      newData[x] = oldData[x];
    }
    newData[h] = new Object[]{p.getFname(),p.getSname(),p.getPlaying(),p.getRating()};
    model.setData(newData);
    t.revalidate();
    t.repaint();
    model.fireTableStructureChanged();
    players.add(p);
  }
  public ArrayList<Player> getPlayers(){
    return players;
  }
}
