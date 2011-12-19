package eu.interedition.collatex.implementation.input;

import com.google.common.collect.Lists;
import eu.interedition.collatex.AbstractTest;
import eu.interedition.collatex.IWitness;
import eu.interedition.collatex.Token;
import eu.interedition.collatex.input.SimpleToken;
import eu.interedition.collatex.input.Witness;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class WitnessTest extends AbstractTest {

  @Test
  public void isNear() {
    final Token token1 = mock(Token.class);
    final Token token2 = mock(Token.class);
    final Token token3 = mock(Token.class);

    final Witness w = new Witness("id");
    w.setTokens(Lists.newArrayList(token1, token2, token3));
    assertTrue(w.isNear(token1, token2));
    assertTrue(w.isNear(SimpleToken.START, token1));
  }

  @Test
  public void isNear2() {
    final IWitness witness = createWitnesses("a b c d e f g h i j k l")[0];
    final Iterator<Token> iterator = witness.getTokens().iterator();
    final Token a = iterator.next();
    final Token b = iterator.next();
    final Token c = iterator.next();
    final Token d = iterator.next();

    assertTrue(witness.isNear(a, b));
    assertFalse(witness.isNear(a, c));
    assertFalse(witness.isNear(b, d));
    assertTrue(witness.isNear(c, d));
  }

}
