/*
 *  Copyright (C) 2023 Adriann Paranhos - IFSP/SCL and Emanuel José da Silva - IFSP/SCL
 *  Contact: adriann <dot> paranhos <at> aluno <dot> ifsp <dot> edu <dot> br
 *  Contact: emanuel <dot> silva <at> aluno <dot> ifsp <dot> edu <dot> br
 *
 *  This file is part of CTruco (Truco game for didactic purpose).
 *
 *  CTruco is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  CTruco is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with CTruco.  If not, see <https://www.gnu.org/licenses/>
 */

package com.adriann.emanuel.armageddon;

import com.bueno.spi.model.GameIntel;
import com.bueno.spi.model.TrucoCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.bueno.spi.model.CardRank.*;
import static com.bueno.spi.model.CardSuit.*;

import static org.assertj.core.api.Assertions.*;

public class ArmageddonTest {

    private Armageddon armageddon;
    private GameIntel.StepBuilder intel;

    private GameIntel.StepBuilder maoDeOnze(List<TrucoCard> botCards, TrucoCard vira){
        return GameIntel.StepBuilder.with().gameInfo(List.of(),List.of(),vira,1)
                .botInfo(botCards,11).opponentScore(0);
    }

    @BeforeEach
    void setUp(){
        armageddon = new Armageddon();
    }

    @Nested
    @DisplayName("Tests to implement mao de onze logic")
    class MaoDeOnzeTest{
        @Test
        @DisplayName("Should refuse mao de onze when the hand is weak")
        void shouldRefuseMaoDeONzeHandWeak(){
            TrucoCard vira = TrucoCard.of(KING,DIAMONDS);
            List<TrucoCard> cards = List.of(
                    TrucoCard.of(FOUR,DIAMONDS),
                    TrucoCard.of(FIVE,HEARTS),
                    TrucoCard.of(SIX,SPADES)
            );
            intel = maoDeOnze(cards,vira);

            assertThat(armageddon.getMaoDeOnzeResponse(intel.build())).isFalse();
        }
    }
}
