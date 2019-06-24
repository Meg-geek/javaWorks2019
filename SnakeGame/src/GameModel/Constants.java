package GameModel;

public class Constants {
    public static final int CELLS_AMOUNT_IN_LINE = 40;
    public static final int CELL_HIGHT = 15;
    public static final int CELL_WIDTH = CELL_HIGHT;
    public static final int FIELD_HIGHT = CELL_HIGHT * CELLS_AMOUNT_IN_LINE;// + CELL_HIGHT*3;
    public static final int FIELD_WIDTH = FIELD_HIGHT;
    public static final int BEGIN_LENGTH = 3;
    public static final int INDENT = 5;
    public static final String GAME_NAME = "My Snake game";
    public static final int FRAME_WIDTH = FIELD_WIDTH + INDENT * CELL_WIDTH;
    public static final int FRAME_HIGHT = FRAME_WIDTH;
    public static final int BUTTON_WIDTH = CELL_WIDTH * 20;
    public static final int BUTTON_HIGHT = CELL_HIGHT * 6;
    public static final int SNAKEBODY_COLOR_RED = 0;
    public static final int SNAKEBODY_COLOR_GREEN = 100;
    public static final int SNAKEBODY_COLOR_BLUE = 0;
    public static final int BACKGROUND_COLOR_RED = 170;
    public static final int BACKGROUND_COLOR_GREEN = 223;
    public static final int BACKGROUND_COLOR_BLUE = 79;

    public static final int DIFFICULTY_EASY = 1000 / 8;
    public static final int DIFFICULTY_MEDIUM = 1000 / 16;
    public static final int DIFFICULTY_HARD = 1000 / 32;

    public static final int PANELS_FONT_SIZE = 40;

}
