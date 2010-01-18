package eu.interedition.collatex.experimental.ngrams;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import eu.interedition.collatex.input.builders.WitnessBuilder;

public class NGramBasedAlgorithmTest {

  @Test
  public void testNgrams() {
    // "The black cat", "The black and white cat"
    final WitnessBuilder builder = new WitnessBuilder();
    final List<Subsegment2> ngrams = BiGrams.calculate(builder.build("The black cat"));
    Assert.assertEquals(4, ngrams.size());
    Assert.assertEquals("# the", ngrams.get(0).getNormalized());
    Assert.assertEquals("the black", ngrams.get(1).getNormalized());
    Assert.assertEquals("black cat", ngrams.get(2).getNormalized());
    Assert.assertEquals("cat #", ngrams.get(3).getNormalized());
  }
}
