/**
 * Created by Christopher on 1/31/14.
 */
public class Length1 extends Length implements Comparable<Length1>
{
    private int miles;
    private int yards;
    public Length1()
    {

    }
    public Length1(Length1 l1)
    {
        this.setMiles(l1.getMiles());
        this.setYards(l1.getYards());
    }
    public Length1(int miles, int yards)
    {
        this.setMiles(miles);
        this.setYards(yards);
    }
    public void setYards(int y)
    {
        this.yards = y;
    }
    public int getYards()
    {
        return this.yards;
    }
    public void setMiles(int m)
    {
        this.miles = m;
    }
    public int getMiles()
    {
        return this.miles;
    }
    public Length1 add(Length1 other)
    {
        Length1 L = new Length1((this.getMiles() + other.getMiles()), (this.getYards() + other.getYards()));
        while (L.getYards() >= 1760)
        {
            L.setMiles(L.getMiles()+1);
            L.setYards(L.getYards()-1760);
        }
        return L;
    }
    public Length1 subtract(Length1 other)
    {
        int yd = this.getMiles()*1760 + this.getYards();
        int yd1 = other.getMiles()*1760 + other.getYards();
        Length1 L1 = new Length1(0,yd-yd1);
        L1.convert();
        return L1;
    }
    public int toFeet()
    {
        return ((this.getMiles() * 5280) + (this.getYards() * 3));
    }
    public void convert()
    {
        while (this.getYards() >= 1760)
        {
            this.setMiles(this.getMiles()+1);
            this.setYards(this.getYards()-1760);
        }
    }
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("The length is " + this.getMiles() + " miles and " + this.getYards() + " yards long.");
        return sb.toString();
    }
    public int compareTo(Length1 other)
    {
        if ((this.getMiles()*1760 + this.getYards()) > (other.getMiles()*1760 + other.getYards()))
        {
            return 1;
        }
        else if((this.getMiles()*1760 + this.getYards()) < (other.getMiles()*1760 + other.getYards()))
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
