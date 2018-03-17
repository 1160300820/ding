package P1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class MagicSquare {

	public static boolean generateMagicSquare(int n) throws 
	 FileNotFoundException{
        if(n%2==0||n<0)
        {
        	System.out.println("n²»ÊÇÆæÊý");
        	return false;
        }
		int magic[][] = new int[n][n];

		int row = 0, col = n / 2, i, j, square = n * n;

		for (i = 1; i <= square; i++) 
		{
			magic[row][col] = i;

		if (i % n == 0) 
			row++;

		else
		{

		if (row == 0) row = n - 1;

		else row--;

		if (col == (n - 1)) col = 0;

		else col++;

		}

		}
        File file = new File("src\\P1\\txt\\6.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(file));
		for (i = 0; i < n; i++) { for (j = 0; j < n; j++)
		{
			ps.append(""+magic[i][j]+"\t");
		}
		if(i<n-1)
        ps.append("\r");
		}
        ps.close();
		return true;

		}
	    public static boolean isLegalMagicSquare(String fileName) throws IOException
	    {
	    	int i,j=0,n=0,m=0,sum=0,sum1=0;
	    	FileInputStream inputStream = new FileInputStream("src\\P1\\txt\\"+fileName);
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));  
	        if(!bufferedReader.ready())
	        {
	        	System.out.println("faile to open the file");
	        	return false;
	        }
	        String str = null;
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        try
	        {
	        	while((str = bufferedReader.readLine()) != null)  
	 	        {  
	        		String[] strings = str.split("\t");
	        		if(m==0)
	        			n=strings.length;
	        		if(n!=strings.length)
	        		{
	        			System.out.println("not a square matrix,the file is wrong");
	        			return false;
	        		}
	        		for(i=0;i<strings.length;i++)
	        		{
	        			if(Integer.parseInt(strings[i])<0)
	        			{
	        				System.out.println("there is a minus");
	        				return false;
	        			}
	        			list.add(Integer.parseInt(strings[i]));
	        		}
	        		m++;
	 	        }
	 	        if(m!=n)
	 	        {
	 	        	System.out.println("not a square matrix,the file is wrong");
	 	        	return false;
	 	        }
	        }catch(Exception e) {
	        	System.out.println(e);
	        	inputStream.close();  
		        bufferedReader.close();
	        	return false;
	        }
	       for(i=0;i<list.size();i=i+n)
	       {
	    	   sum+=list.get(i+j);
	    	   j++;
	       }
	       j--;
	       for(i=0;i<list.size();i=i+n)
	       {
	    	   sum1+=list.get(i+j);
	    	   j--;
	       }
	       if(sum1!=sum)
	       {
	    	   System.out.println("sum!=sum1,not a magic matrix");
	           return false;
	       }
	       for(i=0;i<list.size();i=i+n)
	       {
	    	   sum1=0;
	    	   for(j=0;j<n;j++)
	    	   {
	    		   sum1+=list.get(i+j);
	    	   }
	    	   if(sum1!=sum)
	    	   {
	    		   System.out.println("sum!=sum1,not a magic matrix");
		           return false;
	    	   }
	       }
	       for(i=0;i<n;i++)
	       {
	    	   sum1=0;
	    	   for(j=0;j<list.size();j=j+n)
	    	   {
	    		   sum1+=list.get(i+j);
	    	   }
	    	   if(sum1!=sum)
	    	   {
	    		   System.out.println("sum!=sum1,not a magic matrix");
		           return false;
	    	   }
	       }
	        inputStream.close();  
	        bufferedReader.close();
	        return
	        		true;
	    }
        public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        	if(isLegalMagicSquare("1.txt"))
            	System.out.println("is a magic matrix");
        	if(isLegalMagicSquare("2.txt"))
            	System.out.println("is a magic matrix");
        	if(isLegalMagicSquare("3.txt"))
            	System.out.println("is a magic matrix");
        	if(isLegalMagicSquare("4.txt"))
            	System.out.println("is a magic matrix");
        	if(isLegalMagicSquare("5.txt"))
            	System.out.println("is a magic matrix");
        generateMagicSquare(5);
        if(isLegalMagicSquare("6.txt"))
        	System.out.println("is a magic matrix");
	}

}