package Lab_1_1_from7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab_1_Main {


		public static void main(String[] args) 
		{
			// TODO Auto-generated method stub
			List<String> list1=new ArrayList();
			List<String> list2=new ArrayList();
			List<String> res=new ArrayList();
			Collections.addAll(list1, "Working", "in","Capgemini");
			Collections.addAll(list2, "She's", "in","Capgemini");
			
			Lab_1  main=new Lab_1 ();
			res=main.removeElements(list1, list2);
			System.out.println(res);
		}
			
}
