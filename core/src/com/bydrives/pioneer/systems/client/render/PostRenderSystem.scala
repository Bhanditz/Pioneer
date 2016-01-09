package com.bydrives.pioneer.systems.client.render

import com.artemis.BaseSystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Created by ives on 18/10/15.
 */
class PostRenderSystem(batch: SpriteBatch, camera: OrthographicCamera) extends BaseSystem {
  override def processSystem(): Unit = {}
  override def end(): Unit = {
    super.end()
    batch.end()
  }
}
