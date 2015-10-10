package com.bydrives.pioneer.systems

import com.artemis.systems.EntityProcessingSystem
import com.artemis.{ComponentMapper, Aspect, Entity}
import com.bydrives.pioneer.components.{Position, Velocity}

/**
 * Created by ivesv on 10/10/2015.
 *
 * Handles movement of entities, changes position based on velocity
 * Relies on {@link com.bydrives.pioneer.components.Velocity} and {@link com.bydrives.pioneer.components.Position}
 */
class MovementSystem extends EntityProcessingSystem(Aspect.all(classOf[Position], classOf[Velocity])) {
  var cp: ComponentMapper[Position] = null
  var cv: ComponentMapper[Velocity] = null

  override def process(e: Entity): Unit = {
    val pos: Position = cp.get(e)
    val vel: Velocity = cv.get(e)

    pos.x += vel.vx * getWorld.getDelta
    pos.y += vel.vy * getWorld.getDelta
  }
}
