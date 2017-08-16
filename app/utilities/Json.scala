package utilities

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.databind.{DeserializationFeature, JsonNode, ObjectMapper, PropertyNamingStrategy}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

trait Json {

  import Json._

  def toText: String = mapper.writeValueAsString(this)

  def toJsonNode: JsonNode = mapper.readTree(this.toText)

}

object Json {

  private val mapper = new ObjectMapper with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.setSerializationInclusion(Include.NON_NULL)
  mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  def toJson(obj: AnyRef): String = mapper.writeValueAsString(obj)

  def toObject[T: Manifest](content: String): Option[T] = {
    if (content == null || content.isEmpty)
      None
    else
      Some(mapper.readValue[T](content))
  }

  implicit class AnySetter(any: AnyRef) {

    def toText: String = Json.toJson(any)

  }

  implicit class ListSetter(list: List[Any]) {

    def toText: String = Json.toJson(list)

  }

  implicit class MapSetter(map: Map[String, String]) {

    def toText: String = Json.toJson(map)

  }

}
