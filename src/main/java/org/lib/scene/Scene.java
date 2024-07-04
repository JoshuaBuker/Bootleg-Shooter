package org.lib.scene;

import java.util.*;

import org.lib.component.DynamicComponent;
import org.lib.component.StaticComponent;

public abstract class Scene {
  private String sceneName;
  private boolean pause = false;

  private final Map<String, DynamicComponent> DYNAMIC_COMPONENTS = new HashMap<>();
  private final Map<String, StaticComponent> STATIC_COMPONENTS = new HashMap<>();

  public Scene(String sceneName) {
    this.sceneName = sceneName;
  }

  public void addStatic(StaticComponent comp, String id) {
    this.STATIC_COMPONENTS.put(id, comp);
  }

  public void addDynamic(DynamicComponent comp, String id) {
    this.DYNAMIC_COMPONENTS.put(id, comp);
  }

  public void addStatic(StaticComponent comp) {
    this.STATIC_COMPONENTS.put(String.valueOf(STATIC_COMPONENTS.size()), comp);
  }

  public void addDynamic(DynamicComponent comp) {
    this.DYNAMIC_COMPONENTS.put(String.valueOf(DYNAMIC_COMPONENTS.size()), comp);
  }

  public Map<String, DynamicComponent> getDynamicMap() {
    return this.DYNAMIC_COMPONENTS;
  }

  public Map<String, StaticComponent> getStaticMap() {
    return this.STATIC_COMPONENTS;
  }

  public void pause() {
    this.pause = true;
  }
  public void resume() {
    this.pause = false;
  }
  
  public String getName() { return this.sceneName; }

  protected void applyPhysicsAndCollisions() {}
  protected void applyEvents() {}

  public void drawFrame() {
    if (!false) {
      for(Map.Entry<String, StaticComponent> entry : this.STATIC_COMPONENTS.entrySet()) {
        // System.out.println(entry.getKey());
        entry.getValue().run();
      }
  
      applyEvents();
      applyPhysicsAndCollisions();
  
      for(Map.Entry<String, DynamicComponent> entry : this.DYNAMIC_COMPONENTS.entrySet()) {
        // System.out.println(entry.getKey());
        entry.getValue().run();
      }
    }
  }
}
