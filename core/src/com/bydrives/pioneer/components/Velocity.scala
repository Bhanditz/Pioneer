package com.bydrives.pioneer.components

import com.artemis.Component

/**
 * Created by ivesv on 10/10/2015.
 */
case class Velocity(var vx: Float, var vy: Float, var ax: Float, var ay: Float) extends Component {
  def this() = this(0,0,0,0)
}
