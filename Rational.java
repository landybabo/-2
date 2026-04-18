import java.util.Scanner;

public class Rational {
    /* 1. 생성자로 분자 분모 따로 입력 받아 저장 (numerator, denominator)
        2. 근데 default 생성자도 만들어놓기
        3. public 메소드들 생성
        덧셈
        뺄셈
        곱셈
        나눗셈
        string type , 분수형태로 반환
        string type , 소수 형태로 반환 , 단 서식 지정 기능(소수점 몇번째 아래까지)
        flow
        물어보기(selector 변수), 객체 만들건지, 메소드로 연산 진행할건지. 연산 결과들이 보고 싶은지.
        객체 생성 > 객체 배열에 저장
        물어보기로 돌아가기
     */

    private int numerator = 0;
    private int denominator = 1;

    public Rational()
    {
        System.out.println(" 호출됨 Beep. ");
    }

    public Rational(int num, int denom)
    {
        numerator = num;
        denominator = denom;
        System.out.println("생성 ! ");
    }

    //연산 메소드들 넣기
    public static String Add(Rational A, Rational B)
    {
        System.out.println(" + 연산");
        int num = (A.numerator * B.denominator) + (B.numerator * A.denominator);
        int denom = A.denominator * B.denominator;

        for(int i = 2 ; i < num && i < denom ; i++)
        {
            if( num % i == 0 && denom % i == 0 )
            {
                num = num / i;
                denom = denom / i;
            }
        }

       return question(num,denom);
    }

    public static String Sub(Rational A, Rational B)
    {
        System.out.println(" - 연산");
        int num = (A.numerator * B.denominator) - (B.numerator * A.denominator);
        int denom = A.denominator * B.denominator;

        for(int i = 2 ; i < num && i < denom ; i++)
        {
            if( num % i == 0 && denom % i == 0 )
            {
                num = num / i;
                denom = denom / i;
            }
        }

       return question(num,denom);
    }

    public static String Mult(Rational A, Rational B)
    {
        System.out.println(" * 연산");
        int num = A.numerator * B.numerator;
        int denom = A.denominator * B.denominator;

        for(int i = 2 ; i < num && i < denom ; i++)
        {
            if( num % i == 0 && denom % i == 0 )
            {
                num = num / i;
                denom = denom / i;
            }
        }

       return question(num,denom);
    }

    public static String Div(Rational A, Rational B)
    {
        System.out.println(" / 연산");
        int num = A.numerator * B.denominator;
        int denom = A.denominator * B. numerator;

        for(int i = 2 ; i < num && i < denom ; i++)
        {
            if( num % i == 0 && denom % i == 0 )
            {
                num = num / i;
                denom = denom / i;
            }
        }

        return question(num,denom);
    }

    public static String bunsu(int num , int denom)
    {
        String temp = num + "/" + denom;
        System.out.println(temp);
        return temp;
    }

    public static String sosu(int num, int denom)
    {
        Scanner input = new Scanner(System.in);
        int decimal = 0;
        int temp1 = num/denom;
        double temp2 = (double)num/denom - (double)temp1;

        String retr = temp1+ "." +temp2;


        System.out.print("소수 몇번째 자리까지 저장? : ");
        decimal = input.nextInt();

        //여기 부분 구현 어떻게 할지 생각하기
        //위 분수 메소드 처럼 구현해도 될까?
        //일단.. substring 함수를 쓰는 방법이 있긴한데.
        // temp2 = String.format("%.",temp1); <폐기

        System.out.println();
        return retr;
    }

    public static String question(int num, int denom)
    {
        Scanner input = new Scanner(System.in);

        int selec;

        System.out.println("분수로 저장 = 1 , 소수로 저장 = 2");
        System.out.print(" 값 입력 : ");
        selec = input.nextInt();

        if(selec == 1)
        {
           return bunsu(num,denom);
        } else if (selec == 2)
        {
           return sosu(num,denom);
        }else System.out.printf("\n error ");
        return null;
    }

    public static void mainquest()
    {
        System.out.printf("\n\n**************************\n");
        System.out.println(" 1. 분수 만들기 ");
        System.out.println(" 2. 사칙연산 ");
        System.out.println(" 3. 결과보기");
        System.out.println(" 4. 초기화 ");
        System.out.println(" 0. 종료 ");
        System.out.println("**************************");
        System.out.print(" 뭘 하고 싶나요? : ");
    }

    public static void main()
    {
        Scanner input = new Scanner(System.in);

        String[] answ = new String[100];
        Rational[] fnums = new Rational[100];
        int selector = 0;
        int fCnt = 0;
        int answCnt = 0;

        mainquest();
        selector= input.nextInt();

        while(selector != 0)
        {
            switch (selector)
            {
                case 1:
                    System.out.printf("분자 : ");
                    int num = input.nextInt();

                    System.out.println("분모(분자랑 다른숫자) : ");
                    int denom = input.nextInt();

                    Rational rat = new Rational(num,denom);
                    fnums[fCnt] = rat;
                    fCnt++;
                    break;
                case 2:
                    System.out.println(" 더하기 : 1, 빼기 : 2, 곱하기 : 3, 나누기 : 4");
                    System.out.print("뭐 할래? : ");
                    selector = input.nextInt();

                    System.out.println("어떤 애들 끼리 연산시킬래?");

                    for(int i = 0; i <fCnt ; i++)
                    {
                        System.out.printf("\n %d. %d/%d \n",i,fnums[i].numerator,fnums[i].denominator);
                    }
                    System.out.print("입력 1: ");
                    int temp1 = input.nextInt();
                    System.out.print("입력 2 : ");
                    int temp2 = input.nextInt();

                    switch(selector)
                    {
                        case 1:
                            answ[answCnt] = Add(fnums[temp1],fnums[temp2]);
                            answCnt++;
                            break;
                        case 2:
                            answ[answCnt] = Sub(fnums[temp1],fnums[temp2]);
                            answCnt++;
                            break;
                        case 3:
                            answ[answCnt] = Mult(fnums[temp1],fnums[temp2]);
                            answCnt++;
                            break;
                        case 4:
                            answ[answCnt] = Div(fnums[temp1],fnums[temp2]);
                            answCnt++;
                            break;
                    }
                    break;

                case 3:
                    for(int i = 0; i < answCnt; i++)
                    {
                        System.out.printf("\n%d 번째 결과 : %s\n",i+1,answ[i]);
                    }
                    break;

                case 4:
                    fCnt = 0;
                    answCnt = 0;
                    break;
            }
            mainquest();
            selector = input.nextInt();
        }


    }
}
