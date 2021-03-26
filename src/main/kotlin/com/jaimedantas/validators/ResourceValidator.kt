package com.jaimedantas.validators

import br.com.fluentvalidator.AbstractValidator
import br.com.fluentvalidator.predicate.ObjectPredicate.nullValue
import br.com.fluentvalidator.predicate.StringPredicate.stringMatches
import com.jaimedantas.model.Resource
import java.util.function.Predicate.not

class ResourceValidator() : AbstractValidator<Resource>() {

    val UUID_REGEX: String = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}"

    override fun rules() {

        ruleFor(Resource::id)
                .must(stringMatches(UUID_REGEX))
                .`when`(not(nullValue()))
                .withMessage("The Resource Id is not valid")
                .withFieldName("id")
                .critical();

    }

}
