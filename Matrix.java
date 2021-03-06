/*
  Practice Program #1:
  Matrix rotation.
  Given a NxN matrix, create a function that rotates it clockwise
  Ryan Yoder (2017)
 */
import java.util.*;
import java.math.*;

public class Matrix{
  int[][] matrix;

  public static void main(String[] args){
    // Request a matrix to be generated by the user
    System.out.println("Please enter the dimensions for your matrix, parsed with an ENTER.");
    Scanner scan = new Scanner(System.in);
    int dim1 = scan.nextInt();
    int dim2 = scan.nextInt();
    System.out.println("You have requested a matrix with the dimensions " + dim1 + "x" + dim2);

    Matrix theMatrix = new Matrix(dim1, dim2);

    System.out.println("The generated matrix is:");
    System.out.println(theMatrix);

    System.out.println("Rotating the matrix clockwise 90 degrees...");
    System.out.println("The resulting matrix is:");
    theMatrix.rotateClockwise();
    System.out.println(theMatrix);

    System.out.println("Rotating the resulting matrix counter-clockwise 180 degrees...");
    System.out.println("The resulting matrix is:");
    theMatrix.rotateCounterClockwise();
    theMatrix.rotateCounterClockwise();
    System.out.println(theMatrix);
  }

  public Matrix(int dim1, int dim2){
    Random rand = new Random();
    int[][] matrix = new int[dim1][dim2];
    for(int i = 0; i < dim1; i++){
      for(int j = 0; j < dim2; j++){
        matrix[i][j] = rand.nextInt(100);
      }
    }
    this.matrix = matrix;
  }

  public void rotateClockwise(){
    int[][] newMatrix = new int[this.matrix[0].length][this.matrix.length];
    int r = 0;
    int y = newMatrix[0].length-1;
    for(int i = 0; i < newMatrix.length; i++){
      for(int j = 0; j < newMatrix[0].length; j++){
        newMatrix[i][j] = this.matrix[y][r];
        y--;
      }
      r++;
      y = newMatrix[0].length-1;
    }
    this.matrix = newMatrix;
  }

  // Another approach to matrix rotation; this one using less code and less memory
  public void rotateCounterClockwise(){
    int[][] newMatrix = new int[this.matrix[0].length][this.matrix.length];
    for(int i = 0; i < this.matrix.length; i++){
      for(int j = 0; j < this.matrix[0].length; j++){
        newMatrix[this.matrix[0].length - 1 - j][i] = this.matrix[i][j];
      }
    }
    this.matrix = newMatrix;
  }

  public String toString(){
    String str = "";
    for(int i = 0; i < this.matrix.length; i++){
      for(int j = 0; j < this.matrix[i].length; j++){
        str += (this.matrix[i][j] + "\t");
      }
      str += ("\n");
    }
    return str;
  }

}
