package com.softarea.tetris.menu.listeners;

import com.softarea.tetris.ApplicationContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FullScreenListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
    ApplicationContext.getInstance().getMainWindow().setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
}
