package models

import entities.FruitingEntity
import org.joda.time.DateTime

case class Fruiting(id: String
                    , sensorId: String
                    , thermal: Double
                    , humidity: Double
                    , co2: Double
                    , uv: Double
                    , created: DateTime)

object Fruiting {

  def apply(entity: FruitingEntity): Fruiting =
    Fruiting(
      id = entity.id
      , sensorId = entity.sensorId
      , thermal = entity.thermal
      , humidity = entity.humidity
      , co2 = entity.co2
      , uv = entity.uv
      , created = entity.created
    )
}