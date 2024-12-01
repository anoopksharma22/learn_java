import java.util.Scanner;

interface IQuestion{
    void display();
    boolean checkAnswer(String userAnswer);
}

class Option{
    String[] options;

    public Option(String... options){
        this.options = options;
    }
    public void displayOption(){
        char label = 'A';
        for( String op: this.options){
            System.err.println(label + ": " + op);
            label++;
        }
    }
}

class QuestionFactory{
    public static IQuestion createQuestion(int id, String questionText, String[] options, String correctAnswer){
        Option option = new Option(options);
        Question question = new Question(id, questionText, option, correctAnswer);
        return question;
    }
}

class QuizController{
    IQuestion[] question;

    public QuizController(IQuestion[] questions){
        this.question = questions;
    }

    public void startQuiz(){
        Scanner sc = new Scanner(System.in);
        int score = 0;
        for( IQuestion q: this.question){
            q.display();
            System.out.print("Your answer: ");
            String userInput = sc.nextLine();
            if( q.checkAnswer(userInput) ){
                score++;
            }
            System.out.println("-----------------------");
        }
        System.out.println("Your score: " + score);
        sc.close();
    }
}

class Question implements IQuestion{
    int id;
    String questionText;
    Option options; 
    String answer;

    public void display(){
        System.out.println(this.questionText);
        this.options.displayOption();
    }
    
    public boolean checkAnswer(String userAnswer){
        boolean res = false;
        if( this.answer.equalsIgnoreCase(userAnswer)){
            res = true;
        }
        return res;
    }

    public Question(int id, String question, Option options, String answer) {
        this.id = id;
        this.questionText = question;
        this.options = options;
        this.answer = answer;
    }
}

public class Main{
    public static void main(String[] args) {
        IQuestion[] questionSet = {
            QuestionFactory.createQuestion(1, "Capital of India", new String[]{"Delhi", "Pune", "Bengaluru", "Chennai"}, "Delhi"),
            QuestionFactory.createQuestion(2, "Capital of MH", new String[]{"Delhi", "Mumbai", "Bengaluru", "Chennai"}, "Mumbai"),
            QuestionFactory.createQuestion(3, "Capital of UP", new String[]{"Delhi", "Pune", "Lucknow", "Chennai"}, "Lucknow"),
            QuestionFactory.createQuestion(4, "Capital of BR", new String[]{"Delhi", "Pune", "Bengaluru", "Patna"}, "Patna"),
            QuestionFactory.createQuestion(5, "Capital of CG", new String[]{"Raipur", "Pune", "Bengaluru", "Chennai"}, "Raipur"),
            QuestionFactory.createQuestion(6, "Capital of HP", new String[]{"Delhi", "Pune", "Chandigarh", "Chennai"}, "Chandigarh")
        };
        QuizController qc = new QuizController(questionSet);
        qc.startQuiz();
    }
}