package controllers

import javax.inject.{Inject, Singleton}

import controllers.base.BasedController
import facades.FruitingFacade
import forms.FruitingForm
import models.CreateFruiting
import views.FruitingView

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

}
