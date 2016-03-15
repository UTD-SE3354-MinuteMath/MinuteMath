package com.github.utd_se3354_minutemath.minutemath;

/**
 * Created by Alec on 3/5/2016.
 */
public class Question {
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int MULTIPLICATION = 3;
    static final int DIVISION = 4;

    private int operator_1;
    private int operator_2;
    private int operand;
    private int answer;

    Question(int operator_1, int operator_2, int operand){
        this.operator_1 = operator_1;
        this.operator_2 = operator_2;
        this.operand = operand;
        this.answer = calcuateAnswer(operator_1,operator_2,operand);
    }

    int calcuateAnswer(int operator_1, int operator_2, int operand){
        switch(operand){
            case(ADDITION):
                return operator_1+operator_2;
            case(SUBTRACTION):
                return operator_1-operator_2;
            case(MULTIPLICATION):
                return operator_1*operator_2;
            case(DIVISION):
                return operator_1/operator_2;
        }
        return 0;
    }

}
