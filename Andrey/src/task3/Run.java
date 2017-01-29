package task3;

import task3.accessories.Accessory;
import task3.accessories.Paper;
import task3.flowers.Flowers;
import task3.flowers.lilii.ClaudeShride;
import task3.flowers.lilii.Lelii;
import task3.flowers.lilii.Lilii;
import task3.flowers.rose.Aelita;
import task3.flowers.rose.Berlin;
import task3.flowers.rose.Rosa;

import java.util.ArrayList;

/**
 * Created by Sherlock on 27.01.2017.
 */
    public class Run {
    public static void main(String[] args) {
        Rosa rose1 = new Berlin(50 , 45 , 10);
        Rosa rose2 = new Berlin(70 , 90 , 8);
        Rosa rose3 = new Aelita(60 , 70 , 9);

        Lilii lilii1 = new ClaudeShride(30 , 40 , 7 );
        Lilii lilii2 = new Lelii(60 , 55 , 9 );
        Lilii lilii3 = new ClaudeShride(65 , 70 , 8 );

        ArrayList<Flowers> flowerses = new ArrayList<Flowers>();

        flowerses.add(rose1);
        flowerses.add(rose2);
        flowerses.add(rose3);

        flowerses.add(lilii1);
        flowerses.add(lilii2);
        flowerses.add(lilii3);


        Accessory byket = new Paper(flowerses);
        System.out.println("Загальна вартість букета: " + byket.totalPrise() );
       // System.out.println(Arrays.toString());
        //System.out.println(byket.findFlowers(50,70).toString());

        //System.out.println(byket.findFlowers2(5,10).toString());



    }
}
