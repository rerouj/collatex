package eu.interedition.collatex2.interfaces;

import java.util.List;

public interface IAlignment {

  List<IMatch> getMatches();

  List<IMatch> getMatchesSortedForB();

  List<IGap> getGaps();

  List<ITransposition> getTranspositions();

}