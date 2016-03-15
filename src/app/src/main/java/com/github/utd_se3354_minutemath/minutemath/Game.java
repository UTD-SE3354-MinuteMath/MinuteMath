package com.github.utd_se3354_minutemath.minutemath;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Alec on 3/14/2016.
 */
public abstract class Game implements Serializable{
    static final int ADDITION = 1;
    static final int SUBTRACTION = 2;
    static final int MULTIPLICATION = 3;
    static final int DIVISION = 4;

    private int type;
    private int numQuestions;
    private int duration;
    private boolean timed;
    private LinkedList<Question> questions= new LinkedList<Question>();

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTimed(boolean timed) {
        this.timed = timed;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public boolean getTimed(){
        return this.timed;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setQuestions(LinkedList<Question> questions) {
        this.questions = questions;
    }
}

