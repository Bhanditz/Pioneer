package com.bydrives.pioneer.components

import com.artemis.Component

/**
 * Created by ivesv on 10/10/2015.
 * Defines the position of an Entity
 * @param x pos x
 * @param y pos y
 * @param z depth of entity, defines collision/view
 */
case class Position(x: Float, y: Float, z: Integer) extends Component
