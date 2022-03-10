package com.shunya.overflow.Validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.shunya.overflow.Models.Question;

@Component
public class TagValidator {
	
    public boolean supports(Class<?> clazz) {
        return Question.class.equals(clazz);
    }
    
    
    public void validate(Object target, Errors errors) {
        Question question = (Question) target;
        
        String[] tags = question.getFrontEndTags().split(", ");
        if(tags.length > 3) {
        	errors.rejectValue("frontEndTags", "too Many", "Must have 3 tags or less");
        }
                
    }
}