package com.bydrives.pioneer.world.chunks

/**
 * Created by ivesv on 10/12/2015.
 *
 * Contains tiles, entities
 */
class Chunk(width: Int, height: Int, x: Int, y: Int) {
  /**
   * Entities in this chunk
   */
  val entities = Set[Int]()
  /**
   * 1D array of tiles, for chunk dimensions 5 * 5 the array is 25 ints long
   */
  val tiles = new Array[Int](width*height)

  generateChunk()

  /**
   * Get tile based on coordinates
   * @param x coordinate
   * @param y coordinate
   * @return Int of tile
   */
  def getTile(x: Int, y: Int): Int = tiles(x + y * width)

  /**
   * Check if coordinate is in chunk
   * @param x coordinate
   * @param y coordinate
   * @return Boolean if is in chunk
   */
  def inChunk(x: Int, y: Int): Boolean = x >= this.x && x < this.x + width && y >= this.y && y < this.y + height

  /**
   * Generates the chunk, stub for now.
   */
  def generateChunk(): Unit = {
    for(i <- tiles) {
      tiles(i) = 0
    }
  }
}
