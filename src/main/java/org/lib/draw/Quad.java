package org.lib.draw;

import org.lib.color.ColorRGBA;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;
import org.lib.util.Util;
import org.lwjgl.opengl.GL11;

public class Quad {
  
  public static void drawQuad(PercentDimension dim, PercentPoint pos, ColorRGBA color) {
    GL11.glPushMatrix();
      GL11.glTranslatef(pos.getX(), pos.getY(), 0);
      GL11.glRotatef(0, 0, 0, 1);
    
      GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor4f(color.getRed1f(), color.getGreen1f(), color.getBlue1f(), color.getAlpha());
        GL11.glVertex2f(-dim.getWidth(), -dim.getHeight());
        GL11.glVertex2f(dim.getWidth(), -dim.getHeight());
        GL11.glVertex2f(dim.getWidth(), dim.getHeight());
        GL11.glVertex2f(-dim.getWidth(), dim.getHeight());
      GL11.glEnd();

    GL11.glPopMatrix();
  }

  public static void drawQuad(PixelDimension dim, PixelPoint pos, ColorRGBA color, PixelDimension window) {
    drawQuad(Util.pixelToPercentDimension(window, dim), Util.pixelToPercentPoint(window, pos), color);
  }

  public static void drawQuad(PercentPoint topLeft, PercentPoint topRight, PercentPoint bottomRight, PercentPoint bottomLeft, ColorRGBA color) {
    GL11.glBegin(GL11.GL_QUADS);
      GL11.glColor4f(color.getRed1f(), color.getGreen1f(), color.getBlue1f(), color.getAlpha());
      GL11.glVertex2f(-topLeft.getX(), -topLeft.getY());
      GL11.glVertex2f(topLeft.getX(), -topLeft.getY());
      GL11.glVertex2f(topLeft.getX(), topLeft.getY());
      GL11.glVertex2f(-topLeft.getX(), topLeft.getY());
    GL11.glEnd();
  }

  public static void drawQuad(PixelPoint topLeft, PixelPoint topRight, PixelPoint bottomRight, PixelPoint bottomLeft, ColorRGBA color, PixelDimension window) {
    drawQuad(
      Util.pixelToPercentPoint(window, topLeft),
      Util.pixelToPercentPoint(window, topRight),
      Util.pixelToPercentPoint(window, bottomRight),
      Util.pixelToPercentPoint(window, bottomLeft),
      color
    );
  }

}
