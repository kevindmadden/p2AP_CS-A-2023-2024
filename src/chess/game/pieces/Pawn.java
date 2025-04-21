package chess.game.pieces;

import chess.game.game.Board;
import chess.game.game.Player;
import chess.game.game.Point;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Pieces {

    public Pawn(Point currentPoint, Player player) {
        super(currentPoint, player);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Point> getMoves() {
        int x = currentPoint.getX(), y = currentPoint.getY();
        List<Point> availableMoves = new ArrayList<>();
        if (player.getPlayer().equals(Board.PLAYER_1)) {
            if (x > 0 && isEmpty(x - 1, y)) {
                doMove(new Point(x - 1, y));
                if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
                undoMove(Board.EMPTY);
                if (x == 6 && isEmpty(x - 2, y)) {
                    doMove(new Point(x - 2, y));
                    if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 2, y));
                    undoMove(Board.EMPTY);
                }
            }
            if (x > 0 && y < 7 && !isEmpty(x - 1, y + 1) && !player.getPlayer().equals(Board.board[x - 1][y + 1].substring(1))) {
                String piece = Board.board[x - 1][y + 1];
                doMove(new Point(x - 1, y + 1));
                if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 1));
                undoMove(piece);
            }
            if (y > 0 && x > 0 && !isEmpty(x - 1, y - 1) && !player.getPlayer().equals(Board.board[x - 1][y - 1].substring(1))) {
                String piece = Board.board[x - 1][y - 1];
                doMove(new Point(x - 1, y - 1));
                if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 1));
                undoMove(piece);
            }
        }

        if (player.getPlayer().equals(Board.PLAYER_2)) {
            if (x < 7 && isEmpty(x + 1, y)) {
                doMove(new Point(x + 1, y));
                if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
                undoMove(Board.EMPTY);
                if (x == 1 && isEmpty(x + 2, y)) {
                    doMove(new Point(x + 2, y));
                    if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 2, y));
                    undoMove(Board.EMPTY);
                }
            }
            if (x < 7 && y < 7 && !isEmpty(x + 1, y + 1) && !player.getPlayer().equals(Board.board[x + 1][y + 1].substring(1))) {
                String piece = Board.board[x + 1][y + 1];
                doMove(new Point(x + 1, y + 1));
                if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 1));
                undoMove(piece);
            }
            if (x < 7 && y > 0 && !isEmpty(x + 1, y - 1) && !player.getPlayer().equals(Board.board[x + 1][y - 1].substring(1))) {
                String piece = Board.board[x + 1][y - 1];
                doMove(new Point(x + 1, y - 1));
                if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 1));
                undoMove(piece);
            }
        }
        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return Board.PAWN;
    }
}