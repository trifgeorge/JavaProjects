/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builderpattern;

/**
 *
 * @author G
 */
public class Pizza {

    private final boolean salam;
    private final boolean branza;
    private final int ciuperci;
    private final int sos;

    public static class PizzaBuilder {

        private boolean salam;
        private boolean branza;
        private int ciuperci;
        private int sos;

        public PizzaBuilder salam(boolean salam) {
            this.salam = salam;
            return this;
        }

        public PizzaBuilder branza(boolean branza) {
            this.branza = branza;
            return this;
        }

        public PizzaBuilder ciuperci(int ciuperci) {
            this.ciuperci = ciuperci;
            return this;
        }

        public PizzaBuilder sos(int sos) {
            this.sos = sos;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    private Pizza(PizzaBuilder builder) {

        this.salam = builder.salam;
        this.branza = builder.branza;
        this.ciuperci = builder.ciuperci;
        this.sos = builder.sos;

    }

    @Override
    public String toString() {
        return "Pizza{" + "salam=" + salam + ", branza=" + branza + ", ciuperci=" + ciuperci + ", sos=" + sos + '}';
    }

}
