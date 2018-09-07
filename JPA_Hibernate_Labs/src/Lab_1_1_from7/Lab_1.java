package Lab_1_1_from7;

import java.util.List;


public class Lab_1 implements Comparable<Lab_1>
{
	public List<String> removeElements(List<String> list1,List<String> list2)
	{
		list1.removeAll(list2);
		return  list1;
	}

	@Override
	public int compareTo(Lab_1 o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
