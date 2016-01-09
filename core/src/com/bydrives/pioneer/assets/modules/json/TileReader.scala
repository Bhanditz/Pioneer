package com.bydrives.pioneer.assets.modules.json

import java.io.IOException

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.{JsonReader, JsonValue}
import com.bydrives.pioneer.assets.modules.Module
import com.bydrives.pioneer.world.{Decal, Tile}

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

    tileDir.list().filter(_.isDirectory).foreach((tileFile: FileHandle) => {
      tiles += read(tileFile, module)
    })
    tiles
  }

  override def read(dir: FileHandle, module: Module): Tile = {
    val reader: JsonReader = new JsonReader
    val config: FileHandle = dir.child(dir.name() + ".json")
    val jsonValue: JsonValue = reader.parse(config)
    try {
      val topTexture: Texture = new Texture(Gdx.files.local(dir.path() + "/" + jsonValue.getString("texture", dir.name() + "-top.png")))
      val sideTexture: Texture = new Texture(Gdx.files.local(dir.path() + "/" + jsonValue.getString("texture", dir.name() + "-side.png")))
      val topSideTexture: Texture = new Texture(Gdx.files.local(dir.path() + "/" + jsonValue.getString("texture", dir.name() + "-topside.png")))
      val name: String = s"${module.name.toLowerCase}:${jsonValue.getString("name")}"
      val tile = new Tile(name, Array[Texture](topTexture, sideTexture, topSideTexture))

      if (dir.child("decals").exists() && jsonValue.get("decals") != null) {
        var decals = Set[Decal]()
        val decalProperties = jsonValue.get("decals")
        val itemIterator = decalProperties.get("items").iterator()
        while(itemIterator.hasNext) {
          val item = itemIterator.next()
          decals += new Decal(new Texture(dir.child("decals").child(item.getString("name") + ".png")), item.getInt("quantity"))
        }
        tile.decalDensity = decalProperties.getInt("density")
        tile.decals = decals
        tile.generateDecalQuantityList()
      }

      tile
    } catch {
      case ioe: IOException => Gdx.app.error("TileReader", s"Couldn't load file $ioe"); null
    }
  }
}
