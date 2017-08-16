package controllers.base

import controllers.base.Exceptions.{CANNOT_MAKE_TRANSACTION, INVALID_JSON, NOT_JSON, NO_BODY}
import play.api.mvc.{AnyContent, ControllerComponents, Request}
import utilities.Json

abstract class BasedController(cc: ControllerComponents)
  extends ResultController(cc) {

  protected def form[Form: Manifest](request: Request[AnyContent])
                                    (action: => Boolean) = {
    request match {
      case _ if !request.hasBody => invalidInput(NO_BODY)
      case _ if request.body.asJson.isEmpty => invalidInput(NOT_JSON)
      case _ if as[Form](request).isEmpty => invalidInput(INVALID_JSON)
      case _ => errorHandling(action)
    }
  }

  protected def as[Object: Manifest](request: Request[AnyContent]): Option[Object] =
    Json.toObject[Object](request.body.asJson.get.toString)

  private def errorHandling(action: => Boolean) = {
    try {
      if (action) success
      else fail(CANNOT_MAKE_TRANSACTION)
    } catch {
      case t: Throwable => {
        t.printStackTrace
        fail(t.getMessage)
      }
    }
  }

}