public class HugeInteger {

    int[] arr = new int[40];
    int isNegative = 0;

    public HugeInteger()
    {
        for(int i = 0; i < 40 ; i++)
        {
            arr[i] = 0;
        }
    }

    public void parse(String given)
    {
        for(int i = 0; i < given.length() ; i++)
        {
            this.arr[39-i] = given.charAt((given.length() -1) - i ) - '0';
        }
    }

    public String toString()
    {
        int index = 0;
        String ret = "";

        for(int i = 0; i < 40 ; i++)
        {
            if(this.arr[i] == 0)  continue;
            index = i;
        }

        for(;index < 40 ; index++)
        {
            ret = ret + this.arr[index];
        }
        return ret;
    }

    public void add(HugeInteger a) {
        int carry = 0;

        for (int i = 39; i >= 0; i--) {
            int sum = this.arr[i] + a.arr[i] + carry;
            this.arr[i] = sum % 10;
            carry = sum / 10;
        }
    }

    public void subtract(HugeInteger a)
    {
        for (int i = 39; i >= 0; i--) {
            if (this.arr[i] < a.arr[i]) {
                this.arr[i] += 10;
                this.arr[i - 1]--;
            }
            this.arr[i] -= a.arr[i];
        }
    }

    public boolean isEqualTo(HugeInteger a)
    {
        for(int i = 0; i < 40 ; i++)
        {
            if(this.arr[i] != a.arr[i])    return false;
        }
        return true;
    }

    public boolean isNotEqualTo(HugeInteger a)
    {
        for(int i = 0; i < 40 ; i++)
        {
            if(this.arr[i] != a.arr[i])    return true;
        }
        return false;
    }

    public boolean isGreaterThan(HugeInteger a)
    {
        for (int i = 0; i < 40; i++) {
            if (this.arr[i] > a.arr[i]) return true;
            if (this.arr[i] < a.arr[i]) return false;
        }
        return false;
    }

    //a<b
    public boolean isLessThan(HugeInteger a)
    {
        if(this.isGreaterThan(a) == true)
        {
            return false;
        } else if (this.isEqualTo(a) == true)
        {
            return false;
        } else return true;
    }


    public boolean isGreaterThanOrEqualTo(HugeInteger a)
    {
        if(this.isLessThan(a))  return false;

        return true;
    }


    public boolean isLessThanOrEqualTo(HugeInteger a)
    {
        if(this.isGreaterThan(a)) return false;

        return true;
    }

    public boolean isZero()
    {
        for(int i = 0; i<40; i++)
        {
            if(this.arr[i] != 0)    return false;
        }
        return true;
    }

}
