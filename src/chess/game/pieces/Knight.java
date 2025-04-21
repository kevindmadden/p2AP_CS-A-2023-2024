package chess.game.pieces;

import chess.game.game.Player;
import chess.game.game.Point;

import java.util.ArrayList;
import java.util.List;

import static chess.game.game.Board.*;

public class Knight extends Pieces {

    public Knight(Point currentPoint, Player player) {
        super(currentPoint, player);
    }

    @Override
    public List<Point> getMoves() {
        List<Point> availableMoves = new ArrayList<>();
        int x = currentPoint.getX(), y = currentPoint.getY();
        if (x < 7 && y < 6 && isEmpty(x + 1, y + 2)) {
            doMove(new Point(x + 1, y + 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 2));
            undoMove(EMPTY);
        }
        if (x > 0 && y < 6 && isEmpty(x - 1, y + 2)) {
            doMove(new Point(x - 1, y + 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 2));
            undoMove(EMPTY);
        }
        if (x < 6 && y > 0 && isEmpty(x + 2, y - 1)) {
            doMove(new Point(x + 2, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 2, y - 1));
            undoMove(EMPTY);
        }
        if (x < 6 && y < 7 && isEmpty(x + 2, y + 1)) {
            doMove(new Point(x + 2, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 2, y + 1));
            undoMove(EMPTY);
        }
        if (x < 7 && y > 1 && isEmpty(x + 1, y - 2)) {
            doMove(new Point(x + 1, y - 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 2));
            undoMove(EMPTY);
        }
        if (x > 0 && y > 1 && isEmpty(x - 1, y - 2)) {
            doMove(new Point(x - 1, y - 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 2));
            undoMove(EMPTY);
        }
        if (x > 1 && y > 0 && isEmpty(x - 2, y - 1)) {
            doMove(new Point(x - 2, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 2, y - 1));
            undoMove(EMPTY);
        }
        if (x > 1 && y < 7 && isEmpty(x - 2, y + 1)) {
            doMove(new Point(x - 2, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 2, y + 1));
            undoMove(EMPTY);
        }

        if (x < 7 && y < 6 && !isEmpty(x + 1, y + 2) && !player.getPlayer().equals(board[x + 1][y + 2].substring(1))) {
            String piece = board[x + 1][y + 2];
            doMove(new Point(x + 1, y + 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 2));
            undoMove(piece);
        }
        if (x > 0 && y < 6 && !isEmpty(x - 1, y + 2) && !player.getPlayer().equals(board[x - 1][y + 2].substring(1))) {
            String piece = board[x - 1][y + 2];
            doMove(new Point(x - 1, y + 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 2));
            undoMove(piece);
        }
        if (x < 6 && y > 0 && !isEmpty(x + 2, y - 1) && !player.getPlayer().equals(board[x + 2][y - 1].substring(1))) {
            String piece = board[x + 2][y - 1];
            doMove(new Point(x + 2, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 2, y - 1));
            undoMove(piece);
        }
        if (x < 6 && y < 7 && !isEmpty(x + 2, y + 1) && !player.getPlayer().equals(board[x + 2][y + 1].substring(1))) {
            String piece = board[x + 2][y + 1];
            doMove(new Point(x + 2, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 2, y + 1));
            undoMove(piece);
        }
        if (x < 7 && y > 1 && !isEmpty(x + 1, y - 2) && !player.getPlayer().equals(board[x + 1][y - 2].substring(1))) {
            String piece = board[x + 1][y - 2];
            doMove(new Point(x + 1, y - 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 2));
            undoMove(piece);
        }
        if (x > 0 && y > 1 && !isEmpty(x - 1, y - 2) && !player.getPlayer().equals(board[x - 1][y - 2].substring(1))) {
            String piece = board[x - 1][y - 2];
            doMove(new Point(x - 1, y - 2));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 2));
            undoMove(piece);
        }
        if (x > 1 && y > 0 && !isEmpty(x - 2, y - 1) && !player.getPlayer().equals(board[x - 2][y - 1].substring(1))) {
            String piece = board[x - 2][y - 1];
            doMove(new Point(x - 2, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 2, y - 1));
            undoMove(piece);
        }
        if (x > 1 && y < 7 && !isEmpty(x - 2, y + 1) && !player.getPlayer().equals(board[x - 2][y + 1].substring(1))) {
            String piece = board[x - 2][y + 1];
            doMove(new Point(x - 2, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 2, y + 1));
            undoMove(piece);
        }

        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return KNIGHT;
    }
}
