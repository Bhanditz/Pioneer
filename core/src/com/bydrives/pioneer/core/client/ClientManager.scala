package com.bydrives.pioneer.core.client

import com.artemis.{World, WorldConfiguration}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bydrives.pioneer.core.GameManager
import com.bydrives.pioneer.systems.client.RenderSystem

/**
 * Created by ivesv on 10/10/2015.
 */
class ClientManager() extends GameManager(false) {
  val batch: SpriteBatch = new SpriteBatch()
  val camera: OrthographicCamera = new OrthographicCamera()
  super.setWorld(new World(registerSystems(new WorldConfiguration)))

  override def registerSystems(worldConfiguration: WorldConfiguration): WorldConfiguration = {
    super.registerSystems(worldConfiguration)
    worldConfiguration.setSystem(new RenderSystem(batch, camera))
  }
}
