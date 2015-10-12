package com.bydrives.pioneer.assets.modules.json

import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/12/2015.
 *
 * Creates Tile from JSON Object
 */
object TileReader extends ObjectReader[Tile] {
  override def readFile(file: FileHandle, moduleRoot: String): Tile = {
    //TODO: Implement
    new Tile("Test", new Texture("grass.jpg"))
  }
}
