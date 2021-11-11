package main.java.algorithm.genetic_algorithm.dna;

/**
 * Interface created just in case a different crossover function is needed (polymorphism)
 */
public interface GeneticInheritanceProcessStrategy {
    DNA crossover(DNA parentA, DNA parentB);
}
