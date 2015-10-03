import java.util.Scanner;


public class MatrixTester {

	private static Matrix initiate_matrix(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		int rows = input.nextInt();
		System.out.println("Enter the number of columns: ");
		int columns = input.nextInt();

		double[][] mat_holder = new double[columns][rows];
		for (int i=0; i<columns; i++){
			double[] column = new double[rows];
			for(int j=0; j<rows; j++){
				System.out.println("Enter value of row " + (j+1) + " of column " + (i+1) + ".");
				double val = input.nextDouble();
				column[j] = val;
			}
			mat_holder[i] = column;
		}
		Matrix master = new  Matrix(mat_holder);
		System.out.println("This is your matrix: ");
		System.out.println(master.toString());
		return master;
	}

	private static String find_operation(String operation){
		if (operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("subtract") || operation.equalsIgnoreCase("multiply")){
			return "Enter other matrix: ";
		}else if (operation.equalsIgnoreCase("invert")){
			return "Invert";
		}else if (operation.equalsIgnoreCase("transpose")){
			return "Transpose";
		}else if (operation.equalsIgnoreCase("determinant")){
			return "Determinant";
		}else{
			throw new IllegalArgumentException("This Operation Is Not Available");
		}
	}

	public static void main(String[] args) {
		while(true){
			Matrix matrix = initiate_matrix();
			Scanner input = new Scanner(System.in);
			System.out.println("What would you like to do with this matrix?");
			System.out.println("Add, Subtract, Invert, Transpose, Determinant, Multiply");
			String op = input.nextLine();
			String operation_que = find_operation(op);
			if (operation_que.equals("Enter other matrix: ")){
				System.out.println(operation_que);
				Matrix other = initiate_matrix();
				if (op.equalsIgnoreCase("add")){
					Matrix sum = matrix.matrix_add(other);
					System.out.println(sum.toString());
				}else if (op.equalsIgnoreCase("subtract")){
					Matrix difference = matrix.matrix_subtract(other);
					System.out.println(difference.toString());
				}else if (op.equalsIgnoreCase("multiply")){
					Matrix product = matrix.matrix_multiply(other);
					System.out.println(product.toString());
				}
			}else if (operation_que.equals("Invert")){
				System.out.println(matrix.matrix_inverse().toString());
			}else if (operation_que.equals("Transpose")){
				System.out.println(matrix.matrix_transpose().toString());
			}else if (operation_que.equals("Determinant")){
				System.out.println(matrix.matrix_determinant());
			}



		}
	}
}
