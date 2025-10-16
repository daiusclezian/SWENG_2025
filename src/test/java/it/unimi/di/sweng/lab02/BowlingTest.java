package it.unimi.di.sweng.lab02;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BowlingTest {
    private Game game;

    @BeforeEach
    void gameReset(){
        this.game = new Game();
    }

    private void sameRoll(final int pins, final int times){
        for (int i=0; i<times; i++) {
            game.roll(pins);
        }
    }

    @Test
    void gutterGame() {
        // Il test deve simulare una partita (20 lanci) in cui non viene colpito neanche un birillo.
        // il punteggio della partita sarà quindi 0
        sameRoll(0, 20);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    void allOnesGame() {
        // Il test deve simulare una partita (20 lanci) in cui in ogni lancio viene buttato giù
        // esattamente un birillo.
        // il punteggio della partita sarà quindi 20
        sameRoll(1, 20);
        assertThat(game.score()).isEqualTo(20);

    }
/*
    @Test
   void oneSpareGame() {
   // Il test deve simulare una partita (20 lanci) si fa uno spare
   // con i primi 2 lanci e il successivo colpisce 3 birilli.
  // Nei rimanenti lanci non prende nessun birillo
  // il punteggio della partita sarà quindi 16
        game.roll(5);
        game.roll(5);
        game.roll(3);
        sameRoll(0, 17);
        assertThat(game.score()).isEqualTo(16);
  }
/*
    @Test
   void notSpareGame() {
     // Il test deve simulare una partita in cui vengono colpiti 5 birilli due volte di seguito,
     // ma non all'interno del medesimo frame.
     // Questa condizione non deve essere riconosciuta come spare.
     // Es., roll(1), roll(5), roll(5), ecc., non è spare.
        game.roll(1);
        game.roll(5);
        game.roll(5);
        sameRoll(1, 17);
        assertThat(game.score()).isEqualTo(28);
  }
/*
    @Test
   void oneStrikeGame() {
     // Il test deve simulare una partita in cui avviene uno strike.
     // Es., lo score di: roll(10), roll(3), roll(4), roll(0), ..., roll(0), è 24.
        game.roll(10);
        game.roll(3);
        game.roll(4);
        sameRoll(0, 16);
        assertThat(game.score()).isEqualTo(24);
  }
/*
    @Test
   void notStrikeGame() {
     // Il test deve simulare una partita in cui vengono colpiti 10 birilli con il secondo tiro di un frame,
     // Questa condizione deve essere riconosciuta come spare e non come strike.
        // Es., lo score di: roll(0), roll(10), roll(3), roll(0), ..., roll(0), è 16. // non riconosce se strike o spare pk somma 0 in caso strike
        // Es., lo score di: roll(0), roll(10), roll(3), roll(1), ..., roll(0), è 16.
        game.roll(0);
        game.roll(10);
        game.roll(3);
        game.roll(1);
        sameRoll(0, 15);
        assertThat(game.score()).isEqualTo(17);
  }
/*
    @Test
   void lastFrameStrikeGame() {
     // Il test deve simulare una partita in cui avviene uno strike nell'ultimo frame.
     // In questo caso il giocatore completa il frame ed ha diritto ad un tiro aggiuntivo.
     // Es., lo score di: roll(0), ..., roll(0), roll(10), roll(3), roll(2), è 15.
        sameRoll(0, 18);
        game.roll(10);
        game.roll(3);
        game.roll(2);
        assertThat(game.score()).isEqualTo(15);
  }
/*
	@Test
   void perfectGame() {
     // Il test deve simulare una partita perfetta in cui avvengono 12 strike di seguito.
     // Es., lo score di: roll(10), ..., roll(10), è 300.
        sameRoll(10, 12);
        assertThat(game.score()).isEqualTo(300);
  }

  /*
    @Test
    void scoreOutOfBound() {
        sameRoll(1, 20);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            game.roll(1);
        }, "Partita invalida");

    }

   */
/**/
}
