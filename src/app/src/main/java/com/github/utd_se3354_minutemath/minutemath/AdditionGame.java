package com.github.utd_se3354_minutemath.minutemath;

import java.util.LinkedList;

/**
 * Created by Alec on 3/14/2016.
 */
public class AdditionGame extends Game {


    AdditionGame(){
      super.setType(ADDITION);
    }


    public void setAdditionQuestions(){
        int i;
        LinkedList<Question> additionQuestions = new LinkedList<>();
        for(i = 0; i < super.getNumQuestions(); i++){
            additionQuestions.add(new Question(generateOperand(),generateOperand(),ADDITION));
        }
        super.setQuestions(additionQuestions);
    }

    int generateOperand(){
        return ((int) (100.0*Math.random()));
    }
}
