import java.util.*;

public class LottoNumber {

    public final static int LOTTO_NUMBER_COUNT = 6;
    public final static int LOTTO_SERVICE_NUMBER_COUNT = 1;
    public final static int LOTTO_NUMBER_RANGE = 42;

    private Random rand = new Random();
    private Set<Integer> set = new HashSet<>();

    public List<Integer> createBasicLottoNumbers() {
        List<Integer> numbers = notDuplicateRandomBalls();
        return numbers;
    }

    private List<Integer> notDuplicateRandomBalls() {
        while(set.size()<LOTTO_NUMBER_COUNT){
            Integer result = rand.nextInt(LOTTO_NUMBER_RANGE)+1;
            set.add(result);
        }

        return new ArrayList<>(set);
    }

    public Integer createBonusLottoNumber(){
        Integer result=0;
        while(set.size()<(LOTTO_NUMBER_COUNT+LOTTO_SERVICE_NUMBER_COUNT)){
            result = rand.nextInt(LOTTO_NUMBER_RANGE)+1;
            set.add(result);
        }
        return result;
    }

}
