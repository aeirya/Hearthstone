package com.bubble.hearthstone.ui.gui.panels;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.LoginEvent;
import com.bubble.hearthstone.ui.gui.components.CustomLabel;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends Panel {

    private final JFrame frame;
    private final CenterBox centerBox;
    private final GameManager manager;

    public LoginPanel(JFrame frame, GameManager manager) {
        this.frame = frame;
        this.manager = manager;
        pane.setPreferredSize(frame.getSize());
        pane.setBackground(new Color(20,50,45));
        centerBox = new CenterBox();
        pane.add(centerBox);
    }

    private class CenterBox extends JPanel {
        private static final long serialVersionUID = 1L;
        
        private final JTextField username;
        private final JPasswordField password;

        private CenterBox () {
            username = new JTextField();
            password = new JPasswordField();
            setComponentFont(username);
            setComponentFont(password);
            setup();
        }
        
        private void setup() {
            this.setBackground(pane.getBackground().brighter());
            this.setPreferredSize(
                new Dimension(frame.getWidth() * 1, frame.getHeight() * 2/3)
            );
            this.setLayout(new GridBagLayout());
            this.add(new LoginBox());
            this.setBorder(BorderFactory.createLineBorder(pane.getBackground().darker()));
        }

        private void setComponentFont(JComponent comp) {
            comp.setFont(
                new Font("SansSerif", Font.BOLD, 20)
            );
        }

        @SuppressWarnings("all")
        private void sendEvent(IGameEvent event) 
        {
            manager.handleEvent(event);
        }

        private class LoginBox extends JPanel {
            
            private static final long serialVersionUID = 1L;

            private final JButton login;
            private final JButton quit;
            private final CustomLabel lblUsername;
            private final CustomLabel lblPassword;
            
            private LoginBox() {
                lblUsername = new CustomLabel("username");
                lblPassword = new CustomLabel("password");
                login = new JButton("login");
                quit = new JButton("quit");
                this.setup();
                this.setFonts();
                this.setEvents();
            }

            private void setup() {
                this.setBackground(new Color(40,70,40).brighter());
                this.setLayout(new GridBagLayout());
                this.setBorder(BorderFactory.createLineBorder(new Color(100,130,130)));
                this.setPreferredSize(new Dimension(300,200));
                this.setColors();
                this.initiateComponents();
                this.setSizes();
                quit.setFocusable(false);
            }

            private void initiateComponents() {
                final CustomLabel label1 = new CustomLabel("LOGIN", this.getBackground().darker().darker(), Color.WHITE.darker());
                final CustomLabel label2 = new CustomLabel("Hearhstone ", this.getBackground().darker(), Color.WHITE.darker());
                setComponentFont(label1);
                setComponentFont(label2);

                final GridBagConstraints c = new GridBagConstraints();
                c.fill = GridBagConstraints.HORIZONTAL;
                
                c.weightx = 0.50;
                c.gridx = 0;
                c.gridy = 0;
                this.add(label1 , c);
                c.weightx = 1;
                c.gridx = 1;
                c.gridy = 0;
                this.add(label2 , c);
                
                c.weightx = 0.50;
                c.gridx = 0;
                c.gridy = 1;
                this.add(lblUsername, c);
                c.weightx = 0;
                c.gridx = 1;
                c.gridy = 1;
                this.add(username, c);
                c.weightx = 0.50;
                c.gridx = 0;
                c.gridy = 2;
                this.add(lblPassword, c);
                c.weightx = 0;
                c.gridx = 1;
                c.gridy = 2;
                this.add(password, c);
                c.weightx = 1;
                c.gridx = 1;
                c.gridy = 3;
                this.add(login, c);
                c.weightx = 0.5;
                c.gridx = 0;
                c.gridy = 3;
                this.add(quit, c);
            }

            private void setSizes() {
                // lblUsername.setPreferredSize(lblUsername.getSize());
                // lblPassword.setPreferredSize(lblPassword.getSize());
            }

            private void setColors() {
                final Color bg = this.getBackground();
                lblUsername.setBackground(bg.darker());
                lblPassword.setBackground(bg.darker());
            }

            private void setFonts() {
                setComponentFont(lblUsername);
                setComponentFont(lblPassword);
                setComponentFont(login);
                setComponentFont(quit);
            }
            
            private void setEvents() {
                login.addActionListener(
                    e -> {
                        final String user = username.getText();
                        final String pass = String.valueOf(password.getPassword());
                        sendEvent(
                            new LoginEvent(user, pass)
                        );
                    }
                );
            }
        }
    }
}