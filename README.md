Chess

by Afthab
--------------------------------------------------------------------------
Implement an object oriented program to track and validate a chess game.

The intended moves by the players are provided as input one move at a time. The program should validate the syntax, the correctness of the input and apply them, at each step the current state of the chess board should be output.

The rules of chess are well known. The program should accept moves in the move notation. The output of the game should be in FEN. A good illustration of FEN can be found at this link. The program is expected to validate checks, but not checkmates.

Here is some sample output/input for the program

rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
input e4:
rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR b KQkq e3 0 1
input c5:
rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2
