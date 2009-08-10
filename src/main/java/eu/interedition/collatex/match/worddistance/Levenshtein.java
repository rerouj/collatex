package eu.interedition.collatex.match.worddistance;

import org.apache.commons.lang.StringUtils;

public class Levenshtein implements WordDistance {

  @Override
  public float distance(String word1, String word2) {
    return StringUtils.getLevenshteinDistance(word1.toLowerCase(), word2.toLowerCase());
  }
}