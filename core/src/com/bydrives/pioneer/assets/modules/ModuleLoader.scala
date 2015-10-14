package com.bydrives.pioneer.assets.modules

import com.artemis.World
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.utils.{JsonReader, JsonValue}
import com.bydrives.pioneer.assets.AssetsDB
import com.bydrives.pioneer.assets.modules.json.TileReader
import com.bydrives.pioneer.world.{Tile, TileRegistry}

/**
 * Created by ivesv on 10/12/2015.
 *
 * Loads + converts all modules, also serializes modules to bytes for sending over the network
 */
object ModuleLoader {
  val modules = indexModules(AssetsDB.MODULES)

  def indexModules(location: String): Set[Module] = {
    Gdx.app.debug("ModuleLoader", "Indexing modules...")
    // Create necessary folders first (if they don't exist)
    Gdx.files.local(location).mkdirs()

    var modules = Set[Module]()
    val subDirectories = Gdx.files.local(location).list().filter(_.isDirectory)

    val reader: JsonReader = new JsonReader
    for(directory <- subDirectories) {
      val configFiles = directory.list(s"${directory.name()}.json")
      if (configFiles.nonEmpty) {
        val jsonValue: JsonValue = reader.parse(configFiles(0))
        val version: String = jsonValue.get("version").asString()
        val module: Module = new Module(directory.name(), version, configFiles(0).parent().path())
        modules += module
      }
    }
    Gdx.app.debug("ModuleLoader", s"Indexed ${modules.size} modules")
    modules
  }

  def loadModules(): Unit = {
    modules.foreach(module => {
      val dir: FileHandle = Gdx.files.local(module.location)
      val tiles: Set[Tile] = TileReader.readFolder(dir, module)
      tiles.foreach(TileRegistry.addTile)
    })
  }
}
