import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class ActionClass implements KeyListener, ActionListener {

    JScrollPane scrollPane;
    JButton allTodo = new JButton("All Todo");
    JButton pendingTodo = new JButton("Pending");
    JButton completedTodo = new JButton("Completed");
    JTextField todoTextIn = new JTextField();
    JLabel placeTodoText = new JLabel();
    JPanel panel = new JPanel();
    ImageIcon oIcon;
    ImageIcon xIcon;
    ImageIcon checkIcon;

    ActionClass()
    {
        //----------------------------------------------------------------------------------------------------------VERTICAL SCROLL BAR JPANELS START
        // jpanel + vertical layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));// Vertical layout
        panel.setBackground(new Color(12,12,12));
        panel.setBorder(null);
        panel.setBounds(460,140,410,300);
        //panel.setBorder(BorderFactory.createLineBorder(new Color(100, 141, 244),1));
        panel.setVisible(false);

        // panel + scrollPanel
        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(460, 140, 410, 300);
        scrollPane.setVisible(false);

        //----------------------------------------------------------------------------------------------------------VERTICAL SCROLL BAR JPANELS END

        //----------------------------------------------------------------------------------------------------------TODOS FILTER START
        //all
        allTodo.setBounds(570, 90, 95, 35);
        allTodo.setFocusable(false);
        allTodo.setBackground(new Color(12, 12, 12));
        allTodo.setFont(new Font("Arial", Font.BOLD, 16));
        allTodo.setForeground(new Color(195,195,195));
        allTodo.setBorder(null);
        allTodo.addActionListener(this);

        //PENDING
        pendingTodo.setBounds(672, 90, 95, 35);
        pendingTodo.setFocusable(false);
        pendingTodo.setBackground(new Color(12, 12, 12));
        pendingTodo.setFont(new Font("Arial", Font.BOLD, 16));
        pendingTodo.setForeground(new Color(195,195,195));
        pendingTodo.addActionListener(this);
        pendingTodo.setBorder(null);

        //COMPLATED
        completedTodo.setBounds(775, 90, 95, 35);
        completedTodo.setFocusable(false);
        completedTodo.addActionListener(this);
        completedTodo.setBackground(new Color(12, 12, 12));
        completedTodo.setFont(new Font("Arial", Font.BOLD, 16));
        completedTodo.setForeground(new Color(195,195,195));
        completedTodo.setBorder(null);

        //----------------------------------------------------------------------------------------------------------TODOS FILTER END

        //----------------------------------------------------------------------------------------------------------TODOTEXT AND TEXT INPUT START

        //todoText in
        placeTodoText.setBounds(30,65,300,30);
        placeTodoText.setBackground(new Color(12, 12, 12));
        placeTodoText.setFont(new Font("Arial", Font.PLAIN, 14));
        placeTodoText.setText("Enter Todo:");
        placeTodoText.setForeground(Color.LIGHT_GRAY);

        //todoTextInput
        todoTextIn.setBounds(30,90,300,50);
        todoTextIn.setBackground(new Color(12, 12, 12));
        todoTextIn.addKeyListener(this);
        todoTextIn.setFont(new Font("Arial", Font.PLAIN, 20));
        todoTextIn.setForeground(new Color(195, 195, 195));
        todoTextIn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        //----------------------------------------------------------------------------------------------------------TODOTEXT AND TEXT INPUT END

    }

    //----------------------------------------------keyEVENTS START
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String todoText = todoTextIn.getText(); // Text from the input
            if (todoText.length() <= 24 && !todoText.isEmpty()) {

                // Define consistent size for the todo label
                int labelWidth = 300;
                int labelHeight = 30;

                // panel for each todo item
                JPanel todoPanel = new JPanel(null);
                todoPanel.setPreferredSize(new Dimension(labelWidth, labelHeight));
                todoPanel.setBackground(new Color(12, 12, 12));

                // create a new JLabel for each todo
                JLabel todoLabel = new JLabel( "**" + todoText);
                todoLabel.setForeground(Color.WHITE);
                todoLabel.setFont(new Font("Arial", Font.BOLD, 16));
                todoLabel.setBounds(10, 5, labelWidth, labelHeight); // Leave space for the button

                // remove todo button
                JCheckBox removeTodo = new JCheckBox();
                xIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/remove.png")));

                removeTodo.setBounds(labelWidth + 60, 5, 30, 23); // fixed position for remove chbox
                removeTodo.setFocusable(false);
                removeTodo.setBackground(new Color(12, 12, 12));
                removeTodo.setFont(new Font("Arial", Font.BOLD, 15));
                removeTodo.setForeground(new Color(250, 50, 97));
                removeTodo.setBorder(null);
                removeTodo.setIcon(xIcon);
                //lambda for remove todo
                removeTodo.addActionListener(ae1 -> {
                    panel.remove(todoPanel); // remove entire todo panel
                    panel.revalidate();
                    panel.repaint();
                });

                // CheckBox for todo status
                JCheckBox completedCheckBox = new JCheckBox();
                oIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/ou.png")));
                checkIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/xu.png")));

                completedCheckBox.setBounds(labelWidth + 40, 5, 20, 23); // Fixed position for compl chbox
                completedCheckBox.setFocusable(false);
                completedCheckBox.setBackground(new Color(12, 12, 12));
                completedCheckBox.setBorder(null);
                completedCheckBox.setIcon(oIcon);
                completedCheckBox.setSelectedIcon(checkIcon);
                //lambda for compl todo
                completedCheckBox.addItemListener(ae2 -> {
                    if (completedCheckBox.isSelected()) {
                        // as completed
                        todoLabel.setForeground(new Color(250,50, 97));
                    } else {
                        //  as pending
                        todoLabel.setForeground(Color.WHITE);
                    }
                });

                // add label button and checkbox to the todo panel
                todoPanel.add(todoLabel);
                todoPanel.add(removeTodo);
                todoPanel.add(completedCheckBox);

                // add todo panel to main panel
                panel.add(todoPanel);
                panel.revalidate();
                panel.repaint();

                //make todo visible
                panel.setVisible(true);
                scrollPane.setVisible(true);

                // reset the input
                todoTextIn.setText("");
                placeTodoText.setText("Enter todo:");
                placeTodoText.setForeground(Color.LIGHT_GRAY);
                todoTextIn.setForeground(new Color(195, 195, 195));
                todoTextIn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            } else {
                placeTodoText.setText("Enter todo: Wrong todo.");
                placeTodoText.setForeground(new Color(250,50, 97));
                todoTextIn.setForeground(new Color(250,50, 97));
                todoTextIn.setBorder(BorderFactory.createLineBorder(new Color(250,50, 97), 1));
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == allTodo)
        {

            for(Component component : panel.getComponents())
            {
                component.setVisible(true);
            }

            panel.setVisible(true);
            scrollPane.setVisible(true);
            // Repaint and revalidate the panel to reflect changes
            //panel.revalidate();
           // panel.repaint();
        }

        else if (e.getSource() == pendingTodo)
        {
            for (Component component : panel.getComponents()) {
                if (component instanceof JPanel todoPanel) {
                    boolean isPending = true;
                    for (Component child : todoPanel.getComponents()) {
                        if (child instanceof JCheckBox checkBox) {
                            // Determine if this todo is completed
                            if (checkBox.isSelected()) {
                                isPending = false; // If selected, it's completed
                                break;
                            }
                        }
                    }
                    // Set the visibility based on whether the todo is pending
                    todoPanel.setVisible(isPending);
                }
            }

            panel.setVisible(true);
            scrollPane.setVisible(true);
            // Repaint and revalidate the panel to reflect changes
            //panel.revalidate();
            //panel.repaint();
        }

        else if (e.getSource() == completedTodo)
        {
            for (Component component : panel.getComponents()) {
                if (component instanceof JPanel todoPanel) {
                    boolean isPending = false;
                    for (Component child : todoPanel.getComponents()) {
                        if (child instanceof JCheckBox checkBox) {
                            // Determine if this todo is completed
                            if (checkBox.isSelected()) {
                                isPending = true; // If selected, it's completed
                                break;
                            }
                        }
                    }
                    // Set the visibility based on whether the todo is pending
                    todoPanel.setVisible(isPending);
                }
            }

            panel.setVisible(true);
            scrollPane.setVisible(true);
            // Repaint and revalidate the panel to reflect changes
            //panel.revalidate();
            //panel.repaint();
        }
    }
    //----------------------------------------------keyEVENTS END
}