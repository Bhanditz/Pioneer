package com.bydrives.pioneer.systems.client.render

import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.artemis.{Aspect, ComponentMapper}
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.bydrives.pioneer.components.{Position, TileType}
import com.bydrives.pioneer.world.{Tile, TileRegistry}

/**
 * Created by ivesv on 10/10/2015.
 * Renders all entities
 */
@Wire
class TileRenderSystem(batch: SpriteBatch, camera: OrthographicCamera) extends IteratingSystem(Aspect.all(classOf[Position], classOf[TileType])) {
  var cPosition: ComponentMapper[Position] = null
  var cTileType: ComponentMapper[TileType] = null

  override def process(e: Int): Unit = {
    val tileType: Tile = TileRegistry.getTile(cTileType.get(e).tileID)
    val position: Position = cPosition.get(e)

    batch.draw(tileType.textures(0), position.x, position.y + position.z, tileType.width, tileType.height + tileType.depth)
  }
}
