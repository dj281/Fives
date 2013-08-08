package model;

public class Player
{
  private String fname,sname,playing;
  private int rating;
  
  public Player(String fname, String sname, String playing, int rating){
    this.fname = fname;
    this.sname = sname;
    this.playing = playing;
    this.rating = rating;
  }

  public String getFname()
  {
    return fname;
  }

  public void setFname(String fname)
  {
    this.fname = fname;
  }

  public String getSname()
  {
    return sname;
  }

  public void setSname(String sname)
  {
    this.sname = sname;
  }

  public String getPlaying()
  {
    return playing;
  }

  public void setPlaying(String playing)
  {
    this.playing = playing;
  }

  public int getRating()
  {
    return rating;
  }

  public void setRating(int rating)
  {
    this.rating = rating;
  }

}
