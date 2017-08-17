package facades

import javax.inject.{Inject, Singleton}

import entities.FruitingEntity
import models.{CreateFruiting, Fruiting}
import persists.FruitingPersist
import utilities.Uuid

@Singleton
class FruitingFacade @Inject()(persist: FruitingPersist) {

  def stamp(model: CreateFruiting): Fruiting = {
    Fruiting(
      persist.insert(FruitingEntity(model, Uuid.get))
    )
  }


}
