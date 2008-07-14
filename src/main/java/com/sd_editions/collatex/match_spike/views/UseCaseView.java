package com.sd_editions.collatex.match_spike.views;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sd_editions.collatex.Block.Block;
import com.sd_editions.collatex.Block.BlockStructure;
import com.sd_editions.collatex.Block.BlockStructureListIterator;
import com.sd_editions.collatex.Block.Util;
import com.sd_editions.collatex.Block.Word;
import com.sd_editions.collatex.match_spike.ColorMapper;
import com.sd_editions.collatex.match_spike.WordColorTuple;
import com.sd_editions.collatex.match_spike.WordMatchMap;

public class UseCaseView {

  private final WordMatchMap wordMatchMap;
  private final List<BlockStructure> witnessList;

  //  private final List<List<int[]>> matchMatrixList;

  public UseCaseView(String[] usecase) {
    witnessList = Lists.newArrayList();
    for (String witness : usecase) {
      witnessList.add(Util.string2BlockStructure(witness));
    }
    wordMatchMap = new WordMatchMap(witnessList);
    //    matchMatrixList = makeMatchMatrixList();
    fillWordMatrix();
  }

  //  public List<List<int[]>> makeMatchMatrixList() {
  //    List<List<int[]>> matrixList = Lists.newArrayList();
  //    List<int[]> matrix = Lists.newArrayList();
  //    int numberOfWitnessess = witnessList.size();
  //    for (int i = 0; i < numberOfWitnessess; i++) {
  //      //      vector[i] = ;
  //    }
  //    matrixList.add(matrix);
  //    return matrixList;
  //  }

  private void fillWordMatrix() {
    int cols = 0;
    for (BlockStructure blockStructure : witnessList) {
      cols = Math.max(cols, blockStructure.getNumberOfBlocks());
    }
    Util.p(cols);
    WordColorTuple[][] wcm = new WordColorTuple[witnessList.size()][cols];
    ColorMapper colorMap = new ColorMapper(wordMatchMap);

    for (int witness_index = 0; witness_index < witnessList.size(); witness_index++) {
      BlockStructure witness = witnessList.get(witness_index);
      Util.p(witness);
      BlockStructureListIterator<? extends Block> listIterator = witness.listIterator();
      listIterator.next(); // first blockstructure is always a sentence
      for (int word_index = 0; word_index < wcm.length; word_index++) {
        Util.p(word_index);
        if (listIterator.hasNext()) {
          wcm[witness_index][word_index] = null;
        } else {
          final Word next = (Word) listIterator.next();
          String word = (next).getContent();
          Util.p(word);
          String normalizedWord = word.toLowerCase();
          String color = "color" + colorMap.determineColor(normalizedWord, witness_index, word_index);
          wcm[witness_index][word_index] = new WordColorTuple(word, color);
        }
      }
    }
  }

  public String toHtml() {
    String html = "<ol type=\"A\">";
    int color = 1;
    HashMap<String, Integer> colorMap = Maps.newHashMap();
    for (BlockStructure witness : witnessList) {
      html += "<li>";
      BlockStructureListIterator<? extends Block> iterator = witness.listIterator();
      while (iterator.hasNext()) {
        Block block = iterator.next();
        if (block instanceof Word) {
          String word = ((Word) block).getContent();
          String normalizedWord = word.toLowerCase();
          if (!colorMap.containsKey(normalizedWord)) colorMap.put(normalizedWord, new Integer(color++));
          html += "<span class=\"color" + colorMap.get(normalizedWord) + "\">" + word + "</span> ";
        }
      }
      html += "</li>";
    }
    html += "</ol>";
    html += new WordMatchMapView(wordMatchMap).toHtml();
    return html;
  }

  public String toHtml2() {
    String html = "<ol type=\"A\">";
    int color = 1;
    HashMap<String, Integer> colorMap = Maps.newHashMap();
    int witnessIndex = 0;
    for (BlockStructure witness : witnessList) {
      html += "<li>";
      BlockStructureListIterator<? extends Block> iterator = witness.listIterator();
      while (iterator.hasNext()) {
        Block block = iterator.next();
        if (block instanceof Word) {
          String word = ((Word) block).getContent();
          String normalizedWord = word.toLowerCase();
          wordMatchMap.getExactMatchesForWitness(normalizedWord, witnessIndex);
          if (!colorMap.containsKey(normalizedWord)) colorMap.put(normalizedWord, new Integer(color++));
          html += "<span class=\"color" + colorMap.get(normalizedWord) + "\">" + word + "</span> ";
        }
      }
      html += "</li>";
      witnessIndex++;
    }
    html += "</ol>";
    html += new WordMatchMapView(wordMatchMap).toHtml();
    return html;
  }
}