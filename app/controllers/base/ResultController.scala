package controllers.base

import controllers.BasedControllerComponents
import play.api.mvc.AbstractController
import utilities.Json

abstract class ResultController(bcc: BasedControllerComponents)
  extends AbstractController(bcc) {

  def success(json: Json) = Ok(json.toText) as APPLICATION_JSON

  def fail(error: String) = InternalServerError(error)

  def invalidInput(error: String) = BadRequest(error)

  private lazy val APPLICATION_JSON = "application/json"
}
