import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class ActionClass implements KeyListener, ActionListener {

    int i = 1;
    JScrollPane scrollPane;
    JButton allTodo = new JButton("All Todo");
    JButton pendingTodo = new JButton("Pending");
    JButton completedTodo = new JButton("Complete");
    //text field
    JTextField todoTextIn = new JTextField();
    JLabel placeTodoText = new JLabel();
    JPanel panel = new JPanel();
    JLabel todoLS = new JLabel();
    ImageIcon oIcon;
    ImageIcon xIcon;
    ImageIcon checkIcon;


    ActionClass()
    {
        //----------------------------------------------------------------------------------------------------------VERTICAL SCROLL BAR JPANELS START
        // Create a JPanel with a vertical layout and a large preferred size
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));// Vertical layout
        panel.setBackground(new Color(12,12,12));
        panel.setBorder(null);
        panel.setBounds(460,90,410,300);
        //panel.setBorder(BorderFactory.createLineBorder(new Color(100, 141, 244),1));
        panel.setVisible(false);

        // Wrap the JPanel in a JScrollPane
        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(460, 90, 410, 300);
        scrollPane.setVisible(false);

        //imageLS
        ImageIcon imageIcon1 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/todoLs.bmp")));
        // Scale the image to the desired size
        Image image = imageIcon1.getImage().getScaledInstance(220, 200, Image.SCALE_SMOOTH);
        todoLS = new JLabel();
        //makeing cp image sizes
        todoLS.setIcon(new ImageIcon(image));
        todoLS.setBounds(508, 85, 220, 200);
        todoLS.setVisible(true);

        //----------------------------------------------------------------------------------------------------------VERTICAL SCROLL BAR JPANELS END

        //----------------------------------------------------------------------------------------------------------TODOS FILTER START
        //all
        allTodo.setBounds(460, 400, 95, 35);
        allTodo.setFocusable(false);
        allTodo.setBackground(new Color(12, 12, 12));
        allTodo.setFont(new Font("Arial", Font.BOLD, 16));
        allTodo.setForeground(new Color(250,50, 97));
        allTodo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        allTodo.addActionListener(this);

        //PENDING
        pendingTodo.setBounds(572, 400, 95, 35);
        pendingTodo.setFocusable(false);
        pendingTodo.setBackground(new Color(12, 12, 12));
        pendingTodo.setFont(new Font("Arial", Font.BOLD, 16));
        pendingTodo.setForeground(new Color(250,50, 97));
        pendingTodo.addActionListener(this);
        pendingTodo.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));

        //COMPLATED
        completedTodo.setBounds(682, 400, 95, 35);
        completedTodo.setFocusable(false);
        completedTodo.addActionListener(this);
        completedTodo.setBackground(new Color(12, 12, 12));
        completedTodo.setFont(new Font("Arial", Font.BOLD, 16));
        completedTodo.setForeground(new Color(250,50, 97));
        completedTodo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));

        //----------------------------------------------------------------------------------------------------------TODOS FILTER END

        //----------------------------------------------------------------------------------------------------------TODOTEXT AND TEXT INPUT START

        //todoText in
        placeTodoText.setBounds(30,65,300,30);
        placeTodoText.setBackground(new Color(12, 12, 12));
        placeTodoText.setFont(new Font("Arial", Font.PLAIN, 14));
        placeTodoText.setText("Enter todo:");
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

                // Panel for each todo item
                JPanel todoPanel = new JPanel(null);
                todoPanel.setPreferredSize(new Dimension(labelWidth, labelHeight));
                todoPanel.setBackground(new Color(12, 12, 12));

                // Create a new JLabel instance for each todo
                JLabel todoLabel = new JLabel("T." + todoText);
                todoLabel.setForeground(Color.WHITE);
                todoLabel.setFont(new Font("Arial", Font.BOLD, 16));
                todoLabel.setBounds(10, 5, labelWidth, labelHeight); // Leave space for the button

                // Remove todo button
                JCheckBox removeTodo = new JCheckBox();
                xIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/remove.png")));

                removeTodo.setBounds(labelWidth + 60, 5, 30, 23); // Fixed position on the right
                removeTodo.setFocusable(false);
                removeTodo.setBackground(new Color(12, 12, 12));
                removeTodo.setFont(new Font("Arial", Font.BOLD, 15));
                removeTodo.setForeground(new Color(250, 50, 97));
                removeTodo.setBorder(null);
                removeTodo.setIcon(xIcon);
                removeTodo.addActionListener(e1 -> {
                    panel.remove(todoPanel); // Remove the entire todo panel
                    panel.revalidate();
                    panel.repaint();
                });

                // CheckBox for todo status
                JCheckBox completedCheckBox = new JCheckBox();
                oIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/ou.png")));
                checkIcon = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/xu.png")));

                completedCheckBox.setBounds(labelWidth + 40, 5, 20, 23); // Fixed position on the right
                completedCheckBox.setFocusable(false);
                completedCheckBox.setBackground(new Color(12, 12, 12));
                completedCheckBox.setBorder(null);
                completedCheckBox.setIcon(oIcon);
                completedCheckBox.setSelectedIcon(checkIcon);
                completedCheckBox.addItemListener(e1 -> {
                    if (completedCheckBox.isSelected()) {
                        // Mark as completed
                        todoLabel.setForeground(new Color(250,50, 97)); // Change color to indicate completion
                    } else {
                        // Mark as pending
                        todoLabel.setForeground(Color.WHITE); // Change color back to pending style
                    }
                });

                // Add label, button, and checkbox to the todo panel
                todoPanel.add(todoLabel);
                todoPanel.add(removeTodo);
                todoPanel.add(completedCheckBox);

                // Add the todo panel to the main panel
                panel.add(todoPanel);
                panel.revalidate();
                panel.repaint();

                //open todoBox

                for (Component component : panel.getComponents()) {
                    component.setVisible(true);
                }

                panel.setVisible(true);
                scrollPane.setVisible(true);
                todoLS.setVisible(false);

                // Reset the input field
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
            // Show all todos
            for (Component component : panel.getComponents()) {
                component.setVisible(true);
            }

            panel.setVisible(true);
            scrollPane.setVisible(true);
            todoLS.setVisible(false);
            // Repaint and revalidate the panel to reflect changes
            panel.revalidate();
            panel.repaint();
        }

        else if(e.getSource() == pendingTodo)
        {
            // Show all todos
            for (Component component : panel.getComponents()) {
                component.setVisible(true);
            }

            panel.setVisible(true);
            scrollPane.setVisible(true);
            todoLS.setVisible(false);
            // Repaint and revalidate the panel to reflect changes
            panel.revalidate();
            panel.repaint();
        }

        else if(e.getSource() == completedTodo)
        {
            // Show all todos
            for (Component component : panel.getComponents()) {
                component.setVisible(true);
            }

            panel.setVisible(true);
            scrollPane.setVisible(true);
            todoLS.setVisible(false);
            // Repaint and revalidate the panel to reflect changes
            panel.revalidate();
            panel.repaint();
        }



    }
    //----------------------------------------------keyEVENTS END
}