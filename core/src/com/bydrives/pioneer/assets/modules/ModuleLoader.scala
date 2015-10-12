package com.bydrives.pioneer.assets.modules

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.{JsonReader, JsonValue}
import com.bydrives.pioneer.assets.AssetsDB

/**
 * Created by ivesv on 10/12/2015.
 *
 * Loads + converts all modules, also serializes modules to bytes for sending over the network
 */
class ModuleLoader {
  val modules = indexModules(AssetsDB.MODULES)


  def indexModules(location: String): Set[Module] = {
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
        val module: Module = new Module(directory.name(), version, configFiles(0).path())
        modules += module
      }
    }
    modules
  }
}
