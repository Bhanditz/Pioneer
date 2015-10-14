package com.bydrives.pioneer.world

import com.badlogic.gdx.graphics.Texture

/**
 * Created by ivesv on 10/14/2015.
 */
case class Decal(texture: Texture, width: Float, height: Float) {
  def this(texture: Texture) = this(texture, texture.getWidth/TileRegistry.BASE_SIZE, texture.getHeight/TileRegistry.BASE_SIZE)
}
