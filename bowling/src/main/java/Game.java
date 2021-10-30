public class Game {

  private int score=0;
  private int[] rolls = new int[21];
  private int currentRoll = 0;

  public void roll(int pins){
    rolls[currentRoll++] = pins;
  }

  public int getScore() {
    int score = 0;
    int firstFrame = 0;
    for(int frame = 0; frame < 10; frame++){
      if(isSpare(firstFrame)) {
        score += 10 + nextBallForSpare(firstFrame);
        firstFrame+=2;
      }else if(isStrike(rolls[firstFrame])){
        score += 10 + nextBallsForStrike(firstFrame);
        firstFrame+=1;
      }else{
        score += nextBallsForFrame(firstFrame);
        firstFrame+=2;
      }
    }
    return score;
  }

  private int nextBallsForFrame(int firstFrame) {
    return Game.this.getScore(firstFrame);
  }

  private int getScore(int firstFrame) {
    return rolls[firstFrame] + rolls[firstFrame + 1];
  }

  private int nextBallsForStrike(int firstFrame) {
    return rolls[firstFrame + 1] + rolls[firstFrame + 2];
  }

  private int nextBallForSpare(int firstFrame) {
    return rolls[firstFrame + 2];
  }

  private boolean isStrike(int roll) {
    return roll ==10;
  }

  private boolean isSpare(int firstFrame) {
    return rolls[firstFrame]+rolls[firstFrame + 1]==10;
  }
}
