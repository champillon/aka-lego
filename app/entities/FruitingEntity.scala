package entities

import models.CreateFruiting
import org.joda.time.DateTime

case class FruitingEntity(id: String
                          , sensorId: String
                          , thermal: Double
                          , humidity: Double
                          , co2: Double
                          , uv: Double
                          , created: DateTime)
  extends BasedEntity

object FruitingEntity {

  def apply(model: CreateFruiting, id: String): FruitingEntity =
    FruitingEntity(
      id = id
      , sensorId = model.sensorId
      , thermal = model.thermal
      , humidity = model.humidity
      , co2 = model.co2
      , uv = model.uv
      , created = model.created
    )
}