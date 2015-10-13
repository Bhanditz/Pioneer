package com.bydrives.pioneer.systems.managers

import com.artemis.BaseSystem
import com.artemis.annotations.Wire
import com.bydrives.pioneer.factories.TileFactory
import com.bydrives.pioneer.world.Tile
import com.bydrives.pioneer.world.chunks.Chunk

/**
 * Created by ivesv on 10/12/2015.
 *
 * Base world, is used for keeping track of chunks and time
 *
 * @param name    Name of world
 * @param width   Width of world (multiplied by CHUNK_SIZE) (world is loopable)
 * @param height  Height of world (multiplied by CHUNK_SIZE) (world is loopable)
 */
@Wire
class WorldManager(name: String = "Earth", width: Int, height: Int) extends BaseSystem {
  val CHUNK_SIZE = 16

  var chunks = Map[Int, Chunk]()

  override def initialize(): Unit = generateWorld(0, 0, 3)

  /**
   * Generates a world based on position and
   * @param x
   * @param y
   */
  def generateWorld(x: Float, y: Int, radius: Int): Unit = {
    val chunkPosX: Int = x.toInt / CHUNK_SIZE
    val chunkPosY: Int = y.toInt / CHUNK_SIZE
    for(xPos <- chunkPosX - radius / 2 to chunkPosX + radius / 2 / CHUNK_SIZE; yPos <- chunkPosY - radius / 2 to chunkPosY + radius / 2 / CHUNK_SIZE) {
      if(!chunks.contains(xPos + yPos * CHUNK_SIZE)) {
        val chunk = new Chunk(CHUNK_SIZE, CHUNK_SIZE, xPos, yPos)
        chunks += (xPos + yPos * CHUNK_SIZE -> chunk)
        for((tile: Tile, pos) <- chunk.tiles.view.zipWithIndex) {
          TileFactory.create(tile, xPos * CHUNK_SIZE + (pos % CHUNK_SIZE), yPos * CHUNK_SIZE + pos / CHUNK_SIZE, getWorld)
        }
      }
    }
  }

  override def processSystem(): Unit = {}
}
