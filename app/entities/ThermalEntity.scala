package entities

import models.CreatingThermal
import org.joda.time.DateTime

case class ThermalEntity(id: String
                         , sensorId: String
                         , thermal: Int
                         , created: DateTime)
  extends BasedEntity

object ThermalEntity {

  def apply(model: CreatingThermal, id: String): ThermalEntity =
    ThermalEntity(
      id = id
      , sensorId = model.sensorId
      , thermal = model.thermal
      , created = model.created
    )
}