package views

import models.Thermal
import utilities.Json

case class ThermalView(id: String
                       , sensorId: String
                       , thermal: Int)
  extends Json

object ThermalView {

  def apply(model: Thermal): ThermalView =
    ThermalView(
      id = model.id
      , sensorId = model.sensorId
      , thermal = model.thermal
    )
}