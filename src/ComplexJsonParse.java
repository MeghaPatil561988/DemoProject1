import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JsonPath js=new JsonPath(payload.CoursePrice());
		
		//Print No of courses returned by API
		
int count=	js.getInt("courses.size()");
System.out.println(count);
//Print Purchase Amount
int totalAmount= js.getInt("dashboard.purchaseAmount");
System.out.println(totalAmount);
//Print Title of the first course


  String titleFirstCourse=js.get("courses[2].title");
  System.out.println(titleFirstCourse);
  
  //Print All course titles and their respective Prices
  
  for(int i=0;i<count;i++)
  {
	  String courseTitles=js.get("courses["+i+"].title");
	  System.out.println(courseTitles);
	  
	  //System.out.println(js.get("courses["+i+"].price"));
	  //it will not take sysout that's why use .toString() otherwise put it in one variable.
	  
	  System.out.println(js.get("courses["+i+"].price").toString());
	  
	  
	  
  }
  
  //Print no of copies sold by RPA Course
  //if its dynamic then also this code will work 
  //because in future RPA is on 5th position that time also it works.
  
 System.out.println("Print no of copies sold by RPA Course");
 
 for(int i=0;i<count;i++)
 {
	  String courseTitles=js.get("courses["+i+"].title");
	  if(courseTitles.equalsIgnoreCase("RPA"))
	  {
		  int copies=js.get("courses["+i+"].copies");
		  System.out.println(copies);
		  break;
	  }
	
	  
 }
 
 
 
	}

}
