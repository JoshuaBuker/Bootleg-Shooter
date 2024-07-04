package org.lib.scene;

import java.util.*;

import org.lib.window.Window;

public class SceneManager {
  // ===================== INSTANCE =======================
  private Map<String, Scene> sceneMap = new HashMap<>();
  private Scene activeScene = new Scene("Placeholder") {};

  public SceneManager(Window window, Scene[] scenes) {
    loadScenes(scenes);
  }

  public void loadScenes(Scene[] scenes) {
    for(Scene scene: scenes) {
      registerScene(scene);
    }
  }

  public void registerScene(Scene scene) {
    this.sceneMap.put(scene.getName(), scene);
  }

  public SceneManager setActiveScene(String sceneName) {
    this.activeScene = sceneMap.get(sceneName);
    return this;
  }
  
  public SceneManager setActiveScene(Scene scene) {
    this.activeScene = sceneMap.get(scene.getName());
    return this;
  }

  public void displaySceneFrame() {
    if (activeScene != null) {
      activeScene.drawFrame();
    }
  }


}
