package com.bydrives.pioneer.world

/**
 * Created by ivesv on 10/12/2015.
 */
object TileRegistry {
  var tiles = Set[Tile]()

  def getTile(id: String): Tile = {
    tiles.find(_.name == id).get
  }

  def addTile(tile: Tile): Unit = {
    tiles += tile
  }
}
