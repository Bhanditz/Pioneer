package com.bydrives.pioneer.systems.client

import com.artemis.{Entity, Aspect}
import com.artemis.systems.EntityProcessingSystem
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bydrives.pioneer.components.Position
import com.bydrives.pioneer.components.client.Visual

/**
 * Created by ivesv on 10/10/2015.
 * Renders all entities
 */
class RenderSystem(batch: SpriteBatch) extends EntityProcessingSystem(Aspect.all(classOf[Visual], classOf[Position])) {
  override def process(e: Entity): Unit = {
    println(s"Processing Entity $e")
  }
}
