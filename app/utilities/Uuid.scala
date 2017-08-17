package utilities

import java.util.UUID

object Uuid {

  def get = UUID.randomUUID.toString
}
