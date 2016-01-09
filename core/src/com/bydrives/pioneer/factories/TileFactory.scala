package com.bydrives.pioneer.factories

import com.artemis._
import com.bydrives.pioneer.components.{Position, TileType}
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/13/2015.
 *
 * Used to create tiles
 */
object TileFactory {
  def create(tile: Tile, x: Int, y: Int, z: Int, world: World): Entity = {
    val entity: Entity = world.createEntity()
    val position: Position = world.getMapper(classOf[Position]).create(entity)
    val tileType: TileType = world.getMapper(classOf[TileType]).create(entity)
    position.x = x
    position.y = y
    position.z = z
    tileType.tileID = tile.name

    entity
  }
}
