package com.andreas.projektarbete;

public class Project_Notes {

/* __****************PROJECT NOTES*********************__


        <-- GAME REQUIREMENTS/RULES -->

        Participants: (The Dealer, the User).

1. The Cards: gets shuffled before adding them to the players. The deck has 52 cards.

2. Betting: before the game starts, all player must bet a value, range: 2$ - 500$.

3. Distribute: one card to each player, the dealer gets the last one.

4. HIT or STAY: each player gets to choose one of two options: HIT = get a new card. STAY = pass.

5. Winning/loosing - the player that gets closest to the value 21, but not over, wins.
If both the dealer and user gets 21, no one wins and no bet is lost.

6. Rounds: after someone wins/loses/tie, the cards gets shuffled again.

7. If the player does not have any currency left, the player loses by default.


    <-- PROJECT LOGIC -->

1. Player enters his/her NAME.
    - Scanner + Run a loop to check the condition is met. Switch.

2. All players must BET.
    2$ - 500$. - Total SUM - Bet Sum. Current SUM. Use double.

3. The DECK gets shuffled.
    Math Random Method.

4. The Dealer distribute 1 card to each player. 52 -
    Subtract 2 cards each time the cards gets distributed. One for the dealer and one for the User.

5. The player can choose HIT/STAY.
    if/else.

6. Check the values. Who gets closest to 21.
    IF/Else compare. If the Value is over 21 the round is over.

        ***Classes***

    SuperClass: participants.
        Fields:
            {name, currency, wins, loses}

    SubClasses.
        -Dealer-
         Unique fields:
            Methods:
            check users name, Shuffle/ReShuffle cards, distribute cards, check who won/lost
                Dealer Subclasses - Deck, Card
        -User-
          Unique fields: -
          Methods:
          HIT/STAY, end game.

          ***Outside Methods***
           None



    <-- RATING CRITERIA -->

G:
    1. All the requirements for the game, 1-7 is completed. The User must write his/hers name at the beginning.
    2. Produce a UML - Diagram. Minimum: 1 Class, 1 Instance or Inheritance.

VG:
    A. An ACE can be counted as both 1 and 11. If the total SUM > 21. Then the ACE counts as 1, ELSE 11.
    B. All Classes should be encapsulated. (USE Getters and Setters).
    C. If the player gets 10 + ACE, the Dealer gives 1.5 of the total SUM.
    D. The player will be able the finish the game at any time by pressing: '0'.
    E. The application does not crash. It has been Debugged.

 */
}
