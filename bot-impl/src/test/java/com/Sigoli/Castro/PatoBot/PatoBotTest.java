package com.Sigoli.Castro.PatoBot;
import com.bueno.spi.model.*;
import com.bueno.spi.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PatoBotTest {
    PatoBot patoBot;
    private GameIntel.StepBuilder stepBuilder;

@BeforeEach
public void createPatoBot(){
    patoBot = new PatoBot();
}
    @Test
    @DisplayName("Should return true id opponent is first to play")
    void shoulReturnTrueIfOpponentIsFirstToPlay() {

        TrucoCard opponentCard = TrucoCard.of(CardRank.FIVE, CardSuit.CLUBS);
        boolean opponentPlay = true;
        assertThat(patoBot
                .checkIfOpponentIsFirstToPlay(Optional.ofNullable(opponentCard)).equals(opponentPlay));
    }

   @Test
   @DisplayName("Should return false if opponent is not first to play")
    void shouldReturnFalseIfOpponentIsNotFirstToPlay(){

        boolean opponentPlay = false;
        assertThat(patoBot.checkIfOpponentIsFirstToPlay(Optional.empty()).equals(opponentPlay));
    }


}



