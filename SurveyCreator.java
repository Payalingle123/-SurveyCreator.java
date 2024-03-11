import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SurveyCreator extends JFrame {
    private JTextField questionField;
    private JComboBox<String> questionTypeComboBox;
    private JButton addQuestionButton;
    private JTextArea surveyTextArea;

    public SurveyCreator() {
        setTitle("Survey Creator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel questionLabel = new JLabel("Question:");
        questionField = new JTextField(20);
        inputPanel.add(questionLabel);
        inputPanel.add(questionField);

        String[] questionTypes = {"Multiple Choice", "Text Input", "Rating Scale"};
        questionTypeComboBox = new JComboBox<>(questionTypes);
        inputPanel.add(questionTypeComboBox);

        addQuestionButton = new JButton("Add Question");
        addQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String question = questionField.getText();
                String questionType = (String) questionTypeComboBox.getSelectedItem();
                surveyTextArea.append(question + " - " + questionType + "\n");
                questionField.setText("");
            }
        });
        inputPanel.add(addQuestionButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        surveyTextArea = new JTextArea();
        surveyTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(surveyTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SurveyCreator().setVisible(true);
            }
        });
    }
}
