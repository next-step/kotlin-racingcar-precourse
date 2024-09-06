package domain

import java.time.Instant

class CarName (
   private val name: String = "${Instant.now().toEpochMilli()}"
){
   init {
      when {
         name.isBlank() -> throw IllegalArgumentException("자동차 이름은 빈값일 수 없습니다.")
      }
   }

   val nameForPrint: String get() = name

   override fun equals(other: Any?): Boolean {
      if (this === other) return true
      if (other !is CarName) return false

      if (name != other.name) return false

      return true
   }

   override fun hashCode(): Int {
      return name.hashCode()
   }
}
