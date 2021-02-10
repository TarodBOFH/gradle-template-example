package org.tarodbofh.example

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@DisplayName("Hotel Data Health Test")
internal class ExampleAppTest(@Autowired private val restTemplate: TestRestTemplate) {

    @Test
    fun `spring context boots`() {
    }

    @Test
    fun `status endpoint works`() {
        val result = restTemplate.getForEntity<String>("/actuator/info")
        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
    }
}
