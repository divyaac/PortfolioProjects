
public class Matrix {
	private double [][] master;
	public int columns;
	public int rows;
	public boolean square = false;
	
	public Matrix(double [][] matrix){
		master = new double[matrix.length][matrix[0].length];
		for (int i = 0; i<matrix.length; i++){
			for(int j = 0; j<matrix[0].length; j++){
				this.master[i][j] = matrix[i][j];
			}
		}
		this.columns = master.length;
		this.rows = master[0].length;
		if (rows==columns){
			square = true;
		}
	}
	
	public Matrix matrix_transpose(){
		double [][] transpose = new double[rows][columns];
		for (int row_index=0; row_index < rows; row_index++){
			for(int col_index= 0 ; col_index < columns; col_index ++){
				transpose[row_index][col_index] = master[col_index][row_index];
			}
		}
		return new Matrix(transpose);
	}
	
	public Matrix multiply_by_constant(double constant){
		double [][] product = new double[columns][rows] ;
		for(int i = 0; i< columns; i++){
			for(int j = 0; j< rows; j++){
				product[i][j] = constant * master[i][j];
			}
		}
		return new Matrix(product);
	}
	
	public Matrix matrix_add(Matrix other){
		if(other.rows!= rows || columns!= other.columns){
			throw new IllegalArgumentException("Matrices must be equal in size");
		}else{
			double [][] sum = new double [columns][rows];
			for (int row_index=0; row_index < rows; row_index++){
				for(int col_index= 0 ; col_index < other.columns; col_index ++){
					sum[col_index][row_index] = master[col_index][row_index] + other.get_Value(row_index+1, col_index+1);
				}
			}
			return new Matrix(sum);
		}
	}
	
	public Matrix matrix_subtract(Matrix other){
		if(other.rows!= rows || columns!= other.columns){
			throw new IllegalArgumentException("Matrices must be equal in size"); }
		Matrix holder = other.multiply_by_constant(-1);
		Matrix difference = matrix_add(holder);
		return difference;
	}
	
	
	
	public Matrix matrix_multiply(Matrix other){
		if(other.rows != columns){
			throw new IllegalArgumentException("Rows of Other matrix must = columns of current matrix");
		}else{
			double[][] product = new  double [other.columns][this.rows];
			for (int row_index=0; row_index < rows; row_index++){
				for(int col_index= 0 ; col_index < other.columns; col_index ++){
					double col[] = other.getColumn(col_index+1);
					double row[] = this.getRow(row_index+1);
					product[col_index][row_index] = dot_product(row, col);
				}
			}
			return new Matrix(product);
		}
	}
	
	
	public Matrix matrix_inverse(){
		Matrix adjoint = this.matrix_adjoint();
		if (matrix_determinant()==0) {
			throw new IllegalArgumentException("This Matrix Is Singular: Cannot Be Inverted");
		}else if (!square){
			throw new UnsupportedOperationException("Only Square Matrices Can Be Inverted");
		}
		return adjoint.multiply_by_constant((1/(matrix_determinant())));
	}
	
	
	public double matrix_determinant(){
		if (!square){
			throw new UnsupportedOperationException("Square Matrix Determinant Only");
		}else{
			double determinant = find_det();
			return determinant;
		}
	}
	
	public Matrix matrix_adjoint(){
		double[][] cofactor_matrix = new double[columns][rows];
		CofactorOperator cof = new CofactorOperator(this);
		for (int i= 1; i<=rows; i++){
			for (int j= 1; j<= columns; j++){
				double value= cof.cofactor_operator(i, j).matrix_determinant();;
				if ((i + j) % 2 !=0){
					value*=-1; 
				}
				cofactor_matrix[j-1][i-1] = value;
			}
		}
		Matrix cof_matrix = new  Matrix(cofactor_matrix);
		return cof_matrix.matrix_transpose();
	}
	
	
	private double find_det(){
		if (rows==1){
			return get_Value(1,1);
		}else if(rows==2){
			double prod_ad = get_Value(1,1) * get_Value(2,2);
			double prod_bc = get_Value(2,1) * get_Value(1,2);
			return (prod_ad - prod_bc);
		}else{
			double sum = 0;
			CofactorOperator cof = new CofactorOperator(this);
			for (int i=1; i<=columns; i++){
				Matrix holder = cof.cofactor_operator(1, i);
				if ((i+1) %2 ==0){
					sum+= get_Value(1, i) * holder.matrix_determinant();
				}else{
					sum-= get_Value(1, i) * holder.matrix_determinant();
				}
			}
			return sum;
		}
	}
	
	
	
	
	
	private double dot_product(double[] row, double[] column){
		if (row.length != column.length){
			throw new IllegalArgumentException("Row and Column lengths should be equal");
		}else{
			double product = 0;
			for (int i=0; i<row.length; i++){
				product+= row[i] * column[i];
			}
			return product;
		}
	}
	
	/**
	 * Used only for obtaining values by a user - obtaining values within the program can be done by simply 
	 * obtaining each column and row array, and looking at values from there.
	 * @param row_index
	 * @param col_index
	 * @return
	 */
	public double get_Value(int row_index, int col_index){
		return master[col_index-1][row_index-1];
	}
	
	public void change_Value(double value, int row_index, int col_index){
		master[col_index-1][row_index-1] = value;
	}
	
	
	
	/**
	 * 
	 * @param column_index The column number (starting from the first column to the last column)
	 * @return An array containing values of the column
	 */
	public double[] getColumn(int column_index){
		return master[column_index-1];
	}
	
	/**
	 * 
	 * @param row_index The row number (starting from 1 to the number of rows)
	 * @return
	 */
	public double[] getRow(int row_index){
		double[] row = new double[master.length];
		for (int j = 0; j <columns; j++){
			row[j] = master[j][row_index-1];
		}
		return row;
	}
	
	
	public String toString(){
		String holder = "";
		for (int i=1; i<=rows; i++){
			double[] ind_row = getRow(i);
			for (int elem=0; elem<ind_row.length; elem++){
				holder+= ind_row[elem] + "   ";
			}
			holder+= '\n';
		}
		return holder;
	}
}
