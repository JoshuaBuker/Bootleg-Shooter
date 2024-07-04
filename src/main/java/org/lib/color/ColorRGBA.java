package org.lib.color;

public class ColorRGBA {
  // =========================================== Static ===============================================
  // ==================================================================================================
  public static final ColorRGBA BLACK             = new ColorRGBA(0, 0, 0);
  public static final ColorRGBA WHITE             = new ColorRGBA(255, 255, 255);
  public static final ColorRGBA RED               = new ColorRGBA(255, 0, 0);
  public static final ColorRGBA LIME              = new ColorRGBA(0, 255, 0);
  public static final ColorRGBA BLUE              = new ColorRGBA(0, 0, 255);
  public static final ColorRGBA YELLOW            = new ColorRGBA(255, 255, 0);
  public static final ColorRGBA CYAN              = new ColorRGBA(0, 255, 255);
  public static final ColorRGBA MAGENTA           = new ColorRGBA(255, 0, 255);
  public static final ColorRGBA SILVER            = new ColorRGBA(192, 192, 192);
  public static final ColorRGBA GRAY              = new ColorRGBA(128, 128, 128);
  public static final ColorRGBA MAROON            = new ColorRGBA(128, 0, 0);
  public static final ColorRGBA OLIVE             = new ColorRGBA(128, 128, 0);
  public static final ColorRGBA GREEN             = new ColorRGBA(0, 128, 0);
  public static final ColorRGBA PURPLE            = new ColorRGBA(128, 0, 128);
  public static final ColorRGBA TEAL              = new ColorRGBA(0, 128, 128);
  public static final ColorRGBA NAVY              = new ColorRGBA(0, 0, 128);
  public static final ColorRGBA FIREBRICK         = new ColorRGBA(178, 34, 34);
  public static final ColorRGBA ORANGE_RED        = new ColorRGBA(255, 69, 0);
  public static final ColorRGBA FOREST_GREEN      = new ColorRGBA(34, 139, 34);
  public static final ColorRGBA SPRING_GREEN      = new ColorRGBA(0, 255, 127);
  public static final ColorRGBA TURQUOISE         = new ColorRGBA(64, 224, 208);
  public static final ColorRGBA STEEL_BLUE        = new ColorRGBA(70, 130, 180);
  public static final ColorRGBA BLUE_VIOLET       = new ColorRGBA(138,43,226);
  public static final ColorRGBA DEEP_PINK         = new ColorRGBA(255,20,147);
  public static final ColorRGBA SIENNA            = new ColorRGBA(160,82,45);
  public static final ColorRGBA SLATE_GRAY        = new ColorRGBA(112,128,144);
  public static final ColorRGBA LIGHT_SLATE_GRAY  = new ColorRGBA(119,136,153);
  public static final ColorRGBA GAINSBORO         = new ColorRGBA(220,220,220);
  public static final ColorRGBA SANDY_BROWN       = new ColorRGBA(244,164,96);
  public static final ColorRGBA PLUM              = new ColorRGBA(221,160,221);

  // ========================================= Instance ===============================================
  // ==================================================================================================

  private short red, blue, green;
  private float alpha = 1.0f;

  public ColorRGBA(int red, int green, int blue) {
    this.red = (short)red;
    this.blue = (short)blue;
    this.green = (short)green;
    System.nanoTime();
  }
  
  public ColorRGBA(int red, int green, int blue, float alpha) {
    this.red = (short)red;
    this.blue = (short)blue;
    this.green = (short)green;
    this.alpha = (float)alpha;
  }

  public short getRed255() { return red; }
  public short getBlue255() { return blue; }
  public short getGreen255() { return green; }
  public float getAlpha() { return alpha; }

  public float getRed1f() { return red / 255.0f; }
  public float getBlue1f() { return blue / 255.0f; }
  public float getGreen1f() { return green / 255.0f; }

  public void setRed(int red) { this.red = (short)red; }
  public void setGreen(int green) { this.green = (short)green; }
  public void setBlue(int blue) { this.blue = (short)blue; }
  public void setAlpha(float alpha) { this.alpha = alpha; }

  
}
