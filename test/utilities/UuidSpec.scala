package utilities

import bases.BasedSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class UuidSpec
  extends BasedSpec {

  "get" should {
    "return Uuid" in {
      val result = Uuid.get

      result.isInstanceOf[String]
    }
  }

}
