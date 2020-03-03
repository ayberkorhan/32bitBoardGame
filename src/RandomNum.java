import java.util.*;

public class RandomNum
{
    public int genereteRand(int min, int max ){// belirli aralıkta random sayı üretme
        int tmpRand = (int)(Math.random()*(max-min) + min );
        return tmpRand;
    }

} 