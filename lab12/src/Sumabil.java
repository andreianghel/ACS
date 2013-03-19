import java.util.Collection;

public interface Sumabil
{
	public void addValue(Sumabil value);
	public float getValue();
	public void setValue();
}

class MyVector3<E> implements Sumabil
{
	float value;
	float[] vector;
	
	//public MyVector3(){}
	public MyVector3()
	{
		this.value = 0;
		this.vector = new float[3];
	}

	
	@Override
	public float getValue() {
		return this.value;
	}
	
	@Override
	public void addValue(Sumabil value) {
		this.value += value.getValue();
	}
	
	@Override
	public void setValue()
	{
		for(int i = 0; i < 3; i++)
			this.value += vector[i];
	}
}

class MyMatrix<E> implements Sumabil
{
	public float[][] vector = new float[4][4];
	public float val;
	
	public MyMatrix(){}
	public MyMatrix(int i)
	{
		this.val = 0;
		for(int j = 0; j < i; j++)
			for(int h = 0; h < i; h++)
				vector[j][h] = i;
	}
	
	@Override
	public float getValue() {
		return this.val;
	}
	
	@Override
	public void addValue(Sumabil value) {
		this.val += value.getValue();
	}
	
	@Override
	public void setValue()
	{
		for(int j = 0; j < 4; j++)
			for(int h = 0; h < 4; h++)
				this.val += vector[j][h];
	}

}

class generic
{
		public static <T extends Sumabil> float addAll(Collection<T> c)
		{
			float suma = 0;
			for(T i : c)
				suma = suma + i.getValue();
			return suma;
			
		}
	
	
}

