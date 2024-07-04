package org.lib.positioning;

public class PixelPoint {
  private short x, y;

  public PixelPoint(int x, int y) {
    this.x = (short)x;
    this.y = (short)y;
  }

  public short getX() { return x; }
  public short getY() { return y; }

  public void setX(int x) { this.x = (short)x; }
  public void setY(int y) { this.y = (short)y; }

  
}
