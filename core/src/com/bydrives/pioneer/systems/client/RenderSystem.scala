package com.bydrives.pioneer.systems.client

import com.artemis.annotations.Wire
import com.artemis.systems.IteratingSystem
import com.artemis.{Aspect, ComponentMapper}
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.bydrives.pioneer.components.Position
import com.bydrives.pioneer.components.client.Visual

/**
 * Created by ivesv on 10/10/2015.
 * Renders all entities
 */
@Wire
class RenderSystem(batch: SpriteBatch, camera: OrthographicCamera) extends IteratingSystem(Aspect.all(classOf[Visual], classOf[Position])) {
  var cPosition: ComponentMapper[Position] = null
  var cVisual: ComponentMapper[Visual] = null

  override def begin(): Unit = {
    super.begin()

    Gdx.gl.glClearColor(0, 0, 0, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.setProjectionMatrix(camera.combined)
    batch.begin()
  }

  override def process(e: Int): Unit = {
    val visual: Visual = cVisual.get(e)
    val position: Position = cPosition.get(e)
    batch.draw(visual.texture, position.x, position.y, visual.width, visual.height)
  }

  override def end(): Unit = {
    super.end()
    batch.end()
  }
}
