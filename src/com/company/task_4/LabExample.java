package com.company.task_4;

import javax.swing.*;
import java.awt.*;

class LabExample extends JFrame {
  private int milanGoals = 0;
  private int realGoals = 0;

  JButton btnMilan = new JButton("Milan");
  JButton btnReal = new JButton("Real");
  JLabel resultTxt = new JLabel("");
  JLabel lastScorer = new JLabel("");
  JLabel winner = new JLabel("");
  Font font = new Font("Times New Roman", Font.BOLD, 30);


  public void setWinner() {
    String winnerTeam = milanGoals > realGoals
        ? "Milan"
        : milanGoals == realGoals
          ? "DRAW"
          : "Real";
    winner.setText("Winner: " + winnerTeam);
  }

  public void setResultText() {
    String text = "Result: " + milanGoals + " X " + realGoals;
    resultTxt.setText(text);
  }

  public void setLastScorer(String scorer) {
    String text = "Last scorer: " + scorer;
    lastScorer.setText(text);
  }

  public void updateInfo(String scorer) {
    setLastScorer(scorer);
    setResultText();
    setWinner();
  }

  public void addRealGoal() {
    this.realGoals += 1;
  }
  public void addMilanGoal() {
    this.milanGoals += 1;
  }

  public void styleLabel(JLabel label) {
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setFont(font);
  }

  LabExample() {
    super("Milan VS Real");
    updateInfo("N/A");

    add(btnMilan);
    add(btnReal);
    btnMilan.setBounds(10, 155, 200, 50);
    btnReal.setBounds(490, 155, 200, 50);
    setLayout(new BorderLayout());
    setSize(700,400);

    add(resultTxt, BorderLayout.CENTER);
    styleLabel(resultTxt);

    add(lastScorer, BorderLayout.SOUTH);
    styleLabel(lastScorer);

    add(winner, BorderLayout.NORTH);
    styleLabel(winner);

    setVisible(true);
    btnReal.addActionListener((e) -> {
        addRealGoal();
        updateInfo("Real");
    });
    btnMilan.addActionListener((e) -> {
      addMilanGoal();
      updateInfo("Milan");
    });
  }
  public static void main(String[]args) {
    new LabExample();
  }
}
