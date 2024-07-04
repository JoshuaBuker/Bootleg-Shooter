package org.game;

import org.lib.color.ColorRGBA;
import org.lib.scene.SceneManager;
import org.lib.window.Window;

public class Main {
  public static void main(String[] args) {
    Window window = new Window.Builder()
      .title("Bootleg Shooter")
      .backgroundColor(new ColorRGBA(65, 110, 69))
      .windowDimensions(800, 600)
      .resizable(false)
      .build();

    SceneManager manager = new SceneManager(window, Constants.SCENES)
      .setActiveScene("Main Menu");
    
    window.run(manager);
  }
}