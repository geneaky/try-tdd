import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {


  private static Game game;
  private int frames;
  private int pins;

  @BeforeEach
  public void setUp(){
    game = new Game();
  }

  @Test
  @DisplayName("공 굴리기 동작")
  public void canRoll() throws Exception{

    game.roll(0);
  }

  private void rollMany(int frames, int pins) {
    for (int i = 0; i < frames; i++) {
      game.roll(pins);
    }
  }

  private void rollSpare() {
    game.roll(5);
    game.roll(5);
  }

  private void rollStrike() {
    game.roll(10);
  }

  @Test
  @DisplayName("gutterGame")
  public void gutterGame() throws Exception{
    rollMany(20, 0);

    assertEquals(0,game.getScore());
  }

  @Test
  @DisplayName("allOnes")
  public void allOnes() throws Exception{
    rollMany(20, 1);

    assertEquals(game.getScore(),20);
  }

  @Test
  @DisplayName("oneSpare")
  public void oneSpare() throws Exception{

    rollSpare();
    game.roll(3);
    rollMany(17,0);
    assertEquals(game.getScore(),16);
  }

  @Test
  @DisplayName("oneStrike")
  public void oneStrike() throws Exception{

    rollStrike();
    game.roll(5);
    game.roll(3);
    rollMany(16,0);
    assertEquals(game.getScore(),26);
  }

  @Test
  @DisplayName("perfectGame")
  public void perfectGame() throws Exception{
    rollMany(10,10);
    game.roll(10);
    game.roll(10);
    assertEquals(game.getScore(),300);
  }

}
