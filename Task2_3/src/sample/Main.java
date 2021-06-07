package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Random;


public class Main extends Application
{
    Stage primaryStage;
    int widthMenu = 750;
    int heightMenu = 500;
    int MatrixSize = 25;
    int cellSize = 24;

    int cntFood;
    int cntEatFood = 0;
    ArrayList<Integer> foodX = new ArrayList<Integer>();
    ArrayList<Integer> foodY = new ArrayList<Integer>();
    ArrayList<Rectangle> food = new ArrayList<Rectangle>();

    int obstaclesK = 10;
    ArrayList<Integer> obstaclesX = new ArrayList<Integer>();
    ArrayList<Integer> obstaclesY = new ArrayList<Integer>();
    ArrayList<Rectangle> obstacles = new ArrayList<Rectangle>();

    int dirX = 0;
    int dirY = 0;
    int posX;
    int posY;
    ArrayList<Snake> SnakePart = new ArrayList<>(0);

    Random rand = new Random();
    Timeline game;
    double snakeSpeed = 1/10.0;
    boolean start = false;

    Graphics graphics = new Graphics();

    /**
     * start the game and go to the main menu
     * @param stage - main stage
     */
    public void start(Stage stage) {
        primaryStage = stage;
        try {
            mainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * main Menu
     */
    public void mainMenu() {

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));


        Image image = new Image("/Img/2.png");
        ImageView img = new ImageView(image);
        img.setFitHeight(300);
        img.setFitWidth(500);
        root.getChildren().add(img);


        Button btnSimple = new Button("Simple");
        btnSimple.setPrefWidth(80);


        Button btnMedium = new Button("Medium");
        btnMedium.setPrefWidth(80);


        Button btnHard = new Button("Hard");
        btnHard.setPrefWidth(80);


        FlowPane flowPaneButt = new FlowPane(Orientation.HORIZONTAL, 10, 10, btnSimple, btnMedium, btnHard);
        flowPaneButt.setAlignment(Pos.CENTER);
        root.getChildren().add(flowPaneButt);


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

        btnSimple.setOnAction(actionEvent ->  {
            snakeSpeed = 1/10.0;
            obstaclesK = 10;
        });

        btnMedium.setOnAction(actionEvent ->  {
            snakeSpeed = 1/15.0;
            obstaclesK = 15;
        });

        btnHard.setOnAction(actionEvent ->  {
            snakeSpeed = 1/20.0;
            obstaclesK = 20;
        });

        //Action button on Click
        btnStart.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String cntFoodStr = textFieldCntFood.getText();
                boolean flag = true;
                try {
                    cntFood = Integer.parseInt(cntFoodStr);
                    lbl2Er.setText("");
                } catch (NumberFormatException e) {
                    lbl2Er.setText("Это по твоему число???");
                    flag = false;
                }

                if (flag) startGame();
            }
        });

        Scene scene = new Scene(root, widthMenu , heightMenu);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Crazy Snake");
        primaryStage.show();
    }

    /**
     * initializing a new game
     */
    public void startGame(){
        graphics.initField(primaryStage);

        foodX = new ArrayList<Integer>();
        foodY = new ArrayList<Integer>();
        food = new ArrayList<Rectangle>();
        obstaclesX = new ArrayList<Integer>();
        obstaclesY = new ArrayList<Integer>();
        obstacles = new ArrayList<Rectangle>();

        PlaceObstacles();
        CreateFood();
        CreateSnake();

        graphics.Game.setOnKeyPressed(this::PressedKey);

        game = new Timeline(new KeyFrame(Duration.seconds(snakeSpeed),
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event) {
                        MoveSnake();
                    }
                }));
        game.setCycleCount(Timeline.INDEFINITE);
    }

    /**
     * handling keystrokes
     * @param event - keystroke
     */
    public void PressedKey(KeyEvent event){
        if(dirY ==0 && event.getCode() == KeyCode.W)
        {
            dirX = 0;
            dirY = -1;
            start = true;
        }
        else if(dirY == 0 && event.getCode() == KeyCode.S)
        {
            dirX = 0;
            dirY = 1;
            start = true;
        }
        else if(dirX ==0 && event.getCode() == KeyCode.A)
        {
            dirX = -1;
            dirY = 0;
            start = true;
        }
        else if(dirX == 0 && event.getCode() == KeyCode.D)
        {
            dirX = 1;
            dirY = 0;
            start = true;
        }

        if(start = true) game.play();
    }

    /**
     * Move Snake
     */
    public void MoveSnake(){

        if((dirX == -1 && posX == 0) || (dirY == -1 && posY == 0) || (dirX == 1 && posX == MatrixSize-1) || (dirY == 1 && posY == MatrixSize-1)) {
            GameOver();
        }
        else
        {
            graphics.removeHead(SnakePart);
            posX+=dirX;
            posY+=dirY;
            graphics.placeHead(SnakePart,posX,posY);
            SnakePart.get(0).setPos(posX,posY);
            if(SnakePart.size() > 1)
            {
                for(int x = 1; x<SnakePart.size();x++)
                {
                    graphics.removeBodyPart(SnakePart,x);
                    graphics.placeBodyPart(SnakePart,x);
                    SnakePart.get(x).setPos(SnakePart.get(x-1).getPosPrevX(),SnakePart.get(x-1).getPosPrevY());
                }
            }

            CheckFood();
            CheckObstaclesForSnake();
            SelfDestroy();
        }
    }

    /**
     * If the snake has eaten food, place it in a new place
     * @param i - number of food eaten
     */
    public void PlaceFood(int i){
        graphics.removeFood(food, i);
        foodX.set(i, rand.nextInt(20));
        foodY.set(i, rand.nextInt(20));
        Color color = graphics.ChooseColor();
        food.set(i, new Rectangle(cellSize,cellSize, color));
        CheckObstaclesForFood(i);
        graphics.placeFood(food, foodX,foodY, i);
    }

    /**
     * Create food on field
     */
    public void CreateFood(){
        for(int i = 0; i < cntFood; i++) {
            Color color = graphics.ChooseColor();
            food.add(new Rectangle(cellSize,cellSize, color));
            foodX.add(rand.nextInt(20));
            foodY.add(rand.nextInt(20));
            CheckObstaclesForFood(i);
            graphics.placeFood(food, foodX,foodY, i);
        }
    }

    /**
     * Create a snake
     */
    public void CreateSnake(){
        dirX = 0;
        dirY = 0;
        posX = new Random().nextInt(MatrixSize);
        posY =new Random().nextInt(MatrixSize);
        for(int j = 1;j<obstaclesX.size()-1;j++) {
            while(posX == obstaclesX.get(j) && posY == obstaclesY.get(j)){
                posX = new Random().nextInt(MatrixSize);
                posY =new Random().nextInt(MatrixSize);
            }
        }
        SnakePart = new ArrayList<>(0);
        SnakePart.add(new Snake(posX, posY));
        graphics.placeHead(SnakePart,posX,posY);
    }

    /**
     * Check obstacle on collision with food
     * @param i - number of food
     */
    public void CheckObstaclesForFood(int i){
        for(int j = 1;j<obstaclesX.size()-1;j++) {
            while(foodX.get(i) == obstaclesX.get(j) && foodY.get(i) == obstaclesY.get(j)){
                foodX.set(i,rand.nextInt(20));
                foodY.set(i,rand.nextInt(20));
            }
        }
    }

    /**
     * checks if the snake collided with itself
     */
    public void SelfDestroy(){
        for(int x = 1; x<SnakePart.size();x++)
        {
            if(posX == SnakePart.get(x).getPosX() && posY == SnakePart.get(x).getPosY())
            {
                GameOver();
                break;
            }
        }
    }

    /**
     * checks if the snake has eaten food
     */
    public void CheckFood(){
        for (int i = 0; i < cntFood; i++) {
            if (foodX.get(i) == posX && foodY.get(i) == posY) {
              //  System.out.println("c");
                NewPart(i);
            }
        }
    }

    /**
     * check snake on collision with obstacles
     */
    public void CheckObstaclesForSnake(){
        for (int i = 1; i < obstaclesX.size()-1; i++) {
            if (obstaclesX.get(i) == posX && obstaclesY.get(i) == posY) {
                GameOver();
                break;
            }
        }
    }

    /**
     * place obstacles on field
     */
    public  void PlaceObstacles(){
        for (int i = 0; i < obstaclesK; i++) {
            obstaclesX.add(rand.nextInt(25));
            obstaclesY.add(rand.nextInt(25));
            obstacles.add(new Rectangle(cellSize,cellSize,Color.rgb(135, 62, 171)));

            int x0 = obstaclesX.get(obstaclesX.size() - 1);;
            int y0 = obstaclesY.get(obstaclesX.size() - 1);;

            int k = (int) Math.random() * (20) + 5;

            int x;
            boolean flag;
            for (int j = 1; j < k; j++) {
                x = rand.nextInt(4);
                flag = true;

                while(flag){
                    switch (x) {
                        case 0:
                            if(x0 >= 20) {
                                x = rand.nextInt(4);
                                break;
                            }
                            x0++;
                            obstaclesX.add(x0);
                            obstaclesY.add(y0);
                            obstacles.add(new Rectangle(cellSize,cellSize,Color.rgb(135, 62, 171)));
                         //   System.out.println(x0 + " " + y0);
                            flag = false;
                            break;
                        case 1:
                            if(x0 <= 0) {
                                x = rand.nextInt(4);
                                break;
                            }
                            x0--;
                            obstaclesX.add(x0);
                            obstaclesY.add(y0);
                            obstacles.add(new Rectangle(cellSize,cellSize,Color.rgb(135, 62, 171)));
                       //     System.out.println(x0 + " " + y0);
                            flag = false;
                            break;
                        case 2:
                            if(y0 >= 20) {
                                x = rand.nextInt(4);
                                break;
                            }
                            y0++;
                            obstaclesX.add(x0);
                            obstaclesY.add(y0);
                            obstacles.add(new Rectangle(cellSize,cellSize,Color.rgb(135, 62, 171)));
                       //     System.out.println(x0 + " " + y0);
                            flag = false;
                            break;
                        case 3:
                            if(y0 <= 0 ) {
                                x = rand.nextInt(4);
                                break;
                            }
                            y0--;
                            obstaclesX.add(x0);
                            obstaclesY.add(y0);
                            obstacles.add(new Rectangle(cellSize,cellSize,Color.rgb(135, 62, 171)));
                            System.out.println(x0 + " " + y0);
                            flag = false;
                            break;
                    }
                }
            }
        }

        for (int i = 0; i < obstaclesX.size()-1; i++) {
            graphics.placeObstacles(obstacles, obstaclesX, obstaclesY, i);
        }
    }

    /**
     * Add snake a block of body
     * @param i - number of eating food
     */
    public void NewPart(int i) {
        cntEatFood++;
        SnakePart.add(new Snake(SnakePart.get(SnakePart.size()-1).getPosPrevX(), SnakePart.get(SnakePart.size()-1).getPosPrevY()));
        graphics.replaceBodyPart(SnakePart,cntEatFood);
        PlaceFood(i);
    }

    /**
     * GameOver
     */
    public void GameOver() {
        start = false;
        game.stop();

        for (int i = 0; i < obstacles.size(); i++){
            graphics.removeObstacles(obstacles, i);
        }

        obstaclesX.clear();
        obstaclesY.clear();
        obstacles.clear();

        for (int i = 0; i < foodX.size()-1; i++){
            graphics.removeFood(food, i);
        }
        foodX.clear();
        foodY.clear();
        food.clear();

        for(int x =SnakePart.size()-1; x>0; x--) {
            graphics.removeBodyPart(SnakePart,x);
            SnakePart.remove(x);
        }

        graphics.removeBodyPart(SnakePart,0);
        cntEatFood = 0;
        mainMenu();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
