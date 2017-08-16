package controllers

import play.api.mvc.{AbstractController, AnyContent, ControllerComponents, Request}
import utilities.Json

abstract class BasedController(cc: ControllerComponents)
  extends AbstractController(cc) {

  protected def form[Form: Manifest](request: Request[AnyContent])
                                    (action: => Json) = {
    request match {
      case _ if !request.hasBody => invalidInput(NO_BODY)
      case _ if request.body.asJson.isEmpty => invalidInput(NOT_JSON)
      case _ if as[Form](request).isEmpty => invalidInput(INVALID_JSON)
      case _ => success(action)
    }
  }

  protected def as[Object: Manifest](request: Request[AnyContent]): Option[Object] =
    Json.toObject[Object](request.body.asJson.get.toString)

  private def success(json: Json) = Ok(json.toText) as APPLICATION_JSON

  private def fail(error: String) = InternalServerError(error)

  private def invalidInput(error: String) = BadRequest(error)

  private lazy val APPLICATION_JSON = "application/json"

  private lazy val NO_BODY = "request have no body."

  private lazy val NOT_JSON = "body is not json format."

  private lazy val INVALID_JSON = "json is not valid."

}