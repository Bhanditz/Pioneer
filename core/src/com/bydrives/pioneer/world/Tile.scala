package com.bydrives.pioneer.world

import com.badlogic.gdx.graphics.Texture

/**
 * Created by ivesv on 10/12/2015.
 */
case class Tile(name: String, textures: Array[Texture], width: Int = 1, height: Int = 1, depth: Int = 1) {
  var decals = Set[Decal]()
  var decalDensity = 0

  var decalQuantityList = Array[Decal]()

  def generateDecalQuantityList(): Unit = {
    val totalQuantity = decals.map(_.quantity).sum
    //TODO GCD

    decals.foreach((decal: Decal) => {
      0 until decal.quantity foreach (x => {
        decalQuantityList = decalQuantityList :+ decal
      })
    })
  }
}
