package level1.homeWork8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;
    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.decode("#77DD77"));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clickBattleField(e);
            }
        });
    }

    private void clickBattleField(MouseEvent e) {
        if (Logic.status != Logic.STATUS_IN_GAME) {
            return;
        }
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        Logic.humanTurn(cellX, cellY);

        repaint();

        if (Logic.status != Logic.STATUS_IN_GAME) {
            String[] message = new String[2];
            String resultMsg = "";
            String title = "";
            switch (Logic.status) {
                case Logic.STATUS_HUMAN_WIN:
                    gameWindow.firstPlayerWinCount += 1;
                    resultMsg = "Ты выиграл!";
                    title = "Победа";
                    break;
                case Logic.STATUS_AI_WIN:
                    gameWindow.secondPlayerWinCount += 1;
                    resultMsg = "Ты проиграл!";
                    title = "Поражение";
                    break;
                case Logic.STATUS_TIE:
                    resultMsg = "Ничья!";
                    title = "Ничья";
                    break;
            }
            message[0] = resultMsg;
            message[1] = "Счет " + gameWindow.firstPlayerWinCount + ":" + gameWindow.secondPlayerWinCount;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }
    }

    private void drawX(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.RED);
        g.drawLine(cellWidth * x + (int) (0.1 * cellWidth),
            cellHeight * y + (int) (0.1 * cellHeight),
            cellWidth * (x + 1) - (int) (0.1 * cellWidth),
            cellHeight * (y + 1) - (int) (0.1 * cellHeight));
        g.drawLine(cellWidth * (x + 1) - (int) (0.1 * cellWidth),
            cellHeight * y + (int) (0.1 * cellHeight),
            cellWidth * x + (int) (0.1 * cellWidth),
            cellHeight * (y + 1) - (int) (0.1 * cellHeight));
        ((Graphics2D) g).setStroke(new BasicStroke(0));
    }

    private void drawO(Graphics g, int x, int y) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawOval(cellWidth * x + (int) (0.1 * cellWidth),
            cellHeight * y + (int) (0.1 * cellHeight),
            cellWidth - (int) (0.2 * cellWidth),
            cellHeight - (int) (0.2 * cellHeight));
        ((Graphics2D) g).setStroke(new BasicStroke(0));
    }
}
