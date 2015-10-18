package com.bydrives.pioneer.systems.client.render

import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.artemis.{Aspect, ComponentMapper}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bydrives.pioneer.components.{TileType, Position}
import com.bydrives.pioneer.components.client.Visual
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/10/2015.
 * Renders all entities
 */
@Wire
class RenderSystem(batch: SpriteBatch, camera: OrthographicCamera) extends IteratingSystem(Aspect.all(classOf[Visual], classOf[Position]).exclude(classOf[TileType])) {
  var cPosition: ComponentMapper[Position] = null
  var cVisual: ComponentMapper[Visual] = null

  override def process(e: Int): Unit = {
    val visual: Visual = cVisual.get(e)
    val position: Position = cPosition.get(e)
    batch.draw(visual.texture, position.x, position.y, visual.width, visual.height)
  }
}
