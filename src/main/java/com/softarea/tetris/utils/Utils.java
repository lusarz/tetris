package com.softarea.tetris.utils;

public final class Utils {
    public static void copyBooleanArray(boolean[][] source, boolean[][] dest) {
        for (int i = 0; i < source.length; i++) {
            boolean[] destColumn = dest[i];
            boolean[] sourceColumn = source[i];
            for (int j = 0; j < sourceColumn.length; j++) {
                destColumn[j] = sourceColumn[j];
            }
        }
    }
}
