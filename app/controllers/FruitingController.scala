package controllers

import javax.inject.{Inject, Singleton}

import controllers.base.BasedController
import facades.FruitingFacade
import forms.FruitingForm
import models.CreateFruiting
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import views.FruitingView

@Singleton
class FruitingController @Inject()(cc: ControllerComponents
                                   , facade: FruitingFacade)
  extends BasedController(cc) {

  def stamp = Action { request: Request[AnyContent] =>
    validate[FruitingForm](request) {
      FruitingView(facade.stamp(
        CreateFruiting(as[FruitingForm](request).get)
      ))
    }
  }

}
