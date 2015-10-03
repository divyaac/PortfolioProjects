
public class CofactorOperator {
	
	private Matrix matrix;
	
	public CofactorOperator(Matrix matrix){
		this.matrix = matrix;
	}
	
	public Matrix cofactor_operator(int row, int col){
		Matrix removed_column = remove_column(this.matrix, col);
		Matrix removed_row = remove_column(removed_column.matrix_transpose(), row);
		return removed_row.matrix_transpose();
	}
	
	/**
	 * Index is the index of column in user terms (starts from  1)
	 * @param holder
	 * @param index
	 * @return
	 */
	private Matrix remove_column(Matrix holder, int index){
		double[][] removed = new double[holder.columns-1][holder.rows];
		boolean skipped  = false;
		for (int i=1; i<=holder.columns; i++){
			if (skipped){
				removed[i-2] = holder.getColumn(i);
			}else{
				if(i==index){
					skipped = true;
				}else{
					removed[i-1] = holder.getColumn(i);
				}
			}
		}
		return new Matrix(removed);
	}
	
	
	
	
	
	
	
}
