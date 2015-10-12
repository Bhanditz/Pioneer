package com.bydrives.pioneer.systems.managers

import com.artemis.annotations.Wire
import com.artemis.{ComponentMapper, Entity, BaseSystem}
import com.badlogic.gdx.graphics.Texture
import com.bydrives.pioneer.components.{TileType, Position}
import com.bydrives.pioneer.components.client.Visual
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/12/2015.
 */
@Wire
class TileManager extends BaseSystem {
  var cp: ComponentMapper[Position] = null
  var cv: ComponentMapper[Visual] = null
  var ct: ComponentMapper[TileType] = null
  val TILE_SIZE = 1

  var tiles = Map[Int, Tile]()
  tiles += 0 -> new Tile("grass", new Texture("grass.jpg"))


  def createTileEntity(id: Int, x: Int, y: Int): Entity = {
    val tile = tiles(id)
    if(tile == null) return null

    val e = getWorld.createEntity()
    val tileType = ct.create(e)
    tileType.tileID = id

    val pos = cp.create(e)
    pos.x = x
    pos.y = y
    val vis = cv.create(e)
    vis.texture = tile.texture
    vis.height = TILE_SIZE
    vis.width = TILE_SIZE

    e
  }

  override def processSystem(): Unit = {

  }
}
