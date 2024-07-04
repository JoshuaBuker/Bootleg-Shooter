package org.game.components.dynamics;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Line;
import org.lib.draw.Quad;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.window.Window;
import org.w3c.dom.css.RGBColor;

public class Player extends DynamicComponent {

  public Player() {
    this.setDimensions(new PixelDimension(50, 50));
    this.setLocation(new PercentPoint(0.0f, 0.0f));
    this.setColor(ColorRGBA.SLATE_GRAY);
  }

  @Override
  public void applyPhysics() {
    
  }

  @Override
  public void draw() {
    Quad.drawQuad(getPercentDimension(), getPercentLocation(), getColor());
  }


  
}
