package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    static int speed = 5;
    static int width = 30;
    static int height = 20;
    static ArrayList<Integer> foodX = new ArrayList<Integer>();
    static ArrayList<Integer> foodY = new ArrayList<Integer>();
    static ArrayList<Integer> foodColor = new ArrayList<Integer>();
    static ArrayList<Integer> obstaclesX = new ArrayList<Integer>();
    static ArrayList<Integer> obstaclesY = new ArrayList<Integer>();
    static int obstaclesK;
    static int cntObstacles;
    static int cornersize = 25;
    static int cntFood;
    static int cntEatFood = 0;
    static int finishFood;
    static List<Corner> snake = new ArrayList<>();
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static boolean win = false;
    static Random rand = new Random();

    public enum Dir {
        left, right, up, down
    }

    public static class Corner {
        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public void start(Stage primaryStage) {
        try {
            mainMenu(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void mainMenu(Stage primaryStage) {

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        //Image
        Image image = new Image("/Img/2.png");
        ImageView img = new ImageView(image);
        img.setFitHeight(300);
        img.setFitWidth(500);
        root.getChildren().add(img);


        //TextField "Length for victory"
        TextField textFieldFinishFood = new TextField();
        Label lbl1 = new Label("Length for victory");
        Label lbl1Er = new Label("                         ");
        FlowPane flowPane1 = new FlowPane(Orientation.HORIZONTAL, 10, 10, lbl1, textFieldFinishFood, lbl1Er);
        flowPane1.setAlignment(Pos.CENTER);
        root.getChildren().add(flowPane1);

        //TextField "Аmount of food"
        TextField textFieldCntFood = new TextField();
        Label lbl2 = new Label("Аmount of food");
        Label lbl2Er = new Label("                         ");
        FlowPane flowPane4 = new FlowPane(Orientation.HORIZONTAL, 10, 10, lbl2, textFieldCntFood, lbl2Er);
        flowPane4.setAlignment(Pos.CENTER);
        root.getChildren().add(flowPane4);

        //Button Start
        Button btnStart = new Button("Start");
        btnStart.setPrefWidth(80);
        BorderPane borderPane = new BorderPane(btnStart);
        root.getChildren().add(borderPane);

        //Action button on Click
        btnStart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String cntFoodStr = textFieldCntFood.getText();
                String finishFoodStr = textFieldFinishFood.getText();

                boolean flag = true;

                try {
                    finishFood = Integer.parseInt(finishFoodStr);
                    lbl1Er.setText("");
                } catch (NumberFormatException e) {
                    lbl1Er.setText("Это по твоему число???");
                    flag = false;
                }

                try {
                    cntFood = Integer.parseInt(cntFoodStr);
                    lbl2Er.setText("");
                } catch (NumberFormatException e) {
                    lbl2Er.setText("Это по твоему число???");
                    flag = false;
                }

                if (flag) startGame(primaryStage);
            }
        });

        Scene scene = new Scene(root, width * cornersize, height * cornersize);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.show();
    }

    public static void startGame(Stage primaryStage){

        VBox root = new VBox();
        Canvas c = new Canvas(width * cornersize, height * cornersize);
        GraphicsContext gc = c.getGraphicsContext2D();

        obstacles(gc);
        CreateFood();

        root.getChildren().add(c);

        Scene scene = new Scene(root, width * cornersize, height * cornersize);

        new AnimationTimer() {
            long lastTick = 0;

            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    tick(gc);
                    return;
                }

                if (now - lastTick > 1000000000 / speed) {
                    lastTick = now;
                    tick(gc);
                }
            }

        }.start();

        // Snake's control
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                direction = Dir.up;
            }
            if (key.getCode() == KeyCode.A) {
                direction = Dir.left;
            }
            if (key.getCode() == KeyCode.S) {
                direction = Dir.down;
            }
            if (key.getCode() == KeyCode.D) {
                direction = Dir.right;
            }

        });

        //Add start snake parts
        snake.add(new Corner(width / 2, height / 2));

        primaryStage.setScene(scene);
        primaryStage.setTitle("SNAKE GAME");
        primaryStage.show();
    }

    public static void tick(GraphicsContext gc) {

        if (gameOver) {
            gc.setFill(Color.rgb(255, 61, 61));
            gc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
            gc.fillText("GAME OVER", 120, 250);
            return;
        }

        if (win) {
            gc.setFill(Color.rgb(18, 204, 68));
            gc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80));
            gc.fillText("YOU WIN!!!", 120, 250);
            return;
        }

        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        switch (direction) {
            case up:
                snake.get(0).y--;
                if (snake.get(0).y < 0) {
                    gameOver = true;
                }
                break;
            case down:
                snake.get(0).y++;
                if (snake.get(0).y > height) {
                    gameOver = true;
                }
                break;
            case left:
                snake.get(0).x--;
                if (snake.get(0).x < 0) {
                    gameOver = true;
                }
                break;
            case right:
                snake.get(0).x++;
                if (snake.get(0).x > width) {
                    gameOver = true;
                }
                break;

        }

        //Eat food
        for (int i = 0; i < cntFood; i++) {
            if (foodX.get(i) == snake.get(0).x && foodY.get(i) == snake.get(0).y) {
                snake.add(new Corner(-1, -1));
                if(cntEatFood % 3 == 0)speed++;
                newFood(i);
            }
        }

        //Self destroy
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                gameOver = true;
            }
        }

        //Background
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.rgb(139, 193, 247));
                } else {
                    gc.setFill(Color.rgb(129, 184, 240));
                }
                gc.fillRect(i * cornersize, j * cornersize, cornersize, cornersize);
            }
        }

        //Random food color
        Color cc = Color.rgb(0,0,255);

        for (int i = 0; i < cntFood; i++) {
            switch (foodColor.get(i)) {
                case 0:
                    cc = Color.rgb(255, 177, 156);
                    break;
                case 1:
                    cc = Color.rgb(255, 242, 156);
                    break;
                case 2:
                    cc = Color.rgb(200, 255, 156);
                    break;
                case 3:
                    cc = Color.rgb(150, 245, 255);
                    break;
                case 4:
                    cc = Color.rgb(229, 150, 255);
                    break;
            }

            gc.setFill(cc);
            gc.fillOval(foodX.get(i) * cornersize, foodY.get(i) * cornersize, cornersize, cornersize);
        }

        // snake
        for (Corner c : snake) {
            gc.setFill(Color.rgb(141, 214, 137));
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
            gc.setFill(Color.rgb(170, 255, 166));
            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);

        }

        //Obstacles
        for (int i = 1; i < obstaclesK; i++) {
            gc.setFill(Color.rgb(135, 62, 171));
            gc.fillRect(obstaclesX.get(i) * cornersize, obstaclesY.get(i) * cornersize, cornersize, cornersize);
            if (obstaclesX.get(i) == snake.get(0).x && obstaclesY.get(i) == snake.get(0).y) {
                gameOver = true;
            }
        }

        //Text of eating food
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        gc.fillText("Eat food: " + cntEatFood + "/" + finishFood, 0, 20);

    }

    public static void CreateFood(){
        for(int i = 0; i< cntFood; i++) {
            foodX.add(rand.nextInt(width));
            foodY.add(rand.nextInt(height));
            CheckObstacles(i);
            foodColor.add(rand.nextInt(5));
        }
    }

    // food
    public static void newFood(int i) {
        cntEatFood++;
        if(cntEatFood == finishFood){
            win = true;
            return;
        }
        foodX.set(i, rand.nextInt(width-1));
        foodY.set(i, rand.nextInt(height-1));
        CheckObstacles(i);
        foodColor.set(i, rand.nextInt(5));

    }

    public static void CheckObstacles(int i){
        for(int j = 1;j<obstaclesK;j++) {
            while(foodX.get(i) == obstaclesX.get(j) && foodY.get(i) == obstaclesY.get(j)){
                //     System.out.println("b");
                foodX.set(i,rand.nextInt(width));
                foodY.set(i,rand.nextInt(height));
            }
        }
    }

    public static void obstacles(GraphicsContext gc) {
        int lastIndex = 0;
        for (int i = 0; i < 10; i++) {
            rand = new Random();
            cntObstacles = rand.nextInt(20) + 10;
            obstaclesX.add(rand.nextInt(width));
            obstaclesY.add(rand.nextInt(height));

            int x0 = obstaclesX.get(lastIndex);
            int y0 = obstaclesY.get(lastIndex);

           // System.out.println(x0 + " " + y0);

            while(obstaclesX.get(i) < 16 && obstaclesX.get(i) > 12) obstaclesX.set(i, rand.nextInt(width));
            while(obstaclesY.get(i) > 8 && obstaclesY.get(i) < 12) obstaclesY.set(i, rand.nextInt(height));

            int k = (int) Math.random() * (20) + 10;
            lastIndex++;

            for (int j = 1; j < k; j++) {
                int x = rand.nextInt(4);

                switch (x) {
                    case 0:
                        x0++;
                        if(x0<16 && x0>12) x0 = x0-2;
                        obstaclesX.add(x0);
                        obstaclesY.add(y0);
                        System.out.println(x0 + " " + y0);
                        break;
                    case 1:
                        x0--;
                        if(x0<16 && x0>12) x0 = x0+2;
                        obstaclesX.add(x0);
                        obstaclesY.add(y0);
                        System.out.println(x0 + " " + y0);
                        break;
                    case 2:
                        y0++;
                        if(y0<12 && y0>8) y0 = y0-2;
                        obstaclesX.add(x0);
                        obstaclesY.add(y0);
                        System.out.println(x0 + " " + y0);
                        break;
                    case 3:
                        y0--;
                        if(y0<12 && y0>8) y0 = y0+2;
                        obstaclesX.add(x0);
                        obstaclesY.add(y0);
                        System.out.println(x0 + " " + y0);
                        break;
                }
                lastIndex++;
            }
        }
        obstaclesK = lastIndex--;
    }

    public static void main(String[] args) {
        launch(args);
    }
}