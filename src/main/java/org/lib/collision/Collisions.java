package org.lib.collision;

import org.lib.component.DynamicComponent;
import org.lib.component.StaticComponent;
import org.lib.draw.Line;
import org.lib.positioning.PercentDimension;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Collisions {
  public static boolean lineIntersectsRectangle(Point2D.Float linePoint1, Point2D.Float linePoint2, StaticComponent comp) {
    // Extract rectangle properties
    float rectX = comp.getPercentLocation().getX();
    float rectY = comp.getPercentLocation().getY();
    float rectWidth = comp.getPercentDimension().getWidth();
    float rectHeight = comp.getPercentDimension().getHeight();

    // Calculate rectangle corners
    Point2D.Float topLeft = new Point2D.Float(rectX - rectWidth / 2, rectY + rectHeight / 2);
    Point2D.Float topRight = new Point2D.Float(rectX + rectWidth / 2, rectY + rectHeight / 2);
    Point2D.Float bottomLeft = new Point2D.Float(rectX - rectWidth / 2, rectY - rectHeight / 2);
    Point2D.Float bottomRight = new Point2D.Float(rectX + rectWidth / 2, rectY - rectHeight / 2);

    // Check for intersection with rectangle edges
    boolean intersectsTop = Line2D.linesIntersect(linePoint1.x, linePoint1.y, linePoint2.x, linePoint2.y,
                                                  topLeft.x, topLeft.y, topRight.x, topRight.y);
    boolean intersectsBottom = Line2D.linesIntersect(linePoint1.x, linePoint1.y, linePoint2.x, linePoint2.y,
                                                     bottomLeft.x, bottomLeft.y, bottomRight.x, bottomRight.y);
    boolean intersectsLeft = Line2D.linesIntersect(linePoint1.x, linePoint1.y, linePoint2.x, linePoint2.y,
                                                   topLeft.x, topLeft.y, bottomLeft.x, bottomLeft.y);
    boolean intersectsRight = Line2D.linesIntersect(linePoint1.x, linePoint1.y, linePoint2.x, linePoint2.y,
                                                    topRight.x, topRight.y, bottomRight.x, bottomRight.y);

    return intersectsTop || intersectsBottom || intersectsLeft || intersectsRight;
  }
}
