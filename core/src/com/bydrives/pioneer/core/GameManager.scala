package com.bydrives.pioneer.core

import com.artemis.{WorldConfiguration, World}
import com.bydrives.pioneer.systems.TestSystem

/**
 * Created by ivesv on 10/10/2015.
 *
 * The core of this game, it is both used by the server and the client.
 * There are two instances of this manager on a local computer, the server instance and the client instance.
 *
 */
class GameManager(isServer: Boolean) {
  var world: World = null

  def setWorld(world:World) : Unit = {
    this.world = world
  }

  /**
   * Register common systems between client and server.
   */
  def registerSystems(worldConfiguration: WorldConfiguration): WorldConfiguration = {
    worldConfiguration.setSystem(new TestSystem)
  }
  /**
   * Gets called every frame
   * @param delta time between last frame
   */
  def render(delta: Float): Unit = {
    if (world != null) {
      world.setDelta(delta)
      world.process()
    }
  }
}
