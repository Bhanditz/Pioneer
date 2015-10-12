package com.bydrives.pioneer.core.client

import com.artemis.{World, WorldConfiguration}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.{Gdx, Screen}
import com.bydrives.pioneer.core.GameManager
import com.bydrives.pioneer.systems.client.RenderSystem

/**
 * Created by ivesv on 10/10/2015.
 */
class ClientManager() extends GameManager(false) with Screen {
  val batch: SpriteBatch = new SpriteBatch()
  val camera: OrthographicCamera = new OrthographicCamera()
  super.world = new World(registerSystems(new WorldConfiguration))

  override def registerSystems(worldConfiguration: WorldConfiguration): WorldConfiguration = {
    super.registerSystems(worldConfiguration)
    worldConfiguration.setSystem(new RenderSystem(batch, camera))
  }

  override def resize(width: Int, height: Int): Unit = {
    camera.viewportWidth = 30f;                 // Viewport of 30 units!
    camera.viewportHeight = 30f * height/width; // Lets keep things in proportion.
    camera.update();
  }

  override def hide(): Unit = {}

  override def dispose(): Unit = {}

  override def pause(): Unit = {}

  override def show(): Unit = {}

  override def resume(): Unit = {}
}
