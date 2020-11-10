public class Demo{


  public static void removeDuplicates(SuperArray s)
  {
    for (int i = s.get(); i > 0 ; i -- ) {
      if (s.indexOf(s.get(i)) != i){
        s.remove(i);
      }
    }
  }
  public static SuperArray findOverlap(SuperArray a, SuperArray b)
  {
    SuperArray wow = new SuperArray(Math.max(a.get() + 1, b.get() + 1));
    removeDuplicates(a);
    removeDuplicates(b);
    SuperArray smallest = (a.get() > b.get()) ? b : a;
    SuperArray largest = (a.get() > b.get()) ? a : b;
    for (int i = 0;i < smallest.get() ;i ++ ) {
      if (largest.indexOf(smallest.get(i)) != 1)
      {
        wow.add(smallest.get(i));
      }
    }
    return wow;
  }
  public static SuperArray zip(SuperArray a, SuperArray b)
  {
    SuperArray wowo = new SuperArray(a.get() + b.get() + 2);
    int bigger = Math.max(a.get() , b.get());
    for (int i = 0;i < bigger; i ++)
    {
      if(a.get() >= i) {wowo.add(a.get(i));}
      if(b.get() >= i) {wowo.add(a.get(i));}
    }
    return wowo;
  }

  public static void main(String[]args){
    SuperArray words = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    System.out.println(words);
    removeDuplicates(words);
    System.out.println(words);  }
}
