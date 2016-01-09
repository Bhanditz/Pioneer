package com.bydrives.pioneer.world.chunks

import com.bydrives.pioneer.world.{TileRegistry, Tile}

/**
 * Created by ivesv on 10/12/2015.
 *
 * Contains tiles, entities
 */
class Chunk(width: Int, height: Int, depth: Int, x: Int, y: Int, z: Int) {
  /**
   * Entities in this chunk
   */
  val entities = Set[Int]()
  /**
   * 1D array of tiles, eg: chunk dimensions 5 * 5 * 5 the array is 125 tiles long
   * This is cheap in memory, since we are only storing references
   */
  val tiles = new Array[Tile](width*height*depth)

  generateChunk()

  /**
   * Get tile based on coordinates
   * @param x coordinate
   * @param y coordinate
   * @return Int of tile
   */
  def getTile(x: Int, y: Int, z: Int): Tile = tiles(x + y * width + z * width * depth)

  /**
   * Check if coordinate is in chunk
   * @param x coordinate
   * @param y coordinate
   * @return Boolean if is in chunk
   */
  def inChunk(x: Int, y: Int, z: Int): Boolean = x >= this.x && x < this.x + width &&
    y >= this.y && y < this.y + height && z > this.z && z < this.z + depth

  /**
   * Generates the chunk, stub for now.
   */
  def generateChunk(): Unit = {
    for((t, i: Int) <- tiles.view.zipWithIndex) {
      tiles(i) = TileRegistry.getTile("pioneer:grass")
    }
  }
}
