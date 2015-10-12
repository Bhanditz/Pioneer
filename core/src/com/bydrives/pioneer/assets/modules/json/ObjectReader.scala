package com.bydrives.pioneer.assets.modules.json

import com.badlogic.gdx.files.FileHandle

/**
 * Created by ivesv on 10/12/2015.
 *
 * Base interface for object readers
 */
trait ObjectReader[T] {
  def readFile(file: FileHandle, moduleRoot: String): T
}
