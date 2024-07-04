package org.lib.component;

public abstract class DynamicComponent extends StaticComponent {
  private float GRAVITY = 10;
  private float mass = 1;

  private float SPEED = 0.01f;

  private float VELOCITY_X = 0;
  private float VELOCITY_Y = 0;


  public float getXVelocity(){ return VELOCITY_X;}
  public float getYVelocity() {return VELOCITY_Y;}
  public float getSpeed(){return SPEED;}

  public void setXVelocity(float xVal){VELOCITY_X = xVal;}
  public void setYVelocity (float yVal){VELOCITY_Y = yVal;}
  public void setSpeed(float speedVal) { SPEED = speedVal;}

  public float getGravity() { return GRAVITY; }
  public float getMass() { return mass; }

  public void setGravity(float gRAVITY) { GRAVITY = gRAVITY; }
  public void setMass(float mass) { this.mass = mass; }

  public void applyPhysics() {}

  @Override
  public void run() {
    applyPhysics();
    draw();
  }
}