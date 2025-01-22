import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

    ActionClass()
    {
        //----------------------------------------------------------------------------------------------------------VERTICAL SCROLL BAR JPANELS START
        // Create a JPanel with a vertical layout and a large preferred size
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));// Vertical layout
        panel.setBackground(new Color(12,12,12));
        panel.setBorder(null);
        panel.setBounds(468,90,400,300);
        //panel.setBorder(BorderFactory.createLineBorder(new Color(100, 141, 244),1));

        // Wrap the JPanel in a JScrollPane
        scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(468, 90, 400, 300);

        //----------------------------------------------------------------------------------------------------------VERTICAL SCROLL BAR JPANELS END

        //----------------------------------------------------------------------------------------------------------TODOS FILTER START
        //all
        allTodo.setBounds(468, 400, 95, 35);
        allTodo.setFocusable(false);
        allTodo.setBackground(new Color(12, 12, 12));
        allTodo.setFont(new Font("Arial", Font.BOLD, 16));
        allTodo.setForeground(new Color(250,50, 97));
        allTodo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,1));
        allTodo.addActionListener(this);

        //PENDING
        pendingTodo.setBounds(580, 400, 95, 35);
        pendingTodo.setFocusable(false);
        pendingTodo.setBackground(new Color(12, 12, 12));
        pendingTodo.setFont(new Font("Arial", Font.BOLD, 16));
        pendingTodo.setForeground(new Color(250,50, 97));
        pendingTodo.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));

        //COMPLATED
        completedTodo.setBounds(690, 400, 95, 35);
        completedTodo.setFocusable(false);
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
            String todoText = todoTextIn.getText(); // Get the text from the input
            if (todoText.length() <= 30 && !todoText.isEmpty()) {

                // Define consistent size for the todo label
                int labelWidth = 300;
                int labelHeight = 30;

                // Panel for each todo item
                JPanel todoPanel = new JPanel(null); // Null layout for precise placement
                todoPanel.setPreferredSize(new Dimension(labelWidth, labelHeight));
                todoPanel.setBackground(new Color(12, 12, 12));

                // Text label
                JLabel todoLabel = new JLabel("T." + todoText);
                todoLabel.setForeground(Color.WHITE);
                todoLabel.setFont(new Font("Arial", Font.BOLD, 16));
                todoLabel.setBounds(10, 5, labelWidth , labelHeight); // Leave space for the button

                // Remove button
                JButton removeTodo = new JButton("X");
                removeTodo.setBounds(labelWidth+50, 5, 30, 20); // Fixed position on the right
                removeTodo.setFocusable(false);
                removeTodo.setBackground(new Color(12, 12, 12));
                removeTodo.setFont(new Font("Arial", Font.BOLD, 12));
                removeTodo.setForeground(new Color(250, 50, 97));
                removeTodo.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                removeTodo.addActionListener(e1 -> {
                    panel.remove(todoPanel); // Remove the entire todo panel
                    panel.revalidate();
                    panel.repaint();
                });

                // Add label and button to the todo panel
                todoPanel.add(todoLabel);
                todoPanel.add(removeTodo);

                // Add the todo panel to the main panel
                panel.add(todoPanel);
                panel.add(Box.createRigidArea(new Dimension(0, 0))); // Add vertical spacing
                panel.revalidate();
                panel.repaint();

                // Reset the input field
                todoTextIn.setText("");
                placeTodoText.setText("Enter todo:");
                placeTodoText.setForeground(Color.LIGHT_GRAY);
                todoTextIn.setForeground(new Color(195, 195, 195));
                todoTextIn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                i++;
            } else {
                placeTodoText.setText("Enter todo: Wrong todo.");
                placeTodoText.setForeground(Color.RED);
                todoTextIn.setForeground(new Color(255, 0, 0));
                todoTextIn.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
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

        }
    }
    //----------------------------------------------keyEVENTS END
}