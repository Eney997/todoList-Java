import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        // Create the JFrame for the main application window
        JFrame appFrame = new JFrame();

        //buttons
        JButton exitButton = new JButton("X");
        JButton minimizeButton = new JButton("_");
        JButton allTodo = new JButton("All");
        JButton pendingTodo = new JButton("Pending");
        JButton completedTodo = new JButton("Complated");

        //framesfor app
        JLabel appTopFrame = new JLabel();
        JLabel appBottomFrame = new JLabel();
        JLabel appTodoImage = new JLabel();
        JPanel appleftFrame = new JPanel();
        JPanel appRightFrame = new JPanel();

        //to-do elements
        //text field
        JTextField todoTextIn = new JTextField();

        //lable for text on top to-doinput text field
        JLabel placeTodoText = new JLabel();



        //----------------------------------------------------------------------------------------------------------TODOS FILTER START
        //all
        allTodo.setBounds(480, 90, 45, 35);
        allTodo.setFocusable(false);
        allTodo.setBackground(new Color(12, 12, 12));
        allTodo.setFont(new Font("Arial", Font.BOLD, 16));
        allTodo.setForeground(new Color(250,50, 97));
        allTodo.setBorder(null);

        //PENDING
        pendingTodo.setBounds(517, 90, 85, 35);
        pendingTodo.setFocusable(false);
        pendingTodo.setBackground(new Color(12, 12, 12));
        pendingTodo.setFont(new Font("Arial", Font.BOLD, 16));
        pendingTodo.setForeground(new Color(250,50, 97));
        pendingTodo.setBorder(null);

        //COMPLATED
        completedTodo.setBounds(597, 90, 95, 35);
        completedTodo.setFocusable(false);
        completedTodo.setBackground(new Color(12, 12, 12));
        completedTodo.setFont(new Font("Arial", Font.BOLD, 16));
        completedTodo.setForeground(new Color(250,50, 97));
        completedTodo.setBorder(null);

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
        todoTextIn.setFont(new Font("Arial", Font.PLAIN, 20));
        todoTextIn.setForeground(new Color(195, 195, 195));
        todoTextIn.setCaretColor(new Color(195, 195, 195));
        todoTextIn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));


        //----------------------------------------------------------------------------------------------------------TODOTEXT AND TEXT INPUT END


        //----------------------------------------------------------------------------------------------------------IMAGES AND FRAMES START
        //------------------------------------------------topFrame address
        ImageIcon imageIcon1 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/topBorder.bmp")));
        // Scale the image to the desired size
        Image image = imageIcon1.getImage().getScaledInstance(900, 7, Image.SCALE_SMOOTH);
        appTopFrame = new JLabel();
        //makeing cp image sizes
        appTopFrame.setIcon(new ImageIcon(image));
        appTopFrame.setBounds(0, 0, 900, 7);

        //------------------------------------------------bottomFrame address
        ImageIcon imageIcon2 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/bottomBorder.bmp")));
        // Scale the image to the desired size
        Image image2 = imageIcon2.getImage().getScaledInstance(901, 7, Image.SCALE_SMOOTH);
        appBottomFrame = new JLabel();
        //makeing cp image sizes
        appBottomFrame.setIcon(new ImageIcon(image2));
        appBottomFrame.setBounds(-1, 493, 901, 7);


        //------------------------------------------------todoImage
        ImageIcon imageIcon3 = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/Assets/todo-image.bmp")));
        // Scale the image to the desired size
        Image image3 = imageIcon3.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        appTodoImage = new JLabel();
        //makeing cp image sizes
        appTodoImage.setIcon(new ImageIcon(image3));
        appTodoImage.setBounds(30, 170, 300, 200);


        //------------------------------------------------leftFrame
        appleftFrame.setLayout(null);
        appleftFrame.setBounds(0, 0, 1, 500);
        appleftFrame.setBackground(new Color(123, 50, 250));

        //------------------------------------------------rightFrame
        appRightFrame.setLayout(null);
        appRightFrame.setBounds(899, 0, 1, 500);
        appRightFrame.setBackground(new Color(123, 50, 250));

        //creating line for top
        JPanel linePanel = new JPanel();
        linePanel.setLayout(null);
        linePanel.setBounds(9, 50, 882, 1);
        linePanel.setBackground(new Color(123, 50, 250));

        //----------------------------------------------------------------------------------------------------------IMAGES AND FRAMES END


        //----------------------------------------------------------------------------------------------------------MINIMIZE AND MAXIMIZE BUTTON START
        //minimize button
        minimizeButton.setBounds(780, 7, 45, 35);
        minimizeButton.setFocusable(false);
        minimizeButton.setBackground(new Color(12, 12, 12));
        minimizeButton.setFont(new Font("Arial", Font.BOLD, 16));
        minimizeButton.setForeground(new Color(250,50, 97));
        minimizeButton.setBorder(BorderFactory.createLineBorder(new Color(100, 141, 244), 1));

        //exitbutton
        exitButton.setBounds(830, 7, 45, 35);
        exitButton.setFocusable(false);
        exitButton.setBackground(new Color(12, 12, 12));
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setForeground(new Color(250,50, 97));
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(100, 141, 244), 1));

        //----------------------------------------------------------------------------------------------------------MINIMIZE AND MAXIMIZE BUTTON END


        //----------------------------------------------------------------------------------------------------------MINIMIZE AND MAXIMIZE BUTTON MOUSELISTENERS ALSO APP MOVE  START
        // Add minimize button event listener
        minimizeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Minimize the window
                appFrame.setState(JFrame.ICONIFIED);
            }
        });

        // Add exit button event listener
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Close the application
                System.exit(0);
            }
        });

        final int[] mouseX = {0};
        final int[] mouseY = {0};

        appFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Capture initial mouse position
                mouseX[0] = e.getX();
                mouseY[0] = e.getY();
            }
        });
        //mousemovement - appMove
        appFrame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Check if dragging is within the top 50 pixels
                if (mouseY[0] <= 50) {
                    // Calculate new frame position
                    int x = appFrame.getX() + e.getX() - mouseX[0];
                    int y = appFrame.getY() + e.getY() - mouseY[0];
                    appFrame.setLocation(x, y);
                }
            }
        });

        //----------------------------------------------------------------------------------------------------------MINIMIZE AND MAXIMIZE BUTTON MOUSELISTENERS ALSO APP MOVE END

        //----------------------------------------------------------------------------------------------------------PUSH ELEMENTS ON FRAME START
        appFrame.add(allTodo);
        appFrame.add(pendingTodo);
        appFrame.add(completedTodo);
        appFrame.add(placeTodoText);
        appFrame.add(todoTextIn);
        appFrame.add(appTopFrame);
        appFrame.add(appBottomFrame);
        appFrame.add(appTodoImage);
        appFrame.add(appleftFrame);
        appFrame.add(appRightFrame);
        appFrame.add(linePanel);
        appFrame.add(minimizeButton);
        appFrame.add(exitButton);
        appFrame.getContentPane().setBackground(new Color(12,12,12));
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setResizable(false);
        //here is without caption maker
        appFrame.setUndecorated(true);
        appFrame.setLayout(null);
        appFrame.setBounds(300,150,900,500);
        //rounded window
        appFrame.setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, 900, 500, 19, 19));

        // Make the JFrame visible
        appFrame.setVisible(true);
        //----------------------------------------------------------------------------------------------------------PUSH ELEMENTS ON FRAME END

    }
}