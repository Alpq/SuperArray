 //Special thanks to Christopher Liu Andy Lin, and Reng Zheng for helping with test cases!
public class SuperArray{
  private String [] data;
  private int size;

  public SuperArray(){
    size = 0;
    data = new String[10];
  }
  public SuperArray(int initialCapacity){
  if (initialCapacity < 0)
  {
    throw new IllegalArgumentException("Invalid Size.");
  }
  size = 0;
  data = new String[initialCapacity];
  }
  public int size()
  {
    return this.size;
  }
  public boolean add(String element)
  {
    if (size != this.data.length)
    {
      this.data[size] = element;
      size ++;
      return true;
    }
    this.resize();
    boolean t = this.add(element);
    return t;
  }
  public void add(int index, String element)
  {
    boolean correct = index > - 1 && index < this.size + 1;
    correct = index < this.data.length && index > -1;
    correct = correct && this.size + 1 != this.data.length;
    if (!correct)
    {
      throw new IndexOutOfBoundsException("Invalid Index.");
    }
    for (int i = size + 1; i > index; i -- )
    {
      this.data[i] = this.data[i - 1];
    }
    this.data[index] = element;
    size ++;
  }
  public String remove(int index)
  {
      if (index < 0 || index > size)
      {
        throw new IndexOutOfBoundsException("Invalid Index.");
      }
      String removed;
      removed = this.data[index]; //sets output variable to string in index
      for (int i = index; i < size; i ++ )
      {
        this.data[i] = this.data[i + 1]; // Starting from the index, every value is shifted to the left
      }
      this.data[size] = null; // the last element is set to null
      size --; // the array is shrunk
      return removed;
  }
  public String get(int index){
    return this.data[index];
  }
  public int get(){
    return this.size;
  }
  public String set(int index, String element)
  {
    if (index > size || index < 0)
    {
      throw new IndexOutOfBoundsException("Invalid Index.");
    }
    String replaced = this.data[index];
    this.data[index] = element;
    return replaced;
  }

  private void resize(){
    String[] bigger = new String[size*10];
    for (int i = 0; i < this.data.length ; i++ ) {
      bigger[i] = this.data[i];
    }
    this.data = bigger;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public void clear(){
    for (int i = 0; i < this.size ; i ++) {
      this.set(i, "");
    }
    size = 0;
  }
  public String toString(){
    String format = "[";
    for (int i = 0; i < this.size; i++) {
      if ( i < this.size - 1) {format = format + this.data[i] + ", " ;}
      if ( i == this.size - 1) {format = format + this.data[i];}
    }
    return format + "]";
  }
  public boolean contains(String s)
  {
    for (int i = 0; i < this.size ; i ++ ) {
      if (this.data[i].equals(s))
      {
        return true;
      }
    }
    return false;
  }
  public int indexOf(String s){
    for (int i = 0; i < this.size ; i ++ ) {
      if (this.data[i].equals(s))
      {
        return i;
      }
    }
  return -1;
  }
  public String[] toArray(){
    String[] safe = new String[size];
    for (int i = 0; i < size ; i ++ ) {
      safe[i] = this.data[i];
    }
    return safe;
  }
  public int lastIndexOf(String value)
  {
    for (int i = this.size; i > 0 ; i -- ) {
      if (this.data[i].equals(value))
      {
      return i;
      }
    }
    return -1;
  }
  public boolean equals(SuperArray other)
  {
    if (this.size != other.size)
    {
      return false;
    }
    for (int i = 0; i < this.size ; i++) {
      if (this.data[i] != other.data[i])
      {
        return false;
      }
    }
    return true;
  }
}
