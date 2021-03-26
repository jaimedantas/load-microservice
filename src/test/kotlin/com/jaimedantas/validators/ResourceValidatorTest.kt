package com.jaimedantas.validators

import br.com.fluentvalidator.Validator
import br.com.fluentvalidator.context.ValidationResult
import com.jaimedantas.model.Resource
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*

@MicronautTest
internal class ResourceValidatorTest{

    @Test
    internal fun shouldValidadeIdAsInvalidUUID() {
        val validator: Validator<Resource> = ResourceValidator()
        val resource: Resource = Resource("invalidId")

        val result: ValidationResult = validator.validate(resource)

        assertFalse(result.isValid())
        assertFalse(result.getErrors().isEmpty());

    }

    @Test
    internal fun shouldValidateIdAsValidUUID() {
        val validator: Validator<Resource> = ResourceValidator()
        val resource = Resource(UUID.randomUUID().toString())

        val result: ValidationResult = validator.validate(resource)

        assertTrue(result.isValid())
        assertTrue(result.getErrors().isEmpty());

    }
}
