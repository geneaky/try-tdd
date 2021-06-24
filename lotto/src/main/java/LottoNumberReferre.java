import java.util.List;

public class LottoNumberReferre {

    public int compareBasicLottoNumbers(List<Integer> basicLottoNumbers, List<Integer> userSelectedNumbers) {
        int count = 0;
        for(int i=0;i<LottoNumber.LOTTO_NUMBER_COUNT;i++){
            if(basicLottoNumbers.get(i)==userSelectedNumbers.get(i)) count++;
        }

        return count;
    }
}
