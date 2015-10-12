package com.bydrives.pioneer.assets.modules

/**
 * Created by Ives on 12/10/2015.
 *
 * A module itself, serializable
 */
class Module(name: String, version: String, location: String) {
  override def toString: String = s"$name: $version"
}
