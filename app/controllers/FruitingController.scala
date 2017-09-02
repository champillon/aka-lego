package controllers

import javax.inject.{Inject, Singleton}

import controllers.base.BasedController
import facades.FruitingFacade
import forms.FruitingForm
import models.CreateFruiting
import views.{FruitingView, FruitingViews}

@Singleton
class FruitingController @Inject()(bcc: BasedControllerComponents
                                   , facade: FruitingFacade)
  extends BasedController(bcc) {

  def stamp = authenticated { request =>
    validate[FruitingForm](request) {
      FruitingView(facade.stamp(
        CreateFruiting(as[FruitingForm](request).get)
      ))
    }
  }

  def listBySensor(sensorId: String) = authenticated { request =>
    handling {
      FruitingViews(facade
        .listBySensor(sensorId)
        .map(m => FruitingView(m)))
    }
  }

}
