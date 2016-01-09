package com.bydrives.pioneer.systems.client.render

import com.artemis.BaseSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Created by ives on 18/10/15.
 */
class PreRenderSystem(batch: SpriteBatch, camera: OrthographicCamera) extends BaseSystem {
  override def begin(): Unit = {
    super.begin()
    Gdx.gl.glClearColor(0, 0, 0, 1)
    camera.update()
    batch.setProjectionMatrix(camera.combined)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.begin()
  }

  override def processSystem(): Unit = {}
}
