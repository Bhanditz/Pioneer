package com.bydrives.pioneer.factories

import com.artemis._
import com.bydrives.pioneer.components.client.Visual
import com.bydrives.pioneer.components.{Position, TileType}
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/13/2015.
 *
 * Used to create tiles
 */
object TileFactory {
  def create(tile: Tile, x: Int, y: Int, world: World): Entity = {
    val entity: Entity = world.createEntity()
    val position: Position = world.getMapper(classOf[Position]).create(entity)
    val tileType: TileType = world.getMapper(classOf[TileType]).create(entity)
    val visual: Visual = world.getMapper(classOf[Visual]).create(entity)
    position.x = x
    position.y = y
    tileType.tileID = tile.name
    visual.texture = tile.texture
    visual.width = 1
    visual.height = 1

    entity
  }
}
