package sample;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Graphics {

    GridPane PlayField = new GridPane();
    Label Score = new Label();
    int MatrixSize = 25;
    int cellSize = 24;
    Scene Game;
    Random rand = new Random();

    /**
     * game initialization
     * @param primaryStage - main stage
     */
    public void initField(Stage primaryStage){
        PlayField = new GridPane();
        Score = new Label();

        Score.setTextFill(Color.WHITE);
        Score.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        Score.setText("Eat Food: " + 0);
        FillField();

        FlowPane flowPane = new FlowPane(Orientation.VERTICAL,PlayField);
        Game = new Scene(flowPane);
        primaryStage.setTitle("Snake");
        primaryStage.setScene(Game);
        primaryStage.show();

        PlayField.add(Score, 1, 0,6,2);
    }

    /**
     * fill field
     */
    public void FillField(){
        for(int x =0;x<MatrixSize;x++)
        {
            if(x % 2 == 0)
                PlayField.addColumn(x,new Rectangle(cellSize,cellSize, Color.rgb(139, 193, 247)));
            else
                PlayField.addColumn(x,new Rectangle(cellSize,cellSize, Color.rgb(129, 184, 240)));

            for(int y = 1; y < MatrixSize;y++) {
                if (y % 2 == 0 && x % 2 == 0)
                    PlayField.addRow(y, new Rectangle(cellSize, cellSize, Color.rgb(139, 193, 247)));
                if (y % 2 == 0 && x % 2 == 1)
                    PlayField.addRow(y, new Rectangle(cellSize, cellSize, Color.rgb(129, 184, 240)));
                if (y % 2 == 1 && x % 2 == 0)
                    PlayField.addRow(y, new Rectangle(cellSize, cellSize, Color.rgb(129, 184, 240)));
                if (y % 2 == 1 && x % 2 == 1)
                    PlayField.addRow(y, new Rectangle(cellSize, cellSize, Color.rgb(139, 193, 247)));
            }
        }
    }

    /**
     *
     * @return - return random color
     */
    public Color ChooseColor(){
        int x = rand.nextInt(3);
        switch (x) {
            case 0:
                return(Color.rgb(255, 177, 156));
            case 1:
                return(Color.rgb(255, 242, 156));
            case 2:
                return(Color.rgb(229, 150, 255));
            case 3:
                return(Color.rgb(150, 245, 255));
        }

        return (Color.WHITE);
    }

    /**
     * remove body part of snake
     * @param SnakePart - array of blocks that make up the snake's body
     * @param x - number of part of snake's body
     */
    public void removeBodyPart(ArrayList<Snake> SnakePart, int x){
        PlayField.getChildren().remove(SnakePart.get(x).snakeBody);

    }

    /**
     * remove head of snake
     * @param SnakePart - array of blocks that make up the snake's body
     */
    public void removeHead(ArrayList<Snake> SnakePart){
        PlayField.getChildren().remove(SnakePart.get(0).snakeHead);
    }

    /**
     * place snake's head
     * @param SnakePart - array of blocks that make up the snake's body
     * @param posX - x position of head
     * @param posY - y position of head
     */
    public void placeHead(ArrayList<Snake> SnakePart, int posX, int posY){
        PlayField.add(SnakePart.get(0).snakeHead, posX,posY);
    }

    /**
     * place body part of snake
     * @param SnakePart - array of blocks that make up the snake's body
     * @param x - number of part of snake's body
     */
    public void placeBodyPart(ArrayList<Snake> SnakePart,int x){
        PlayField.add(SnakePart.get(x).snakeBody, SnakePart.get(x-1).getPosPrevX(),SnakePart.get(x-1).getPosPrevY());
    }

    /**
     * remove food from field
     * @param food - array of blocks of food
     * @param i - number of food in array
     */
    public void removeFood(ArrayList<Rectangle> food, int i){
        PlayField.getChildren().remove(food.get(i));
    }

    /**
     * place food on field
     * @param food - array of blocks of food
     * @param foodX - array of blocks of food's x position
     * @param foodY - array of blocks of food's y position
     * @param i - number of food in array
     */
    public void placeFood(ArrayList<Rectangle> food,ArrayList<Integer> foodX,ArrayList<Integer> foodY, int i){
        PlayField.add(food.get(i), foodX.get(i),foodY.get(i));
    }

    /**
     * place obstacles on field
     * @param obstacles - array of blocks of obstacles
     * @param obstaclesX - array of blocks of obstacle's's x position
     * @param obstaclesY - array of blocks of obstacle's's x position
     * @param i - number of obstacle in array
     */
    public void placeObstacles(ArrayList<Rectangle> obstacles, ArrayList<Integer> obstaclesX,ArrayList<Integer> obstaclesY, int i){
        PlayField.add(obstacles.get(i), obstaclesX.get(i),obstaclesY.get(i));
    }

    /**
     * remove obstacles on field
     * @param obstacles - array of blocks of obstacles
     * @param i - number of obstacle in array
     */
    public void removeObstacles(ArrayList<Rectangle> obstacles,int i){
        PlayField.getChildren().remove(obstacles.get(i));
    }

    /**
     * replace body part of snake
     * @param SnakePart - array of blocks that make up the snake's body
     * @param cntEatFood - amount of food eaten
     */
    public void replaceBodyPart(ArrayList<Snake> SnakePart, int cntEatFood){
        PlayField.add(SnakePart.get(SnakePart.size()-1).snakeBody, SnakePart.get(SnakePart.size()-1).getPosPrevX(), SnakePart.get(SnakePart.size()-1).getPosPrevY());
        Score.setText("Eat Food:" + cntEatFood + "  ");
    }

}
