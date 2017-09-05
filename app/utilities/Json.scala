package utilities

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.core.{JsonGenerator, JsonParser}
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.databind._
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

trait Json {

  import Json._

  def toText: String = mapper.writeValueAsString(this)

  def toJsonNode: JsonNode = mapper.readTree(this.toText)

}

object Json {

  private val mapper = new ObjectMapper with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.registerModule(JodaJacksonModule)
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

object JodaJacksonModule
  extends SimpleModule {

  private val format = "yyyy-MM-dd HH:mm:ss"
  private val dtf = DateTimeFormat.forPattern(format)

  addDeserializer(classOf[DateTime], new JsonDeserializer[DateTime] {
    override def deserialize(parser: JsonParser
                             , context: DeserializationContext): DateTime = {
      dtf.parseDateTime(parser.getText)
    }
  })

  addSerializer(classOf[DateTime], new JsonSerializer[DateTime] {
    override def serialize(value: DateTime
                           , generator: JsonGenerator
                           , serializers: SerializerProvider): Unit = {
      generator.writeString(dtf.print(value))
    }
  })
}

