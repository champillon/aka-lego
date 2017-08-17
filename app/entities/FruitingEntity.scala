package entities

import models.CreateFruiting
import org.joda.time.DateTime

case class FruitingEntity(id: String
                          , sensorId: String
                          , thermal: Int
                          , created: DateTime)
  extends BasedEntity

object FruitingEntity {

  def apply(model: CreateFruiting, id: String): FruitingEntity =
    FruitingEntity(
      id = id
      , sensorId = model.sensorId
      , thermal = model.thermal
      , created = model.created
    )
}