package com.bydrives.pioneer.core

import com.artemis.{World, WorldConfiguration}
import com.bydrives.pioneer.systems.MovementSystem
import com.bydrives.pioneer.systems.managers.WorldManager

/**
 * Created by ivesv on 10/10/2015.
 *
 * The core of this game, it is both used by the server and the client.
 * There are two instances of this manager on a local computer, the server instance and the client instance.
 *
 */
class GameManager(isServer: Boolean) {
  private var _world: World = _

  def world = _world
  def world_=(world:World) : Unit = {
    _world = world
  }

  /**
   * Register common systems between client and server.
   */
  def registerSystems(worldConfiguration: WorldConfiguration): WorldConfiguration = {
    worldConfiguration.setSystem(new WorldManager("Earth", 300, 300))
    worldConfiguration.setSystem(new MovementSystem)
  }

  def postRun(): Unit = {
    world.getSystem(classOf[WorldManager]).createWorld()
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
