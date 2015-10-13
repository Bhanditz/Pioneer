package com.bydrives.pioneer.world

import com.badlogic.gdx.graphics.Texture

/**
 * Created by ivesv on 10/12/2015.
 */
object TileRegistry {
  var tiles = Set[Tile]()
  tiles += new Tile("grass", new Texture("grass.jpg"))

  def getTile(id: String): Tile = {
    tiles.find(_.name == id).get
  }

  def addTile(tile: Tile): Unit = {
    tiles += tile
  }
}
