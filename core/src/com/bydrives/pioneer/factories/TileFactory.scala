package com.bydrives.pioneer.factories

import com.artemis._
import com.bydrives.pioneer.components.client.Visual
import com.bydrives.pioneer.components.{Position, TileType}
import com.bydrives.pioneer.utils.SimplexNoise
import com.bydrives.pioneer.world.Tile

/**
 * Created by ivesv on 10/13/2015.
 *
 * Used to create tiles
 */
object TileFactory {
  def create(tile: Tile, x: Int, y: Int, world: World): Entity = {
    val entity: Entity = world.createEntity()
    val position: Position = world.getMapper(classOf[Position]).create(entity)
    val tileType: TileType = world.getMapper(classOf[TileType]).create(entity)
    val visual: Visual = world.getMapper(classOf[Visual]).create(entity)
    position.x = x
    position.y = y
    tileType.tileID = tile.name
    visual.texture = tile.texture
    visual.width = 1
    visual.height = 1

    createDecals(tile, x, y, world)
    entity
  }

  def createDecals(tile: Tile, x: Int, y: Int, world: World): Unit = {
    if(tile.decals.isEmpty) return

    val position: ComponentMapper[Position] = world.getMapper(classOf[Position])
    val visual: ComponentMapper[Visual] = world.getMapper(classOf[Visual])

    val density = tile.decalDensity.toFloat
    // Assuming that all tiles are square
    val tileSize = tile.texture.getHeight.toFloat
    var stepSize = density/tileSize
    var xStep = x.toFloat
    var yStep = y.toFloat


    val persistence: Float = 1


    while (xStep <= x + 1) {
      yStep = y.toFloat
      while (yStep <= y + 1) {
        var amplitude: Float = 1
        var frequency: Float = 1
        var maxValue: Float = 1
        val noise = (0 until 6 map((i: Int) => {
          val lNoise = SimplexNoise.noise(xStep, yStep) * amplitude

          maxValue += amplitude

          amplitude *= persistence
          frequency *= 2
          lNoise
        }) sum) / maxValue
        if(noise.abs > 0.6) {
          val decal = tile.decalQuantityList((Math.random() * tile.decalQuantityList.length.toFloat).toInt)
          val entity: Entity = world.createEntity()
          val positionComponent = position.create(entity)
          val visualComponent = visual.create(entity)
          positionComponent.x = xStep
          positionComponent.y = yStep
          visualComponent.texture = decal.texture
          visualComponent.width = decal.width
          visualComponent.height = decal.height

          xStep += visualComponent.width / 2
          yStep += visualComponent.height / 2
        }
        yStep += stepSize
      }
      xStep += stepSize
    }
  }
}
