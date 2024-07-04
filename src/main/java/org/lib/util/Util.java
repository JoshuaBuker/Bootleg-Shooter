package org.lib.util;

import org.lib.positioning.PercentDimension;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;

public class Util {

  public static int booleanToInt(boolean bool) {
    return !bool ? 1 : 0;
  }

  public static PercentPoint pixelToPercentPoint(PixelDimension window, PixelPoint pixel) {
    return new PercentPoint((float)pixel.getX() / window.getWidth(), (float)pixel.getY() / window.getHeight());
  }

  public static PercentDimension pixelToPercentDimension(PixelDimension window, PixelDimension dim) {
    return new PercentDimension((float)dim.getWidth() / window.getWidth(), (float)dim.getHeight() / window.getHeight());
  }

  public static PixelPoint percentToPixelPoint(PixelDimension window, PercentPoint pt) {
    return new PixelPoint((short)pt.getX() - (window.getWidth() / 2), (short)-(pt.getY()) + (window.getWidth() / 2));
  }

  public static PixelDimension percentToPixelDimension(PixelDimension window, PercentDimension dim) {
    return new PixelDimension((short)Math.abs(dim.getWidth()) * window.getWidth(), (short)Math.abs(dim.getHeight()) * window.getHeight());
  }
}
