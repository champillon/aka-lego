package models

import entities.ThermalEntity

case class Thermal(id: String
                   , sensorId: String
                   , thermal: Int)

object Thermal {

  def apply(entity: ThermalEntity): Thermal =
    Thermal(
      id = entity.id
      , sensorId = entity.sensorId
      , thermal = entity.thermal
    )
}