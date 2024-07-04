package org.game.scenes;

import org.game.components.dynamics.Enemy;
import org.game.components.dynamics.Player;
import org.lib.collision.Collisions;
import org.lib.color.ColorRGBA;
import org.lib.component.DynamicComponent;
import org.lib.draw.Line;
import org.lib.listener.KeyListener;
import org.lib.listener.MouseListener;
import org.lib.positioning.PercentPoint;
import org.lib.positioning.PixelPoint;
import org.lib.scene.Scene;
import org.lib.util.Util;
import org.lib.window.Window;
import org.lwjgl.glfw.GLFW;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MainMenu extends Scene {
  private Player player;
  private Enemy enemy;

  public MainMenu(String sceneName) {
    super(sceneName);

    player = new Player();
    enemy = new Enemy(player);
    addDynamic(player, "Player");
    addDynamic(enemy, "Enemy");
  }

  @Override
  protected void applyEvents() {
    PixelPoint pos = player.getPixelLocation();

    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_W)) { pos.setY(pos.getY() + 10); }
    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_A)) { pos.setX(pos.getX() - 10); }
    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_S)) { pos.setY(pos.getY() - 10); }
    if(KeyListener.isKeyPressed(GLFW.GLFW_KEY_D)) { pos.setX(pos.getX() + 10); }

    player.setLocation(pos);

    PixelPoint enemyPos = enemy.getPixelLocation();
    PixelPoint originalEnemyPos = enemyPos;
    float dx = enemyPos.getX() - pos.getX();
    float dy = enemyPos.getY() - pos.getY();

    if (dy != 0.0 && dy != Float.NaN && dx != 0.0 && dx != Float.NaN) {
      enemyPos.setX(Math.round(enemyPos.getX() + (dx * -0.02f)));
      enemyPos.setY(Math.round(enemyPos.getY() + (dy * -0.02f)));
    }

    enemy.setLocation(enemyPos);

    if(MouseListener.mouseButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) { 
      float x = (2*(MouseListener.getX()-(Window.getSize().getWidth()/2)))/Window.getSize().getWidth();
      float y = -(2*(MouseListener.getY()-(Window.getSize().getHeight()/2)))/Window.getSize().getHeight();

      PercentPoint tempPt = Util.pixelToPercentPoint(Window.getSize(), pos);
      Point2D.Float linePoint1 = new Point2D.Float(tempPt.getX(), tempPt.getY());
      Point2D.Float linePoint2 = new Point2D.Float(x, y);

      Line.drawLine(tempPt, new PercentPoint(x, y), ColorRGBA.WHITE);

      if (Collisions.lineIntersectsRectangle(linePoint1, linePoint2, enemy)) {
        enemy.tookDamage();
      }
    }
  }
}
