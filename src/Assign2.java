import javax.swing.*;
import java.util.Arrays;

/**
 * Created by Christopher on 1/31/14.
 */
public class Assign2
{
    public static void main(String[] args)
    {
        Length1 a = new Length1(78, 1610);
        Length1 b = new Length1(77, 1694);
        Length1 c = new Length1(a.add(b));
        Length1 d = new Length1(a.subtract(b));
        Length2 g = new Length2(32, 1022, 1);
        Length2 h = new Length2(31, 1700, 2);
        Length2 i = new Length2(g.add(h));
        Length2 j = new Length2(g.subtract(h));
        Length1 e = new Length1(a.add(g));
        Length1 f = new Length1(a.subtract(g));
        Length1[] l1arr = new Length1[]{a, b, c, d, e, f, g, h, i, j};
        String printOut = new String();
        for(int num = 0;num < 10;num++)
        {
            printOut += l1arr[num].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null,printOut);
        printOut = "";
        Arrays.sort(l1arr);
        for(int num = 0;num < 10;num++)
        {
            printOut += l1arr[num].toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, printOut);
        JOptionPane.showMessageDialog(null, a.toFeet() + " feet");
        JOptionPane.showMessageDialog(null, g.toFeet() + " feet");
    }
}