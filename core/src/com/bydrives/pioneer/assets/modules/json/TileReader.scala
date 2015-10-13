package com.bydrives.pioneer.assets.modules.json

import java.io.IOException

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.{JsonReader, JsonValue}
import com.bydrives.pioneer.assets.modules.Module
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/12/2015.
 *
 * Creates Tile from JSON Object
 */
object TileReader extends ObjectReader[Tile] {
  override def readFolder(dir: FileHandle, module: Module): Set[Tile] = {
    var tiles = Set[Tile]()
    val tileDir = dir.child("tiles")
    tileDir.mkdirs()

    tileDir.list(".json").filterNot(_.isDirectory).foreach((tileFile: FileHandle) => {
      tiles += read(tileFile, module)
    })
    tiles
  }

  override def read(file: FileHandle, module: Module): Tile = {
    val reader: JsonReader = new JsonReader
    val jsonValue: JsonValue = reader.parse(file)
    try {
      val texture: Texture = new Texture(Gdx.files.local(file.parent().path() + "/" + jsonValue.getString("texture", file.nameWithoutExtension())))
      val name: String = s"${module.name.toLowerCase}:${jsonValue.getString("name")}"
      new Tile(name, texture)
    } catch {
      case ioe: IOException => Gdx.app.error("TileReader", s"Couldn't load file $ioe"); null
    }
  }
}
