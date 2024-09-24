package day1.study

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * introduce {
 *   name("강진경")
 *   company("현대자동차그룹")
 *   skills {
 *     soft("A passion for problem solving")
 *     soft("Good communication skills")
 *     hard("Kotlin")
 *   }
 *   languages {
 *     "Korean" level 5
 *     "English" level 3
 *   }
 * }
 */
class DslTest {

    @Test
    fun name() {
        val actual: Person = introduce {
            name("강진경")
        }

        actual.name shouldBe "강진경"
    }

    @Test
    fun company() {
        val actual: Person = introduce {
            name("강진경")
            company("현대자동차그룹")
        }

        actual.company shouldBe "현대자동차그룹"
    }

    @Test
    fun skills() {
        val actual: Person = introduce {
            name("강진경")
            company("현대자동차그룹")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
        }

        actual.skills shouldContain SoftSkill("A passion for problem solving")
    }

    @Test
    fun languages() {
        val actual: Person = introduce {
            name("강진경")
            company("현대자동차그룹")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
            languages {
                "Korean" level 5
                "English" level 3
            }
        }

        actual.languages shouldContain Pair("Korean", 5)
    }

    private fun introduce(block: PersonBuilder.() -> Unit): Person {
        return PersonBuilder().apply(block).build()
    }
}

class PersonBuilder(
    private var name: String = "",
    private var company: String? = null,
    private var skills: List<Skill> = listOf(),
    private var languages: List<Pair<String, Int>> = listOf()
) {
    fun name(name: String) {
        this.name = name
    }

    fun company(company: String) {
        this.company = company
    }

    fun skills(block: SkillsBuilder.() -> Unit) {
        skills = SkillsBuilder().apply(block).build()
    }

    fun languages(block: LanguagesBuilder.() -> Unit) {
        languages = LanguagesBuilder().apply(block).build()
    }

    fun build(): Person {
        return Person(name, company, skills, languages)
    }
}

class SkillsBuilder(
    private var skills: MutableList<Skill> = mutableListOf()
) {
    fun soft(soft: String) {
        skills.add(SoftSkill(soft))
    }

    fun hard(hard: String) {
        skills.add(SoftSkill(hard))
    }

    fun build(): List<Skill> {
        return skills.toList()
    }
}

class LanguagesBuilder(
    private var languages: MutableList<Pair<String, Int>> = mutableListOf()
) {

    infix fun String.level(level: Int) = Pair(this, level)

    fun build(): List<Pair<String, Int>> {
        return languages.toList()
    }
}

class Person(
    val name: String,
    val company: String?,
    val skills: List<Skill>,
    val languages: List<Pair<String, Int>>
)

interface Skill

data class SoftSkill(
    var name: String
) : Skill

data class HardSkill(
    var name: String
) : Skill