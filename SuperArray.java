public class SuperArray{
  private String [] data;
  private int size;

  public SuperArray(){
    size = 0;
    data = new String[10];
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
  public String get(int index){
    return this.data[index];
  }
  public String set(int index, String element)
  {
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
}
