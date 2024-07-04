package org.lib.component;

import org.lib.color.ColorRGBA;
import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;
import org.lib.util.Util;
import org.lib.window.Window;

public abstract class StaticComponent {
  private PixelDimension dim;
  private PixelPoint pos;
  private ColorRGBA color;

  private float scale = 1.0f;

//========================== GETTERS ===============================
  public float getScale() { return this.scale; }
  public ColorRGBA getColor() { return this.color; }
  public PixelDimension getPixelDimension() { return this.dim; }
  public PixelPoint getPixelLocation() { return this.pos; }

  public PercentDimension getPercentDimension() { 
    return Util.pixelToPercentDimension(Window.getSize(), dim);
  }

  public PercentPoint getPercentLocation() { 
    return Util.pixelToPercentPoint(Window.getSize(), pos);
  }

//====================== SETTERS ==================================
  public void setScale(float scale) { this.scale = scale; }
  public void setColor(ColorRGBA color) { this.color = color; }
  public void setDimensions(PixelDimension pixelDim) { this.dim = pixelDim; }
  public void setLocation(PixelPoint point) { this.pos = point; }

  public void setDimensions(PercentDimension percentDim) { 
    this.dim = Util.percentToPixelDimension(Window.getSize(), percentDim);
  }

  public void setLocation(PercentPoint point) { 
    this.pos = Util.percentToPixelPoint(Window.getSize(), point);
  }

  public void draw() {}

  public void run() {
    draw();
  }
}
