package com.company;

public  class Term
        implements Cloneable
{
    int coefficient;
    int power;

    public Term(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        if (power == 0) {
            display.append(coefficient);
        }
        else if (power > 0) {
            if (coefficient != 1) display.append(coefficient);
            display.append('x');
            if (power > 1) display.append('^').append(power);
        }
        return display.toString();
    }

    public Term add(Term other) {
        if (this.power == other.power) this.coefficient += other.coefficient;
        return this;
    }

    protected Object clone() {
        Term term = new Term(this.coefficient,this.power);
        return term;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Term)) return false;
        Term other = (Term)o;
        return this.coefficient == other.coefficient && this.power == other.power;
    }
}