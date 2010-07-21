package eu.interedition.collatex2.experimental.graph.indexing;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.interedition.collatex2.experimental.graph.IVariantGraph;
import eu.interedition.collatex2.experimental.graph.VariantGraph2;
import eu.interedition.collatex2.implementation.CollateXEngine;
import eu.interedition.collatex2.interfaces.ITokenMatch;
import eu.interedition.collatex2.interfaces.IWitness;

public class VariantGraphIndexMatcherTest {
  private static CollateXEngine factory;

  @BeforeClass
  public static void setup() {
    factory = new CollateXEngine();
  }

  //NOTE: tests taken from IndexMatcherTest!
  @Test
  public void testEverythingIsUnique() {
    final IWitness witnessA = factory.createWitness("A", "everything is unique should be no problem");
    final IWitness witnessB = factory.createWitness("B", "everything is unique");
    IVariantGraph graph = VariantGraph2.create(witnessA);
    VariantGraphIndexMatcher matcher = new VariantGraphIndexMatcher(graph);
    List<ITokenMatch> matches2 = matcher.getMatches(witnessB);
    assertEquals(3, matches2.size());
    assertEquals("everything: 1 -> 1", matches2.get(0).toString());
    assertEquals("is: 2 -> 2", matches2.get(1).toString());
    assertEquals("unique: 3 -> 3", matches2.get(2).toString());
  }

}