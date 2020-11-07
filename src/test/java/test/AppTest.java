package test;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.trevorwhitney.minesweeper.App;
import org.junit.jupiter.api.Test;

class AppTest {

  @Test
  void appHasAGreeting() {
    App classUnderTest = new App();
    assertThat(classUnderTest.buildBoard()).isNotNull();
  }
}
