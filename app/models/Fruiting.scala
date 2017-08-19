package models

import entities.FruitingEntity

case class Fruiting(id: String
                    , sensorId: String
                    , thermal: Double
                    , humidity: Double
                    , co2: Double)

object Fruiting {

  def apply(entity: FruitingEntity): Fruiting =
    Fruiting(
      id = entity.id
      , sensorId = entity.sensorId
      , thermal = entity.thermal
      , humidity = entity.humidity
      , co2 = entity.co2
    )
}