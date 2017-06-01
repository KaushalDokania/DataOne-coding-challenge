import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Shop
{
	int pcount = 0;										//number of desired products the shop has
	String pname="";
	float amount=0;
}
public class CSVFileRead 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		String fileName = args[0];
		String line = "";
		int temp = 0, n=0, id, i, j;
        float prc;
        
        ArrayList<String> list=new ArrayList<String>();		//Creating ArrayList for the desired items
        for(i=1;i<args.length;i++)
        {
        	list.add(args[i]);
        }
        
		try
		{

			BufferedReader br = new BufferedReader(new FileReader(fileName));
            
			/*counting the number of shops*/
            br.mark(1000000);
            while ((line = br.readLine()) != null)			//reading file line by line
            {
            	String[] b = line.split(", ");
            	temp = Integer.parseInt(b[0]);
            	if(temp>n)
            		n = temp;
            }
            Shop s[] = new Shop[n+1];						//creating array of shops
            for(i=0;i<n+1;i++)
            {
            	s[i] = new Shop();	
            }
            
            br.reset();										//resetting the file pointer
            
            while ((line = br.readLine()) != null)			//reading file line by line
            {
            	String[] b = line.split(", ");
            	id = Integer.parseInt(b[0]);
            	prc = Float.parseFloat(b[1]);
            	int fl;
            	
            	if(b.length>3)								//if combo pack encountered
            	{
            		fl = 0;
            		for(j=2;j<b.length;j++)
            		{
            			if(list.contains(b[j]))
            			{
            				fl = 1;
            				s[id].pcount++;
            				s[id].pname += b[j];
            			}
            			
            		}
            		if(fl==1)
        				s[id].amount += prc;
            	}
            	else										//No combo pack
            	{/*
            		if(chkList(b[2],args))
            		{
            			s[id].pcount++;
            			s[id].pname += b[2];
            			s[id].amount += prc;
            		}*/
            		if(list.contains(b[2]))
            		{
            			s[id].pcount++;
            			s[id].pname += b[2];
            			s[id].amount += prc;
            		}
            	}
            }
            int bestShop = 0;
            float min = 1000000;
            /* scanning the shop objects */
            for(i=1;i<=n;i++)
            {
            	if(s[i].pcount==list.size())					//if the shop has desired number of items
            	{
            		if(s[i].amount<min)
        			{
        				min = s[i].amount;
        				bestShop = i;
        			}
            	}
            }
            if(bestShop==0)
            	System.out.print("=> none");
            else
            	System.out.print("=> "+bestShop+", "+min);
            
        }
		catch (FileNotFoundException e) 
		{
            e.printStackTrace();
		}
		catch (IOException e)
		{
            e.printStackTrace();
        }
	}
}
