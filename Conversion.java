import java.util.*;
class Conversion
{
    public String s="";
    int n;int l;
    Scanner sc=new Scanner(System.in);
    void check(int a)
    {
        if(a==8)
        { while(l%3!=0)
            {
                s="0"+s;
                l++;
            }

        }
        else 
        {
            if(l%4!=0)
            { 
                while(l%4!=0)
                {
                    s="0"+s;
                    l++;
                }

            }
        }
    }

    void input()
    {
        System.out.println("ENTER  NUMBER:");
        n=sc.nextInt();

    }

    void decimal(int a)
    {
        String hd="ABCDEF";
        while(n!=0)
        {
            int r=n%a;
            if(r>9)
                s=hd.charAt(r-10)+s;
            else
                s=r+s;
            n=n/a;
        }
        System.out.println(s);
    }

    void revDecimal(int a)
    {

        int ar[]={10,11,12,13,14,15};
        l=s.length();double res=0.0;int k=l-1;
        for(int i=0;i<l;i++)
        {
            int c=s.charAt(i)-48;
            if(c>9)
                c=ar[c-17];

            double r=Math.pow(a,k);
            res=res+(r*c);
            k--;
        }
        System.out.println("OUTPUT:\n"+res);

    }

    void binaryrev(int a)
    {
        String p[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        l=s.length();String res="";
        for(int i=0;i<l;i++)
        {
            int c=s.charAt(i)-48;
            if(c>9)
                c=c-7;
            if(c<8&&a==8)
            {
                String ss=p[c];
                res=res+ss.substring(1,ss.length());
            }
            else res=res+p[c];
        }

        System.out.println("OUTPUT:\n"+res);
        s=res;
    }

    void binary(int c)
    {

        String p8[]={"000","001","010","011","100","101","110","111"};
        String p16[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        String ar[]={"A","B","C","D","E","F"};
        int b=c;int a=0;
        if(c==3)
        {
            while(b<=l)
            {
                String n=s.substring(a,b);
                for(int i=0;i<8;i++)
                {
                    if(n.equals(p8[i])==true)
                    {
                        System.out.print(i);
                    }
                }

                a=b;
                b=b+c;

            }
        }
        else
        {
            while(b<=l)
            {
                String n=s.substring(a,b);
                for(int i=0;i<16;i++)
                {
                    if(n.equals(p16[i])==true)
                    { 
                        if(i>9)
                        {

                            System.out.print(ar[i-10]);
                        }
                        else
                            System.out.print(i);
                    }
                }
                a=b;
                b=b+c;

            }

        }
    }

    void main()
    {

        System.out.println("CHOICES:");
        System.out.println("PRESS 1 FOR DECIMAL CONVERSION:");
        System.out.println("PRESS 2 FOR BINARY CONVERSION:");
        System.out.println("PRESS 3 FOR OCTAL CONVERSION:");
        System.out.println("PRESS 4 FOR HEXADECIMAL CONVERSION:");
        int choice=sc.nextInt();
        switch(choice)
        {
            case 1:input();
                System.out.println("PRESS 2 FOR DECIMAL TO BINARY:");
                System.out.println("PRESS 8 FOR DECIMAL TO OCTAL:");
                System.out.println("PRESS 16 FOR DECIMAL TO HEXADECIMAL:");
                int c=sc.nextInt();
                System.out.println("OUTPUT:");
                decimal(c);
                break;
            case 2:
                System.out.println("ENTER BINARY NUMBER:");
                s=sc.next();
                l=s.length();
                System.out.println("PRESS 10 FOR BINARY TO DECIMAL:");
                System.out.println("PRESS 8 FOR BINARY TO OCTAL:");
                System.out.println("PRESS 16 FOR BINARY TO HEXADECIMAL:");
                int c1=sc.nextInt();
                System.out.println("OUTPUT:");
                if(c1==10)
                    revDecimal(2);

                if(c1==8)
                {
                    if(l%3!=0)

                    {
                        check(8);
                        System.out.println("new:"+s);

                    }
                    binary(3);

                } 

                else if(c1==16)
                {
                    if(l%4!=0)
                    { 
                        check(16);
                    }

                    binary(4);

                }
                else;
                break;
            case 3: System.out.println("ENTER AN OCTAL NUMBER:");
                input();
                s=s+n;
                l=s.length();
                System.out.println("PRESS 1 FOR OCTAL TO DECIMAL:");
                System.out.println("PRESS 2 FOR OCTAL TO BINARY:");
                System.out.println("PRESS 3 FOR OCTAL TO HEXADECIMAL:");
                int c2=sc.nextInt();
                if (c2==1)
                    revDecimal(8);
                else if(c2==2)
                {
                    binaryrev(8);
                }
                else 
                {
                    binaryrev(8);

                    l=s.length();
                    check(16);
                    System.out.println("FINAL OUTPUT:");
                    binary(4);
                }     
                break;
            case 4: System.out.println("ENTER A HEXADECIMAL:");
                s=sc.next();
                l=s.length();
                System.out.println("PRESS 1 FOR HEXADECIMAL TO DECIMAL:");
                System.out.println("PRESS 2 FOR HEXADECIMAL TO BINARY:");
                System.out.println("PRESS 3 FOR HEXADECIMAL TO OCTAL:");
                int c3=sc.nextInt();
                if(c3==1)
                    revDecimal(16);
                else if(c3==2)
                    binaryrev(16);
                else
                {
                    binaryrev(16);
                    l=s.length();
                    check(8);
                    System.out.println("FINAL OUTPUT:");
                    binary(3);
                }

                break;
            default:System.out.println("WRONG CHOICE:");
        }

    }
}

