import java.util.Random;
public class Halloween
{
    public int travellingPeddler(int darkAura, int seedNumber)
    {
        darkAura=1;
        seedNumber=7*7;//7 is the holy number in Christianity.
        return seedNumber;
    }
    public static int x,y,i,j;
    public static int size=1;
    public static int sumsize=0;
    public static int n=7;
    public static int m=7;
    public static int MAXIMUM=0;
    public static int count=0;
    public static int [][]field=new int[7][7];
    public static Random r=new Random();
    public static void main(String[]args)
    {
        begin();
        for(i=1;i<=31;i++)
        {
            int method=r.nextInt(4)+1;
            System.out.println("DAY "+i);
            switch(method)
            {
                case 1:
                growRandom();
                printall();
                    break;
                case 2:
                suckPower();
                printall();
                    break;
                case 3:
                growAll();
                printall();
                    break;
                case 4:
                growBiggest();
                printall();
                    break;
            }
            greatPumpkin();//potential unexplained bug during coding, which may stuck on day 8;
            if(count==1)
            {
                System.out.println("Dr. Brown, here is the great Pumpkin!");
                break;
            }
            if(i==31)
            {System.out.println("Happy Halloween!");}
        }
    }
    public static void begin()
    {
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                field[x][y]=size;
            }
        }     
    }
    public static void growRandom()
    {
        for(int t=0;t<=n;t++)//n number of pumpkins!!!
        {
            int rsize=r.nextInt(2)+1;
            field[r.nextInt(6)][r.nextInt(6)]+=rsize;//find random position in 2D ARRAY
        }
    }
    public static void suckPower()
    {
        int allsum=0;
        int aver=0;
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                allsum+=field[x][y];
            }
        }
        aver=allsum/49;//for more precise average should use float 49.0
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                if(field[x][y]>aver)
                {field[x][y]++;}
                else if(field[x][y]<aver&&field[x][y]>=1)
                {field[x][y]--;}
            }
        }
        System.out.println("average size: "+aver);
    }
    public static void growAll()
    {
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                field[x][y]++;
            }
        }
    }
    public static void findBiggest()
    {
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                if(field[x][y]>MAXIMUM)
                {
                    MAXIMUM=field[x][y];
                }
            }
        }
    }
  
    public static void growBiggest()
    {
        findBiggest();
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                if(field[x][y]==MAXIMUM)
                {
                    field[x][y]++;
                }
            }
        }
    }
    public static void printall()//to form the result better in ### format, empty position replaced by 0.
    {
        for(y=0;y<m;y++)
        {
            for(x=0;x<n;x++)
            {
                if(field[x][y]>=100)//maximum size should be 1+31*3=94.
                {System.out.print(field[x][y]+" ");}
                else if(field[x][y]>=10)
                {System.out.print("0"+field[x][y]+" ");}
                else
                {System.out.print("00"+field[x][y]+" ");}
            }
            System.out.println();
        }
    }
    public static void greatPumpkin()
    {
        int largest=Integer.MIN_VALUE;
        int secondlargest=Integer.MIN_VALUE;
        for(j=0;j<m;j++)
        {
            for(i=0;i<n;i++)
            {
                if(field[i][j]>largest)
                {
                    secondlargest=largest;
                    largest=field[i][j];
                }
                else if(field[i][j]>secondlargest)
                {secondlargest=field[i][j];}
            }
        }
        if(largest-secondlargest>5)
        {count++;}
    }
