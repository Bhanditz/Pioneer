package com.bydrives.pioneer.world

import com.badlogic.gdx.graphics.Texture

/**
 * Created by ivesv on 10/14/2015.
 */
case class Decal(texture: Texture, width: Float, height: Float, quantity: Int) {
  def this(texture: Texture, quantity: Int) =
    this(texture, texture.getWidth/TileRegistry.BASE_SIZE.toFloat, texture.getHeight/TileRegistry.BASE_SIZE.toFloat, quantity)
}
