package com.bydrives.pioneer.components

import com.artemis.Component

/**
 * Created by ivesv on 10/12/2015.
 */
case class TileType(var tileID: Int) extends Component{
  def this() = this(-1)
}
