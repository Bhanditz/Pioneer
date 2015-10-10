package com.bydrives.pioneer.core.server

import com.artemis.{World, WorldConfiguration}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.bydrives.pioneer.core.GameManager

/**
 * Created by ivesv on 10/10/2015.
 */
class ServerManager extends GameManager(true) {
  val camera: OrthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth, Gdx.graphics.getHeight)
  super.setWorld(new World(registerSystems(new WorldConfiguration)))

  override def registerSystems(worldConfiguration: WorldConfiguration): WorldConfiguration = {
    super.registerSystems(worldConfiguration)
  }
}
