package models

import entities.FruitingEntity

case class Fruiting(id: String
                    , sensorId: String
                    , thermal: Int)

object Fruiting {

  def apply(entity: FruitingEntity): Fruiting =
    Fruiting(
      id = entity.id
      , sensorId = entity.sensorId
      , thermal = entity.thermal
    )
}