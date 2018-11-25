package com.company;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public  class Polynomial
{

    Map<Integer,Term> terms;

    public Polynomial() {
        this.terms = new TreeMap<Integer,Term>();
    }

    public Polynomial(Collection<Term> list) {
        this();
        for (Term term : list) this.add((Term)term.clone());
    }

    public Polynomial add(Term other) {
        Term term = terms.get(other.power);
        terms.put(other.power,(term == null) ? other : term.add(other));
        return this;
    }

    public Polynomial add(int coefficient, int power) {
        add(new Term(coefficient,power));
        return this;
    }

    public Polynomial add(Polynomial other) {
        Polynomial poly = new Polynomial(getTerms());
        for (Term term : other.getTerms()) poly.add(term);
        return poly;
    }

    public void plus(Polynomial other) {
        for (Term term : other.getTerms()) this.add(term);
    }

    public Polynomial multiply(Polynomial other) {
        Polynomial poly = new Polynomial();
        for (Term first : this.getTerms()) {
            Polynomial current = new Polynomial();
            for (Term second : other.getTerms()) {
                Term product = new Term(first.coefficient*second.coefficient,first.power+second.power);
                current.add(product);
            }
            poly.plus(current);
        }
        return poly;
    }

    public String toString() {
        StringBuffer display = new StringBuffer();
        int count = 0;
        for (Term term : getTerms()) {
            display.append(term.toString());
            if (count<terms.size()-1) display.append('+');
            count++;
        }
        return display.toString();
    }

    public Collection<Term> getTerms() {
        return this.terms.values();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Polynomial)) return false;
        Polynomial other = (Polynomial) o;
        return this.terms.equals(other.terms);
    }

}