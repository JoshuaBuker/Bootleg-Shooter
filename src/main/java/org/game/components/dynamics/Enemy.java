package org.game.components.dynamics;

import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Line;
import org.lib.draw.Quad;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelDimension;
import org.lib.positioning.PixelPoint;
import org.lib.scene.SceneManager;
import org.lib.window.Window;
import org.w3c.dom.css.RGBColor;

public class Enemy extends DynamicComponent {
  private DynamicComponent player;

  private short movementValue = 10;
  private float health = 1.0f;

  private PixelDimension healthbarDimentions = new PixelDimension(75, 10);
  private PixelDimension healthbarRemainingDimentions = new PixelDimension(75, 10);
  private PixelPoint healthbarLocation;

  public Enemy(DynamicComponent player) {
    this.setDimensions(new PixelDimension(50, 50));
    this.setLocation(new PercentPoint(0.0f, 0.0f));
    this.setColor(ColorRGBA.RED);

    this.player = player;
  }

  public void tookDamage() {
    this.health -= 0.01;

    if (health <= 0) {
      health = 1.0f;
      setLocation(new PercentPoint((float)Math.random(), (float)Math.random()));
    }

    this.healthbarRemainingDimentions.setWidth(Math.round(healthbarDimentions.getWidth() * health));
  }

  @Override
  public void applyPhysics() {

  }

  @Override
  public void draw() {
    Quad.drawQuad(getPixelDimension(), getPixelLocation(), getColor(), Window.getSize());

    // Draw HealthBar
    this.healthbarLocation = new PixelPoint(getPixelLocation().getX(), getPixelLocation().getY() + Math.round(getPixelDimension().getHeight()) + 20);

    Quad.drawQuad(healthbarDimentions, healthbarLocation, ColorRGBA.GRAY, Window.getSize());
    Quad.drawQuad(healthbarRemainingDimentions, healthbarLocation, ColorRGBA.LIME, Window.getSize());
  }


  
}
