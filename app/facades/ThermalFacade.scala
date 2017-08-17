package facades

import javax.inject.{Inject, Singleton}

import entities.ThermalEntity
import models.{CreatingThermal, Thermal}
import persists.ThermalPersist
import utilities.Uuid

@Singleton
class ThermalFacade @Inject()(persist: ThermalPersist) {

  def stamp(model: CreatingThermal): Thermal = {
    val entity = ThermalEntity(model, Uuid.get)

    if (persist.insert(entity))
      Thermal(entity)
    else
      throw new Exception("transaction fail.")
  }


}
