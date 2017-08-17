package views

import models.Fruiting
import utilities.Json

case class FruitingView(id: String
                        , sensorId: String
                        , thermal: Int)
  extends Json

object FruitingView {

  def apply(model: Fruiting): FruitingView =
    FruitingView(
      id = model.id
      , sensorId = model.sensorId
      , thermal = model.thermal
    )
}