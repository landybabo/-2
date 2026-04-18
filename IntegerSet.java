public class IntegerSet extends Integer{

    public static void main(String[] args)
    {
        /*
        Initialize
        union
        intersection
        insertelement
        deleteelement
        tostring
        isequalto
        */

        Integer a1 = new Integer();
        Integer a2 = new Integer();

        System.out.println("공집합 여부 : "  + toString(a1));

        insertElement(a1,7);
        insertElement(a2, 8);

        System.out.println("결과 : " + isEqualTo(a1,a2));

        Integer uni = union(a1,a2);
        System.out.println(toString(a1)  + "+" +  toString(a2) + "=" + toString(uni));

        Integer intersec = intersection(a1,a2);
        System.out.println(toString(a1) + "x" + toString(a2) + "=" + toString(intersec));

        deleteElement(uni,7);
        System.out.println("a1 == uni ? " + isEqualTo(a1,uni));

    }

}

