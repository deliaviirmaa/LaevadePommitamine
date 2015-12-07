/**
 * Created by Delia on 07.12.2015.
 */
public class M2ng {


    public static void main(String[] args) {

        printimine();
        String [] rida = {"a","a","a","b","b","b","c","c","c"};
    }

    public static void printimine (){
        for ( int i=0; i<3;i++){
            System.out.println();
            for (int j=0; j<3;j++){
                System.out.print(0);
            }
        }
    }

    public static void maatriksitePrintimine(String [] t2hed){

        System.out.print(t2hed[0]+t2hed[1]+t2hed[2]);
    }


}
