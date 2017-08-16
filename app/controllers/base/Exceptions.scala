package controllers.base

object Exceptions {

  lazy val NO_BODY = "request have no body."

  lazy val NOT_JSON = "body is not json format."

  lazy val INVALID_JSON = "json is not valid."

  lazy val CANNOT_MAKE_TRANSACTION = "cannot make transaction."
}
