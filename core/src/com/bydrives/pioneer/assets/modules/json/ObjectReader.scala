package com.bydrives.pioneer.assets.modules.json

import com.badlogic.gdx.files.FileHandle
import com.bydrives.pioneer.assets.modules.Module

/**
 * Created by ivesv on 10/12/2015.
 *
 * Base interface for object readers
 */
trait ObjectReader[T] {
  def readFolder(dir: FileHandle, module: Module): Set[T]
  def read(file: FileHandle, module: Module): T
}
