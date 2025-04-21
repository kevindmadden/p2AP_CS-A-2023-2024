package chess.game.pieces;

import chess.game.game.Player;
import chess.game.game.Point;

import java.util.ArrayList;
import java.util.List;

import static chess.game.game.Board.*;


public class Rook extends Pieces {
    public boolean hasMoved;

    public Rook(Point currentPoint, Player player) {
        super(currentPoint, player);
        hasMoved=false;
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean getHasMoved() {
        return hasMoved;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Point> getMoves() {
        int x = currentPoint.getX(), y = currentPoint.getY();
        List<Point> availableMoves = new ArrayList<>();
        while (x < 7 && isEmpty(x + 1, y)) {
            doMove(new Point(x + 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
            undoMove(EMPTY);
            x++;
        }

        if (x < 7 && !player.getPlayer().equals(board[x + 1][y].substring(1))) {
            String piece = board[x + 1][y];
            doMove(new Point(x + 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
            undoMove(piece);
        }

        x = currentPoint.getX();

        while (x > 0 && isEmpty(x - 1, y)) {
            doMove(new Point(x - 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
            undoMove(EMPTY);
            x--;
        }

        if (x > 0 && !player.getPlayer().equals(board[x - 1][y].substring(1))) {
            String piece = board[x - 1][y];
            doMove(new Point(x - 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
            undoMove(piece);
        }

        x = currentPoint.getX();

        while (y < 7 && isEmpty(x, y + 1)) {
            doMove(new Point(x, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y + 1));
            undoMove(EMPTY);
            y++;
        }

        if (y < 7 && !player.getPlayer().equals(board[x][y + 1].substring(1))) {
            String piece = board[x][y + 1];
            doMove(new Point(x, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y + 1));
            undoMove(piece);
        }

        y = currentPoint.getY();

        while (y > 0 && isEmpty(x, y - 1)) {
            doMove(new Point(x, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y - 1));
            undoMove(EMPTY);
            y--;
        }

        if (y > 0 && !player.getPlayer().equals(board[x][y - 1].substring(1))) {
            String piece = board[x][y - 1];
            doMove(new Point(x, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y - 1));
            undoMove(piece);
        }

        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return ROOK;
    }
}
