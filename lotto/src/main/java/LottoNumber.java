import java.util.*;

public class LottoNumber {

    public final static int LOTTO_NUMBER_COUNT = 6;
    public final static int LOTTO_SERVICE_NUMBER_COUNT = 1;
    public final static int LOTTO_NUMBER_RANGE = 42;

    private Random rand = new Random();
    private Set<Integer> resultSet = new HashSet<>();
    private Set<Integer> userSet;

    public List<Integer> createBasicLottoNumbers() {
        List<Integer> numbers = notDuplicateRandomBalls();
        return numbers;
    }

    private List<Integer> notDuplicateRandomBalls() {
        while(resultSet.size()<LOTTO_NUMBER_COUNT){
            Integer result = rand.nextInt(LOTTO_NUMBER_RANGE)+1;
            resultSet.add(result);
        }

        return new ArrayList<>(resultSet);
    }

    public Integer createBonusLottoNumber(){
        Integer result=0;
        while(resultSet.size()<(LOTTO_NUMBER_COUNT+LOTTO_SERVICE_NUMBER_COUNT)){
            result = rand.nextInt(LOTTO_NUMBER_RANGE)+1;
            resultSet.add(result);
        }
        return result;
    }

    public List<Integer> lottoAutoGenerator() {
        userSet = new HashSet<>();
        while(userSet.size()<LOTTO_NUMBER_COUNT){
            Integer result = rand.nextInt(LOTTO_NUMBER_RANGE)+1;
            userSet.add(result);
        }

        return new ArrayList<>(userSet);
    }
}
