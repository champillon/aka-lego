package entities

import models.CreatingThermal
import org.joda.time.DateTime

case class ThermalEntity(sensorId: String
                         , thermal: Int
                         , created: DateTime)

object ThermalEntity {

  def apply(model: CreatingThermal): ThermalEntity =
    ThermalEntity(
      sensorId = model.sensorId
      , thermal = model.thermal
      , created = model.created
    )
}