/**
 * Created by Christopher on 1/31/14.
 */
public class Length2 extends Length1{
    private int feet;
    public Length2()
    {

    }
    public Length2(Length2 l2)
    {
        this.setMiles(l2.getMiles());
        this.setYards(l2.getYards());
        this.setFeet(l2.getFeet());
    }
    public Length2(int miles, int yards, int feet)
    {
        this.setMiles(miles);
        this.setYards(yards);
        this.setFeet(feet);
    }
    public void setFeet(int feet)
    {
        this.feet = feet;
    }
    public int getFeet()
    {
        return this.feet;
    }
    public int toFeet()
    {
        return ((this.getMiles()*5280)+(this.getYards()*1760)+(this.getFeet()));
    }
    public Length2 add(Length2 other)
    {
        Length2 L = new Length2(this.getMiles() + other.getMiles(), this.getYards() + other.getYards(), this.getFeet() + other.getFeet());
        while (L.getFeet()>=3)
        {
            L.setFeet(L.getFeet()-3);
            L.setYards(L.getYards()+1);
        }
        while (L.getYards()>=1760)
        {
            L.setYards(L.getYards()-1760);
            L.setMiles(L.getMiles()+1);
        }
        return L;
    }
    public Length2 subtract(Length2 other)
    {
        int feet;
        int feet1;
        feet = this.getMiles()*5280 + this.getYards()*3 + this.getFeet();
        feet1 = other.getMiles()*5280 + other.getYards()*3 + other.getFeet();
        int newFeet = feet - feet1;
        Length2 L = new Length2(0, 0, newFeet);
        L.convert();
        return L;
    }
    public void convert()
    {
        while (this.getFeet() >= 3)
        {
            this.setYards(this.getYards()+1);
            this.setFeet(this.getFeet()-3);
        }
        while (this.getYards() >= 1760)
        {
            this.setMiles(this.getMiles()+1);
            this.setYards(this.getYards()-1760);
        }
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("The length is " + this.getMiles() + " miles and " + this.getYards() + " yards and " + this.getFeet() + " feet long.");
        return sb.toString();
    }
    public int compareTo(Length2 other)
    {
        if ((this.getMiles()*1760 + this.getYards() * 3 + this.getFeet()) > (other.getMiles()*1760 + other.getYards()*3 + this.getFeet()))
        {
            return 1;
        }
        else if((this.getMiles()*1760 + this.getYards() * 3 + this.getFeet()) < (other.getMiles()*1760 + other.getYards()*3 + this.getFeet()))
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
