package base

import entities.BasedEntity
import base.ExceptionMessages._

object Exceptions {

  class CannotCreateException(entity: BasedEntity)
    extends Exception(s"${CANNOT_CREATE} ${entity}")

}
